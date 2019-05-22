package com.symbosoft.fulldemo;

import com.symbosoft.fulldemo.model.Employee;
import com.symbosoft.fulldemo.repository.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Tests the Employee model in relation to in-memory pre-configured DB only
     * does not validate configuration of production DB
     *
     * effectively a unit test - save for employee repository dependency
     */
    @Test
    public void whenFindByName_thenReturnEmployee() {
        var person = new Employee();
        person.setName("alex");

        entityManager.persist(person);
        entityManager.flush();

        var response = employeeRepository.findByName(person.getName());

        assertThat(response.getName()).isEqualTo(person.getName());
    }
}

