package controllers.application

import exception.handler.ControllerAdviceRequestError
import models.aplication.Person
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.http.MediaType
import services.application.PersonServices

@RestController
@RequestMapping("/person")
@ComponentScan("services.application")
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
}

