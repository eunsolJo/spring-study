package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{

        // 1. 자동주입 대상이 없으면, 수정자 메서드 자체가 호출이 안됨
        @Autowired(required = false)
        public void setNoBean1(Member noBean1){
            System.out.println("noBean1 = " + noBean1);
        }

        // 2. org.springframework.lang.@Nullable : 자동 주입 대상이 없으면 null이 입력된다.
        @Autowired
        public void setNoBean2(@Nullable Member noBean2){
            System.out.println("noBean2 = " + noBean2);
        }

        // 3. Optional<> : 자동주입 대상이 없으면 Optional.empty가 입력된다.
        @Autowired
        public void setNoBean2(Optional<Member> noBean3){
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
