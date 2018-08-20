package org.rao.kotlin.messaging

import javax.inject.Inject
import javax.jms.ConnectionFactory
import javax.jms.JMSContext
import javax.jms.Topic
import javax.naming.InitialContext
import javax.naming.NamingException

class Subscriber {
    @Inject
    internal var initialContext: InitialContext? = null

    @Throws(NamingException::class)
    fun listenToMessage(): String? {
        val topic = initialContext!!.lookup("jms/Topic") as Topic
        val connectionFactory = initialContext!!.lookup("jms/__defaultConnectionFactory") as ConnectionFactory
        // println("inside getting message")

        val jmsContext = connectionFactory.createContext(JMSContext.SESSION_TRANSACTED)
        var messageResponse = jmsContext.createConsumer(topic)
                .receiveBody(String::class.java)

        println("Yay--- " + messageResponse!!)
        return messageResponse
    }
}
