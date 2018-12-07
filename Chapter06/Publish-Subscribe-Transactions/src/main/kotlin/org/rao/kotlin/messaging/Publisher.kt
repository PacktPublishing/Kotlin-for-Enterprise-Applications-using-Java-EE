package org.rao.kotlin.messaging

import javax.inject.Inject
import javax.jms.ConnectionFactory
import javax.jms.JMSContext
import javax.jms.Topic
import javax.naming.InitialContext

class Publisher {
    @Inject
    internal var initialContext: InitialContext? = null

    fun publishMessage(message:String) {
        val topic = initialContext!!.lookup("jms/Topic") as Topic
        val connectionFactory = initialContext!!.lookup("jms/__defaultConnectionFactory") as ConnectionFactory

        val jmsContext = connectionFactory.createContext(JMSContext.SESSION_TRANSACTED)
        jmsContext
                .createProducer()
                .send(topic, message)
        jmsContext.commit()
        println("Message sent")
    }
}
