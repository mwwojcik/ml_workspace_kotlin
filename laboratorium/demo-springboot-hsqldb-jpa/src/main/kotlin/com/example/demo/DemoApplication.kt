package com.example.demo

import db.RegulyDbBean
import db.repo.IRegulaRepozytorium
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackages = arrayOf("db"))
@EntityScan( basePackages = arrayOf("db","encje","db.encje"))
@ComponentScan(basePackages = arrayOf("db"))
class DemoApplication

fun main(args: Array<String>) {
	var ctx=runApplication<DemoApplication>(*args)
	var bean=ctx.getBean(RegulyDbBean::class.java)
	bean.znajdzWszystkieReguly()
}
