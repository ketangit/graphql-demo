package com.mycompany.demo.java.tools.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Table(indexes = {@Index(name = "I_SizeCodeDefinition_LookupCode", columnList = "LookupCode", unique = true)})
@Entity
public class SizeCodeDefinition {
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "SizeCodeID")
    private int sizeCodeId;

    @NotNull
    @Size(max = 10)
    @Basic
    @Column(name = "LookupCode")
    private String lookupCode;

    @NotNull
    @Size(max = 10)
    @Basic
    @Column(name = "BottleSize")
    private String bottleSize;

    @NotNull
    @Basic
    @Column(name = "PackPerCase")
    private int packPerCase;

    @NotNull
    @Basic
    @Column(name = "UnitPerCase")
    private int unitPerCase;

    @Basic
    @Column(name = "DBTimeStamp")
    private LocalDateTime dbTimeStamp;

    public int getSizeCodeId() {
        return sizeCodeId;
    }

    public void setSizeCodeId(int sizeCodeId) {
        this.sizeCodeId = sizeCodeId;
    }

    public String getLookupCode() {
        return lookupCode;
    }

    public void setLookupCode(String lookupCode) {
        this.lookupCode = lookupCode;
    }

    public String getBottleSize() {
        return bottleSize;
    }

    public void setBottleSize(String bottleSize) {
        this.bottleSize = bottleSize;
    }

    public int getPackPerCase() {
        return packPerCase;
    }

    public void setPackPerCase(int packPerCase) {
        this.packPerCase = packPerCase;
    }

    public int getUnitPerCase() {
        return unitPerCase;
    }

    public void setUnitPerCase(int unitPerCase) {
        this.unitPerCase = unitPerCase;
    }

    public LocalDateTime getDbTimeStamp() {
        return dbTimeStamp;
    }

    public void setDbTimeStamp(LocalDateTime dbTimeStamp) {
        this.dbTimeStamp = dbTimeStamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SizeCodeDefinition that = (SizeCodeDefinition) o;

        if (sizeCodeId != that.sizeCodeId) return false;
        if (packPerCase != that.packPerCase) return false;
        if (unitPerCase != that.unitPerCase) return false;
        if (!lookupCode.equals(that.lookupCode)) return false;
        if (!bottleSize.equals(that.bottleSize)) return false;
        return dbTimeStamp.equals(that.dbTimeStamp);
    }

    @Override
    public int hashCode() {
        int result = sizeCodeId;
        result = 31 * result + lookupCode.hashCode();
        result = 31 * result + bottleSize.hashCode();
        result = 31 * result + packPerCase;
        result = 31 * result + unitPerCase;
        result = 31 * result + dbTimeStamp.hashCode();
        return result;
    }
}
