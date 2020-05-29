package ru.sberned.domclick.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication
class SpringKotlinHibernateApplication

fun main(args: Array<String>) {
	runApplication<SpringKotlinHibernateApplication>(*args)
}
