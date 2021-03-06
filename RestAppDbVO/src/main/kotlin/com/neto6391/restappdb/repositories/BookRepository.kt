package com.neto6391.restappdb.repositories

import com.neto6391.restappdb.data.model.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository: JpaRepository<Book, Long>