package biblioteca;

import biblioteca.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Livros> livros = new ArrayList<>();
    static ArrayList<Clientes> clientes = new ArrayList<>();
    static ArrayList<Bibliotecarios> bibliotecarios = new ArrayList<>();
    static ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    static int logado = -1;

    static String senhaAdmin = "Admin123";

    public static int gerarCodigo() {

        int codigo;
        boolean existe;

        do {

            codigo = (int) (Math.random() * 900000) + 100000;
            existe = false;

            for (Clientes c : clientes) {

                if (c.getCodigoDoCliente() == codigo) {
                    existe = true;
                    break;
                }

            }

        } while (existe);

        return codigo;
    }

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        int opcao;

        do {

            String nomeLogado = "Nenhum";
            int codigoLogado = 000000;

            if (logado >= 0) {
                nomeLogado = bibliotecarios.get(logado).getNomeDoBibliotecario();
                codigoLogado = bibliotecarios.get(logado).getCodigoDoBibliotecario();
            }

            System.out.println("\n===== SISTEMA BIBLIOTECA =====");
            System.out.println("Bibliotecario Logado: " + nomeLogado + " Codigo: " + codigoLogado);
            System.out.println("1 Login Bibliotecario");
            System.out.println("2 Cadastrar Bibliotecario");
            System.out.println("3 Cadastrar Livro");
            System.out.println("4 Cadastrar Cliente");
            System.out.println("5 Realizar Emprestimo");
            System.out.println("6 Listar Clientes");
            System.out.println("0 Sair");

            opcao = leitor.nextInt();

            switch (opcao) {

                case 1:
                    loginBibliotecario(leitor);
                    break;

                case 2:
                    cadastrarBibliotecario(leitor);
                    break;

                case 3:
                    cadastrarLivro(leitor);
                    break;

                case 4:
                    cadastrarCliente(leitor);
                    break;

                case 5:
                    realizarEmprestimo(leitor);
                    break;

                case 6:
                    listarClientes();
                    break;
            }

        } while (opcao != 0);

    }

    public static void loginBibliotecario(Scanner leitor) {

        System.out.println("Nome:");
        String nome = leitor.next();

        System.out.println("Senha:");
        String senha = leitor.next();

        for (int i = 0; i < bibliotecarios.size(); i++) {

            if (bibliotecarios.get(i).getNomeDoBibliotecario().equals(nome) &&
                    bibliotecarios.get(i).getSenhaDoBlibliotecario().equals(senha)) {

                logado = i;

                System.out.println("Login realizado com sucesso");
                System.out.println("Bem vindo " + bibliotecarios.get(i).getNomeDoBibliotecario());

                return;
            }
        }

        System.out.println("Login incorreto");
    }

    public static void cadastrarBibliotecario(Scanner leitor) {

        System.out.println("Senha admin:");
        String senha = leitor.next();

        if (!senha.equals(senhaAdmin)) {
            System.out.println("Senha incorreta");
            return;
        }

        Bibliotecarios novo = new Bibliotecarios();

        novo.setIdDoBibliotecario(bibliotecarios.size());

        int codigo = gerarCodigo();
        novo.setCodigoDoBibliotecario(codigo);

        leitor.nextLine();

        System.out.println("Nome:");
        novo.setNomeDoBibliotecario(leitor.nextLine());

        System.out.println("Senha:");
        novo.setSenhaDoBlibliotecario(leitor.next());

        bibliotecarios.add(novo);

        System.out.println("Bibliotecario cadastrado");
        System.out.println("Codigo de acesso: " + codigo);
    }

    public static void cadastrarLivro(Scanner leitor) {

        System.out.println("Tipo de livro:");
        System.out.println("1 - Livro Fisico");
        System.out.println("2 - Ebook");
        System.out.println("3 - AudioBook");

        int tipo = leitor.nextInt();
        leitor.nextLine();

        Livros novo;

        if (tipo == 1) {
            novo = new LivroFisico();
        } else if (tipo == 2) {
            novo = new Ebook();
        } else if (tipo == 3) {
            novo = new AudioBook();
        } else {
            System.out.println("Tipo invalido");
            return;
        }

        novo.setIdDoLivro(livros.size());

        System.out.println("ISBN:");
        novo.setIsbn(leitor.nextLine());

        System.out.println("Nome:");
        novo.setNomeDoLivro(leitor.nextLine());

        System.out.println("Autor:");
        novo.setAutor(leitor.nextLine());

        System.out.println("Ano:");
        novo.setDataDeLancamento(leitor.nextInt());

        System.out.println("Quantidade:");
        novo.setQuantidadeEmEstoque(leitor.nextInt());

        novo.setQuantidadeEmprestado(0);

        leitor.nextLine();

        // CAMPOS ESPECÍFICOS
        if (novo instanceof LivroFisico) {

            LivroFisico lf = (LivroFisico) novo;

            System.out.println("Editora:");
            lf.setEditora(leitor.nextLine());

            System.out.println("Numero de paginas:");
            lf.setNumeroDePaginas(leitor.nextInt());
            leitor.nextLine();

            System.out.println("Localizacao na biblioteca:");
            lf.setLocalizacaoNaBiblioteca(leitor.nextLine());

            System.out.println("Estado de conservacao:");
            lf.setEstadoConservacao(leitor.nextLine());
        }

        if (novo instanceof Ebook) {

            Ebook eb = (Ebook) novo;

            System.out.println("Tamanho do arquivo MB:");
            eb.setTamanhoArquivoMB(leitor.nextDouble());
            leitor.nextLine();

            System.out.println("Formato do arquivo:");
            eb.setFormatoArquivo(leitor.nextLine());

            System.out.println("Plataforma:");
            eb.setPlataforma(leitor.nextLine());

            System.out.println("Link download:");
            eb.setLinkDownload(leitor.nextLine());
        }

        if (novo instanceof AudioBook) {

            AudioBook ab = (AudioBook) novo;

            System.out.println("Narrador:");
            ab.setNarrador(leitor.nextLine());

            System.out.println("Duracao minutos:");
            ab.setDuracaoMinutos(leitor.nextInt());
            leitor.nextLine();

            System.out.println("Formato audio:");
            ab.setFormatoAudio(leitor.nextLine());

            System.out.println("Idioma:");
            ab.setIdioma(leitor.nextLine());
        }

        livros.add(novo);

        System.out.println("Livro cadastrado com sucesso");
    }

    public static void cadastrarCliente(Scanner leitor) {

        Clientes novo = new Clientes();

        novo.setIdDoCliente(clientes.size());

        int codigo = gerarCodigo();
        novo.setCodigoDoCliente(codigo);

        leitor.nextLine();

        System.out.println("Nome:");
        novo.setNomeDoCliente(leitor.nextLine());

        System.out.println("CPF:");
        novo.setCpfDoCliente(leitor.nextLine());

        novo.setCadastroAtivo(true);
        novo.setEmrestimoAtivo(false);

        clientes.add(novo);

        System.out.println("Cliente cadastrado");
        System.out.println("Codigo do cliente: " + codigo);
    }

    public static void realizarEmprestimo(Scanner leitor) {

        if (logado == -1) {
            System.out.println("Nenhum bibliotecario logado");
            return;
        }

        System.out.println("Realizar Emprestimo");
        System.out.println("1 - Cliente ja Cadastrado");
        System.out.println("2 - Novo Cliente");

        int clienteNovo = leitor.nextInt();

        if (clienteNovo == 2) {
            cadastrarCliente(leitor);
        }

        System.out.println("Codigo cliente:");
        int codigoCliente = leitor.nextInt();

        leitor.nextLine();

        System.out.println("ISBN livro:");
        String isbn = leitor.nextLine();

        Clientes cliente = null;
        Livros livro = null;

        for (Clientes c : clientes) {

            if (c.getCodigoDoCliente() == codigoCliente) {
                cliente = c;
                break;
            }
        }

        for (Livros l : livros) {

            if (l.getIsbn().equals(isbn)) {
                livro = l;
                break;
            }
        }

        if (cliente == null || livro == null) {

            System.out.println("Cliente ou livro nao encontrado");
            return;
        }

        if (livro.getQuantidadeEmEstoque() <= 0) {

            System.out.println("Livro sem estoque");
            return;
        }

        livro.setQuantidadeEmEstoque(livro.getQuantidadeEmEstoque() - 1);
        livro.setQuantidadeEmprestado(livro.getQuantidadeEmprestado() + 1);

        cliente.setEmrestimoAtivo(true);

        Emprestimo novo = new Emprestimo();

        novo.setIdDoEmprestimo(emprestimos.size());
        novo.setIdDoCliente(cliente.getIdDoCliente());
        novo.setIdDoLivro(livro.getIdDoLivro());
        novo.setIdDoBibliotecario(bibliotecarios.get(logado).getIdDoBibliotecario());
        novo.setLivroEmPosse(livro.getNomeDoLivro());
        novo.setDataEmprestimo(LocalDate.now().toString());

        emprestimos.add(novo);

        System.out.println("Emprestimo realizado com sucesso");
    }

    public static void listarClientes() {

        if (clientes.size() == 0) {

            System.out.println("Nenhum cliente cadastrado");
            return;
        }

        int pagina = 0;
        int porPagina = 10;

        Scanner scanner = new Scanner(System.in);

        while (true) {

            int inicio = pagina * porPagina;
            int fim = Math.min(inicio + porPagina, clientes.size());

            System.out.printf("| %-3s | %-6s | %-20s | %-15s | %-16s |\n",
                    " Id", "Codigo", "Nome do Cliente", "CPF do Cliente", "Emprestimo Ativo");

            System.out.println("--------------------------------------------------------------------------");
            for (int i = inicio; i < fim; i++) {
                clientes.get(i).exibirCliente();
            }

            System.out.println("\n1 Proxima pagina");
            System.out.println("2 Pagina anterior");
            System.out.println("0 Voltar");

            int opcao = scanner.nextInt();

            if (opcao == 1 && fim < clientes.size()) {

                pagina++;
            } else if (opcao == 2 && pagina > 0) {

                pagina--;
            } else if (opcao == 0) {

                return;
            }

        }
    }

}