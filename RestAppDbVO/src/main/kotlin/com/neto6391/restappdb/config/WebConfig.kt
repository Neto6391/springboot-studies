package com.neto6391.restappdb.config

import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@EnableWebMvc
class WebConfig : WebMvcConfigurer {

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
    }



}