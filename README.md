# Springboot
- 스프링부트와 AWS로 혼자 구현하는 웹 서비스 책 참고. 

# Chapter 
- 2장  HelloController, web/dto/ :  HelloResponseDto  
- 3장   domain/Posts  :  Posts,PostsRepository, BaseTimeEntity   
       service/posts/ :   PostsService 
       web/dto/ : PostsSaveRequestDto    
       web/ : PostsApiController  
- 4장  src/main/resource/templates index.mustache, 
  - web/ : indexController
- 5장 Spring Security
  - config/auth/dto/ : CustomOAuth2UserService, @LoginUser, LoginUserArgmentResolver, SecurityConfig
  - config/auth/ : WebConfig
      

# 구성 
- domain/ ~ : @Entity 구성 , @Entity에 대한 Repository 구성 
- service/ ~  : Service 구현  
- web/dto/ ~: Entity에 대한 dto (requestDto,resposseDto) 
- web/ ~ :  Controller 구성  
- config/auth/dto ~ : OAuthService 구성 , @interface User 구성 , Resolver 구성 , SercurityConfig 구성
- config/auth/WebConfig.java : WebmvcConfig 구성(resolver 적용)




* * 부록 
# 어노테이션
- @SpringBootAplication : 내장 was 
- @RestController : [@Controller에 @ResponseBody] 가 추가   Json 형태로 객체 데이터를 반환 
- @RunWith  : Junit5부터는 @ExtendWith(SpringExtension.class) 으로 사용 or 생략 가능. 
- @WebMvcTest : mvc모델에 집중할수 있는 test용으로 @Controller, @ControllerAdvice 를 사용 가능 
  - service, repository,  component는 사용 불가  
- @RequiredArgsConstructor : 모든 final 필드에 대해서 생성자를 만들어준다. 

- @Entity : 테이블과 매칭 
  - Entity 클래스와 repository를 동일경로에 위치시키면 @Repository를 사용할 필요가 없음 
- @Builder : 빌더 패턴을 사용, 생성자에 선언시 생성자에 포함된 부분만 빌더로 사용 가능.(어떤값을 채워야하는지 명확해짐.) 

- @Autowired : 권장하진 않는다.
  - 서비스에서 @RequiredArgsConstructor를 하게 되면(생성자로 Bean 객체를 받도록 하면) @Autowired의 효과를 본다. 
  - 참고 : web/ PostsApiController

- @EntityListeners(AuditingEntityListener.class)
  - 클래스 를 만들고 해당 클래스를 JPA Auditing으로 적용 (JPA에서는 Audit이라는 기능을 제공하고 있습니다. Audit은 감시하다, 감사하다라는 뜻으로 Spring Data JPA에서 시간에 대해서 자동으로 값을 넣어주는 기능입니다) 
- @MappedSuperclass 
  - Auditing을 상속 받을경우 Enitiy에ㅓㅅ auditing값도 column으로 인지하도록 설정.
- @EnableJpaAuditing 
    Auditing 활성화 

  

# ORM 
-  Spring Data JPA -> Hibernate -> JPA
- extends JpaRepository<엔터티 클래스,id 값 반환형>
- repository.save : id 값 존재 하면 update 아니면 save
- repository.findAll : 모든 값 찾기.


# API 구조  - 도메인 모델 (보통 사용하는 트랜젝션 스크립트 도메인이 아닌!)
- Request 데이터를 받을 Dto 
- API 요청을 받을 Controller
- 트랜젝션 도메인 기능간의 순서를 보장하는 Service
- 서비스는 트렌젝션 도메인 간 순서만 보장의 역할이지 로직을 처리하는 것이 아니다.

# 더티체킹 
- Entity의 값만 변경하면  트랜잭션이 끝나는 시점에 해당 테이블에 반영 분을 반영 
- JPA의 영속성 컨텍스트 

# 생성 수정 시간 JPA Auditing 


# Spring Security OAuth2
1) dependency
- implementation 'org.springframework.boot:spring-boot-starter-security'
- implementation 'org.springframework.boot:spring-boot-starter-oauth2-client'

2) Config 구성
- SecurityFilterChain
- antMatchers
- @EnableWebSecurity

3) OAuth2 서비스 구현
- OAuth2UserService<OAuth2UserRequest, OAuth2User> 상속
- OAuth2UserRequest.getClientRegistration().getRegistrationId() : 구글/네이버 서비스 구분 코드

4) OAuthAttributes 구현체 Entity

5) @Interface를 이용한 SessionUser 적용 하여,
-  httpSession.getAttribute("user")의 중복된 코드 처리.
-  HandlerMethodArgumentResolver : 파라미터에 대한 변환/바인딩 
  - 인터셉터 이후에 진행된다. 
  - supportsParameter() , resolveArgument() 존재

6) WebMvcConfigurer에서 만들어둔 Resolver를 등록. 
- 스프링에서 사용되는 설정
- addArgumentResolvers
