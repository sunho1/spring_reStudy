package com.example.study.member;

import com.example.study.configuration.AppConfig;
import com.example.study.configuration.AutoAppConfig;
import com.example.study.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class ApplicationContextInfotest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    @DisplayName("모든 빈 출력")
    public void findAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for( String beanDefinitionName : beanDefinitionNames){
            Object bean = ac.getBean(beanDefinitionName);

            System.out.println("name = "+beanDefinitionName + ", object = "+bean);
        }
    }
    
    
    @Test
    @DisplayName("애플리케이션 빈 출력")
    public void findApplicationAllBean(){
        
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for(String beanDefinitionName : beanDefinitionNames ){
            //메타데이터
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            //메타데이터에서 확인할 수 있는것 : 기존에 등록된 것이 아니라, 사용하기 위해서 만든 것이라는 의미 or 외부 라이브러리
            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);

                System.out.println("name = "+beanDefinitionName + ", object = "+bean);
            }
        }
    }


    @Test
    @DisplayName("빈 이름으로 조회 ")
    public void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService : "+memberService);
        System.out.println("memberService.getClass() : "+memberService.getClass());

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 타입으로 조회 ")
    public void findBeanByType(){
        MemberService memberService = ac.getBean( MemberService.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회 ")
    public void findBeanByName2(){
        MemberService memberService = ac.getBean( MemberServiceImpl.class);

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 X")
    public void findBeanByNameX(){
        MemberService memberService = ac.getBean( MemberServiceImpl.class);

        assertThrows(NoSuchBeanDefinitionException.class,
                ()-> ac.getBean("xxxxxx", MemberService.class));

        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("스프링 컨테이너 없는 순수 DI")
    public void pureContainer(){
        AppConfig appConfig = new AppConfig();

        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
    }


    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    public void springContainer(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService",MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴 유지")
    void configurationTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService",MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);


        MemberRepository memberRepository1= memberService.getMemberRepository();
        MemberRepository memberRepository2= orderService.getMemberRepository();
    }

    @Test
    void configurationDeep(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean.getClass() = "+bean.getClass());
    }

    @Test
    void scanTest(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);


    }



}