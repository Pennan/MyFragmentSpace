package com.np.daggerdemo;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * <B>Des</B>
 *
 * @author ningpan 2016/11/21 16:07
 */
@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Level {
    String value() default "";
}
