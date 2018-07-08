package org.rao.kotlin.javaee.servletexample

import javax.ejb.Stateless


@Stateless
open class StatelessEjb() {
    //constructor(StatelessEjb)
    fun hello(name: String) : String {
        return "Hello $name"
    }

}
