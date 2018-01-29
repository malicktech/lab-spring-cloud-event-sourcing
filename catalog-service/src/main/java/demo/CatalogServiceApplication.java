package demo;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import demo.config.DefaultProfileUtil;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class CatalogServiceApplication {
	
	private static final Logger log = LoggerFactory.getLogger(CatalogServiceApplication.class);

    private final Environment env;

    public CatalogServiceApplication(Environment env) {
        this.env = env;
    }
    
    public static void main(String[] args) throws UnknownHostException {        
        SpringApplication app = new SpringApplication(CatalogServiceApplication.class);
        DefaultProfileUtil.addDefaultProfile(app);
        Environment env = app.run(args).getEnvironment();
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        
        log.info("\n----------------------------------------------------------\n\t" +
                "Application '{}' is running! Access URLs:\n\t" +
                "Local: \t\t{}://localhost:{}\n\t" +
                "External: \t{}://{}:{}\n\t" +
                "Profile(s): \t{}\n----------------------------------------------------------",
            env.getProperty("spring.application.name"),
            protocol,
            env.getProperty("server.port"),
            protocol,
            InetAddress.getLocalHost().getHostAddress(),
            env.getProperty("server.port"),
            env.getActiveProfiles());
    }
    
    @LoadBalanced
    @Bean
    public RestTemplate loadRestTemplate() {
        return new RestTemplate();
    }
}