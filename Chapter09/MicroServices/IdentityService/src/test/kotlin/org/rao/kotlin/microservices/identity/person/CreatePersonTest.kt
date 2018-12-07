package org.rao.kotlin.microservices.identity.person

import java.util.UUID
import javax.ws.rs.core.Response
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.rao.kotlin.microservices.identity.person.controller.PersonController
import org.rao.kotlin.microservices.identity.person.model.Person
import org.rao.kotlin.microservices.identity.util.Constants
import org.rao.kotlin.service.PersonServiceImpl

import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.rao.kotlin.microservices.identity.organization.TestUtil

@RunWith(MockitoJUnitRunner.Silent::class)
class CreatePersonTest {


    @InjectMocks
    internal var controller: PersonController? = null

    @Mock
    internal var serviceImpl: PersonServiceImpl? = null


    internal var builder = mock(Response.ResponseBuilder::class.java)

    @Test
    fun createPersonTest() {
        val createPersonRequest = mock(Person::class.java)
        createPersonRequest.name = "test user"
        createPersonRequest.loginId = "user@some.com"
        createPersonRequest.orgId = "123"
        val uuid = UUID.randomUUID().toString()

        val response = TestUtil.getResponseForIdentityCreation(uuid)

        `when`(serviceImpl!!.createPerson(createPersonRequest))
                .thenReturn(uuid)

        `when`(builder.build())
                .thenReturn(response)

        controller!!.createPerson(createPersonRequest)


        assertTrue(response.status == 201)
        assertTrue(response.entity.toString() == Constants.IDENTITY_CREATED)
        assertNotNull(response.metadata["location"])

    }
}
