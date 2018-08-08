package com.mycompany.demo.java.tools.repository;

import com.mycompany.demo.java.tools.domain.SalesTaxGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesTaxGroupRepository extends JpaRepository<SalesTaxGroup, Integer> {

}
