package zw.co.pabuwe.polarbookshop.catalogservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

//@Data
@ConfigurationProperties(prefix = "polar")
public class PolarProperties {
    /**
     * A message to welcome users
     */
    private String greeting;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}
