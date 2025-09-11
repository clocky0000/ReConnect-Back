package com.example.ReConnect.security;

import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.SecretKey;
import java.security.SecureRandom;
import java.util.Base64;

public class CryptoService {
    private static final String TRANS = "AES/GCM/NoPadding";
    private static final int GCM_TAG_BITS = 128;
    private static final int IV_LEN = 12;
    private final SecretKey key;
    private final SecureRandom rnd = new SecureRandom();

    public CryptoService(byte[] key32) {
        if (key32 == null || key32.length != 32) throw new IllegalArgumentException("AES-256 key must be 32 bytes");
        this.key = new SecretKeySpec(key32, "AES");
    }

    public String encrypt(String plain) {
        if (plain == null) return null;
        try {
            byte[] iv = new byte[IV_LEN];
            rnd.nextBytes(iv);
            Cipher c = Cipher.getInstance(TRANS);
            c.init(Cipher.ENCRYPT_MODE, key, new GCMParameterSpec(GCM_TAG_BITS, iv));
            byte[] ct = c.doFinal(plain.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            byte[] out = new byte[iv.length + ct.length];
            System.arraycopy(iv, 0, out, 0, iv.length);
            System.arraycopy(ct, 0, out, iv.length, ct.length);
            return Base64.getEncoder().encodeToString(out);
        } catch (Exception e) {
            throw new RuntimeException("Encryption failed", e);
        }
    }

    public String decrypt(String packedB64) {
        if (packedB64 == null) return null;
        try {
            byte[] packed = Base64.getDecoder().decode(packedB64);
            if (packed.length <= IV_LEN + 16) throw new IllegalArgumentException("Ciphertext too short");
            byte[] iv = new byte[IV_LEN];
            byte[] ct = new byte[packed.length - IV_LEN];
            System.arraycopy(packed, 0, iv, 0, IV_LEN);
            System.arraycopy(packed, IV_LEN, ct, 0, ct.length);

            Cipher c = Cipher.getInstance(TRANS);
            c.init(Cipher.DECRYPT_MODE, key, new GCMParameterSpec(GCM_TAG_BITS, iv));
            byte[] pt = c.doFinal(ct);
            return new String(pt, java.nio.charset.StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException("Decryption failed", e);
        }
    }
}
