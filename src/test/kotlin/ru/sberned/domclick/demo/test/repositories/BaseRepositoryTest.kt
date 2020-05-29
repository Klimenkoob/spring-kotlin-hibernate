package ru.sberned.domclick.demo.test.repositories

import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringRunner
import ru.sberned.domclick.demo.repositories.DepartmentRepository
import ru.sberned.domclick.demo.repositories.EmployeeRepository
import ru.sberned.domclick.demo.test.configuration.PostgresTestContainersInitializer


@ActiveProfiles("test")
@RunWith(SpringRunner::class)
@DataJpaTest
@ContextConfiguration(
        initializers = [PostgresTestContainersInitializer::class]
)
abstract class BaseRepositoryTest {

    @Autowired
    protected lateinit var departmentRepository: DepartmentRepository

    @Autowired
    protected lateinit var employeeRepository: EmployeeRepository
}