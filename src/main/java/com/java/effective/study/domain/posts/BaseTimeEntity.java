package com.java.effective.study.domain.posts;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   //해당 클래스를 상속할 경우 필드값도 칼럼으로  인식.
@EntityListeners(AuditingEntityListener.class)// 해당 클래스에 Auditing 기능 장착.
public abstract class BaseTimeEntity {

    @CreatedDate        // 저장 될떄 자동으로 반영.
    private LocalDateTime createDate;

    @LastModifiedDate   // 수정 될떄 자동으로 반영.
    private LocalDateTime modifiedDate;


}
