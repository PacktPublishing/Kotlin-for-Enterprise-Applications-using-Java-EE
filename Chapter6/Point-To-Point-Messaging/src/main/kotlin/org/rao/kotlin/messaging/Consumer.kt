package org.rao.kotlin.messaging

import javax.inject.Inject
import javax.jms.ConnectionFactory
import javax.jms.Queue
import javax.naming.InitialContext

class Consumer {
    @Inject
    internal var initialContext: InitialContext? = null

    fun receiveMessage(): String {

        val queue = initialContext!!.lookup("jms/PointToPointQueue") as Queue
        val connectionFactory = initialContext!!.lookup("jms/__defaultConnectionFactory") as ConnectionFactory
        val message = connectionFactory
                .createContext()
                .createConsumer(queue)
                .receiveBody(String::class.java)

      //  println("Message received $message")
        return message
    }
}
