package volkanozturk.examples.springbootprojectexample.mapper;

import volkanozturk.examples.springbootprojectexample.dto.Customer;
import volkanozturk.examples.springbootprojectexample.dto.CustomerRef;
import volkanozturk.examples.springbootprojectexample.entity.CustomerEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Objects;

/**
 * Customer Mapper Interface class by using <a href="https://mapstruct.org">MapStruct</a>.
 *
 * @author <a href="https://github.com/volkanozturk">Volkan Ozturk</a>
 * @since 1.0.0
 */
@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.ERROR, unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface CustomerMapper {

  CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

  /**
   * Mapper method in order to map from {@link Customer} to {@link CustomerEntity}.
   *
   * @param customer object that is going to be mapped. Please, see the {@link Customer} class for details.
   * @return Returns CustomerEntity. Please, see the {@link CustomerEntity} class for details.
   *
   * @author <a href="https://github.com/volkanozturk">Volkan Ozturk</a>
   * @since 1.0.0
   */
  @Mappings({
      @Mapping(target = "id", ignore = true)
  })
  CustomerEntity toEntity(Customer customer);

  /**
   * Mapper method in order to map from {@link CustomerEntity} to {@link Customer}.
   *
   * @param customerEntity object that is going to be mapped. Please, see the {@link CustomerEntity} class for details.
   * @return Returns Customer. Please, see the {@link Customer} class for details.
   *
   * @author <a href="https://github.com/volkanozturk">Volkan Ozturk</a>
   * @since 1.0.0
   */
  Customer toDto(CustomerEntity customerEntity);

  /**
   * Mapper method in order to map from list of {@link Customer} to list of {@link CustomerEntity}.
   *
   * @param customerList list that is going to be mapped. Please, see the {@link Customer} class for details.
   * @return Returns List of CustomerEntity. Please, see the {@link CustomerEntity} class for details.
   *
   * @author <a href="https://github.com/volkanozturk">Volkan Ozturk</a>
   * @since 1.0.0
   */
  List<CustomerEntity> toEntityList(List<Customer> customerList);

  /**
   * Mapper method in order to map from list of {@link CustomerEntity} to list of {@link Customer}.
   *
   * @param customerEntityList list that is going to be mapped. Please, see the {@link CustomerEntity} class for details.
   * @return Returns List of Customer. Please, see the {@link Customer} class for details.
   *
   * @author <a href="https://github.com/volkanozturk">Volkan Ozturk</a>
   * @since 1.0.0
   */
  List<Customer> toDtoList(List<CustomerEntity> customerEntityList);

  /**
   * Mapper method in order to map from {@link CustomerEntity} to {@link CustomerRef}.
   * This method uses a bean mapping in order to ignore specified fields mappings. For this case, customerType & fullName fields in CustomerEntity are ignored in the mapping implementation.
   *
   * @param customerEntity object that is going to be mapped. Please, see the {@link CustomerEntity} class for details.
   * @return Returns CustomerRef. Please, see the {@link CustomerRef} class for details.
   *
   * @author <a href="https://github.com/volkanozturk">Volkan Ozturk</a>
   * @since 1.0.0
   */
  @BeanMapping(ignoreUnmappedSourceProperties = {"customerType", "fullName"})
  CustomerRef toDtoRef(CustomerEntity customerEntity);

  /**
   * Mapper method in order to map from list of {@link CustomerEntity} to list of {@link CustomerRef}.
   *
   * @param customerEntityList list that is going to be mapped. Please, see the {@link CustomerEntity} class for details.
   * @return Returns List of Customerref. Please, see the {@link CustomerRef} class for details.
   *
   * @author <a href="https://github.com/volkanozturk">Volkan Ozturk</a>
   * @since 1.0.0
   */
  List<CustomerRef> toDtoRefList(List<CustomerEntity> customerEntityList);

  /**
   * Method to be used for setting the CustomerEntity from Customer object if it exists.
   * This method calls after mapping all fields within {@link CustomerMapper#toEntity(Customer)}.
   *
   * @param customer object
   * @param customerEntity is used for mapping target.
   *
   * @author <a href="https://github.com/volkanozturk">Volkan Ozturk</a>
   * @since 1.0.0
   */
  @AfterMapping
  default void setEntityId(Customer customer, @MappingTarget CustomerEntity customerEntity) {
    if(Objects.nonNull(customer.getId()))
      customerEntity.setId(customer.getId());
  }
}
