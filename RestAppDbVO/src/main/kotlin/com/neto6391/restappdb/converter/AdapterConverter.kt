package com.neto6391.restappdb.converter

import com.github.dozermapper.core.DozerBeanMapperBuilder
import com.github.dozermapper.core.Mapper

class AdapterConverter {
    companion object {
        var mapper:Mapper = DozerBeanMapperBuilder.buildDefault()

        fun <O, D>  parseObject(origin:O, destination:Class<D>): D {
            return mapper.map(origin, destination)
        }

        fun <O, D>  parseListObjects(origin:List<O>, destination:Class<D>): List<D> {
            val destinationObjects:MutableList<D> = mutableListOf<D>()
            origin.forEach { o ->
                destinationObjects.add(mapper.map(o, destination))
            }
            return destinationObjects
        }
    }
}