package net.lab0.dwarf.shell

import org.springframework.shell.standard.ShellComponent
import org.springframework.shell.standard.ShellMethod
import org.springframework.shell.standard.ShellOption

@ShellComponent
class Hello {

  @ShellMethod(value = "Say hello", group = Groups.EXAMPLES)
  fun hello() = "hello"

  @ShellMethod(value = "helped", group = Groups.EXAMPLES)
  fun helped(
      @ShellOption(valueProvider = HelpProvider::class) text: String
  ) = "help $text"

}
