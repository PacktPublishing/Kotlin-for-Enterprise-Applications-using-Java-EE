package org.rao.kotlin.javaee

import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

class Person(@field:NotBlank private val name: String,
             @field:Email private val emailId: String,
             @field:NotNull private val preferredLanguage: String)

