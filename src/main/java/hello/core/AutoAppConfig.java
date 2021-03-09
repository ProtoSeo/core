package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// AppConfig 가 자동으로 등록되는 것을 방지하기 위해서 excludeFilters 를 설정한다.
// basePackages 를 통해 검색을 시작할 패키지를 지정할 수 있다.
// 지정하지 않으면 @ComponentScan 이 붙은 클래스의 패키지가 시작 위치가 된다.
@ComponentScan(
        basePackages = "hello.core",
        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
                classes = Configuration.class)
)
public class AutoAppConfig {

}
