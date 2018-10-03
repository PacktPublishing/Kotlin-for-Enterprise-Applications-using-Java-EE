package org.rao.kotlin.designpatterns.factory.usecase1

object SensorClient {
    var sensor: Sensor? = null

    @JvmStatic
    fun main(args: Array<String>) {
        sensor = SensorFactory.getSensor("optical")
        if(sensor == null){
            println("requested sensor type not available yet")
        }else {
            println(sensor!!::class.simpleName)
        }
    }

}
