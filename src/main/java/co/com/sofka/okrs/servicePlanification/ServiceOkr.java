package co.com.sofka.okrs.servicePlanification;

import co.com.sofka.okrs.domainPlanification.Okr;
import co.com.sofka.okrs.repositoryPlanification.RepositoryOkr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServiceOkr implements IServiceOkr{
    @Autowired
    private RepositoryOkr repositoryOKr;


    @Override
    public Flux<Okr> findAll() {
        return repositoryOKr.findAll();
    }

    @Override
    public Mono<Okr> save(Okr okr) {
        return repositoryOKr.save(okr);
    }

    @Override
    public Mono<Okr> update(Okr okr) {
        repositoryOKr.findAll().filter(x -> x.getId() == okr.getId());{
            repositoryOKr.deleteById(okr.getId());
        }
        return repositoryOKr.save(okr);
    }

    @Override
    public Mono<Void> delete(String id) {
        return repositoryOKr.deleteById(id);
    }
}
