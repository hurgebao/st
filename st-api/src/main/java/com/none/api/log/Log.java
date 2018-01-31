package com.none.api.log;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.*;

/**
 * 类的方法描述注解
 * 
 * @author shi
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Log {

	public String operate() default "";

	public String propertys() default "";

	public String level() default "";
}