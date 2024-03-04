package bibliotecavainaweb.src.models;

import bibliotecavainaweb.src.interfaces.Aluguel;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca implements Aluguel {
    List<Livros> livros;
    List<Usuario> usuarios;


    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public Biblioteca(List<Livros> livros, List<Usuario> usuarios) {
        this.livros = livros != null ? livros : new ArrayList<>();
        this.usuarios = usuarios != null ? usuarios : new ArrayList<>();
    }

    public List<Livros> getLivros() {
        return livros;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void adicionarLivro(Livros livro) {
        livros.add(livro);
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }


    public void removerLivro(Livros livro) {
        livros.remove(livro);
    }

    public void removerUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public void alugarLivro(Livros livro, Usuario usuario) {
        if (livro.isDisponivel()) {
            alugarLivro(livro, usuario);
        }
        livro.setDisponivel(false);
    }

    public void devolverLivro(Livros livro, Usuario usuario) {
        if (!livro.isDisponivel()) {
            devolverLivro(livro, usuario);
        }
        livro.setDisponivel(true);
    }


    public void adicionarUsuarioABiblioteca(List<Usuario> usuario) {
        usuarios.addAll(usuario);
    }

    @Override
    public boolean usuarioJaCadastrado(Usuario usuario) {
        for (Usuario u : usuarios) {
            if (u.getNome().equals(usuario.getNome()) && u.getSenha().equals(usuario.getSenha())) {
                System.out.println("Usuário já cadastrado");
                return true;
            } else {
                System.out.println("Usuário não cadastrado");
                return false;
            }
        }
        return false;
    }


    public String toString() {
        return "Livros: " + livros + "\n" + "Usuários: " + usuarios;
    }

    
}
