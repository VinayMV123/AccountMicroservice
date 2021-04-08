package com.amisign.accountservice.repository;

import com.amisign.accountservice.model.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<UserDO, Long> {

}
