package hello.core.lifescycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {

        @Bean(initMethod = "init", destroyMethod = "close")
        // destroyMethod = "close"를 사용하지 않으면 추론 기능으로 종료 메서드를 추론해서 호출
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.steUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
