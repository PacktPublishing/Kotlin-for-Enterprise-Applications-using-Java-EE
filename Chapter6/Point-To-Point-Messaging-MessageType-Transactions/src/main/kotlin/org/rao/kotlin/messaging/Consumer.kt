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
        //val textMessage = connectionFactory
        val jmsContext = connectionFactory.createContext(JMSContext.CLIENT_ACKNOWLEDGE)
        val textMessage = jmsContext.createConsumer(queue)
                .receive()
        jmsContext.commit()
        return textMessage
    }
}
