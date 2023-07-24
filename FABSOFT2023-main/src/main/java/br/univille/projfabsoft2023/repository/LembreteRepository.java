package br.univille.projfabsoft2023.repository;

import br.univille.projfabsoft2023.entity.Lembrete;
import br.univille.projfabsoft2023.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LembreteRepository extends CrudRepository<Lembrete, Long> {
    List<Lembrete> findByUsuarioNome(String nome);

    List<Lembrete> findByUsuario(Usuario usuario);
}
