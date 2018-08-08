package com.mycompany.demo.java.tools.repository;

import com.mycompany.demo.java.tools.domain.SizeCodeDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SizeCodeDefinitionRepository extends JpaRepository<SizeCodeDefinition, Integer> {

}
