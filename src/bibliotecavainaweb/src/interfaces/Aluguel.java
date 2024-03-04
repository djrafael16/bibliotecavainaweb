package bibliotecavainaweb.src.interfaces;

import bibliotecavainaweb.src.models.Livros;
import bibliotecavainaweb.src.models.Usuario;

public interface Aluguel {
    void alugarLivro(Livros livro, Usuario usuario);
    void devolverLivro(Livros livro, Usuario usuario);
    boolean usuarioJaCadastrado(Usuario usuario);
}
