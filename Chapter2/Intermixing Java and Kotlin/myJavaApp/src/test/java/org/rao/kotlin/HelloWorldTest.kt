package org.rao.kotlin

import org.junit.Assert
import org.junit.Test
import org.mockito.Mock

import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class HelloWorldTest {

    internal var helloWorld = mock(HelloWorld::class.java)

    @Test
    fun testHello() {
        val mockMessage = "hello"
        `when`(helloWorld.hello()).thenReturn(mockMessage)

        val message = helloWorld.hello()

        Assert.assertNotNull(message)
        Assert.assertEquals("hello", message)
    }

}
