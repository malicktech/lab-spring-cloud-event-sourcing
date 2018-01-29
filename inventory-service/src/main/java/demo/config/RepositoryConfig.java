package demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import demo.catalog.Catalog;
import demo.product.Product;

@Configuration class RepositoryConfig extends RepositoryRestConfigurerAdapter {
    
	@Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Catalog.class, Product.class);
    }
}
