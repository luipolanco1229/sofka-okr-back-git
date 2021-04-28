package co.com.sofka.okrs.repository;

import co.com.sofka.okrs.domain.Okr;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface RepositoryOkr extends ReactiveMongoRepository<Okr, String>  {

    Flux<Okr> findByUsuarioIdOrderByAvanceOkrDesc(String responsable);
}
