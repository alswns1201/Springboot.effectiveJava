package com.java.effective.study.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> {// Post클래스로 Database를 접근하게 해줄 Repository



}
