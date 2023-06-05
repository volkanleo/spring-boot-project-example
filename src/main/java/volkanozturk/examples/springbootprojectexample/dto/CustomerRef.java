package volkanozturk.examples.springbootprojectexample.dto;

import volkanozturk.examples.springbootprojectexample.dto.shared.AbstractGenericDtoType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Customer Reference Class.
 * Its SuperClass can be reached from {@link AbstractGenericDtoType} class.
 *
 * @author <a href="https://github.com/volkanozturk">Volkan Ozturk</a>
 * @since 1.0.0
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = true)
public class CustomerRef extends AbstractGenericDtoType {
}
