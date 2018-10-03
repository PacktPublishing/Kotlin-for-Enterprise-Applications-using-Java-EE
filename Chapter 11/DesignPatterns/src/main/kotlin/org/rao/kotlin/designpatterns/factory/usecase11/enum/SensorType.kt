package org.rao.kotlin.designpatterns.factory.usecase11

enum class SensorType private constructor(private val type: String) {
    HUMIDITY("humid"), TEMPARATURE("heat"), OPTICAL("optic")
}
