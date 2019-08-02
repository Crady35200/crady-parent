package com.crady.annotation.beanRegister;

import com.crady.annotation.beanRegister.bean.Monkery;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * author:Crady
 * date:2019/08/02 23:13
 * desc:
 **/
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(Monkery.class);
        registry.registerBeanDefinition("monkey",rootBeanDefinition);
    }
}
