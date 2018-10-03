package org.rao.kotlin.designpatterns.chain.handler

import org.rao.kotlin.designpatterns.chain.model.identity.Identity

interface Handler {
    fun addHandler(auditHandler: Handler)
    fun handleRequest(identityRequest: Identity)
}
