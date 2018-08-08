package com.mycompany.demo.java.tools.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Table(indexes = {@Index(name = "I_Department_Name", columnList = "Name", unique = true)})
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Department {

    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "DepartmentID")
    private int departmentId;

    @NotNull
    @Size(max = 10)
    @Basic
    @Column(name = "LookupCode")
    private String lookupCode;

    @NotNull
    @Size(max = 30)
    @Basic
    @Column(name = "Name")
    private String name;

    @NotNull
    @Digits(integer = 2, fraction = 2)
    @Basic
    @Column(name = "Markup", precision = 2, scale = 2)
    private Double markup;

    @Basic
    @CreatedDate
    @Column(name = "DBTimeStamp")
    private LocalDateTime dbTimeStamp;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "DepartmentGroupID", referencedColumnName = "DepartmentGroupID", foreignKey = @ForeignKey(name = "FK_Department_DepartmentGroup"))
    private DepartmentGroup departmentGroup;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "SalesTaxGroupID", referencedColumnName = "SalesTaxGroupID", foreignKey = @ForeignKey(name = "FK_Department_SalesTaxGroup"))
    private SalesTaxGroup salesTaxGroup;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getLookupCode() {
        return lookupCode;
    }

    public void setLookupCode(String lookupCode) {
        this.lookupCode = lookupCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMarkup() {
        return markup;
    }

    public void setMarkup(Double markup) {
        this.markup = markup;
    }

    public LocalDateTime getDbTimeStamp() {
        return dbTimeStamp;
    }

    public void setDbTimeStamp(LocalDateTime dbTimeStamp) {
        this.dbTimeStamp = dbTimeStamp;
    }

    public DepartmentGroup getDepartmentGroup() {
        return departmentGroup;
    }

    public void setDepartmentGroup(DepartmentGroup departmentGroup) {
        this.departmentGroup = departmentGroup;
    }

    public SalesTaxGroup getSalesTaxGroup() {
        return salesTaxGroup;
    }

    public void setSalesTaxGroup(SalesTaxGroup salesTaxGroup) {
        this.salesTaxGroup = salesTaxGroup;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (departmentId != that.departmentId) return false;
        if (!lookupCode.equals(that.lookupCode)) return false;
        if (!name.equals(that.name)) return false;
        if (!markup.equals(that.markup)) return false;
        if (!dbTimeStamp.equals(that.dbTimeStamp)) return false;
        if (!departmentGroup.equals(that.departmentGroup)) return false;
        return salesTaxGroup.equals(that.salesTaxGroup);
    }

    @Override
    public int hashCode() {
        int result = departmentId;
        result = 31 * result + lookupCode.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + markup.hashCode();
        result = 31 * result + dbTimeStamp.hashCode();
        result = 31 * result + departmentGroup.hashCode();
        result = 31 * result + salesTaxGroup.hashCode();
        return result;
    }
}
