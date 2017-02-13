package com.example.bean;

import javax.persistence.*;

/**
 * Created by heying on 2017/2/1 0001.
 */
@Entity
public class Year {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String cell11;
    @Column
    private String cell21;
    @Column
    private String cell31;
    @Column
    private String cell32;
    @Column
    private String cell33;
    @Column
    private String cell34;
    @Column
    private String cell35;
    @Column
    private String cell36;
    @Column
    private String cell37;
    @Column
    private String cell38;
    @Column
    private String city;
    @Column
    private String[] industry;
    @Column
    private String[] sale;
    @Column
    private String[] crossCountry;
    @Column
    private String cell41;
    @Column
    private String cell42;
    @Column
    private String cell51;
    @Column
    private String cell52;
    @Column
    private String cell53;
    @Column
    private String cell54;
    @Column
    private String cell61;
    @Column
    private String cell62;
    @Column
    private String cell63;
    @Column
    private String cell64;
    @Column
    private String cell71;
    @Column
    private String cell72;
    @Column
    private String cell73;
    @Column
    private String cell74;
    @Column
    private String cell75;
    @Column
    private String companyName;
    @Column
    private String year;
    @Column
    private Long userId;
    @Column
    private String r_cell11;
    @Column
    private String r_cell12;
    @Column
    private String r_cell13;
    @Column
    private String r_cell14;
    @Column
    private String r_cell15;
    @Column
    private String r_cell21;
    @Column
    private String r_cell22;
    @Column
    private String r_cell23;
    @Column
    private String r_cell24;
    @Column
    private String r_cell25;
    @Column
    private String r_cell31;
    @Column
    private String r_cell32;
    @Column
    private String r_cell33;
    @Column
    private String r_cell34;
    @Column
    private String r_cell35;
    @Column
    private String r_cell41;
    @Column
    private String r_cell42;
    @Column
    private String r_cell43;
    @Column
    private String r_cell44;
    @Column
    private String r_cell45;
    @Column
    private String r_cell51;
    @Column
    private String r_cell52;
    @Column
    private String r_cell53;
    @Column
    private String r_cell54;
    @Column
    private String r_cell55;
    @Column
    private String r_cell61;
    @Column
    private String r_cell62;
    @Column
    private String r_cell63;
    @Column
    private String r_cell64;
    @Column
    private String r_cell65;
    @Column
    private String r_cell71;
    @Column
    private String r_cell72;
    @Column
    private String r_cell73;
    @Column
    private String r_cell74;
    @Column
    private String r_cell75;
    @Column
    private String r_cell81;
    @Column
    private String r_cell82;
    @Column
    private String r_cell83;
    @Column
    private String r_cell84;
    @Column
    private String r_cell85;
    @Column
    private String r_cell91;
    @Column
    private String r_cell92;
    @Column
    private String r_cell93;
    @Column
    private String r_cell94;
    @Column
    private String r_cell95;
    @Column
    private String r_cell101;
    @Column
    private String r_cell102;
    @Column
    private String r_cell103;
    @Column
    private String r_cell104;
    @Column
    private String r_cell105;
    @Column
    private String cityid;
    @Column private String permission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCell11() {
        return cell11;
    }

    public void setCell11(String cell11) {
        this.cell11 = cell11;
    }

    public String getCell21() {
        return cell21;
    }

    public void setCell21(String cell21) {
        this.cell21 = cell21;
    }

    public String getCell31() {
        return cell31;
    }

    public void setCell31(String cell31) {
        this.cell31 = cell31;
    }

    public String getCell32() {
        return cell32;
    }

    public void setCell32(String cell32) {
        this.cell32 = cell32;
    }

    public String getCell33() {
        return cell33;
    }

    public void setCell33(String cell33) {
        this.cell33 = cell33;
    }

    public String getCell34() {
        return cell34;
    }

    public void setCell34(String cell34) {
        this.cell34 = cell34;
    }

    public String getCell35() {
        return cell35;
    }

    public void setCell35(String cell35) {
        this.cell35 = cell35;
    }

    public String getCell36() {
        return cell36;
    }

    public void setCell36(String cell36) {
        this.cell36 = cell36;
    }

    public String getCell37() {
        return cell37;
    }

    public void setCell37(String cell37) {
        this.cell37 = cell37;
    }

    public String getCell38() {
        return cell38;
    }

