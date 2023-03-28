package com.example.demo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

public class CustomQueryRepositoryImpl implements CustomQueryRepository{

  @PersistenceContext EntityManager em;


  @Override
  public List<RobotPool> findRobotMembersForRobot(String robotName) {
    List<Robot> robotQueryResult = getRobotWithName(robotName);
    if (robotQueryResult.size() != 1) {
      // do some error handling i guess
    }
    Robot robot = robotQueryResult.get(0);

    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<RobotPool> criteriaQuery = criteriaBuilder.createQuery(RobotPool.class);
    Root<RobotPool> root = criteriaQuery.from(RobotPool.class);

    Expression<Boolean> isMemberClause = criteriaBuilder.isMember(robot, root.get("members"));
    criteriaQuery.select(root).where(isMemberClause);

    return em.createQuery(criteriaQuery).getResultList();
  }

  private List<Robot> getRobotWithName(String robotName) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<Robot> criteriaQuery = criteriaBuilder.createQuery(Robot.class);
    Root<Robot> root = criteriaQuery.from(Robot.class);

    Expression<Boolean> predicate = criteriaBuilder.equal(root.get("robotName"), robotName);
    criteriaQuery.select(root).where(predicate);

    return em.createQuery(criteriaQuery).getResultList();

  }
}
