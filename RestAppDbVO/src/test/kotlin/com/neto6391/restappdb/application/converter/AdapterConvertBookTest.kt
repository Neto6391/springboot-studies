package com.neto6391.restappdb.application.converter

import com.neto6391.restappdb.application.converter.mocks.MockBook
import com.neto6391.restappdb.converter.AdapterConverter
import com.neto6391.restappdb.data.model.Book
import com.neto6391.restappdb.data.vo.v1.BookVO
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.*

class AdapterConvertBookTest {

    lateinit  var inputObject: MockBook

    @Before
    fun setUp() {
        inputObject = MockBook()
    }

    @Test
    fun parseEntityToVOTest() {
        var output: BookVO = AdapterConverter.parseObject(inputObject.mockEntity(), BookVO::class.java)
        Assert.assertEquals((0L).toLong(), output.key)
        Assert.assertEquals("Title Test0", output.title)
        Assert.assertEquals(0.toDouble(), 0.0, output.price)
        Assert.assertTrue("Dates aren't close enough to each other!", (Date().time - output.launchDate.time ) < 1000)
        Assert.assertEquals("Author Test0", output.author)

    }

    @Test
    fun parseEntityListToToVOListTest() {
        var outputList:List<BookVO> = AdapterConverter.parseListObjects(inputObject.mockEntityList(), BookVO::class.java)
        val outputZero = outputList.get(0)

        Assert.assertEquals((0L).toLong(), outputZero.key)
        Assert.assertEquals("Title Test0", outputZero.title)
        Assert.assertEquals(0.toDouble(), 0.0, outputZero.price)
        Assert.assertTrue("Dates aren't close enough to each other!", (Date().time - outputZero.launchDate.time ) < 1000)
        Assert.assertEquals("Author Test0", outputZero.author)

        val outputSeven = outputList.get(7)

        Assert.assertEquals((7L).toLong(), outputSeven.key)
        Assert.assertEquals("Title Test7", outputSeven.title)
        Assert.assertEquals(7.toDouble(), 7.0, outputSeven.price)
        Assert.assertTrue("Dates aren't close enough to each other!", (Date().time - outputSeven.launchDate.time ) < 1000)
        Assert.assertEquals("Author Test7", outputSeven.author)

        val outputTwelve = outputList.get(12)

        Assert.assertEquals((12L).toLong(), outputTwelve.key)
        Assert.assertEquals("Title Test12", outputTwelve.title)
        Assert.assertEquals(12.toDouble(), 12.0, outputTwelve.price)
        Assert.assertTrue("Dates aren't close enough to each other!", (Date().time -outputTwelve.launchDate.time ) < 1000)
        Assert.assertEquals("Author Test12", outputTwelve.author)
    }

    @Test
    fun parseVOToEntityTest() {
        val output = AdapterConverter.parseObject(inputObject.mockVO(), Book::class.java)
        Assert.assertEquals((0L).toLong(), output.id)
        Assert.assertEquals("Title Test0", output.title)
        Assert.assertEquals(0.toDouble(), 0.0, output.price)
        Assert.assertTrue("Dates aren't close enough to each other!", (Date().time - output.launchDate.time ) < 1000)
        Assert.assertEquals("Author Test0", output.author)
    }

    @Test
    fun parserVOListToEntityListTest() {
        val outputList = AdapterConverter.parseListObjects(inputObject.mockVOList(), Book::class.java)
        val outputZero = outputList.get(0)

        Assert.assertEquals((0L).toLong(), outputZero.id)
        Assert.assertEquals("Title Test0", outputZero.title)
        Assert.assertEquals(0.toDouble(), 0.0, outputZero.price)
        Assert.assertTrue("Dates aren't close enough to each other!", (Date().time - outputZero.launchDate.time ) < 1000)
        Assert.assertEquals("Author Test0", outputZero.author)

        val outputSeven = outputList.get(7)

        Assert.assertEquals((7L).toLong(), outputSeven.id)
        Assert.assertEquals("Title Test7", outputSeven.title)
        Assert.assertEquals(7.toDouble(), 7.0, outputSeven.price)
        Assert.assertTrue("Dates aren't close enough to each other!", (Date().time - outputSeven.launchDate.time ) < 1000)
        Assert.assertEquals("Author Test7", outputSeven.author)

        val outputTwelve = outputList.get(12)

        Assert.assertEquals((12L).toLong(), outputTwelve.id)
        Assert.assertEquals("Title Test12", outputTwelve.title)
        Assert.assertEquals(12.toDouble(), 12.0, outputTwelve.price)
        Assert.assertTrue("Dates aren't close enough to each other!", (Date().time -outputTwelve.launchDate.time ) < 1000)
        Assert.assertEquals("Author Test12", outputTwelve.author)
    }

}