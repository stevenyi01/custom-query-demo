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
  public List<RobotPool> findRobotMembersForRobot(Robot robot) {
    CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
    CriteriaQuery<RobotPool> criteriaQuery = criteriaBuilder.createQuery(RobotPool.class);
    Root<RobotPool> root = criteriaQuery.from(RobotPool.class);

    Expression<Boolean> isMemberClause = criteriaBuilder.isMember(robot, root.get("members"));

    criteriaQuery.select(root).where(isMemberClause);

//    select generatedAlias0 from RobotPool as generatedAlias0 where generatedAlias0.members in (:param0)

//    In<Robot> inClause = criteriaBuilder.in(robot);
//    inClause.value(root.get("members"));
//
//    criteriaQuery.select(root);
//    criteriaQuery.where(inClause);
//
    return em.createQuery(criteriaQuery).getResultList();
  }
}
