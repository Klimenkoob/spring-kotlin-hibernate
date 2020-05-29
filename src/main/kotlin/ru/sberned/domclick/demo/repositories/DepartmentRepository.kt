package ru.sberned.domclick.demo.repositories

import org.springframework.data.jpa.repository.JpaRepository
import ru.sberned.domclick.demo.entities.DepartmentEntity

interface DepartmentRepository : JpaRepository<DepartmentEntity, Long> {

    fun findOneByName(name: String) : DepartmentEntity
}