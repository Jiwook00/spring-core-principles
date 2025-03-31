package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "hello.core",
        // 지정하지 않으면: @ComponentScan이 붙은 설정 정보 클래스의 패키지가 시작 위치
        // 권장: 설정 정보 클래스의 위치를 프로젝트 최상단에 둔다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
