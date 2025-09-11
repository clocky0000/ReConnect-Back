package com.example.ReConnect.persistence;

import com.example.ReConnect.security.CryptoService;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Converter
public class EncryptedStringConverter implements AttributeConverter<String, String> {
    private static CryptoService crypto;
    @Autowired public void setCrypto(CryptoService c){ crypto = c; }

    @Override public String convertToDatabaseColumn(String attribute) {
        return (attribute == null || attribute.isEmpty()) ? attribute : crypto.encrypt(attribute);
    }
    @Override public String convertToEntityAttribute(String dbData) {
        return (dbData == null || dbData.isEmpty()) ? dbData : crypto.decrypt(dbData);
    }
}
