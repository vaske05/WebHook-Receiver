package com.elfak.whreceiver.web.rest.controller.impl

import com.elfak.whreceiver.web.rest.controller.WebHookReceiverController
import com.elfak.whreceiver.web.rest.request.AirDataRequest
import com.elfak.whreceiver.web.rest.request.CovidDataRequest
import lombok.RequiredArgsConstructor
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
@RequiredArgsConstructor
class WebHookReceiverControllerImpl : WebHookReceiverController {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun receiveCovidData(covidDataRequest: CovidDataRequest): ResponseEntity<*>? {
        logger.info("--- COVID data ---")
        logger.info("updated: " + covidDataRequest.updated)
        logger.info("country: " + covidDataRequest.country)
        logger.info("cases: " + covidDataRequest.cases)
        logger.info("todayCases: " + covidDataRequest.todayCases)
        logger.info("deaths: " + covidDataRequest.deaths)
        logger.info("todayDeaths: " + covidDataRequest.todayDeaths)
        logger.info("recovered: " + covidDataRequest.recovered)
        logger.info("todayRecovered: " + covidDataRequest.todayRecovered)
        logger.info("tests: " + covidDataRequest.tests)
        logger.info("------------------")

        return ResponseEntity("Received covid data", HttpStatus.OK)
    }

    override fun receiveCovidData(airDataRequest: AirDataRequest): ResponseEntity<*>? {
        logger.info("--- AIR data ---")
        logger.info("status: " + airDataRequest.status)
        logger.info("data.city: " + (airDataRequest.data?.city))
        logger.info("data.state: " + airDataRequest.data?.state)
        logger.info("data.country: " + airDataRequest.data?.country)
        logger.info("data.current.weather.time: " + airDataRequest.data?.current?.weather?.ts)
        logger.info("data.current.weather.hu: " + airDataRequest.data?.current?.weather?.hu)
        logger.info("data.current.weather.ic: " + airDataRequest.data?.current?.weather?.ic)
        logger.info("data.current.weather.pr: " + airDataRequest.data?.current?.weather?.pr)
        logger.info("data.current.weather.wd: " + airDataRequest.data?.current?.weather?.wd)
        logger.info("data.current.weather.ws: " + airDataRequest.data?.current?.weather?.ws)
        logger.info("data.current.weather.tp: " + airDataRequest.data?.current?.weather?.tp)
        logger.info("data.current.pollution.time: " + airDataRequest.data?.current?.pollution?.ts)
        logger.info("data.current.pollution.aqicn: " + airDataRequest.data?.current?.pollution?.aqicn)
        logger.info("data.current.pollution.aqius: " + airDataRequest.data?.current?.pollution?.aqius)
        logger.info("data.current.pollution.maincn: " + airDataRequest.data?.current?.pollution?.maincn)
        logger.info("data.current.pollution.mainus: " + airDataRequest.data?.current?.pollution?.mainus)
        logger.info("------------------")

        return ResponseEntity("Received air data", HttpStatus.OK)
    }
}