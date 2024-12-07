package com.cfdfea.ecommerce.config;

import com.cfdfea.ecommerce.entity.Country;
import com.cfdfea.ecommerce.entity.Product;
import com.cfdfea.ecommerce.entity.ProductCategory;
import com.cfdfea.ecommerce.entity.State;
import com.cfdfea.ecommerce.repository.CountryRepository;
import com.cfdfea.ecommerce.repository.ProductCategoryRepository;
import com.cfdfea.ecommerce.repository.ProductRepository;
import com.cfdfea.ecommerce.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class SetupInitialData implements ApplicationListener<ContextRefreshedEvent> {
    private final ProductRepository productRepository;
    private final ProductCategoryRepository productCategoryRepository;
    private final CountryRepository countryRepository;
    private final StateRepository stateRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // Create product categories
        // Step 1: Create and save product categories
        createCountriesAndStates();
        ProductCategory cars = createCategory("Cars");
        ProductCategory heatTransfer = createCategory("Heat Transfer");
        ProductCategory turbulence = createCategory("Turbulence");
        ProductCategory windTurbine = createCategory("Wind Turbine");

        // Step 2: Create and save products for each category
        createProduct(cars, "CAR-TECH-1000", "Car simulation",
                "Learn car simulation at your own pace. The author explains how the technology works in simple, clear language. This guide includes practical examples you can apply to your own projects. Start exploring car simulation today!",
                "assets/images/products/car/car-1000.png", true, 100, new BigDecimal("14.99"), new Date());

        createProduct(cars, "CAR-TECH-1001", "Car Analysis",
                "Learn car simulation at your own pace. The author explains how the technology works in simple, clear language. This guide includes practical examples you can apply to your own projects. Start exploring car simulation today!",
                "assets/images/products/car/car-1001.png", true, 100, new BigDecimal("20.99"), new Date());

        createProduct(heatTransfer, "HEATING-1000", "Heating Simulation",
                "Learn heating simulation at your own pace. The author explains how the technology works in simple, clear language. This guide includes practical examples you can apply to your own projects. Start exploring heating simulation today!",
                "assets/images/products/heat/heat-1000.png", true, 100, new BigDecimal("18.99"), new Date());

        createProduct(heatTransfer, "HEATING-1001", "Heating Analysis",
                "Learn heating analysis at your own pace. The author explains how the technology works in simple, clear language. This guide includes practical examples you can apply to your own projects. Start exploring heating analysis today!",
                "assets/images/products/heat/heat-1001.png", true, 100, new BigDecimal("18.99"), new Date());

        createProduct(turbulence, "TURBULENCE-1000", "Turbulence Simulation",
                "Learn turbulence simulation at your own pace. The author explains how the technology works in simple, clear language. This guide includes practical examples you can apply to your own projects. Start exploring turbulence simulation today!",
                "assets/images/products/turbulence/turbulence-1000.png", true, 100, new BigDecimal("17.99"), new Date());

        createProduct(turbulence, "TURBULENCE-1001", "Turbulence Analysis",
                "Learn turbulence analysis at your own pace. The author explains how the technology works in simple, clear language. This guide includes practical examples you can apply to your own projects. Start exploring turbulence analysis today!",
                "assets/images/products/turbulence/turbulence-1001.png", true, 100, new BigDecimal("17.99"), new Date());

        createProduct(windTurbine, "WINDTURBINE-1000", "Wind Turbine Simulation",
                "Learn wind turbine simulation at your own pace. The author explains how the technology works in simple, clear language. This guide includes practical examples you can apply to your own projects. Start exploring wind turbine simulation today!",
                "assets/images/products/windturbine/windturbine-1000.png", true, 100, new BigDecimal("16.99"), new Date());

        createProduct(windTurbine, "WINDTURBINE-1001", "Wind Turbine Analysis",
                "Learn wind turbine analysis at your own pace. The author explains how the technology works in simple, clear language. This guide includes practical examples you can apply to your own projects. Start exploring wind turbine analysis today!",
                "assets/images/products/windturbine/windturbine-1001.png", true, 100, new BigDecimal("16.99"), new Date());
    }

    private ProductCategory createCategory(String name) {
        ProductCategory category = new ProductCategory();
        category.setCategoryName(name);
        return productCategoryRepository.save(category);
    }

    private void createProduct(ProductCategory category, String sku, String name, String description, String imageUrl,
                               boolean active, int unitsInStock, BigDecimal unitPrice, Date dateCreated) {
        Product product = new Product();
        product.setCategory(category);
        product.setSku(sku);
        product.setName(name);
        product.setDescription(description);
        product.setImageUrl(imageUrl);
        product.setActive(active);
        product.setUnitsInStock(unitsInStock);
        product.setUnitPrice(unitPrice);
        product.setDateCreated(dateCreated);
        productRepository.save(product);
    }
    private Country createCountry(String code, String name) {
        Country country = new Country();
        country.setCode(code);
        country.setName(name);
        return countryRepository.save(country);
    }

    private void createState(Country country, String name) {
        State state = new State();
        state.setName(name);
        state.setCountry(country);
        stateRepository.save(state);
    }
    private void createCountriesAndStates() {
        // Create countries
        Country brazil = createCountry("BR", "Brazil");
        Country canada = createCountry("CA", "Canada");
        Country germany = createCountry("DE", "Germany");
        Country india = createCountry("IN", "India");
        Country turkey = createCountry("TR", "Turkey");
        Country usa = createCountry("US", "United States");

        // Create states for each country
        createState(brazil, "Acre");
        createState(brazil, "Alagoas");
        // Add all other Brazilian states...

        createState(canada, "Alberta");
        createState(canada, "British Columbia");
        // Add all other Canadian provinces...

        createState(germany, "Bavaria");
        createState(germany, "Berlin");
        // Add all other German states...

        createState(india, "Andhra Pradesh");
        createState(india, "Tamil Nadu");
        // Add all other Indian states...

        createState(turkey, "Istanbul");
        createState(turkey, "Ankara");
        // Add all other Turkish states...

        createState(usa, "California");
        createState(usa, "Texas");
        // Add all other US states...
    }
}
