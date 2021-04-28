package co.com.sofka.okrs.repositoryPlanification;

import co.com.sofka.okrs.domainPlanification.Kr;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryKr extends ReactiveMongoRepository<Kr, String> {
}
