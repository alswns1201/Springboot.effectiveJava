package com.java.effective.study.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) // 파라미터에서 어노테이션 사용 가능
@Retention(RetentionPolicy.RUNTIME) // 런타임시 접근 가능
public @interface LoginUser {
}
