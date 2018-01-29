package demo;

import demo.address.AddressRepository;
import demo.catalog.CatalogRepository;
import demo.inventory.InventoryRepository;
import demo.product.ProductRepository;
import demo.shipment.ShipmentRepository;
import demo.warehouse.WarehouseRepository;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

//@Configuration
class GraphConfiguration {

    @Bean
    public SessionFactory sessionFactory() {
        // we need to specify which packages Neo4j should scan
        // we'll use classes in each package to avoid brittleness
        Class<?>[] packageClasses = {
                ProductRepository.class,
                ShipmentRepository.class,
                WarehouseRepository.class,
                AddressRepository.class,
                CatalogRepository.class,
                InventoryRepository.class
        };
        String[] packageNames =
                Arrays.asList(packageClasses)
                        .stream()
                        .map( c -> getClass().getPackage().getName())
                        .collect(Collectors.toList())
                        .toArray(new String[packageClasses.length]);
        return new SessionFactory(packageNames);
    }
    
    @Bean
    public Neo4jTransactionManager transactionManager() throws Exception {
        return new Neo4jTransactionManager(sessionFactory());
    }

}
