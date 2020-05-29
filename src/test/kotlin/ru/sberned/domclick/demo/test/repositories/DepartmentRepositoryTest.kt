package ru.sberned.domclick.demo.test.repositories

import org.junit.Assert
import org.junit.Test
import ru.sberned.domclick.demo.entities.DepartmentEntity
import ru.sberned.domclick.demo.entities.EmployeeEntity

class DepartmentRepositoryTest : BaseRepositoryTest() {

    @Test
    fun `test save and update`() {
        val id = departmentRepository.save(
                DepartmentEntity(
                        name = "Department One"
                )
        ).id!!
        Assert.assertEquals(1, departmentRepository.count())
            val savedDepartment = departmentRepository.findById(id).get()
            savedDepartment.addEmployee { EmployeeEntity(department = this, firstName = "Ivan", lastName = "Petrov") }
            savedDepartment.addEmployee { EmployeeEntity(department = this, firstName = "Masha", lastName = "Ivanova") }
            departmentRepository.save(savedDepartment)
            val updatedDepartment = departmentRepository.findById(id).get()
            Assert.assertEquals("Department One", updatedDepartment.name)
            Assert.assertEquals(2, updatedDepartment.employees.size)
    }

    @Test
    fun `test find one by name`() {
        departmentRepository.saveAll(
                listOf(
                    DepartmentEntity(
                            name = "Department One"
                    ),
                    DepartmentEntity(
                            name = "Department Two"
                    )
                )
        )
        Assert.assertEquals(2, departmentRepository.count())
        val department = departmentRepository.findOneByName("Department One")
        Assert.assertEquals("Department One", department.name)
    }
}