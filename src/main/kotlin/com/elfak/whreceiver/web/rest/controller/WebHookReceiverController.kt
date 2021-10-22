package com.elfak.whreceiver.web.rest.controller

import com.elfak.whreceiver.web.WebConstant
import com.elfak.whreceiver.web.rest.request.AirDataRequest
import com.elfak.whreceiver.web.rest.request.CovidDataRequest
import org.springframework.http.MediaType.APPLICATION_JSON_VALUE
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = [WebConstant.RECEIVER_BASE_URL], produces = [APPLICATION_JSON_VALUE])
interface WebHookReceiverController {

    @PostMapping(value = ["/covid"])
    fun receiveCovidData(@RequestBody covidDataRequest: CovidDataRequest): ResponseEntity<*>?

    @PostMapping(value = ["/air"])
    fun receiveCovidData(@RequestBody airDataRequest: AirDataRequest): ResponseEntity<*>?
}