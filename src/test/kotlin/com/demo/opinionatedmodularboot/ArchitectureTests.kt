package com.demo.opinionatedmodularboot

import com.demo.opinionatedmodularboot.modules.ModuleAPI
import com.tngtech.archunit.base.DescribedPredicate
import com.tngtech.archunit.core.domain.JavaMethodCall
import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition
import com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices
import org.junit.jupiter.api.Test
import org.springframework.stereotype.Service

class ArchitectureTests {

    @Test
    fun `modules can depend on libraries not the other way around`() {
        val target = ClassFileImporter().importPackages("com.demo")

        val libraryModulesShouldNotDependOnApplicationModules = ArchRuleDefinition
            .noClasses().that()
            .resideInAPackage("com.demo.opinionatedmodularboot.*")
            .should().dependOnClassesThat()
            .resideInAPackage("com.demo.opinionatedmodularboot.modules..")
            .because("Library Modules should not depend on any Application Modules")

        libraryModulesShouldNotDependOnApplicationModules.check(target)
    }

    @Test
    fun `application module interdependencies are never cyclic`() {
        val target = ClassFileImporter().importPackages("com.demo")

        val rule = slices()
            .matching("com.demo.opinionatedmodularboot.modules.(*)")
            .should()
            .beFreeOfCycles()
            .because("Application Modules should not have cyclic dependencies between them")

        rule.check(target)
    }

    @Test
    fun `application module should depend only on service classes and module api methods from other modules`() {
        val target = ClassFileImporter().importPackages("com.demo")

        val rule = ArchRuleDefinition
            .classes()
            .that()
            .resideInAPackage("com.demo.opinionatedmodularboot.modules..")
            .should()
            .callMethodWhere(targetIsInAServiceClassAndIsAnnotatedAsAModuleAPI())

        rule.check(target)
    }

    private fun targetIsInAServiceClassAndIsAnnotatedAsAModuleAPI() =
        object : DescribedPredicate<JavaMethodCall>("target method should be a part of a @Service class") {
            override fun test(t: JavaMethodCall): Boolean {
                if (t.origin.owner.packageName == t.target.owner.packageName) {
                    return true
                }
                if (!t.targetOwner.packageName.startsWith("com.demo.opinionatedmodularboot.modules")) {
                    return true
                }
                return t.target.owner.isAnnotatedWith(Service::class.java) &&
                        t.target.isAnnotatedWith(ModuleAPI::class.java)
            }
        }
}