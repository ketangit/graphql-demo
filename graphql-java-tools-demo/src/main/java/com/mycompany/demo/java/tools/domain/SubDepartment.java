package com.mycompany.demo.java.tools.domain;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Table(indexes = {@Index(name = "I_SubDepartment_LookupCode", columnList = "LookupCode", unique = true)})
@Entity
public class SubDepartment {

    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "SubDepartmentID")
    private int subDepartmentId;

    @NotNull
    @Size(max = 30)
    @Basic
    @Column(name = "Name")
    private String name;

    @NotNull
    @Size(max = 10)
    @Basic
    @Column(name = "LookupCode")
    private String lookupCode;

    @Basic
    @Column(name = "DBTimeStamp")
    private LocalDateTime dbTimeStamp;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "DepartmentID", referencedColumnName = "DepartmentID", foreignKey = @ForeignKey(name = "FK_SubDepartment_Department"))
    private Department department;

    public int getSubDepartmentId() {
        return subDepartmentId;
    }

    public void setSubDepartmentId(int subDepartmentId) {
        this.subDepartmentId = subDepartmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLookupCode() {
        return lookupCode;
    }

    public void setLookupCode(String lookupCode) {
        this.lookupCode = lookupCode;
    }

    public LocalDateTime getDbTimeStamp() {
        return dbTimeStamp;
    }

    public void setDbTimeStamp(LocalDateTime dbTimeStamp) {
        this.dbTimeStamp = dbTimeStamp;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SubDepartment that = (SubDepartment) o;

        if (subDepartmentId != that.subDepartmentId) return false;
        if (!name.equals(that.name)) return false;
        if (!lookupCode.equals(that.lookupCode)) return false;
        if (!dbTimeStamp.equals(that.dbTimeStamp)) return false;
        return department.equals(that.department);
    }

    @Override
    public int hashCode() {
        int result = subDepartmentId;
        result = 31 * result + name.hashCode();
        result = 31 * result + lookupCode.hashCode();
        result = 31 * result + dbTimeStamp.hashCode();
        result = 31 * result + department.hashCode();
        return result;
    }
}
