package com.neto6391.restappdb.controllers

import com.neto6391.restappdb.data.vo.v1.PersonVO
import org.springframework.web.bind.annotation.*
import com.neto6391.restappdb.services.PersonServices
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/api/person/v1")
class PersonController (private val services: PersonServices) {


	@GetMapping(produces = ["application/json", "application/xml", "application/x-yaml"])
	fun findAll():List<PersonVO> {
		return services.findAll()
	}

	@GetMapping("/{id}", produces = ["application/json", "application/xml", "application/x-yaml"])
	fun findById(@PathVariable(value="id")  id:Long): PersonVO {
			return services.findById(id)
	}

	@PostMapping(
			produces = ["application/json", "application/xml", "application/x-yaml"],
			consumes = ["application/json", "application/xml", "application/x-yaml"]
	)
	fun create(@RequestBody person: PersonVO): PersonVO {
		return services.create(person)
	}

	@PutMapping(
			produces = ["application/json", "application/xml", "application/x-yaml"],
			consumes = ["application/json", "application/xml", "application/x-yaml"]
	)
	fun update(@RequestBody person: PersonVO): PersonVO {
		return services.update(person)
	}

	@DeleteMapping("/{id}")
	fun delete(@PathVariable(value="id")  id:Long):ResponseEntity<PersonVO> {
		services.delete(id)
		return ResponseEntity.ok().build()
	}

}

