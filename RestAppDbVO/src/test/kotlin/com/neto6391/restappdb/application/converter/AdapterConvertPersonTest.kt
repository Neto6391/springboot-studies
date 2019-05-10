package com.neto6391.restappdb.application.converter

import com.neto6391.restappdb.application.converter.mocks.MockPerson
import com.neto6391.restappdb.converter.AdapterConverter
import com.neto6391.restappdb.data.vo.v1.PersonVO
import org.junit.Assert
import com.neto6391.restappdb.data.model.Person
import org.junit.Before
import org.junit.Test


class AdapterConvertPersonTest {

    lateinit  var inputObject: MockPerson

    @Before
    fun setUp() {
        inputObject = MockPerson()
    }

    @Test
    fun parseEntityToVOTest() {
        var output: PersonVO = AdapterConverter.parseObject(inputObject.mockEntity(), PersonVO::class.java)
        Assert.assertEquals((0L).toLong(), output.key)
        Assert.assertEquals("First Name Test0", output.firstName)
        Assert.assertEquals("Last Name Test0", output.lastName)
        Assert.assertEquals("Address Test0", output.address)
        Assert.assertEquals("Male", output.gender)
    }

    @Test
    fun parseEntityListToToVOListTest() {
        var outputList:List<PersonVO> = AdapterConverter.parseListObjects(inputObject.mockEntityList(), PersonVO::class.java)
        val outputZero = outputList.get(0)

        Assert.assertEquals((0L).toLong(), outputZero.key)
        Assert.assertEquals("First Name Test0", outputZero.firstName)
        Assert.assertEquals("Last Name Test0", outputZero.lastName)
        Assert.assertEquals("Address Test0", outputZero.address)
        Assert.assertEquals("Male", outputZero.gender)

        val outputSeven = outputList.get(7)

        Assert.assertEquals((7L).toLong(), outputSeven.key)
        Assert.assertEquals("First Name Test7", outputSeven.firstName)
        Assert.assertEquals("Last Name Test7", outputSeven.lastName)
        Assert.assertEquals("Address Test7", outputSeven.address)
        Assert.assertEquals("Female", outputSeven.gender)

        val outputTwelve = outputList.get(12)

        Assert.assertEquals((12L).toLong(), outputTwelve.key)
        Assert.assertEquals("First Name Test12", outputTwelve.firstName)
        Assert.assertEquals("Last Name Test12", outputTwelve.lastName)
        Assert.assertEquals("Address Test12", outputTwelve.address)
        Assert.assertEquals("Male", outputTwelve.gender)
    }

    @Test
    fun parseVOToEntityTest() {
        val output = AdapterConverter.parseObject(inputObject.mockVO(), Person::class.java)
        Assert.assertEquals(java.lang.Long.valueOf(0L), output.id)
        Assert.assertEquals("First Name Test0", output.firstName)
        Assert.assertEquals("Last Name Test0", output.lastName)
        Assert.assertEquals("Address Test0", output.address)
        Assert.assertEquals("Male", output.gender)
    }

    @Test
    fun parserVOListToEntityListTest() {
        val outputList = AdapterConverter.parseListObjects(inputObject.mockVOList(), Person::class.java)
        val outputZero = outputList.get(0)

        Assert.assertEquals((0L).toLong(), outputZero.id)
        Assert.assertEquals("First Name Test0", outputZero.firstName)
        Assert.assertEquals("Last Name Test0", outputZero.lastName)
        Assert.assertEquals("Address Test0", outputZero.address)
        Assert.assertEquals("Male", outputZero.gender)

        val outputSeven = outputList.get(7)

        Assert.assertEquals((7L).toLong(), outputSeven.id)
        Assert.assertEquals("First Name Test7", outputSeven.firstName)
        Assert.assertEquals("Last Name Test7", outputSeven.lastName)
        Assert.assertEquals("Address Test7", outputSeven.address)
        Assert.assertEquals("Female", outputSeven.gender)

        val outputTwelve = outputList.get(12)

        Assert.assertEquals((12L).toLong(), outputTwelve.id)
        Assert.assertEquals("First Name Test12", outputTwelve.firstName)
        Assert.assertEquals("Last Name Test12", outputTwelve.lastName)
        Assert.assertEquals("Address Test12", outputTwelve.address)
        Assert.assertEquals("Male", outputTwelve.gender)
    }

}