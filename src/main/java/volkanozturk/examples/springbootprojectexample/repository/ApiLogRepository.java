package volkanozturk.examples.springbootprojectexample.repository;

import volkanozturk.examples.springbootprojectexample.entity.ApiLogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApiLogRepository extends MongoRepository<ApiLogEntity, String> {
}
