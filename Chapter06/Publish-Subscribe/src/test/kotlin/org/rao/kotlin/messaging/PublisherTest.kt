package org.rao.kotlin.messaging

import org.junit.Assert
import org.junit.Test
import javax.enterprise.inject.se.SeContainerInitializer


class PublisherTest {

    @Test
    fun testPublishMessage() {
        val seContainerInitializer = SeContainerInitializer.newInstance()
        val seContainer = seContainerInitializer.initialize()
        val publisherInstance = seContainer.select(Publisher::class.java)

        val publisher = publisherInstance.get()
        Assert.assertNotNull(publisher)
        val message = "Test messgage for topic"
        publisher.publishMessage(message)
    }
}
