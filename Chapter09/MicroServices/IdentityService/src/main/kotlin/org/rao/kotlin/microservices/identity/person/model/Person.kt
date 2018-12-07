package org.rao.kotlin.microservices.identity.person.model


class Person() {

    lateinit var identifier: String
    lateinit var name: String

    var loginId:String ?= null
    var orgId:String ?= null
    var preferredLanguage: String? = null


    lateinit var address: Address




}
