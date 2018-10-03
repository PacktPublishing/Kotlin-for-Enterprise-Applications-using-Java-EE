package org.rao.kotlin.designpatterns.singleton

import org.junit.Assert
import org.junit.Test

class SingletonTest {
    @Test
    fun testSingletonObject() {

         var details: String  = Singleton.getDetails()
        Assert.assertEquals ("this is a singleton class", details);

    }
}
