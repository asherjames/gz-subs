package ash.gz;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
class CustomRestMvcConfig extends RepositoryRestConfigurerAdapter
{
  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config)
  {
    config.setReturnBodyOnCreate(true);
    config.setReturnBodyOnUpdate(true);
  }

  @Override
  public void configureJacksonObjectMapper(ObjectMapper objectMapper)
  {
    super.configureJacksonObjectMapper(objectMapper);
    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
  }
}
