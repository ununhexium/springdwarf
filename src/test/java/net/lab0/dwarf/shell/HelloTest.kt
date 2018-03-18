package net.lab0.dwarf.shell

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.shell.ConfigurableCommandRegistry
import org.springframework.shell.standard.StandardMethodTargetRegistrar
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.util.ReflectionUtils

@ExtendWith(SpringExtension::class)
internal class HelloTest {
    private val registrar = StandardMethodTargetRegistrar()
    private val registry = ConfigurableCommandRegistry()

    @BeforeEach
    fun setUp() {
        val context = AnnotationConfigApplicationContext(Hello::class.java)
        registrar.setApplicationContext(context)
        registrar.register(registry)
    }

    @Test
    fun sayHello() {
        val commands = registry.listCommands()

        val methodTarget = commands["hello"]!!

        assertThat(methodTarget.availability.isAvailable).isTrue()

        assertThat(
            ReflectionUtils.invokeMethod(methodTarget.method, methodTarget.bean)
        ).isEqualTo("hello")
    }
}
