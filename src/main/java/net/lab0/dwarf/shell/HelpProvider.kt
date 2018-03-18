package net.lab0.dwarf.shell

import org.springframework.core.MethodParameter
import org.springframework.shell.CompletionContext
import org.springframework.shell.standard.ValueProviderSupport

class HelpProvider : ValueProviderSupport{
  override fun supports(parameter: MethodParameter?, completionContext: CompletionContext?): Boolean {
    return
  }
}
