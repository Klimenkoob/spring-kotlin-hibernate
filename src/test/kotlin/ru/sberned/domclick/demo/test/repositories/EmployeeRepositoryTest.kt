package ru.sberned.domclick.demo.test.repositories

import org.junit.Assert
import org.junit.Test
import ru.sberned.domclick.demo.entities.DepartmentEntity
import ru.sberned.domclick.demo.entities.EmployeeEntity

class EmployeeRepositoryTest : BaseRepositoryTest() {

    @Test
    fun `test save and get`() {
        val departmentId = departmentRepository.save(DepartmentEntity(name = "Common department")).id!!
        val employeeId = employeeRepository.save(
                        EmployeeEntity(
                                firstName = "Vasya",
                                department = departmentRepository.getOne(departmentId))
                ).id!!
        Assert.assertEquals(1, employeeRepository.count())
        val employee = employeeRepository.findById(employeeId).get()
        Assert.assertEquals("Vasya", employee.firstName)
    }
}