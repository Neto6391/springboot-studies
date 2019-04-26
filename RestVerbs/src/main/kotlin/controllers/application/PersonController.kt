package controllers.application

import exception.handler.ControllerAdviceRequestError
import models.aplication.Person
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import services.application.PersonServices

@RestController
@RequestMapping("/person")
@ComponentScan("services.application", "models.application")
class PersonController : ControllerAdviceRequestError() {

	@Autowired
	lateinit private var services:PersonServices


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
	fun findById(@PathVariable(value="id")  id:String):Person {
			return services.findById(id)
	}

	@RequestMapping(
			method = [RequestMethod.POST],
			consumes = [MediaType.APPLICATION_JSON_VALUE],
			produces = [MediaType.APPLICATION_JSON_VALUE]
	)
	fun create(@RequestBody person:Person):Person {
		return services.create(person)
	}

	@RequestMapping(
			method = [RequestMethod.PUT],
			consumes = [MediaType.APPLICATION_JSON_VALUE],
			produces = [MediaType.APPLICATION_JSON_VALUE]
	)
	fun update(@RequestBody person:Person):Person {
		return services.update(person)
	}

	@RequestMapping(
			value = ["/{id}"],
			method = [RequestMethod.DELETE]
	)
	fun delete(@PathVariable(value="id")  id:String) {
		services.delete(id)
	}

}

