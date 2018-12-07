package org.rao.kotlin.designpatterns.factory.usecase2

object SensorClient {

    @JvmStatic
    fun main(args: Array<String>) {
       var list = SensorFactory.getSensorList(SensorType.HUMIDITY.name,100)

        if(list == null){
            println("requested sensors are not available yet")
        }else {
            println(list.size)
            println(list.get(0)::class.simpleName)
        }
    }

}
