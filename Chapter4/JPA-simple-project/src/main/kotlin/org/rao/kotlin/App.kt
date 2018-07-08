package org.rao.kotlin

import java.util.ArrayList
import java.util.Random
import org.rao.kotlin.jpa.PersonDaoImpl
import org.rao.kotlin.entity.Address
import org.rao.kotlin.entity.ContactDetails
import org.rao.kotlin.entity.ContactType
import org.rao.kotlin.service.PersonServiceImpl
import org.rao.kotlin.entity.Person
import org.rao.kotlin.entity.PreferredLanguage
import javax.inject.Inject

object App {
    @Inject
    lateinit var personServiceImpl: PersonServiceImpl

    @JvmStatic
    fun main(args: Array<String>) {

        val createPersonRequest = Person("myLoginId" + Random().nextInt())
        val contactDetails = ContactDetails()

        contactDetails.number = "1234567871"
        contactDetails.type = ContactType.WORK
        val contactDetailsList = ArrayList<ContactDetails>()
        contactDetailsList.add(contactDetails)
        createPersonRequest.contact = contactDetailsList

        val address = Address()
        address.street = "a"
        address.city = "Bengaluru"
        address.state = "Karnataka"
        address.country = "India"

        createPersonRequest.address = address
        createPersonRequest.name = "myName"
        createPersonRequest.preferredLanguage = PreferredLanguage.EN_US
        val person = personServiceImpl.createPerson(createPersonRequest)
        println("Data created " + person.identifier)

    }
}
