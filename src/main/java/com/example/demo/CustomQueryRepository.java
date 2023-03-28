package com.example.demo;

import java.util.List;

public interface CustomQueryRepository {

  List<RobotPool> findRobotMembersForRobot(String robotName);
}
