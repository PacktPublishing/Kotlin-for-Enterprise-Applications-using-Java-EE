package org.rao.kotlin.designpatterns.factory.usecase2

enum class SensorType private constructor(private val type: String) {
    HUMIDITY("humid"), TEMPARATURE("heat"), OPTICAL("optic")
}
