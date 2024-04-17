package com.tsys.tsep.repository;

import com.tsys.tsep.model.Sale;
import com.tsys.tsep.model.SaleResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<SaleResponse, Integer> {


}
