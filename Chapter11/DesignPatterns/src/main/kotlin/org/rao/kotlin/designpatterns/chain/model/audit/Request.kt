package org.rao.kotlin.designpatterns.chain.model.audit

import org.rao.kotlin.designpatterns.chain.model.identity.Identity

open class Request {
    var identity: Identity? = null
}
