package cn.yxffcode.mybatispagequeryall;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author gaohang on 16/8/4.
 */
public class DaoPageQueryAllBeanPostProcessor implements BeanPostProcessor {
    private final Class<?> annotation;

    public DaoPageQueryAllBeanPostProcessor(final String annotationName) {
        try {
            this.annotation = Class.forName(annotationName);
            if (!annotation.isAnnotation()) {
                throw new IllegalArgumentException(annotationName + " is not an annotation");
            }
        } catch (ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override public Object postProcessBeforeInitialization(final Object o, final String beanName)
            throws BeansException {
        return o;
    }

    @Override public Object postProcessAfterInitialization(final Object o, final String beanName)
            throws BeansException {
        return null;
    }
}
