package org.ibs.service;



import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.ibs.service.domain.Course;
import org.ibs.service.domain.Department;
import org.ibs.service.domain.Employee;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback(value = false)

class DbTest {

    @PersistenceContext
    EntityManager em;


    @BeforeEach
    void setup() {
        Department department = new Department(null, "IT");
        Course course = new Course(null, "Rest service");
        Employee emp = new Employee(null, "a", "b",
                LocalDate.now(), department, 500000, List.of(course));

        em.persist(department);
        em.persist(course);
        em.persist(emp);
    }

    @Test
    void test() {
        Assert.assertEquals(1, em.createQuery("FROM Department").getResultList().size());

        Employee emp = em.createQuery("FROM Employee", Employee.class)
                .setMaxResults(1)
                .getResultList()
                .get(0);

        Assert.assertEquals("Rest service", emp.getCourses().get(0).getName());

    }
}







