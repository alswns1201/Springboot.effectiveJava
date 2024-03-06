package com.java.effective.study.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findAllByEmail(String email); // 이메일 값을 통해서 이미 가입된 사용자인지 확인.

}
