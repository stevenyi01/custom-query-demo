package com.example.demo;

import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class DemoApplicationTests {
	@Autowired
	RobotRepository robotRepository;

	@Autowired
	RobotMemberRepository robotMemberRepository;

	@AfterEach
	void cleanup() {
		robotRepository.deleteAll();
		robotMemberRepository.deleteAll();
	}

	@Test
	void contextLoads() {

		int a = 2;


		Robot result = robotRepository.save(new Robot());

		RobotPool members = new RobotPool();
		members.setMembers(Set.of(result));

		RobotPool membersResult = robotMemberRepository.save(members);

		robotMemberRepository.findRobotMembersForRobot(result);
		int b = 2;

		int c = 3;
	}

}
