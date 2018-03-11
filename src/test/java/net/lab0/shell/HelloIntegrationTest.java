package net.lab0.shell;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.MethodTarget;
import org.springframework.shell.Shell;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class HelloIntegrationTest {

  @Autowired
  private Shell shell;

  @Test
  void testHello() {
    Map<String, MethodTarget> commands = shell.listCommands();
    MethodTarget methodTarget = commands.get("hello");
    assertThat(methodTarget).isNotNull();
    assertThat(methodTarget.getGroup()).isEqualTo(Groups.EXAMPLES);
    assertThat(methodTarget.getAvailability().isAvailable()).isTrue();
    assertThat(shell.evaluate(() -> "hello")).isEqualTo("hello");
  }
}
