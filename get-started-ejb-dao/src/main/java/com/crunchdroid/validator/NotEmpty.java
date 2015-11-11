package com.crunchdroid.validator;

import java.lang.annotation.Documented;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.PARAMETER;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author Riad YOUSFI <riad.yousfi@crunchdroid.net>
 */
@Documented
@Constraint(validatedBy = NotEmptyValidator.class)
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
public @interface NotEmpty {

    String message() default "{com.crunchdroid.validator.NotEmpty}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
