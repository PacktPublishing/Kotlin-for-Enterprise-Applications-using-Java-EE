package org.rao.kotlin.messaging

import javax.inject.Inject
import javax.jms.ConnectionFactory
import javax.jms.Message
import javax.jms.Queue
import javax.jms.TextMessage
import javax.naming.InitialContext

class Consumer {
    @Inject
    internal var initialContext: InitialContext? = null

    fun receiveMessage(): Message {

        val queue = initialContext!!.lookup("jms/PointToPointQueue") as Queue
        val connectionFactory = initialContext!!.lookup("jms/__defaultConnectionFactory") as ConnectionFactory
        val textMessage = connectionFactory
                .createContext()
                .createConsumer(queue)
                .receive()
      //  println("Message received $message")
        return textMessage
    }
}
