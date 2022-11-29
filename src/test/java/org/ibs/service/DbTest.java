package org.ibs.service;



import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.ibs.service.domain.Course;
import org.ibs.service.domain.Department;
import org.ibs.service.domain.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


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
        //   Employee emp = new Employee(null, "a", "b", LocalDate.now(), );

        em.persist(department);
        em.persist(course);
    }

    @Test
    void test(){

    }




}







