Spring을 이루는 핵심 요소
======
## IoC 컨테이너
### IoC 컨테이너(Inversion of Control Container)?
먼저, IoC가 무엇인가?에 대하여 알 필요가 있는데, 직역하자면 '제어 반전'으로, 사용자가 외부의 라이브러리를 호출해 이용하는 기존의 방식이 아닌 **외부의 라이브러리가 프로그래머가 작성한 코드를 호출해 사용**하는것을 말한다. 말 그대로 제어 방식이 반전된 것. 
스프링에서는 스프링 프레임워크가 **빈(Bean)** 을 만들 때 작성한 개체의 생성자 인수, 팩토리 메소드의 인수, 팩토리 메소드에 생성되거나 반환된 후 개체 인스턴스의 설정된 속성을 통해서만 종속성을 정의하게 되는데, 이것을 **의존성 주입(Dependency Injection)** 이라고 한다.

`org.springframework.beans` 및 `org.springframework.context`는 스프링 프레임워크의 기본적인 IoC 컨테이너 구성요소이다.<br>
[BeanFactory](https://docs.spring.io/spring-framework/docs/5.3.13/javadoc-api/org/springframework/beans/factory/BeanFactory.html) 인터페이스는 모든 유형의 개체를 관리할 수 있는 고급 구성 메커니즘을 제공한다.<br>
[ApplicationContext](https://docs.spring.io/spring-framework/docs/5.3.13/javadoc-api/org/springframework/context/ApplicationContext.html)는 `BeanFactory` 인터페이스의 하위 인터페이스로, 추가적으로

- 스프링의 AOP 기능과의 더욱 쉬운 통합
- 메세지 자원 처리(국제화에서 사용)
- 이벤트 게시
- 웹 어플리케이션에서 사용하기 위한 `WebApplicationContext`와 같은 응용 계층 컨텍스트

를 제공한다.<br>
요약하자면, `BeanFactory`는 구성 프레임워크와 기본적인 기능을 제공하고, `ApplicationContext`는 엔터프라이즈 기능이 추가되어 있다. `ApplicationContext`는 `BeanFactory`의 완전한 상위 집합(superset)에 해당한다. `ApplicationContext` 대신 `BeanFactory`를 사용하는 방법에 대한 내용은 [BeanFactory](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#beans-beanfactory)를 참조하면 된다.

### 컨테이너(Container)?
`org.springframework.context.ApplicationContext` 인터페이스는 Spring IoC Container를 나타내며 Bean을 인스턴스화, 구성 및 조립하는 역할을 한다.<br>
컨테이너는 구성 메타데이터를 읽어와 객체에 대한 인스턴스화, 구성 및 조립에 대한 지침을 받습니다.<br>
구성 메타데이터는 XML, JAVA annotations, 또는 Java code로 표시됩니다. 이는 응용프로그램을 구성하는 객체간의 풍부한 상호종속성을 표현할 수 있습니다.<br>

`ApplicationContext` 인터페이스의 여러 구현 방식은 스프링과 함께 제공됩니다. stand-alone 응용 프로그램에서는 일반적으로 [ClassPathXmlApplicationContext](https://docs.spring.io/spring-framework/docs/5.3.13/javadoc-api/org/springframework/context/support/ClassPathXmlApplicationContext.html) 또는 [FIleSystemXmlApplicationContext](https://docs.spring.io/spring-framework/docs/5.3.13/javadoc-api/org/springframework/context/support/FileSystemXmlApplicationContext.html)를 생성합니다.<br>
XML은 구성 메타데이터를 정의하는 것이 일반적이었으나, Java annotaions 또는 Java code를 이용해 선언적으로 활성화 할 수 있는 소량의 XML 구성을 제공하고 있기 떄문에, Java annotaions나 code를 이용해 컨테이너에게 지시할 수 있습니다.<br>

대부분의 애플리케이션 시나리오에서 하나 이상의 Spring IoC 컨테이너 인스턴스를 인스턴스화하는 데 명시적 사용자 코드가 필요하지 않습니다. 예를 들어, 웹 애플리케이션 시나리오에서 애플리케이션의 `web.xml` 파일에 있는 상용어 웹 설명자 XML의 간단한 8줄이면 충분합니다([편리한 웹 애플리케이션에서의 ApplicationContext 인스턴스화](https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#context-create)).<br>
[Spring Tools for Eclipse](https://spring.io/tools)(이클립스 지원 개발 환경)를 사용할 경우 마우스 클릭 몇 번 또는 키 입력만으로 이 상용구 구성을 쉽게 만들 수 있습니다.<br>

다음 다이어그램은 스프링 작동 방식을 개괄적으로 보여줍니다. 응용 프로그램 클래스는 구성 메타데이터와 결합되므로 `ApplicationContext`가 생성되고 초기화되면 완전히 구성되고 실행 가능한 시스템 또는 응용 프로그램을 갖게 됩니다.
![Figure 1. The Spring IoC Container](https://docs.spring.io/spring-framework/docs/current/reference/html/images/container-magic.png)<br>
**그림 1. 스프링 IoC 컨테이너**
