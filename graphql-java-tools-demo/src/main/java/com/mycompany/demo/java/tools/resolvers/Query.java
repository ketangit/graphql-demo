package com.mycompany.demo.java.tools.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mycompany.demo.java.tools.domain.Department;
import com.mycompany.demo.java.tools.domain.DepartmentGroup;
import com.mycompany.demo.java.tools.domain.SalesTaxGroup;
import com.mycompany.demo.java.tools.domain.SizeCodeDefinition;
import com.mycompany.demo.java.tools.domain.SubDepartment;
import com.mycompany.demo.java.tools.domain.UpcCode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Query implements GraphQLQueryResolver {
    public Department department(int departmentId) {
        Department department = new Department();
        department.setDepartmentId(departmentId);
        return department;
    }

    public List<Department> departments() {
        return new ArrayList<>();
    }

    public SubDepartment subDepartment(int subDepartmentId) {
        return new SubDepartment();
    }

    public SalesTaxGroup salesTaxGroup(int salesTaxGroupId) {
        return new SalesTaxGroup();
    }

    public DepartmentGroup departmentGroup(int departmentGroupId) {
        return new DepartmentGroup();
    }

    public SizeCodeDefinition sizeCodeDefinition(int sizeCodeId) {
        return new SizeCodeDefinition();
    }

    public UpcCode upcCode(int upcCodeId, int itemId) {
        return new UpcCode();
    }
}
