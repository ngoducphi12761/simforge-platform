package com.cfdfea.ecommerce;

import com.cfdfea.ecommerce.entity.Country;
import com.cfdfea.ecommerce.entity.Product;
import com.cfdfea.ecommerce.entity.ProductCategory;
import com.cfdfea.ecommerce.repository.CountryRepository;
import com.cfdfea.ecommerce.repository.ProductCategoryRepository;
import com.cfdfea.ecommerce.repository.ProductRepository;
import com.cfdfea.ecommerce.repository.StateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringBootEcommerceApplication {
	private final ProductCategoryRepository productCategoryRepository;
	private final ProductRepository productRepository;
	private final CountryRepository countryRepository;
	private final StateRepository stateRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEcommerceApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner() {
//		return args -> {
//			// Create product categories
//			ProductCategory cars = new ProductCategory();
//			cars.setCategoryName("Cars");
//
//			ProductCategory heatTransfer = new ProductCategory();
//			heatTransfer.setCategoryName("Heat Transfer");
//
//			ProductCategory turbulence = new ProductCategory();
//			turbulence.setCategoryName("Turbulence");
//
//			ProductCategory windTurbine = new ProductCategory();
//			windTurbine.setCategoryName("Wind Turbine");
//			Product carSimulation = new Product("Car Simulation",
//					"Comprehensive guide to car simulations, including practical examples and clear explanations of advanced concepts.",
//					"assets/images/products/car/car-1000.png", new BigDecimal("14.99"), 100, true)
//			cars.addProduct(carSimulation);
//			//cars.addProduct();
//
//			heatTransfer.addProduct(new Product( "Heating Simulation",
//					"Step-by-step guide to heat transfer simulations, including theoretical background and practical applications.",
//					"assets/images/products/heat/heat-1000.png", new BigDecimal("18.99"), 100, true));
//			heatTransfer.addProduct(new Product( "Heating Analysis",
//					"In-depth analysis of heating systems, covering simulation strategies and performance optimization.",
//					"assets/images/products/heat/heat-1001.png", new BigDecimal("18.99"), 100, true));
//
//			turbulence.addProduct(new Product( "Turbulence Simulation",
//					"Comprehensive overview of turbulence simulation techniques for engineers and researchers.",
//					"assets/images/products/turbulence/turbulence-1000.png", new BigDecimal("17.99"), 100, true));
//			turbulence.addProduct(new Product( "Turbulence Analysis",
//					"Advanced guide to turbulence analysis, including practical examples for complex systems.",
//					"assets/images/products/turbulence/turbulence-1001.png", new BigDecimal("17.99"), 100, true));
//
//			windTurbine.addProduct(new Product( "Wind Turbine Simulation",
//					"Step-by-step instructions for simulating wind turbine performance, with case studies and real-world examples.",
//					"assets/images/products/windturbine/windturbine-1000.png", new BigDecimal("16.99"), 100, true));
//			windTurbine.addProduct(new Product( "Wind Turbine Analysis",
//					"Detailed insights into wind turbine analysis, focusing on simulation accuracy and efficiency.",
//					"assets/images/products/windturbine/windturbine-1001.png", new BigDecimal("16.99"), 100, true));
//
//			// Save categories (cascade saves products)
//			List<ProductCategory> categories = Arrays.asList(cars, heatTransfer, turbulence, windTurbine);
//			productCategoryRepository.saveAll(categories);
//		};
//	}

}