    public void setCell38(String cell38) {
        this.cell38 = cell38;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String[] getIndustry() {
        return industry;
    }

    public void setIndustry(String[] industry) {
        this.industry = industry;
    }

    public String[] getSale() {
        return sale;
    }

    public void setSale(String[] sale) {
        this.sale = sale;
    }

    public String[] getCrossCountry() {
        return crossCountry;
    }

    public void setCrossCountry(String[] crossCountry) {
        this.crossCountry = crossCountry;
    }

    public String getCell41() {
        return cell41;
    }

    public void setCell41(String cell41) {
        this.cell41 = cell41;
    }

    public String getCell42() {
        return cell42;
    }

    public void setCell42(String cell42) {
        this.cell42 = cell42;
    }

    public String getCell51() {
        return cell51;
    }

    public void setCell51(String cell51) {
        this.cell51 = cell51;
    }

    public String getCell52() {
        return cell52;
    }

    public void setCell52(String cell52) {
        this.cell52 = cell52;
    }

    public String getCell53() {
        return cell53;
    }

    public void setCell53(String cell53) {
        this.cell53 = cell53;
    }

    public String getCell54() {
        return cell54;
    }

    public void setCell54(String cell54) {
        this.cell54 = cell54;
    }

    public String getCell61() {
        return cell61;
    }

    public void setCell61(String cell61) {
        this.cell61 = cell61;
    }

    public String getCell62() {
        return cell62;
    }

    public void setCell62(String cell62) {
        this.cell62 = cell62;
    }

    public String getCell63() {
        return cell63;
    }

    public void setCell63(String cell63) {
        this.cell63 = cell63;
    }

    public String getCell64() {
        return cell64;
    }

    public void setCell64(String cell64) {
        this.cell64 = cell64;
    }

    public String getCell71() {
        return cell71;
    }

    public void setCell71(String cell71) {
        this.cell71 = cell71;
    }

    public String getCell72() {
        return cell72;
    }

    public void setCell72(String cell72) {
        this.cell72 = cell72;
    }

    public String getCell73() {
        return cell73;
    }

    public void setCell73(String cell73) {
        this.cell73 = cell73;
    }

    public String getCell74() {
        return cell74;
    }

    public void setCell74(String cell74) {
        this.cell74 = cell74;
    }

    public String getCell75() {
        return cell75;
    }

    public void setCell75(String cell75) {
        this.cell75 = cell75;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public String getR_cell11() {
        return r_cell11;
    }

    public void setR_cell11(String r_cell11) {
        this.r_cell11 = r_cell11;
    }

    public String getR_cell12() {
        return r_cell12;
    }

    public void setR_cell12(String r_cell12) {
        this.r_cell12 = r_cell12;
    }

    public String getR_cell13() {
        return r_cell13;
    }

    public void setR_cell13(String r_cell13) {
        this.r_cell13 = r_cell13;
    }

    public String getR_cell14() {
        return r_cell14;
    }

    public void setR_cell14(String r_cell14) {
        this.r_cell14 = r_cell14;
    }

    public String getR_cell15() {
        return r_cell15;
    }

    public void setR_cell15(String r_cell15) {
        this.r_cell15 = r_cell15;
    }

    public String getR_cell21() {
        return r_cell21;
    }

    public void setR_cell21(String r_cell21) {
        this.r_cell21 = r_cell21;
    }

    public String getR_cell22() {
        return r_cell22;
    }

    public void setR_cell22(String r_cell22) {
        this.r_cell22 = r_cell22;
    }

    public String getR_cell23() {
        return r_cell23;
    }

    public void setR_cell23(String r_cell23) {
        this.r_cell23 = r_cell23;
    }

    public String getR_cell24() {
        return r_cell24;
    }

    public void setR_cell24(String r_cell24) {
        this.r_cell24 = r_cell24;
    }

    public String getR_cell25() {
        return r_cell25;
    }

    public void setR_cell25(String r_cell25) {
        this.r_cell25 = r_cell25;
    }

    public String getR_cell31() {
        return r_cell31;
    }

    public void setR_cell31(String r_cell31) {
        this.r_cell31 = r_cell31;
    }

    public String getR_cell32() {
        return r_cell32;
    }

    public void setR_cell32(String r_cell32) {
        this.r_cell32 = r_cell32;
    }

    public String getR_cell33() {
        return r_cell33;
    }

    public void setR_cell33(String r_cell33) {
        this.r_cell33 = r_cell33;
    }

    public String getR_cell34() {
        return r_cell34;
    }

    public void setR_cell34(String r_cell34) {
        this.r_cell34 = r_cell34;
    }

    public String getR_cell35() {
        return r_cell35;
    }

    public void setR_cell35(String r_cell35) {
        this.r_cell35 = r_cell35;
    }

    public String getR_cell41() {
        return r_cell41;
    }

    public void setR_cell41(String r_cell41) {
        this.r_cell41 = r_cell41;
    }

    public String getR_cell42() {
        return r_cell42;
    }

    public void setR_cell42(String r_cell42) {
        this.r_cell42 = r_cell42;
    }

    public String getR_cell43() {
        return r_cell43;
    }

    public void setR_cell43(String r_cell43) {
        this.r_cell43 = r_cell43;
    }

    public String getR_cell44() {
        return r_cell44;
    }

    public void setR_cell44(String r_cell44) {
        this.r_cell44 = r_cell44;
    }

    public String getR_cell45() {
        return r_cell45;
    }

    public void setR_cell45(String r_cell45) {
        this.r_cell45 = r_cell45;
    }

    public String getR_cell51() {
        return r_cell51;
    }

    public void setR_cell51(String r_cell51) {
        this.r_cell51 = r_cell51;
    }

    public String getR_cell52() {
        return r_cell52;
    }

    public void setR_cell52(String r_cell52) {
        this.r_cell52 = r_cell52;
    }

    public String getR_cell53() {
        return r_cell53;
    }

    public void setR_cell53(String r_cell53) {
        this.r_cell53 = r_cell53;
    }

    public String getR_cell54() {
        return r_cell54;
    }

    public void setR_cell54(String r_cell54) {
        this.r_cell54 = r_cell54;
    }

    public String getR_cell55() {
        return r_cell55;
    }

    public void setR_cell55(String r_cell55) {
        this.r_cell55 = r_cell55;
    }

    public String getR_cell61() {
        return r_cell61;
    }

    public void setR_cell61(String r_cell61) {
        this.r_cell61 = r_cell61;
    }

    public String getR_cell62() {
        return r_cell62;
    }

    public void setR_cell62(String r_cell62) {
        this.r_cell62 = r_cell62;
    }

    public String getR_cell63() {
        return r_cell63;
    }

    public void setR_cell63(String r_cell63) {
        this.r_cell63 = r_cell63;
    }

    public String getR_cell64() {
        return r_cell64;
    }

    public void setR_cell64(String r_cell64) {
        this.r_cell64 = r_cell64;
    }

    public String getR_cell65() {
        return r_cell65;
    }

    public void setR_cell65(String r_cell65) {
        this.r_cell65 = r_cell65;
    }

    public String getR_cell71() {
        return r_cell71;
    }

    public void setR_cell71(String r_cell71) {
        this.r_cell71 = r_cell71;
    }

    public String getR_cell72() {
        return r_cell72;
    }

    public void setR_cell72(String r_cell72) {
        this.r_cell72 = r_cell72;
    }

    public String getR_cell73() {
        return r_cell73;
    }

    public void setR_cell73(String r_cell73) {
        this.r_cell73 = r_cell73;
    }

    public String getR_cell74() {
        return r_cell74;
    }

    public void setR_cell74(String r_cell74) {
        this.r_cell74 = r_cell74;
    }

    public String getR_cell75() {
        return r_cell75;
    }

    public void setR_cell75(String r_cell75) {
        this.r_cell75 = r_cell75;
    }

    public String getR_cell81() {
        return r_cell81;
    }

    public void setR_cell81(String r_cell81) {
        this.r_cell81 = r_cell81;
    }

    public String getR_cell82() {
        return r_cell82;
    }

    public void setR_cell82(String r_cell82) {
        this.r_cell82 = r_cell82;
    }

    public String getR_cell83() {
        return r_cell83;
    }

    public void setR_cell83(String r_cell83) {
        this.r_cell83 = r_cell83;
    }

    public String getR_cell84() {
        return r_cell84;
    }

    public void setR_cell84(String r_cell84) {
        this.r_cell84 = r_cell84;
    }

    public String getR_cell85() {
        return r_cell85;
    }

    public void setR_cell85(String r_cell85) {
        this.r_cell85 = r_cell85;
    }

    public String getR_cell91() {
        return r_cell91;
    }

    public void setR_cell91(String r_cell91) {
        this.r_cell91 = r_cell91;
    }

    public String getR_cell92() {
        return r_cell92;
    }

    public void setR_cell92(String r_cell92) {
        this.r_cell92 = r_cell92;
    }

    public String getR_cell93() {
        return r_cell93;
    }

    public void setR_cell93(String r_cell93) {
        this.r_cell93 = r_cell93;
    }

    public String getR_cell94() {
        return r_cell94;
    }

    public void setR_cell94(String r_cell94) {
        this.r_cell94 = r_cell94;
    }

    public String getR_cell95() {
        return r_cell95;
    }

    public void setR_cell95(String r_cell95) {
        this.r_cell95 = r_cell95;
    }

    public String getR_cell101() {
        return r_cell101;
    }

    public void setR_cell101(String r_cell101) {
        this.r_cell101 = r_cell101;
    }

    public String getR_cell102() {
        return r_cell102;
    }

    public void setR_cell102(String r_cell102) {
        this.r_cell102 = r_cell102;
    }

    public String getR_cell103() {
        return r_cell103;
    }

    public void setR_cell103(String r_cell103) {
        this.r_cell103 = r_cell103;
    }

    public String getR_cell104() {
        return r_cell104;
    }

    public void setR_cell104(String r_cell104) {
        this.r_cell104 = r_cell104;
    }

    public String getR_cell105() {
        return r_cell105;
    }

    public void setR_cell105(String r_cell105) {
        this.r_cell105 = r_cell105;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
