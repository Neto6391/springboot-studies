package com.neto6391.restappdb.controllers.v1

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.neto6391.restappdb.data.vo.v1.PersonVO
import org.springframework.web.bind.annotation.*
import com.neto6391.restappdb.services.PersonServices
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn
import org.springframework.http.ResponseEntity
import kotlin.collections.HashMap

@Api(value = "Person Endpoint", description = "Description for person", tags = ["PersonEndpoint"])
@RestController
@RequestMapping("/api/persons/v1")
class PersonController (private val service: PersonServices) {


	@ApiOperation(value = "Find all people")
	@GetMapping(produces = ["application/json", "application/xml", "application/x-yaml"])
	fun findAll():MutableList<Any> {
		val persons:List<PersonVO> = service.findAll()
		val personHash = HashMap<String, List<PersonVO>>()
		val personArrayList = mutableListOf<Any>()
		persons.map { p ->
			p.add(
					linkTo(methodOn(PersonController::class.java).findById(p.key)).withSelfRel()
			)
		}

		personHash.put("persons", persons)
		personArrayList.add(personHash)
		return personArrayList
	}


	//How specific dominies can be access in this method of API CORS example 'localhost'
//	@CrossOrigin(origins = ["http://localhost:8080"])
	@ApiOperation(value = "Find a specific person by your ID")
	@GetMapping("/{id}", produces = ["application/json", "application/xml", "application/x-yaml"])
	fun findById(@PathVariable(value="id")  id:Long): PersonVO {
		val personVo = service.findById(id)
		personVo.add(linkTo(methodOn(PersonController::class.java).findById(id)).withSelfRel())
		return personVo
	}

//	@CrossOrigin(origins = ["http://localhost:8080", "http://www.erudio.com.br"])
	@ApiOperation(value = "Create a new person")
	@PostMapping(
			produces = ["application/json", "application/xml", "application/x-yaml"],
			consumes = ["application/json", "application/xml", "application/x-yaml"]
	)
	fun create(@RequestBody person: PersonVO): PersonVO {
		val personVo = service.create(person)
		personVo.add(linkTo(methodOn(PersonController::class.java).findById(personVo.key)).withSelfRel())
		return personVo
	}

	@ApiOperation(value = "Update a specific person")
	@PutMapping(
			produces = ["application/json", "application/xml", "application/x-yaml"],
			consumes = ["application/json", "application/xml", "application/x-yaml"]
	)
	fun update(@RequestBody person: PersonVO): PersonVO {
		val personVo = service.update(person)
		personVo.add(linkTo(methodOn(PersonController::class.java).findById(personVo.key)).withSelfRel())
		return personVo
	}

	@ApiOperation(value = "Disable a specific person by your ID")
	@PatchMapping("/{id}", produces = ["application/json", "application/xml", "application/x-yaml"])
	fun disablePerson(@PathVariable(value="id")  id:Long): PersonVO {
		val personVo = service.disablePerson(id)
		personVo.add(linkTo(methodOn(PersonController::class.java).findById(id)).withSelfRel())
		return personVo
	}


	@ApiOperation(value = "Delete a specific person by your ID")
	@DeleteMapping("/{id}")
	fun delete(@PathVariable(value="id")  id:Long):ResponseEntity<PersonVO> {
		service.delete(id)
		return ResponseEntity.ok().build()
	}

}

