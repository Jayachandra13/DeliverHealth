package com.jc.deliverhealth.model

import java.io.Serializable


class Result(
    var name: String? = null,
    var height: String? = null,
    var mass: String? = null,
    var hair_color: String? = null,
    var skin_color: String? = null,
    var eye_color: String? = null,
    var birth_year: String? = null,
    var gender: String? = null,
    var image: String? = null,
): Serializable

data class StarWars(
    var results: List<Result>? = null
)