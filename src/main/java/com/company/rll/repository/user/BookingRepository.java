package com.company.rll.repository.user;

import com.company.rll.entity.user.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
  @Query("FROM user_booking WHERE user_id = ?1")
  BookingEntity findByUserId(long userId);
}
