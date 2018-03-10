package ash.gz.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource
{
  @RequestMapping("/test")
  public String getHelloWorld()
  {
    return "Hello world!";
  }
}
