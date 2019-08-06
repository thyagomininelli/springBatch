package br.com.infra.spring;

import java.io.Serializable;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Component
@Configuration
@EnableScheduling // Habilitando o Spring Scheduling(Agendador Automatico)
// @EnableAsync //Habilitando o Spring Async (Processamento assincrono. Permite
// processamento multithread)
@EnableBatchProcessing
@EnableTransactionManagement // Habilitando o Controle Transacional
public class SpringConfigurador implements Serializable {

	private static final long serialVersionUID = 3037200994699406071L;

//	@Bean
//	BatchConfigurer configurer(@Qualifier("dataSource") DataSource dataSource) {
//		return new DefaultBatchConfigurer(dataSource);
//	}

//	@Bean
//	public PlatformTransactionManager transactionManager() {
//		return new ResourcelessTransactionManager();
//	}

	

}