package org.rao.kotlin.cdi

import javax.enterprise.inject.Produces

class PreferredLanguageProducer {

    @Produces
    @NativeEnglishSpeaker
    fun exposeDefaultPreferredLanguage(): PreferredLanguage {
        return PreferredLanguage.EN_US
    }
}

