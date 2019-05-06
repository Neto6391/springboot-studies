package com.neto6391.restappdb.serialization.converter

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import org.springframework.http.MediaType
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter

class YamlJackson2HttpMessageConverter : AbstractJackson2HttpMessageConverter(YAMLMapper(), MediaType.parseMediaType("application/x-yaml"))