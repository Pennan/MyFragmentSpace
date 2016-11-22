package com.np.annotationtest.annotation;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * <B>Des</B>
 *
 * @author ningpan 2016/11/22 14:25
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface InheritedAnnotation1 {
    String value1();
}
