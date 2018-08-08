package com.mycompany.demo.java.tools.repository;

import com.mycompany.demo.java.tools.domain.SubDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubDepartmentRepository extends JpaRepository<SubDepartment, Integer> {

}
