package org.rao.kotlin.javaee

import org.junit.Assert
import org.junit.Test
import javax.validation.Validation
import javax.validation.Validator

class PersonTest {

    @Test
    fun validUser() {
        val person = Person(
                "Raghavendra Rao",
                "kraghavendrarao1@gmail.com",
                "en-us")

        val validationErrors = PersonTest.validator!!
                .validate(person)
        Assert.assertTrue(validationErrors.isEmpty())
    }

    @Test
    fun invalidName() {
        val person = Person(
                "",
                "kraghavendrarao1@gmail.com",
                "en-us")

        val validationErrors = PersonTest.validator!!
                .validate(person)
        Assert.assertEquals(1, validationErrors.size.toLong())
    }

    @Test
    fun invalidEmailId() {
        val person = Person(
                "Raghavendra Rao",
                "kraghavendrarao1",
                "en-us")

        val validationErrors = PersonTest.validator!!
                .validate(person)
        Assert.assertEquals(1, validationErrors.size.toLong())
    }

    companion object {
        private val validator : Validator = Validation.buildDefaultValidatorFactory()
                .validator
    }
}
