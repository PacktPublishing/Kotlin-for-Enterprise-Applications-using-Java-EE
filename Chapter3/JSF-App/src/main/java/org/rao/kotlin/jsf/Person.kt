package org.rao.kotlin.jsf

import javax.faces.bean.ManagedBean

@ManagedBean(name = "person")
class Person {

    val name: String
        get() = "Mathur"
}
