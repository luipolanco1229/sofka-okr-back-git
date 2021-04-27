package co.com.sofka.okrs.repository;

import co.com.sofka.okrs.domain.Kr;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RepositoryKr extends ReactiveMongoRepository<Kr, String> {
}
