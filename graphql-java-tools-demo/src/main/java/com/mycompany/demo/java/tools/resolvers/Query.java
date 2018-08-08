package com.mycompany.demo.java.tools.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mycompany.demo.java.tools.domain.Department;
import com.mycompany.demo.java.tools.domain.DepartmentGroup;
import com.mycompany.demo.java.tools.domain.SalesTaxGroup;
import com.mycompany.demo.java.tools.domain.SizeCodeDefinition;
import com.mycompany.demo.java.tools.domain.SubDepartment;
import com.mycompany.demo.java.tools.domain.UpcCode;
import com.mycompany.demo.java.tools.repository.DepartmentGroupRepository;
import com.mycompany.demo.java.tools.repository.DepartmentRepository;
import com.mycompany.demo.java.tools.repository.SalesTaxGroupRepository;
import com.mycompany.demo.java.tools.repository.SizeCodeDefinitionRepository;
import com.mycompany.demo.java.tools.repository.SubDepartmentRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class Query implements GraphQLQueryResolver {
    private final DepartmentRepository departmentRepository;
    private final DepartmentGroupRepository departmentGroupRepository;
    private final SubDepartmentRepository subDepartmentRepository;
    private final SalesTaxGroupRepository salesTaxGroupRepository;
    private final SizeCodeDefinitionRepository sizeCodeDefinitionRepository;

    public Query(DepartmentRepository departmentRepository, DepartmentGroupRepository departmentGroupRepository, SubDepartmentRepository subDepartmentRepository, SalesTaxGroupRepository salesTaxGroupRepository, SizeCodeDefinitionRepository sizeCodeDefinitionRepository) {
        this.departmentRepository = departmentRepository;
        this.departmentGroupRepository = departmentGroupRepository;
        this.subDepartmentRepository = subDepartmentRepository;
        this.salesTaxGroupRepository = salesTaxGroupRepository;
        this.sizeCodeDefinitionRepository = sizeCodeDefinitionRepository;
    }

    public Optional<Department> department(int departmentId) {
        return departmentRepository.findById(departmentId);
    }

    public Optional<SubDepartment> subDepartment(int subDepartmentId) {
        return subDepartmentRepository.findById(subDepartmentId);
    }

    public Optional<SalesTaxGroup> salesTaxGroup(int salesTaxGroupId) {
        return salesTaxGroupRepository.findById(salesTaxGroupId);
    }

    public Optional<DepartmentGroup> departmentGroup(int departmentGroupId) {
        return departmentGroupRepository.findById(departmentGroupId);
    }

    public Optional<SizeCodeDefinition> sizeCodeDefinition(int sizeCodeId) {
        return sizeCodeDefinitionRepository.findById(sizeCodeId);
    }

    public UpcCode upcCode(int upcCodeId, int itemId) {
        return new UpcCode();
    }
}
