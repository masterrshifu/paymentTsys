package com.tsys.tsep.repository;

import com.tsys.tsep.model.TransactionKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionKeyRepository extends JpaRepository<TransactionKey, Integer> {

}
