package memory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Slf4j
public class MemoryCondition implements Condition {
    //환경 정보에 memory=on 이라고 되어 있는 경우에만 true 를 반환
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata
            metadata) {
        String memory = context.getEnvironment().getProperty("memory");
        log.info("memory={}", memory);
        return "on".equals(memory);
    }
}
