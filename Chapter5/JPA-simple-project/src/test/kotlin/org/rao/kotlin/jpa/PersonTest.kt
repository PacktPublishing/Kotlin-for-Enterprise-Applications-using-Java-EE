package org.rao.kotlin.jpa

import java.util.ArrayList
import java.util.Random
import java.util.UUID
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner
import org.rao.kotlin.entity.Address
import org.rao.kotlin.entity.ContactDetails
import org.rao.kotlin.entity.ContactType
import org.rao.kotlin.entity.Person
import org.rao.kotlin.entity.PreferredLanguage

@RunWith(MockitoJUnitRunner::class)
class PersonTest {
    @Mock
    private val personDao: PersonDaoImpl? = null

    private var createPersonRequest: Person? = null
    private var createPersonResponse: Person? = null

    @Before
    fun setUp() {

        var createPersonRequest = Person("myLoginId" + Random().nextInt())
        createPersonRequest.name = "myName"
        val contactDetails = ContactDetails()

        contactDetails.number = "1234567891"
        contactDetails.type = ContactType.WORK
        val contactDetailsList = ArrayList<ContactDetails>()
        contactDetailsList.add(contactDetails)
        createPersonRequest!!.contact = contactDetailsList

        val address = Address()
        address.street = "Charles street"
        address.city = "Bengaluru"
        address.state = "Karnataka"
        address.country = "India"
        createPersonRequest!!.address = address

        createPersonResponse = Person("testLoginId")
        createPersonResponse!!.identifier = UUID.randomUUID().toString()

    }

    @Test
    fun test() {

        Mockito.`when`(personDao!!.createPerson(createPersonRequest!!)).thenReturn(createPersonResponse)
        createPersonRequest!!.preferredLanguage = PreferredLanguage.EN_US
        val person = personDao.createPerson(createPersonRequest!!)
        Assert.assertNotNull(person.identifier)

    }
}
