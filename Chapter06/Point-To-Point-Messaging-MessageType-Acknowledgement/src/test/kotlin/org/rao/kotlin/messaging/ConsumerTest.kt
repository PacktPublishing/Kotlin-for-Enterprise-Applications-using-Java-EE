package org.rao.kotlin.messaging

import org.junit.Assert
import org.junit.Test
import javax.enterprise.inject.se.SeContainerInitializer
import javax.jms.Message
import javax.jms.TextMessage

class ConsumerTest {

    @Test
    fun receiveMessageTest() {

            val seContainerInitializer = SeContainerInitializer.newInstance()
            val consumer = seContainerInitializer.initialize()
                    .select(Consumer::class.java)
                    .get()
            Assert.assertNotNull(consumer)
            val message: Message = consumer.receiveMessage()
            if (message is TextMessage)
                println("message received ---- ${message.text}")
            Assert.assertNotNull(message)

        }
}
