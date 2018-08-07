package com.mycompany.demo.java.tools.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Table(indexes = {@Index(name = "I_SalesTaxGroup_SalesTaxGroupName", columnList = "SalesTaxGroupName", unique = true)})
@Entity
public class SalesTaxGroup {

    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "SalesTaxGroupID")
    private int salesTaxGroupId;

    @NotNull
    @Size(max = 50)
    @Basic
    @Column(name = "SalesTaxGroupName")
    private String salesTaxGroupName;

    @NotNull
    @Digits(integer = 2, fraction = 2)
    @Basic
    @Column(name = "SalesTaxGroupValue", precision = 2, scale = 2)
    private Double salesTaxGroupValue;

    public int getSalesTaxGroupId() {
        return salesTaxGroupId;
    }

    public void setSalesTaxGroupId(int salesTaxGroupId) {
        this.salesTaxGroupId = salesTaxGroupId;
    }

    public String getSalesTaxGroupName() {
        return salesTaxGroupName;
    }

    public void setSalesTaxGroupName(String salesTaxGroupName) {
        this.salesTaxGroupName = salesTaxGroupName;
    }

    public Double getSalesTaxGroupValue() {
        return salesTaxGroupValue;
    }

    public void setSalesTaxGroupValue(Double salesTaxGroupValue) {
        this.salesTaxGroupValue = salesTaxGroupValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalesTaxGroup that = (SalesTaxGroup) o;

        if (salesTaxGroupId != that.salesTaxGroupId) return false;
        if (!salesTaxGroupName.equals(that.salesTaxGroupName)) return false;
        return salesTaxGroupValue.equals(that.salesTaxGroupValue);
    }

    @Override
    public int hashCode() {
        int result = salesTaxGroupId;
        result = 31 * result + salesTaxGroupName.hashCode();
        result = 31 * result + salesTaxGroupValue.hashCode();
        return result;
    }
}
