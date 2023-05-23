package br.univille.projfabsoft2023.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoft2023.entity.Usuario;
import br.univille.projfabsoft2023.repository.UsuarioRepository;
import br.univille.projfabsoft2023.service.UsuarioService;

@Service
public class UsuarioServiceImpl 
        implements UsuarioService{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public List<Usuario> getAll() {
        return repository.findAll();
    }
    /*
     * git add .
     * git commit -m "muita coisa"
     * git push
     */

    @Override
    public void save(Usuario usuario) {
        repository.save(usuario);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    
    
}
