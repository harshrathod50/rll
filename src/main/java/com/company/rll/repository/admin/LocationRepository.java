package com.company.rll.repository.admin;

import com.company.rll.entity.admin.LocationEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Long> {
  Page<LocationEntity> findAll(Pageable page);
}
