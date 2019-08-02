package com.crady.annotation.beanRegister;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * author:Crady
 * date:2019/08/02 23:02
 * desc:
 **/
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.crady.annotation.beanRegister.bean.Bird"};
    }
}
