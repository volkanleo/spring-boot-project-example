package volkanozturk.examples.springbootprojectexample.spring.spring;

import volkanozturk.examples.springbootprojectexample.spring.config.CommonConfig;
import volkanozturk.examples.springbootprojectexample.spring.config.OpenApiConfig;
import volkanozturk.examples.springbootprojectexample.spring.config.WebConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * Spring Boot Application Class.
 *
 * @author <a href="https://github.com/volkanozturk">Volkan Ozturk</a>
 * @since 1.0.0
 */
@SpringBootApplication
@Import(value = {CommonConfig.class, WebConfig.class, OpenApiConfig.class})
public class SpringBootProjectExampleApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootProjectExampleApplication.class, args);
  }

}
