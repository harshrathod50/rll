package com.company.rll.repository.bus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.rll.entity.bus.BusEntity;

@Repository
public interface BusRepository extends JpaRepository<BusEntity,Integer>{

	

}
