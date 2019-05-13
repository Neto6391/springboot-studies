package com.neto6391.restappdb.services

import com.neto6391.restappdb.converter.AdapterConverter
import com.neto6391.restappdb.data.model.Book
import com.neto6391.restappdb.data.vo.v1.BookVO
import com.neto6391.restappdb.exceptions.exception.ResourceNotFoundException
import com.neto6391.restappdb.repositories.BookRepository
import org.springframework.stereotype.Service

@Service
class BookServices(private val repository:BookRepository) {

    fun create(book: BookVO): BookVO {
        val entity = AdapterConverter.parseObject(book, Book::class.java)
        val vo = AdapterConverter.parseObject(repository.save(entity), BookVO::class.java)
        return vo
    }

    fun findAll():List<BookVO> {
        return AdapterConverter.parseListObjects(repository.findAll(), BookVO::class.java)
    }

    fun findById(id:Long): BookVO {
        val entity = repository.findById(id).orElseThrow {
            ResourceNotFoundException("No records found for this ID")
        }
        return AdapterConverter.parseObject(entity, BookVO::class.java)
    }

    fun update(book: BookVO): BookVO {
        var entity = repository.findById(book.key).orElseThrow {
            ResourceNotFoundException("No records found for this ID")
        }

        entity.author = book.author
        entity.launchDate = book.launchDate
        entity.price = book.price
        entity.title = book.title
        val vo = AdapterConverter.parseObject(repository.save(entity), BookVO::class.java)
        return vo
    }

    fun delete(id:Long) {
        val entity = repository.findById(id).orElseThrow {
            ResourceNotFoundException("No records found for this ID")
        }
        repository.delete(entity)
    }

}