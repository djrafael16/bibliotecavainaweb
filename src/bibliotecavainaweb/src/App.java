package bibliotecavainaweb.src;

import bibliotecavainaweb.src.models.Biblioteca;
import bibliotecavainaweb.src.models.Livros;
import bibliotecavainaweb.src.models.Usuario;
import java.util.Scanner;

public class App {
    private static Usuario usuarioLogado;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        biblioteca.adicionarLivro(new Livros("O Senhor dos Anéis", "Fantasia", "J.R.R. Tolkien", 1000, 1954));
        biblioteca.adicionarLivro(new Livros("Dom Quixote", "Romance", "Miguel de Cervantes", 800, 1605));
        biblioteca.adicionarLivro(new Livros("Harry Potter e a Pedra Filosofal", "Fantasia", "J.K. Rowling", 400, 1997));

        Usuario usuarioLogado = null;
        boolean continuar = true;

        while (continuar) {
            System.out.println("Bem vindo a biblioteca Vai na Web");
            System.out.println("Selecione uma das opções abaixo:");

            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Listar Livros");
            System.out.println("3 - Alugar Livro");
            System.out.println("4 - Devolver Livro");
            System.out.println("5 - Realizar Cadastro");
            System.out.println("6 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    if (usuarioLogado == null) {
                        System.out.println("Você precisa realizar o login ou cadastro antes de cadastrar livros!");
                        realizarCadastro(biblioteca);
                    } else {
                        cadastrarLivro(biblioteca);
                    }
                    break;
                case 2:
                    listarLivros(biblioteca);
                    break;
                case 3:
                    alugarLivro(biblioteca);
                    break;
                case 4:
                    devolverLivro(biblioteca);
                    break;
                case 5:
                    realizarCadastro(biblioteca);
                    break;
                case 6:
                    continuar = false;
                    System.out.println("Obrigado por utilizar a biblioteca Vai na Web");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    private static void alugarLivro(Biblioteca biblioteca) {
    }

    private static void devolverLivro(Biblioteca biblioteca) {
    }

    private static void cadastrarLivro(Biblioteca biblioteca) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\nCadastrar Livro");
        System.out.println("---------------------");

        System.out.println("Digite o nome do livro");
        String nome = scanner.nextLine();

        System.out.println("Digite o gênero do livro");
        String genero = scanner.nextLine();

        System.out.println("Digite o autor do livro");
        String autor = scanner.nextLine();

        System.out.println("Digite o número de páginas do livro");
        int paginas = scanner.nextInt();

        System.out.println("Digite o ano do livro");
        int ano = scanner.nextInt();

        Livros livro = new Livros(nome, genero, autor, paginas, ano);

        biblioteca.adicionarLivro(livro);

        System.out.println("Livro cadastrado com sucesso!");
    }

    private static void listarLivros(Biblioteca biblioteca) {
        System.out.println("\nListar Livros");

        if (biblioteca.getLivros().isEmpty()) {
            System.out.println("Não existem livros cadastrados");
        } else {
            for (Livros livro : biblioteca.getLivros()) {
                System.out.println(livro);
                System.out.println("---------------------");
            }
        }
    }

    private static void realizarCadastro(Biblioteca biblioteca) {
        Scanner scanner = new Scanner(System.in);

        if (usuarioLogado == null) {
            System.out.println("Você ainda não está logado. Por favor, realize o cadastro.");
            System.out.println("Digite o nome do usuário");
            String nome = scanner.nextLine();

            System.out.println("Digite o email do usuário");
            String email = scanner.nextLine();

            System.out.println("Digite a senha do usuário");
            String senha = scanner.nextLine();

            Usuario usuario = new Usuario(nome, email, senha);

            if (biblioteca.usuarioJaCadastrado(usuario)) {
                System.out.println("Usuário já cadastrado!");
            } else {
                biblioteca.adicionarUsuario(usuario);
                System.out.println("Usuário cadastrado com sucesso!");
                usuarioLogado = usuario;
            }
        } else {
            System.out.println("Você já está logado como " + usuarioLogado.getNome() + "\n");

            cadastrarUmLivro(biblioteca);
        }
    }

    private static void cadastrarUmLivro(Biblioteca biblioteca) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Usuário já cadastrado? \n 1 - Sim \n 2 - Não");
        int opcao = scanner.nextInt();

        try {
            if (opcao == 1 || opcao == 2) {
                if (opcao == 1) {
                    if (VerificarSeUsuarioEstaCadastrado()) {
                        System.out.println("\nUsuário não cadastrado. Retornando ao menu principal.");
                    }
                } else {
                    System.out.println("Realize o cadastro");
                    realizarCadastro();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n\nCadastrar Livro");
        System.out.println("---------------------");

        System.out.println("Digite o nome do livro");
        String nome = scanner.nextLine();

        System.out.println("Digite o gênero do livro");
        String genero = scanner.nextLine();

        System.out.println("Digite o autor do livro");
        String autor = scanner.nextLine();

        System.out.println("Digite o número de páginas do livro");
        int paginas = scanner.nextInt();

        System.out.println("Digite o ano do livro");
        int ano = scanner.nextInt();
        Livros livro = new Livros(nome, genero, autor, paginas, ano);
        biblioteca.adicionarLivro(livro);

    }

    private static void realizarCadastro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do usuário");
        String nome = scanner.nextLine();
        System.out.println("Digite o email do usuário");
        String email = scanner.nextLine();
        System.out.println("Digite a senha do usuário");
        String senha = scanner.nextLine();
        Usuario usuario = new Usuario(nome, email, senha);

        try {
            usuario.usuarioJaCadastrado(nome, senha);
        } catch (Exception e) {
            System.out.println("Erro ao realizar cadastro");
        }
    }

    private static boolean VerificarSeUsuarioEstaCadastrado() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do usuário");
        String nome = scanner.nextLine();
        System.out.println("Digite a senha do usuário");
        String senha = scanner.nextLine();

        Usuario usuario = new Usuario();
        try {
            usuario.usuarioJaCadastrado(nome, senha);
            return true;
        } catch (Exception e) {
            System.out.println("Erro ao verificar se usuário está cadastrado");
            return false;
        }
    }
}
