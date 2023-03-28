package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Robot {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Column(name = "robot_name")
  private String robotName;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRobotName() {
    return robotName;
  }

  public void setRobotName(String robotName) {
    this.robotName = robotName;
  }

  @Override
  public String toString() {
    return String.format("Robot id: %d, name %s", id, robotName);
  }

}
