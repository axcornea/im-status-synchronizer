package com.acriox.imstatussynchronizer.configuration.platform;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OnPlatformCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        var expectedPlatform =
                (Platform) metadata.getAnnotationAttributes(ConditionalOnPlatform.class.getCanonicalName()).get("value");
        var currentPlatform = context.getEnvironment().getProperty("os.name");
        return currentPlatform.contains(expectedPlatform.getFriendlyName());
    }
}
