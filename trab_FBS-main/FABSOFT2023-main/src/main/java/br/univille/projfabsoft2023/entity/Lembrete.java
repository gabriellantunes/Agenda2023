package br.univille.projfabsoft2023.entity;

import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Entity
public class Lembrete {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String descricao;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date dataHora;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    // Getters e setters...
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
