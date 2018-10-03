package org.rao.kotlin.designpatterns.factory.usecase11

object SensorFactory {
    fun getSensor(sensorType:String) : Sensor?{
        if (sensorType == "heat")
            return TemparatureSensor()
        else if (sensorType == "humid")
            return HumiditySensor()
        else if (sensorType == "optical")
            return OpticalSensor()
        else
            return null
    }
}
