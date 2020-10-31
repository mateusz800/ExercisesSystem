package com.example.core.domain.repository;

import com.example.core.domain.entity.SystemConfig;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemConfigRepository extends CrudRepository<SystemConfig, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM math.system_config WHERE param = ? LIMIT 1")
    SystemConfig getParam(String param);
}
