package com.neto6391.restappdb.config

import com.neto6391.restappdb.serialization.converter.YamlJackson2HttpMessageConverter
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {

    private object companion {
        val APPLICATION_YML:MediaType = MediaType.valueOf("application/x-yaml")
    }


    override fun addCorsMappings(registry: CorsRegistry) {
          //Enable Cors Domain for everyone WORKS FOR METHODS GET, POST, PUT, DELETE
//        registry.addMapping("/**")
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT")
    }

    override fun extendMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        converters.add(YamlJackson2HttpMessageConverter())
    }


    //Override Method for permit content Negotiation of files JSON/XML
    override fun configureContentNegotiation(configurer: ContentNegotiationConfigurer) {
        /*
        *
        * For use Extension(.json/.xml) example url /person.extension
        * */
//      configurer.favorParameter(false)
//                .ignoreAcceptHeader(false)
//                .defaultContentType(MediaType.APPLICATION_JSON)
//                .mediaType("json", MediaType.APPLICATION_JSON)
//                .mediaType("xml", MediaType.APPLICATION_XML)

         /*
         *
         * For use Query Param by type('json'/'xml') example url /person/?mediaType='type'
         * */
//       configurer.favorPathExtension(false)
//                .favorParameter(true)
//                .parameterName("mediaType")
//                .ignoreAcceptHeader(true)
//                .useRegisteredExtensionsOnly(false)
//                .defaultContentType(MediaType.APPLICATION_JSON)
//                .mediaType("json", MediaType.APPLICATION_JSON)
//                .mediaType("xml", MediaType.APPLICATION_XML)
        /*
        *
        * For use Header example in Header request by type(json/xml) Send "{Accept: 'application/type'}"
        * */
        configurer.favorPathExtension(false)
                .favorParameter(false)
                .ignoreAcceptHeader(false)
                .useRegisteredExtensionsOnly(false)
                .defaultContentType(MediaType.APPLICATION_JSON)
                .mediaType("json", MediaType.APPLICATION_JSON)
                .mediaType("xml", MediaType.APPLICATION_XML)
                .mediaType("x-yaml", companion.APPLICATION_YML)
    }



}