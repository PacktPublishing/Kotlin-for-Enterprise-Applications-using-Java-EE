package org.rao.kotlin.designpatterns.factory.usecase2


object SensorFactory {
   fun getSensor(sensorType:String) : Sensor?{
        if (sensorType == SensorType.TEMPARATURE.name)
            return TemparatureSensor()
        else if (sensorType == SensorType.HUMIDITY.name)
            return HumiditySensor()
        else if (sensorType == SensorType.OPTICAL.name)
            return OpticalSensor()
        else
            return null
    }
    fun getSensorList(type:String, quantity:Int): MutableList<Sensor> {

        var sensorList: ArrayList<Sensor> = ArrayList<Sensor>()
        println(sensorList.size)
        for (i in 0 until quantity) {
            sensorList.add(SensorFactory.getSensor(type)!!)
        }
        return sensorList
    }
}
