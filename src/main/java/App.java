import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.config.Environment;

public class App extends Service<Configuration> {
    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {

    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        environment.addResource(new TestResource(environment.getObjectMapperFactory().build()));
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}
