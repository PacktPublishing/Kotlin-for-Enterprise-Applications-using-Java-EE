package org.rao.kotlin.messaging

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.util.concurrent.CountDownLatch
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.enterprise.inject.se.SeContainerInitializer
import javax.naming.NamingException
/*
@RunWith(MockitoJUnitRunner::class)
@Suite.SuiteClasses(PublisherTest::class)*/
class SubscriberTest {
    var executorService: ExecutorService? = null
    var countDownLatch: CountDownLatch? = null

    @Before
    fun setUp() {
        countDownLatch = CountDownLatch(10)
        executorService = Executors.newFixedThreadPool(4)
    }

    @Test
    @Throws(NamingException::class)
    fun receiveMessageTest() {
        val seContainerInitializer = SeContainerInitializer.newInstance()

        val subscriber = seContainerInitializer.initialize()
                .select(Subscriber::class.java)
                .get()
        Assert.assertNotNull(subscriber)
        println("Executor service init------------------- ")

        val runnableTask = {
            println("inside while")
            var msgResponse: String? = null
            try {
                msgResponse = subscriber.listenToMessage()
            } catch (e: NamingException) {
                e.printStackTrace()
            }
            if (msgResponse != null) {
                println("Yay--- message received $msgResponse")
            }
        }
        for (i in 0..3) {
            println("---------------------inside for loop--------------- $i")
            executorService!!.submit(runnableTask)
            println("---------------------inside for loop--11111111111-------------")
        }
        println("Calling listen method------------**********")
        countDownLatch!!.await(70, TimeUnit.SECONDS)
        // subscriber.listen();
    }
}
