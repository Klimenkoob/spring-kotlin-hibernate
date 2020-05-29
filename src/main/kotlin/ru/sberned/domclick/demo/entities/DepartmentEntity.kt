package ru.sberned.domclick.demo.entities

import javax.persistence.*

@Entity
@Table(name = "department")
class DepartmentEntity(

        val name: String,

        @OneToMany(
                mappedBy = "department",
                fetch = FetchType.LAZY,
                orphanRemoval = true,
                cascade = [CascadeType.ALL]
        )
        val employees: MutableList<EmployeeEntity> = mutableListOf()
) : BaseAuditEntity<Long>() {

    fun addEmployee(block: DepartmentEntity.() -> EmployeeEntity) {
        employees.add(block())
    }

    fun setEmployees(block: DepartmentEntity.() -> MutableSet<EmployeeEntity>) {
        employees.clear()
        employees.addAll(block())
    }
}