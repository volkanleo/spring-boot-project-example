package volkanozturk.examples.springbootprojectexample.spring.config;

import volkanozturk.examples.springbootprojectexample.mapper.CustomObjectMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Configuration Class for Common Configurations.
 * This configuration class includes component, repository, entity scan & it enables Web MVC.
 * Also, this configuration class declares customObjectMapper bean.
 *
 * @author <a href="https://github.com/volkanozturk">Volkan Ozturk</a>
 * @since 1.0.0
 */
@Configuration
@ComponentScan(basePackages = "volkanozturk.examples.springbootprojectexample")
@EnableMongoRepositories(value = "volkanozturk.examples.springbootprojectexample.repository")
@EntityScan(value = "volkanozturk.examples.springbootprojectexample.entity")
@EnableWebMvc
public class CommonConfig {

  /**
   * Bean declarations for customerObjectMapper.
   *
   * @return CustomObjectMapper. Please, see the {@link CustomObjectMapper} class for details.
   *
   * @author <a href="https://github.com/volkanozturk">Volkan Ozturk</a>
   * @since 1.0.0
   */
  @Bean(name = "customObjectMapper")
  public CustomObjectMapper customObjectMapper() {
    return new CustomObjectMapper();
  }
}
