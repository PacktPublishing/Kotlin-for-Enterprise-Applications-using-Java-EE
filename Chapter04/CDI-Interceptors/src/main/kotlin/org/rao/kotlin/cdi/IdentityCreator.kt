package org.rao.kotlin.cdi

import javax.enterprise.context.Dependent
import javax.inject.Inject

@Dependent
class IdentityCreator {
    @Inject
    @NativeEnglishSpeaker
    private lateinit var defaultPreferredLanguage: PreferredLanguage


    fun createPerson(inputData: InputData): Person {
        val person = Person()
        person.preferredLanguage = if (inputData.preferredLanguage == null)
            defaultPreferredLanguage
        else
            inputData.preferredLanguage
        return person
    }
}

