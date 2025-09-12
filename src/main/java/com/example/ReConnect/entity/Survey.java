package com.example.ReConnect.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "surveys", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id","couple_code"})
})
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false, columnDefinition = "TEXT")
    private String userId;

    @Column(name = "couple_code", nullable = false, columnDefinition = "TEXT")
    private String coupleCode;

    @Column private Integer q1;  @Column private Integer q2;  @Column private Integer q3;  @Column private Integer q4;  @Column private Integer q5;
    @Column private Integer q6;  @Column private Integer q7;  @Column private Integer q8;  @Column private Integer q9;  @Column private Integer q10;
    @Column private Integer q11; @Column private Integer q12; @Column private Integer q13; @Column private Integer q14; @Column private Integer q15;
    @Column private Integer q16; @Column private Integer q17; @Column private Integer q18; @Column private Integer q19; @Column private Integer q20;
    @Column private Integer q21; @Column private Integer q22; @Column private Integer q23; @Column private Integer q24; @Column private Integer q25;
    @Column private Integer q26; @Column private Integer q27; @Column private Integer q28; @Column private Integer q29; @Column private Integer q30;
    @Column private Integer q31; @Column private Integer q32; @Column private Integer q33; @Column private Integer q34; @Column private Integer q35;
    @Column private Integer q36;

    @Column(name = "total_anxiety")
    private Integer totalAnxiety;

    @Column(name = "total_avoidance")
    private Integer totalAvoidance;

    public Long getId() { return id; } public void setId(Long id) { this.id = id; }
    public String getUserId() { return userId; } public void setUserId(String userId) { this.userId = userId; }
    public String getCoupleCode() { return coupleCode; } public void setCoupleCode(String coupleCode) { this.coupleCode = coupleCode; }

    public Integer getQ1(){return q1;} public void setQ1(Integer v){q1=v;} public Integer getQ2(){return q2;} public void setQ2(Integer v){q2=v;}
    public Integer getQ3(){return q3;} public void setQ3(Integer v){q3=v;} public Integer getQ4(){return q4;} public void setQ4(Integer v){q4=v;}
    public Integer getQ5(){return q5;} public void setQ5(Integer v){q5=v;} public Integer getQ6(){return q6;} public void setQ6(Integer v){q6=v;}
    public Integer getQ7(){return q7;} public void setQ7(Integer v){q7=v;} public Integer getQ8(){return q8;} public void setQ8(Integer v){q8=v;}
    public Integer getQ9(){return q9;} public void setQ9(Integer v){q9=v;} public Integer getQ10(){return q10;} public void setQ10(Integer v){q10=v;}
    public Integer getQ11(){return q11;} public void setQ11(Integer v){q11=v;} public Integer getQ12(){return q12;} public void setQ12(Integer v){q12=v;}
    public Integer getQ13(){return q13;} public void setQ13(Integer v){q13=v;} public Integer getQ14(){return q14;} public void setQ14(Integer v){q14=v;}
    public Integer getQ15(){return q15;} public void setQ15(Integer v){q15=v;} public Integer getQ16(){return q16;} public void setQ16(Integer v){q16=v;}
    public Integer getQ17(){return q17;} public void setQ17(Integer v){q17=v;} public Integer getQ18(){return q18;} public void setQ18(Integer v){q18=v;}
    public Integer getQ19(){return q19;} public void setQ19(Integer v){q19=v;} public Integer getQ20(){return q20;} public void setQ20(Integer v){q20=v;}
    public Integer getQ21(){return q21;} public void setQ21(Integer v){q21=v;} public Integer getQ22(){return q22;} public void setQ22(Integer v){q22=v;}
    public Integer getQ23(){return q23;} public void setQ23(Integer v){q23=v;} public Integer getQ24(){return q24;} public void setQ24(Integer v){q24=v;}
    public Integer getQ25(){return q25;} public void setQ25(Integer v){q25=v;} public Integer getQ26(){return q26;} public void setQ26(Integer v){q26=v;}
    public Integer getQ27(){return q27;} public void setQ27(Integer v){q27=v;} public Integer getQ28(){return q28;} public void setQ28(Integer v){q28=v;}
    public Integer getQ29(){return q29;} public void setQ29(Integer v){q29=v;} public Integer getQ30(){return q30;} public void setQ30(Integer v){q30=v;}
    public Integer getQ31(){return q31;} public void setQ31(Integer v){q31=v;} public Integer getQ32(){return q32;} public void setQ32(Integer v){q32=v;}
    public Integer getQ33(){return q33;} public void setQ33(Integer v){q33=v;} public Integer getQ34(){return q34;} public void setQ34(Integer v){q34=v;}
    public Integer getQ35(){return q35;} public void setQ35(Integer v){q35=v;} public Integer getQ36(){return q36;} public void setQ36(Integer v){q36=v;}

    public Integer getTotalAnxiety(){return totalAnxiety;} public void setTotalAnxiety(Integer v){totalAnxiety=v;}
    public Integer getTotalAvoidance(){return totalAvoidance;} public void setTotalAvoidance(Integer v){totalAvoidance=v;}
}
