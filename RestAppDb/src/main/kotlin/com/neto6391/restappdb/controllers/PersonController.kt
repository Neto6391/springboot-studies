package com.neto6391.restappdb.controllers

import com.neto6391.restappdb.models.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import com.neto6391.restappdb.services.PersonServices

@RestController
@RequestMapping("/person")
class PersonController (private val services: PersonServices) {


	@RequestMapping(
			method = [RequestMethod.GET],
			produces = [MediaType.APPLICATION_JSON_VALUE]
	)
	fun findAll():List<Person> {
		return services.findAll()
	}

	@RequestMapping(
			value = ["/{id}"],
			method = [RequestMethod.GET],
			produces = [MediaType.APPLICATION_JSON_VALUE]
	)
	fun findById(@PathVariable(value="id")  id:Long): Person {
			return services.findById(id)
	}

	@RequestMapping(
			method = [RequestMethod.POST],
			consumes = [MediaType.APPLICATION_JSON_VALUE],
			produces = [MediaType.APPLICATION_JSON_VALUE]
	)
	fun create(@RequestBody person: Person): Person {
		return services.create(person)
	}

	@RequestMapping(
			method = [RequestMethod.PUT],
			consumes = [MediaType.APPLICATION_JSON_VALUE],
			produces = [MediaType.APPLICATION_JSON_VALUE]
	)
	fun update(@RequestBody person: Person): Person {
		return services.update(person)
	}

	@RequestMapping(
			value = ["/{id}"],
			method = [RequestMethod.DELETE]
	)
	fun delete(@PathVariable(value="id")  id:Long) {
		services.delete(id)
	}

}

