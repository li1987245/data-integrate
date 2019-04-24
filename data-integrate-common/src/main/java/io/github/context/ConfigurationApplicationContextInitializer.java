package io.github.context;

import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

public class ConfigurationApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        Environment env = applicationContext.getEnvironment();
        ClassPathProviderScanner scanner = BeanUtils.instantiate(ClassPathProviderScanner.class);
        scanner.setAnnotationClass(Service.class);
        scanner.setApplicationContext(applicationContext);
        applicationContext.addBeanFactoryPostProcessor(scanner);
        applicationContext.getBeanFactory().addBeanPostProcessor(scanner);
        applicationContext.getBeanFactory().registerSingleton("dubboScanBean", scanner);
    }
}
