package ru.sberned.domclick.demo.entities

import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "employee")
class EmployeeEntity(

        val firstName: String,

        var lastName: String? = null,

        @ManyToOne
        @JoinColumn(name = "department_id")
        val department: DepartmentEntity
) : BaseAuditEntity<Long>()