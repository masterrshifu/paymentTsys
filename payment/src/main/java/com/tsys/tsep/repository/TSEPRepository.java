package com.tsys.tsep.repository;

import com.tsys.tsep.model.TSEPToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TSEPRepository extends CrudRepository<TSEPToken,String> {

}
