package com.example.bean;


import com.example.util.StringUtils;

import javax.persistence.*;

/**
 * Created by heying on 2017/2/1 0001.
 */
@Entity
public class Year {
    @Id
    @GeneratedValue
    private Long id;
    private String cell11;
    private String cell21;
    private String cell31;
    private String cell32;
    private String cell33;
    private String cell34;
    private String cell35;
    private String cell36;
    private String cell37;
    private String cell38;
    private String city;
    private String industry;
    private String[] sale;
    private String[] crossCountry;
    private String cell41;
    private String cell42;
    @Transient private String cell51;
    private String cell52;
    private String cell53;
    private String cell54;
    @Transient private String cell61;
    private String cell62;
    private String cell63;
    private String cell64;
    private String cell71;
    private String cell72;
    private String cell73;
    private String cell74;
    private String cell75;
    private String companyName;
    private String year;
    private Long userId;

    private String cityId;
    private String permission;


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

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getSale() {
        return StringUtils.join(sale,",");
    }

    public void setSale(String[] sale) {
        this.sale = sale;
    }

    public String getCrossCountry() {
        return StringUtils.join(crossCountry,",");
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
