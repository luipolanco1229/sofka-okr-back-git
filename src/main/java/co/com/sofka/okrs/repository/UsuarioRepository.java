package co.com.sofka.okrs.repository;

import co.com.sofka.okrs.domain.Usuario;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UsuarioRepository extends ReactiveMongoRepository<Usuario, String> {
}
