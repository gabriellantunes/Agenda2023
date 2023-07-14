package br.univille.projfabsoft2023.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Usuario {
    @Column(length = 600)
    private String nome;
    
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    @Column(length = 1000)
    private String endereco;
    private String telefone;
    private String email;

    @Column(length = 100)
    private String senha;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long idUsuario;  // Nova propriedade

    //getters e setters
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {

        return endereco;
    }
    public void setEndereco(String endereco) {

        this.endereco = endereco;
    }
    public String getTelefone() {

        return telefone;
    }
    public void setTelefone(String telefone) {

        this.telefone = telefone;
    }
    public String getEmail() {

        return email;
    }
    public void setEmail(String email) {

        this.email = email;
    }

    public String getNome() {

        return nome;
    }
    public void setNome(String nome) {

        this.nome = nome;
    }
    public Date getDataNascimento() {

        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {

        this.dataNascimento = dataNascimento;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
