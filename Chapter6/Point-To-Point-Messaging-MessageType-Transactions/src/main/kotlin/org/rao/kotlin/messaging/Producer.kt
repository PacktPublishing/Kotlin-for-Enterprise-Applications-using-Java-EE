package org.rao.kotlin.messaging

import javax.enterprise.context.RequestScoped
import javax.inject.Inject
import javax.jms.ConnectionFactory
import javax.jms.JMSContext
import javax.jms.Queue
import javax.naming.InitialContext
import javax.naming.NamingException

class Producer {
    @Inject
    internal var initialContext: InitialContext? = null

    fun sendMessage(message: String): String {
        try {
            val queue = initialContext!!.lookup("jms/PointToPointQueue") as Queue
            val connectionFactory = initialContext!!.lookup("jms/__defaultConnectionFactory") as ConnectionFactory
            val jmsContext = connectionFactory.createContext(JMSContext.SESSION_TRANSACTED)
            val textMessage = jmsContext.createTextMessage(message)
            jmsContext.createProducer()
                      .send(queue, textMessage)
            jmsContext.commit()
            println("Message sent")
            return "Message sent"
        } catch (e: NamingException) {
            println("unable to load a resource " + e.message)
            return "Unable to deliver a message"
        }
    }
}

