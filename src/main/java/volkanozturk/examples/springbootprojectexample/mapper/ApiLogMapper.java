package volkanozturk.examples.springbootprojectexample.mapper;

import volkanozturk.examples.springbootprojectexample.dto.ApiLog;
import volkanozturk.examples.springbootprojectexample.entity.ApiLogEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Objects;

/**
 * ApiLog Mapper Interface class by using <a href="https://mapstruct.org">MapStruct</a>.
 *
 * @author <a href="https://github.com/volkanozturk">Volkan Ozturk</a>
 * @since 1.0.0
 */
@Mapper(
    componentModel = "spring",
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.ERROR, unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface ApiLogMapper {

  ApiLogMapper INSTANCE = Mappers.getMapper(ApiLogMapper.class);

  /**
   * Mapper method in order to map from {@link ApiLog} to {@link ApiLogEntity}.
   *
   * @param apiLog object that is going to be mapped. Please, see the {@link ApiLog} class for details.
   * @return Returns ApiLogEntity. Please, see the {@link ApiLogEntity} class for details.
   *
   * @author <a href="https://github.com/volkanozturk">Volkan Ozturk</a>
   * @since 1.0.0
   */
  @Mappings({
      @Mapping(target = "id", ignore = true)
  })
  ApiLogEntity toEntity(ApiLog apiLog);

  /**
   * Mapper method in order to map from {@link ApiLogEntity} to {@link ApiLog}.
   *
   * @param apiLogEntity object that is going to be mapped. Please, see the {@link ApiLogEntity} class for details.
   * @return Returns ApiLog. Please, see the {@link ApiLog} class for details.
   *
   * @author <a href="https://github.com/volkanozturk">Volkan Ozturk</a>
   * @since 1.0.0
   */
  ApiLog toDto(ApiLogEntity apiLogEntity);

  /**
   * Mapper method in order to map from list of {@link ApiLog} to list of {@link ApiLogEntity}.
   *
   * @param apiLogList list that is going to be mapped. Please, see the {@link ApiLog} class for details.
   * @return Returns List of ApiLogEntity. Please, see the {@link ApiLogEntity} class for details.
   *
   * @author <a href="https://github.com/volkanozturk">Volkan Ozturk</a>
   * @since 1.0.0
   */
  List<ApiLogEntity> toEntityList(List<ApiLog> apiLogList);

  /**
   * Mapper method in order to map from list of {@link ApiLogEntity} to list of {@link ApiLog}.
   *
   * @param apiLogEntityList list that is going to be mapped. Please, see the {@link ApiLogEntity} class for details.
   * @return Returns List of ApiLog. Please, see the {@link ApiLog} class for details.
   *
   * @author <a href="https://github.com/volkanozturk">Volkan Ozturk</a>
   * @since 1.0.0
   */
  List<ApiLog> toDtoList(List<ApiLogEntity> apiLogEntityList);

  /**
   * Method to be used for setting the ApiLogEntity from ApiLog object if it exists.
   * This method calls after mapping all fields within {@link ApiLogMapper#toEntity(ApiLog)}.
   *
   * @param apiLog object
   * @param apiLogEntity is used for mapping target.
   *
   * @author <a href="https://github.com/volkanozturk">Volkan Ozturk</a>
   * @since 1.0.0
   */
  @AfterMapping
  default void setEntityId(ApiLog apiLog, @MappingTarget ApiLogEntity apiLogEntity) {
    if(Objects.nonNull(apiLog.getId()))
      apiLogEntity.setId(apiLog.getId());
  }
}
