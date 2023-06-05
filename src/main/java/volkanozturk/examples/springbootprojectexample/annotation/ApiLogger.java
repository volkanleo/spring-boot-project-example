package volkanozturk.examples.springbootprojectexample.annotation;

import java.lang.annotation.*;

/**
 * ApiLogger Annotation Interface Implementation.
 * This annotation can be used in order to log API details on controller level.
 *
 * @author <a href="https://github.com/volkanozturk">Volkan Ozturk</a>
 * @since 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiLogger {
}
