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

@Table(indexes = {@Index(name = "I_DepartmentGroup_DepartmentGroupName", columnList = "DepartmentGroupName", unique = true)})
@Entity
public class DepartmentGroup {

    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name = "DepartmentGroupID")
    private int departmentGroupId;

    @NotNull
    @Size(max = 50)
    @Basic
    @Column(name = "DepartmentGroupName")
    private String departmentGroupName;

    @Size(max = 100)
    @Basic
    @Column(name = "DepartmentGroupDescription")
    private String departmentGroupDescription;

    public int getDepartmentGroupId() {
        return departmentGroupId;
    }

    public void setDepartmentGroupId(int departmentGroupId) {
        this.departmentGroupId = departmentGroupId;
    }

    public String getDepartmentGroupName() {
        return departmentGroupName;
    }

    public void setDepartmentGroupName(String departmentGroupName) {
        this.departmentGroupName = departmentGroupName;
    }

    public String getDepartmentGroupDescription() {
        return departmentGroupDescription;
    }

    public void setDepartmentGroupDescription(String departmentGroupDescription) {
        this.departmentGroupDescription = departmentGroupDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DepartmentGroup that = (DepartmentGroup) o;

        if (departmentGroupId != that.departmentGroupId) return false;
        if (!departmentGroupName.equals(that.departmentGroupName)) return false;
        return departmentGroupDescription != null ? departmentGroupDescription.equals(that.departmentGroupDescription) : that.departmentGroupDescription == null;
    }

    @Override
    public int hashCode() {
        int result = departmentGroupId;
        result = 31 * result + departmentGroupName.hashCode();
        result = 31 * result + (departmentGroupDescription != null ? departmentGroupDescription.hashCode() : 0);
        return result;
    }
}
