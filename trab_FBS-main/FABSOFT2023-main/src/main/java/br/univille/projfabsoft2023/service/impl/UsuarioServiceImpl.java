package br.univille.projfabsoft2023.service.impl;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.projfabsoft2023.entity.Usuario;
import br.univille.projfabsoft2023.repository.UsuarioRepository;
import br.univille.projfabsoft2023.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public List<Usuario> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Usuario usuario) {
        // gera um número aleatório entre 10000000 e 99999999
        long randomNum = ThreadLocalRandom.current().nextLong(10000000L, 100000000L);
        usuario.setIdUsuario(randomNum);
        repository.save(usuario);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
