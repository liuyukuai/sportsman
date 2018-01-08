package com.sysware.cloud.repository;

import com.sysware.cloud.entity.Athlete;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AthleteRepository extends JpaRepository<Athlete,String> {
}
