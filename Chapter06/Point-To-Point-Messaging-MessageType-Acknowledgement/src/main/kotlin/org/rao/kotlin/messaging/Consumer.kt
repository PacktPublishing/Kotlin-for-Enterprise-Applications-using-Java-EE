package org.rao.kotlin.messaging

import javax.inject.Inject
import javax.jms.*
import javax.naming.InitialContext

class Consumer {
    @Inject
    internal var initialContext: InitialContext? = null

    fun receiveMessage(): Message {

        val queue = initialContext!!.lookup("jms/PointToPointQueue") as Queue
        val connectionFactory = initialContext!!.lookup("jms/__defaultConnectionFactory") as ConnectionFactory
        val jmsConsumer = connectionFactory
                .createContext(JMSContext.DUPS_OK_ACKNOWLEDGE)
                .createConsumer(queue)

        val textMessage = jmsConsumer.receive()
        jmsConsumer.receive().acknowledge()
      //  println("Message received $message")
        return textMessage
    }
}







