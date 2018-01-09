package com.sysware.cloud.repository;

import com.sysware.cloud.entity.Health;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HealthRepository extends JpaRepository<Health,String> {
}
