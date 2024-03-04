package bibliotecavainaweb.src.models;

import java.util.List;

public class Usuario {

    String nome;
    String email;
    String senha;
    List<Livros> livrosAlugados;

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void adicionarLivroAlugado(Livros livro) {
        livrosAlugados.add(livro);
    }

    public void removerLivroAlugado(Livros livro) {
        livrosAlugados.remove(livro);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void usuarioJaCadastrado(String nome, String senha) {
        if (getNome().equals(nome) && getSenha().equals(senha)) {
            System.out.println("Usuário já cadastrado");
        } else {
            System.out.println("Usuário não cadastrado");
        }
    }

    public String toString() {
        return " Nome: " + nome + "\n"
                + " Email: " + email + "\n"
                + " Senha: " + senha + "\n";
    }
}
