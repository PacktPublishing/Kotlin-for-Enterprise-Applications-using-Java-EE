package org.rao.kotlin.designpatterns.chain.model.identity

abstract class Identity {
    var id: String? = null
    var name: String? = null
    var description: String? = null
    var identityType: IdentityType? = null
    var requestMethod: String? = null
}
