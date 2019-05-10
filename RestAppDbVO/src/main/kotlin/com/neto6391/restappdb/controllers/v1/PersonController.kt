package com.neto6391.restappdb.controllers.v1

import com.neto6391.restappdb.data.vo.v1.PersonVO
import org.springframework.web.bind.annotation.*
import com.neto6391.restappdb.services.PersonServices
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/api/persons/v1")
class PersonController (private val service: PersonServices) {


	@GetMapping(produces = ["application/json", "application/xml", "application/x-yaml"])
	fun findAll():List<PersonVO> {
		val persons:List<PersonVO> = service.findAll()
		persons.map { p ->
			p.add(
					linkTo(methodOn(PersonController::class.java).findById(p.key)).withSelfRel()
			)
		}
		return persons
	}

	@GetMapping("/{id}", produces = ["application/json", "application/xml", "application/x-yaml"])
	fun findById(@PathVariable(value="id")  id:Long): PersonVO {
		val personVo = service.findById(id)
		personVo.add(linkTo(methodOn(PersonController::class.java).findById(id)).withSelfRel())
		return personVo
	}

	@PostMapping(
			produces = ["application/json", "application/xml", "application/x-yaml"],
			consumes = ["application/json", "application/xml", "application/x-yaml"]
	)
	fun create(@RequestBody person: PersonVO): PersonVO {
		val personVo = service.create(person)
		personVo.add(linkTo(methodOn(PersonController::class.java).findById(personVo.key)).withSelfRel())
		return personVo
	}

	@PutMapping(
			produces = ["application/json", "application/xml", "application/x-yaml"],
			consumes = ["application/json", "application/xml", "application/x-yaml"]
	)
	fun update(@RequestBody person: PersonVO): PersonVO {
		val personVo = service.update(person)
		personVo.add(linkTo(methodOn(PersonController::class.java).findById(personVo.key)).withSelfRel())
		return personVo
	}

	@DeleteMapping("/{id}")
	fun delete(@PathVariable(value="id")  id:Long):ResponseEntity<PersonVO> {
		service.delete(id)
		return ResponseEntity.ok().build()
	}

}

