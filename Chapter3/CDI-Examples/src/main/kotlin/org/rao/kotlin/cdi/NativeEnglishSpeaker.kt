package org.rao.kotlin.cdi

import javax.inject.Qualifier
import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Documented
annotation class NativeEnglishSpeaker
