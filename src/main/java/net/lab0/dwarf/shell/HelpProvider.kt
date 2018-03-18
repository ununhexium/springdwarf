package net.lab0.dwarf.shell

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.core.MethodParameter
import org.springframework.shell.CompletionContext
import org.springframework.shell.CompletionProposal
import org.springframework.shell.standard.ValueProviderSupport

class HelpProvider : ValueProviderSupport() {

  companion object {
    val log: Logger by lazy {
      LoggerFactory.getLogger(HelpProvider::class.java)
    }
  }

  override fun complete(parameter: MethodParameter?, completionContext: CompletionContext?, hints: Array<out String>?): List<CompletionProposal> {
    // TODO: is this working now in spring boot 2?
    log.warn("Completion")
    return listOf(
        CompletionProposal("choice")
    )
  }
}
