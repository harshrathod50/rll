package com.company.rll.entity.admin;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity(name = "admin_schedule")
@Table(name = "admin_schedule")
public class ScheduleEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "schedule_id")
  private long scheduleId;

  @Column(name = "schdule_date")
  private Date scheduleDate;

  @OneToOne
  private BusEntity bus;

  @Column(name = "date_modified")
  private Date dateModified;

  @Column(name = "date_created")
  private Date dateCreated;
}
