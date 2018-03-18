package net.lab0.dwarf.shell;

import org.jline.reader.Parser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.shell.jline.JLineShellAutoConfiguration;

@SpringBootApplication
@ComponentScan(basePackages = {"net.lab0.shell"})
@EnableAutoConfiguration(exclude = {JLineShellAutoConfiguration.class})
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Bean
  public Parser parser() {
    return (var1, var2, var3) -> null;
  }
}
