package com.demo.opinionatedmodularboot.modules

import java.lang.annotation.ElementType


@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class ModuleAPI {

}