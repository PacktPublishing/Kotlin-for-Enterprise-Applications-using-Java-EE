package org.rao.kotlin.cdi

import javax.enterprise.inject.Produces

class PreferredLanguageProducer1 {
    @Produces
    private lateinit var defaultPreferredLanguage: PreferredLanguage

}

