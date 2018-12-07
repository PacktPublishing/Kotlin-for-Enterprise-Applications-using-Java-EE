package org.rao.kotlin.messaging

import org.junit.Assert
import org.junit.Test
import javax.enterprise.inject.se.SeContainerInitializer

class ProducerTest {

    @Test
    fun sendMessageTest() {

        val seContainerInitializer = SeContainerInitializer.newInstance()
        val producer = seContainerInitializer.initialize()
                .select(Producer::class.java)
                .get()

        Assert.assertNotNull(producer)
        val message = producer.sendMessage("TEST MESSAGE")
        Assert.assertEquals("Message sent", message)


    }
}
