package com.tsys.tsep.repository;

import com.tsys.tsep.model.AccountDetailsVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDetailsRepository extends JpaRepository<AccountDetailsVO, Integer> {

    boolean existsByEmail(String email);

    AccountDetailsVO findByEmail(String email);
}
