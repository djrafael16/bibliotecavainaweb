package bibliotecavainaweb.src.models;

public class Livros {

    String nome;
    String genero;
    String autor;
    int paginas;
    int ano;
    boolean disponivel;

    public Livros() {

    }

    public Livros(String nome, String genero, String autor, int paginas, int ano) {
        this.nome = nome;
        this.genero = genero;
        this.autor = autor;
        this.paginas = paginas;
        this.ano = ano;
        this.disponivel = true;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public String getAutor() {
        return autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public int getAno() {
        return ano;
    }


    public String toString() {
        return " Nome: " + nome + "\n"
                + " Genero: " + genero +
                "\n" + " Autor: " + autor +
                "\n" + " Ano: " + ano +
                "\n" + " Paginas: " + paginas;
    }
}
