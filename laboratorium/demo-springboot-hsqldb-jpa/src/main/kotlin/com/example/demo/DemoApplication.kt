package com.example.demo

import db.repo.IRegulaRepozytorium
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackages = arrayOf("db.repo"))
@EntityScan( basePackages = arrayOf("encje"))
		class DemoApplication

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}
