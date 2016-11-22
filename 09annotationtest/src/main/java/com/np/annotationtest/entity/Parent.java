package com.np.annotationtest.entity;

import com.np.annotationtest.annotation.InheritedAnnotation1;
import com.np.annotationtest.annotation.InheritedAnnotation2;

/**
 * <B>Des</B>
 *
 * @author ningpan 2016/11/22 14:28
 */
@InheritedAnnotation1(value1 = "使用 Inherited 注解的 class")
@InheritedAnnotation2(value2 = "未使用 Inherited 注解的 class")
public class Parent {

    @InheritedAnnotation1(value1 = "使用 Inherited 注解的 method1")
    @InheritedAnnotation2(value2 = "未使用 Inherited 注解的 method1")
    public void method1() {
    }

    @InheritedAnnotation1(value1 = "使用 Inherited 注解的 method2")
    @InheritedAnnotation2(value2 = "未使用 Inherited 注解的 method2")
    public void method2() {
    }

    @InheritedAnnotation1(value1 = "使用 Inherited 注解的 value")
    @InheritedAnnotation2(value2 = "未使用 Inherited 注解的 value")
    public String value;
}
