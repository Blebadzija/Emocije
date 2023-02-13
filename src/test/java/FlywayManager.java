import org.etsntesla.it.spring.DatabaseConfiguration;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FlywayManager implements InitializingBean {
    @Autowired
    DatabaseConfiguration config;
    private Flyway flyway;

    @Override
    public void afterPropertiesSet() throws Exception {
        flyway = Flyway
                .configure()
                .dataSource(config.getUrl(), config.getUser(), config.getPass())
                .locations("classpath:migrations")
                .cleanDisabled(false)
                .load();
    }

    public Flyway getFlyway() {
        return flyway;


    }
}
