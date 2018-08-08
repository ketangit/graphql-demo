package com.mycompany.demo.java.tools.repository;

import com.mycompany.demo.java.tools.domain.DepartmentGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentGroupRepository extends JpaRepository<DepartmentGroup, Integer> {

}
