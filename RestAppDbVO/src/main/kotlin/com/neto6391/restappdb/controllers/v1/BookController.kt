package com.neto6391.restappdb.controllers.v1

import com.neto6391.restappdb.data.vo.v1.BookVO
import com.neto6391.restappdb.services.BookServices
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo
import org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Api(tags = ["BookEndpoint"])
@RestController
@RequestMapping("/api/books/v1")
class BookController(private val service: BookServices) {


    @ApiOperation(value = "Find all books")
    @GetMapping(produces = ["application/json", "application/xml", "application/x-yaml"])
    fun findAll():List<BookVO> {
        val books:List<BookVO> = service.findAll()
        books.map { b ->
            b.add(
                    linkTo(methodOn(BookController::class.java).findById(b.key)).withSelfRel()
            )
        }
        return books
    }

    @ApiOperation(value = "Find a specific book by your ID")
    @GetMapping("/{id}", produces = ["application/json", "application/xml", "application/x-yaml"])
    fun findById(@PathVariable(value="id")  id:Long): BookVO {
        val bookVo = service.findById(id)
        bookVo.add(linkTo(methodOn(BookController::class.java).findById(id)).withSelfRel())
        return bookVo
    }

    @ApiOperation(value = "Create a new book")
    @PostMapping(
            produces = ["application/json", "application/xml", "application/x-yaml"],
            consumes = ["application/json", "application/xml", "application/x-yaml"]
    )
    fun create(@RequestBody book: BookVO): BookVO {
        val bookVo = service.create(book)
        bookVo.add(linkTo(methodOn(BookController::class.java).findById(bookVo.key)).withSelfRel())
        return bookVo
    }

    @ApiOperation(value = "Update a specific book")
    @PutMapping(
            produces = ["application/json", "application/xml", "application/x-yaml"],
            consumes = ["application/json", "application/xml", "application/x-yaml"]
    )
    fun update(@RequestBody book: BookVO): BookVO {
        val bookVo = service.update(book)
        bookVo.add(linkTo(methodOn(BookController::class.java).findById(bookVo.key)).withSelfRel())
        return bookVo
    }

    @ApiOperation(value = "Delete a specific book by your ID")
    @DeleteMapping("/{id}")
    fun delete(@PathVariable(value="id")  id:Long): ResponseEntity<BookVO> {
        service.delete(id)
        return ResponseEntity.ok().build()
    }

}