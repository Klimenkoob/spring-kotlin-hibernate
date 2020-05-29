package ru.sberned.domclick.demo.repositories

import org.springframework.data.jpa.repository.JpaRepository
import ru.sberned.domclick.demo.entities.EmployeeEntity

interface EmployeeRepository : JpaRepository<EmployeeEntity, Long>