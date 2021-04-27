package co.com.sofka.okrs.service;

import co.com.sofka.okrs.repository.RepositoryKr;
import co.com.sofka.okrs.repository.RepositoryOKR;
import co.com.sofka.okrs.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioDashboard {

    @Autowired
    private RepositoryOKR repositoryOKR;

    @Autowired
    private RepositoryKr repositoryKr;

    @Autowired
    private UsuarioRepository usuarioRepository;


}
