package ash.gz;

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
}
