package week4.example.prodfeatures.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import week4.example.prodfeatures.auth.AuditorAwareimpl;

@Configuration
@EnableJpaAuditing
@EnableJpaRepositories(
    repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class,
    basePackages = "week4.example.prodfeatures.repositories"
)
public class AppConfig {

    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

    @Bean
    public AuditorAware<String> auditorAware() {
        return new AuditorAwareimpl();
    }
}