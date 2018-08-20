package org.rao.kotlin.messaging

import org.junit.Assert
import org.junit.Test
import javax.enterprise.inject.se.SeContainerInitializer

class ConsumerTest {

    @Test
    fun receiveMessageTest() {

        val seContainerInitializer = SeContainerInitializer.newInstance()
        val consumer = seContainerInitializer.initialize()
                .select(Consumer::class.java)
                .get()
        Assert.assertNotNull(consumer)
        val message = consumer.receiveMessage()
        Assert.assertNotNull(message)
    }
}
