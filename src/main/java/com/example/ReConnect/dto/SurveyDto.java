package com.example.ReConnect.dto;

import com.example.ReConnect.entity.Survey;

public class SurveyDto {
    private Long id;
    private String userId;
    private String coupleCode;

    private Integer q1; private Integer q2; private Integer q3; private Integer q4; private Integer q5;
    private Integer q6; private Integer q7; private Integer q8; private Integer q9; private Integer q10;
    private Integer q11; private Integer q12; private Integer q13; private Integer q14; private Integer q15;
    private Integer q16; private Integer q17; private Integer q18; private Integer q19; private Integer q20;
    private Integer q21; private Integer q22; private Integer q23; private Integer q24; private Integer q25;
    private Integer q26; private Integer q27; private Integer q28; private Integer q29; private Integer q30;
    private Integer q31; private Integer q32; private Integer q33; private Integer q34; private Integer q35;
    private Integer q36;

    private Integer totalAnxiety;
    private Integer totalAvoidance;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }
    public String getCoupleCode() { return coupleCode; }
    public void setCoupleCode(String coupleCode) { this.coupleCode = coupleCode; }

    public Integer getQ1(){return q1;} public void setQ1(Integer v){q1=v;}
    public Integer getQ2(){return q2;} public void setQ2(Integer v){q2=v;}
    public Integer getQ3(){return q3;} public void setQ3(Integer v){q3=v;}
    public Integer getQ4(){return q4;} public void setQ4(Integer v){q4=v;}
    public Integer getQ5(){return q5;} public void setQ5(Integer v){q5=v;}
    public Integer getQ6(){return q6;} public void setQ6(Integer v){q6=v;}
    public Integer getQ7(){return q7;} public void setQ7(Integer v){q7=v;}
    public Integer getQ8(){return q8;} public void setQ8(Integer v){q8=v;}
    public Integer getQ9(){return q9;} public void setQ9(Integer v){q9=v;}
    public Integer getQ10(){return q10;} public void setQ10(Integer v){q10=v;}
    public Integer getQ11(){return q11;} public void setQ11(Integer v){q11=v;}
    public Integer getQ12(){return q12;} public void setQ12(Integer v){q12=v;}
    public Integer getQ13(){return q13;} public void setQ13(Integer v){q13=v;}
    public Integer getQ14(){return q14;} public void setQ14(Integer v){q14=v;}
    public Integer getQ15(){return q15;} public void setQ15(Integer v){q15=v;}
    public Integer getQ16(){return q16;} public void setQ16(Integer v){q16=v;}
    public Integer getQ17(){return q17;} public void setQ17(Integer v){q17=v;}
    public Integer getQ18(){return q18;} public void setQ18(Integer v){q18=v;}
    public Integer getQ19(){return q19;} public void setQ19(Integer v){q19=v;}
    public Integer getQ20(){return q20;} public void setQ20(Integer v){q20=v;}
    public Integer getQ21(){return q21;} public void setQ21(Integer v){q21=v;}
    public Integer getQ22(){return q22;} public void setQ22(Integer v){q22=v;}
    public Integer getQ23(){return q23;} public void setQ23(Integer v){q23=v;}
    public Integer getQ24(){return q24;} public void setQ24(Integer v){q24=v;}
    public Integer getQ25(){return q25;} public void setQ25(Integer v){q25=v;}
    public Integer getQ26(){return q26;} public void setQ26(Integer v){q26=v;}
    public Integer getQ27(){return q27;} public void setQ27(Integer v){q27=v;}
    public Integer getQ28(){return q28;} public void setQ28(Integer v){q28=v;}
    public Integer getQ29(){return q29;} public void setQ29(Integer v){q29=v;}
    public Integer getQ30(){return q30;} public void setQ30(Integer v){q30=v;}
    public Integer getQ31(){return q31;} public void setQ31(Integer v){q31=v;}
    public Integer getQ32(){return q32;} public void setQ32(Integer v){q32=v;}
    public Integer getQ33(){return q33;} public void setQ33(Integer v){q33=v;}
    public Integer getQ34(){return q34;} public void setQ34(Integer v){q34=v;}
    public Integer getQ35(){return q35;} public void setQ35(Integer v){q35=v;}
    public Integer getQ36(){return q36;} public void setQ36(Integer v){q36=v;}

    public Integer getTotalAnxiety(){ return totalAnxiety; }
    public void setTotalAnxiety(Integer v){ totalAnxiety = v; }
    public Integer getTotalAvoidance(){ return totalAvoidance; }
    public void setTotalAvoidance(Integer v){ totalAvoidance = v; }

    public static SurveyDto from(Survey s){
        SurveyDto d = new SurveyDto();
        d.setId(s.getId()); d.setUserId(s.getUserId()); d.setCoupleCode(s.getCoupleCode());
        d.setQ1(s.getQ1()); d.setQ2(s.getQ2()); d.setQ3(s.getQ3()); d.setQ4(s.getQ4()); d.setQ5(s.getQ5());
        d.setQ6(s.getQ6()); d.setQ7(s.getQ7()); d.setQ8(s.getQ8()); d.setQ9(s.getQ9()); d.setQ10(s.getQ10());
        d.setQ11(s.getQ11()); d.setQ12(s.getQ12()); d.setQ13(s.getQ13()); d.setQ14(s.getQ14()); d.setQ15(s.getQ15());
        d.setQ16(s.getQ16()); d.setQ17(s.getQ17()); d.setQ18(s.getQ18()); d.setQ19(s.getQ19()); d.setQ20(s.getQ20());
        d.setQ21(s.getQ21()); d.setQ22(s.getQ22()); d.setQ23(s.getQ23()); d.setQ24(s.getQ24()); d.setQ25(s.getQ25());
        d.setQ26(s.getQ26()); d.setQ27(s.getQ27()); d.setQ28(s.getQ28()); d.setQ29(s.getQ29()); d.setQ30(s.getQ30());
        d.setQ31(s.getQ31()); d.setQ32(s.getQ32()); d.setQ33(s.getQ33()); d.setQ34(s.getQ34()); d.setQ35(s.getQ35()); d.setQ36(s.getQ36());
        d.setTotalAnxiety(s.getTotalAnxiety()); d.setTotalAvoidance(s.getTotalAvoidance());
        return d;
    }
}
