package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RobotMemberRepository extends JpaRepository<RobotPool, Long>, CustomQueryRepository {
}
