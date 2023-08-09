package com.company.rll.repository.admin;

import com.company.rll.entity.admin.BusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusRepository extends JpaRepository<BusEntity, Integer> {}
