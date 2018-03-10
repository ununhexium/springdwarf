package net.lab0.shell

import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod

@ShellComponent
class Hello {
    @ShellMethod("Say hello")
    fun hello()  = "hello"
}
