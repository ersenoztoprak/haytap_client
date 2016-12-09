package com.haytap.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Controller
@Scope("session")
public @interface SessionScoped
{

}
