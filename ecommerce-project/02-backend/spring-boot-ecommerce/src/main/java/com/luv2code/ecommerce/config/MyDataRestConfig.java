package com.luv2code.ecommerce.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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

import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	private EntityManager entityManager;
	
	@Autowired
	public MyDataRestConfig(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
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
		
		exposeIds(config);
	}

	private void exposeIds(RepositoryRestConfiguration config) {
		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
		List<Class> entityClasses = new ArrayList<Class>();
		for( EntityType tempEntityType : entities) {
			entityClasses.add(tempEntityType.getJavaType());
		}
		Class[] domainTypes = entityClasses.toArray(new Class[0]);
		config.exposeIdsFor(domainTypes);
	}
	
	
}
