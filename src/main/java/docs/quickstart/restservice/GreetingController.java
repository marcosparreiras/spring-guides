package docs.quickstart.restservice;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  private static final String template = "Hello %s!";
  private final AtomicLong counter = new AtomicLong();

  private record Greeting(long id, String name) {}

  @GetMapping("/greeting")
  public Greeting greeting(
    @RequestParam(value = "name", defaultValue = "World") String name
  ) {
    return new Greeting(
      this.counter.incrementAndGet(),
      String.format(GreetingController.template, name)
    );
  }
}
