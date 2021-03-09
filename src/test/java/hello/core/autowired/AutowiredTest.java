package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);

    }
    static class TestBean{

        // 스프링 컨테이너에서 관리하는 것이 없다. (required = true)면 오류 발생
        // 멤버가 스프링 빈으로 등록되어있는 것이 아니므로 오류가 발생한다.
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            // 아예 이 함수가 호출되지 않는다.
            System.out.println("noBean1 = " + noBean1);
        }

        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            // 호출은 되는데, null 이 들어가 있다.
            System.out.println("noBean1 = " + noBean2);
        }

        @Autowired
        public void setNoBean3(Optional<Member> noBean3){
            // 호출은 되는데, Optional 감싸져서 처리가 된다.
            System.out.println("noBean1 = " + noBean3);
        }

    }
}
