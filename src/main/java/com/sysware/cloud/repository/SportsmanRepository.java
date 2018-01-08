package com.sysware.cloud.repository;

import com.sysware.cloud.entity.Sportsman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SportsmanRepository extends JpaRepository<Sportsman,String> {
}
