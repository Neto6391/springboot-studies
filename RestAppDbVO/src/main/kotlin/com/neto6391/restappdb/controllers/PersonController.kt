package com.neto6391.restappdb.controllers

import com.neto6391.restappdb.data.vo.PersonVO
import org.springframework.web.bind.annotation.*
import com.neto6391.restappdb.services.PersonServices
import org.springframework.http.ResponseEntity

@RestController
@RequestMapping("/person")
class PersonController (private val services: PersonServices) {


//	@GetMapping
//	fun findAll():List<PersonVO> {
//		return services.findAll()
//	}
//
//	@GetMapping("/{id}")
//	fun findById(@PathVariable(value="id")  id:Long): PersonVO {
//			return services.findById(id)
//	}
//
//	@PostMapping
//	fun create(@RequestBody person: PersonVO): PersonVO {
//		return services.create(person)
//	}
//
//	@PutMapping
//	fun update(@RequestBody person: PersonVO): PersonVO {
//		return services.update(person)
//	}
//
//	@DeleteMapping("/{id}")
//	fun delete(@PathVariable(value="id")  id:Long):ResponseEntity<PersonVO> {
//		services.delete(id)
//		return ResponseEntity.ok().build()
//	}

}

