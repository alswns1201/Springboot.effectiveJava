package com.java.effective.study.config.auth;

import com.java.effective.study.config.auth.dto.OAuthAttributes;
import com.java.effective.study.config.auth.dto.SessionUser;
import com.java.effective.study.domain.user.User;
import com.java.effective.study.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final UserRepository userRepository;
    private final HttpSession httpSession;



    @Override   //OAuth2UserRequest 에 acceess token이 담기고, acccess token을 얻고 나서의 메소드.
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService delegate = new DefaultOAuth2UserService(); //OAuth2UserService(인터페이스)를 구현한 클래스
        //DefaultOAuth2UserService는 OAuth2UserService의 구현체 : userRequest 정보를 가지고 올 수 있다.
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registationId =userRequest.getClientRegistration().getRegistrationId(); // 서비스를 구분하는 코드 id

        String userNameAttributeName  = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        //데이터 관리인 dto 에서 구현한 of 로 객체 생성.
        // 0f로 생성하는 이유는 of안에서 여러 type의 객체로 변환해서 사용하기 위함.
        OAuthAttributes attributes = OAuthAttributes.of(registationId,userNameAttributeName,oAuth2User.getAttributes());


        User user = Duplicate(attributes);
        httpSession.setAttribute("user", new SessionUser(user)); // SessionUser dto : 세션정보에 대한 관리 클래스




        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey()
                );
    }

    private User Duplicate(OAuthAttributes attributes){
        User user = userRepository.findAllByEmail(attributes.getEmail())    // eamil로 해당 데이터를 확인후
                .map(entity -> entity.update(attributes.getName(),attributes.getPicture())) // update 진행
                .orElse(attributes.toEntity()); // 없으면 Entity 생성.

        return userRepository.save(user);
    }


}