package com.elfak.whreceiver.web.rest.request

import lombok.Getter
import lombok.Setter
import java.util.*


@Getter
@Setter
class CovidDataRequest {
    var updated: Date? = null
    var country: String? = null
    var cases = 0
    var todayCases = 0
    var deaths = 0
    var todayDeaths = 0
    var recovered = 0
    var todayRecovered = 0
    var active = 0
    var critical = 0
    var casesPerOneMillion = 0
    var deathsPerOneMillion = 0
    var tests = 0
    var testsPerOneMillion = 0
    var population = 0
    var continent: String? = null
    var oneCasePerPeople = 0
    var oneDeathPerPeople = 0
    var oneTestPerPeople = 0
    var activePerOneMillion = 0
    var recoveredPerOneMillion = 0
    var criticalPerOneMillion = 0
}