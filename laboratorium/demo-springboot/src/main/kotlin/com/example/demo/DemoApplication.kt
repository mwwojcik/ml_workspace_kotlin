package com.example.demo

import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class DemoApplication{
	@Value("\${hello}")
	lateinit var hello:String
}

fun main(args: Array<String>) {
	val ctx=runApplication<DemoApplication>(*args)

	val bean=ctx.getBean(DemoApplication::class.java)

	println(bean.hello)
}
