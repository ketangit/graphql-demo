package com.mycompany.demo.java.tools.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.mycompany.demo.java.tools.domain.Department;
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
}
