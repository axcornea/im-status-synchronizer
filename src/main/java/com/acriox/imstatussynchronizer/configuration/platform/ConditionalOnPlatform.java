package com.acriox.imstatussynchronizer.configuration.platform;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Specifies a platform on which a bean should be exposed.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.METHOD})
@Conditional(OnPlatformCondition.class)
public @interface ConditionalOnPlatform {

    Platform value();
}
