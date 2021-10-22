package com.elfak.whreceiver.web.rest.request

import lombok.*
import java.time.LocalDateTime

@Getter
@Setter
class AirDataRequest {
    val status: String? = null
    val data: Data? = null

    @lombok.Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class Data {
        var city: String? = null
        var state: String? = null
        var country: String? = null
        val current: Current? = null
    }

    @lombok.Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class Current {
        val weather: Weather? = null
        val pollution: Pollution? = null
    }

    @lombok.Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class Weather {
        val ts: LocalDateTime? = null
        val tp: Int? = null
        val pr: Int? = null
        val hu: Int? = null
        val ws: Double? = null
        val wd: Int? = null
        val ic: String? = null
    }

    @lombok.Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    class Pollution {
        val ts: LocalDateTime? = null
        val aqius: Int? = null
        val mainus: String? = null
        val aqicn: Int? = null
        val maincn: String? = null
    }
}