package com.neto6391.restappdb.application.converter.mocks

import com.neto6391.restappdb.data.model.Book
import com.neto6391.restappdb.data.vo.v1.BookVO
import java.util.*

class MockBook {

    fun mockEntity():Book {
        return mockEntity(0)
    }

    fun mockVO(): BookVO {
        return mockVO(0)
    }

    fun mockEntityList():List<Book> {
        val books:MutableList<Book> = mutableListOf()
        for(i in 0..13) {
            books.add(mockEntity(i))
        }
        return books
    }

    fun mockVOList():List<BookVO> {
        val books:MutableList<BookVO> = mutableListOf()
        for(i in 0..13) {
            books.add(mockVO(i))
        }
        return books
    }

    private fun mockEntity(number: Int): Book {
        val book = Book()
        book.title = "Title Test$number"
        book.price = number.toDouble()
        book.launchDate = Date()
        book.author = "Author Test$number"
        book.id = number.toLong()
        return book
    }

    private fun mockVO(number: Int): BookVO {
        val book = BookVO()
        book.title = "Title Test$number"
        book.price = number.toDouble()
        book.launchDate = Date()
        book.author = "Author Test$number"
        book.key = number.toLong()
        return book
    }

}