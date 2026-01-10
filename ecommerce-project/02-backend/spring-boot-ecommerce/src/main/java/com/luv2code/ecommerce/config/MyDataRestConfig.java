package com.luv2code.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.ConfigurableHttpMethods;
import org.springframework.data.rest.core.mapping.ExposureConfigurer.AggregateResourceHttpMethodsFilter;
import org.springframework.data.rest.core.mapping.ResourceMetadata;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.luv2code.ecommerce.entity.Product;
import com.luv2code.ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		final HttpMethod[] theUnSupportedActions = {HttpMethod.DELETE , HttpMethod.PUT , HttpMethod.POST};
		config.getExposureConfiguration().forDomainType(Product.class)
		.withItemExposure( new AggregateResourceHttpMethodsFilter() {
			public ConfigurableHttpMethods filter(ResourceMetadata metdata, ConfigurableHttpMethods httpMethods) {
				return httpMethods.disable(theUnSupportedActions);
			}
		})
		.withCollectionExposure( new AggregateResourceHttpMethodsFilter() {
			public ConfigurableHttpMethods filter(ResourceMetadata metdata, ConfigurableHttpMethods httpMethods) {
				return httpMethods.disable(theUnSupportedActions);
			}
		} );
		
		config.getExposureConfiguration().forDomainType(ProductCategory.class)
		.withItemExposure( new AggregateResourceHttpMethodsFilter() {
			public ConfigurableHttpMethods filter(ResourceMetadata metdata, ConfigurableHttpMethods httpMethods) {
				return httpMethods.disable(theUnSupportedActions);
			}
		})
		.withCollectionExposure( new AggregateResourceHttpMethodsFilter() {
			public ConfigurableHttpMethods filter(ResourceMetadata metdata, ConfigurableHttpMethods httpMethods) {
				return httpMethods.disable(theUnSupportedActions);
			}
		} );
	}
	
	
}
