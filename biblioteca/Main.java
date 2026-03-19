import java.util.Scanner;
import java.time.LocalDate;

public class Main {

    static Livros[] livros = new Livros[100000];
    static Clientes[] clientes = new Clientes[100000];
    static Bibliotecarios[] bibliotecarios = new Bibliotecarios[100];
    static Emprestimo[] emprestimos = new Emprestimo[100000];

    static int totalLivros = 0;
    static int totalClientes = 0;
    static int totalBibliotecarios = 0;
    static int totalEmprestimos = 0;

    static int logado = -1;

    static String senhaAdmin = "Admin123";

    public static int gerarCodigo() {
        return (int)(Math.random()*900000)+100000;
    }

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        int opcao;

        do {

            String nomeLogado = "Nenhum";

            if(logado >= 0 && bibliotecarios[logado] != null){
                nomeLogado = bibliotecarios[logado].getNomeDoBibliotecario();
            }

            int codigoLogado = 000000;

            if(logado >= 0 && bibliotecarios[logado] != null){
                codigoLogado = bibliotecarios[logado].getCodigoDoBibliotecario();
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

            switch(opcao){

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

                case 6 :
                    ListarClientes();
                    break;
            }

        }while(opcao != 0);

    }

    public static void loginBibliotecario(Scanner leitor){

        System.out.println("Nome:");
        String nome = leitor.next();

        System.out.println("Senha:");
        String senha = leitor.next();

        for(int i=0;i<totalBibliotecarios;i++){

            if(bibliotecarios[i].getNomeDoBibliotecario().equals(nome) &&
                    bibliotecarios[i].getSenhaDoBlibliotecario().equals(senha)){

                logado = i;

                System.out.println("Login realizado com sucesso");
                System.out.println("Bem vindo " + bibliotecarios[i].getNomeDoBibliotecario());

                return;
            }
        }

        System.out.println("Login incorreto");
    }

    public static void cadastrarBibliotecario(Scanner leitor){

        System.out.println("Senha admin:");
        String senha = leitor.next();

        if(!senha.equals(senhaAdmin)){
            System.out.println("Senha incorreta");
            return;
        }

        Bibliotecarios novo = new Bibliotecarios();

        novo.setIdDoBibliotecario(totalBibliotecarios);

        int codigo = gerarCodigo();
        novo.setCodigoDoBibliotecario(codigo);

        leitor.nextLine();

        System.out.println("Nome:");
        novo.setNomeDoBibliotecario(leitor.nextLine());

        System.out.println("Senha:");
        novo.setSenhaDoBlibliotecario(leitor.next());

        bibliotecarios[totalBibliotecarios] = novo;

        totalBibliotecarios++;

        System.out.println("Bibliotecario cadastrado");
        System.out.println("Codigo de acesso: "+codigo);
    }

    public static void cadastrarLivro(Scanner leitor){

        Livros novo = new Livros();

        novo.setIdDoLivro(totalLivros);

        System.out.println("ISBN:");
        novo.setIsbn(leitor.nextLine());

        leitor.nextLine();

        System.out.println("Nome:");
        novo.setNomeDoLivro(leitor.nextLine());

        System.out.println("Autor:");
        novo.setAutor(leitor.nextLine());

        System.out.println("Ano:");
        novo.setDataDeLancamento(leitor.nextInt());

        System.out.println("Quantidade:");
        novo.setQuantidadeEmEstoque(leitor.nextInt());

        novo.setQuantidadeEmprestado(0);

        livros[totalLivros] = novo;

        totalLivros++;

        System.out.println("Livro cadastrado");
    }

    public static void cadastrarCliente(Scanner leitor){

        Clientes novo = new Clientes();

        novo.setIdDoCliente(totalClientes);

        int codigo = gerarCodigo();
        novo.setCodigoDoCliente(codigo);

        leitor.nextLine();

        System.out.println("Nome:");
        novo.setNomeDoCliente(leitor.nextLine());

        System.out.println("CPF:");
        novo.setCpfDoCliente(leitor.nextLine());

        novo.setCadastroAtivo(true);
        novo.setEmrestimoAtivo(false);

        clientes[totalClientes] = novo;

        totalClientes++;

        System.out.println("Cliente cadastrado");
        System.out.println("Codigo do cliente: "+codigo);
    }

    public static void realizarEmprestimo(Scanner leitor){

        if(logado == -1){
            System.out.println("Nenhum bibliotecario logado");
            return;
        }

        int clienteNovo;
        boolean loopClienteNovo = true;

        while (loopClienteNovo) {

            System.out.println("Realizar Emprestimo");
            System.out.println("1 - Cliente ja Cadastrado");
            System.out.println("2 - Novo Cliente");

            clienteNovo = leitor.nextInt();

            switch (clienteNovo) {
                case 1:
                    loopClienteNovo = false;
                    break;
                case 2:
                    cadastrarCliente(leitor);
                    loopClienteNovo = false;
                    break;
                default:
                    System.out.println("Tente novamente");
            }
        }
        System.out.println("Codigo cliente:");

        int codigoCliente = leitor.nextInt();

        System.out.println("ISBN livro:");
        int isbn = leitor.nextInt();

        Clientes cliente = null;
        Livros livro = null;

        for(int i=0;i<totalClientes;i++){

            if(clientes[i].getCodigoDoCliente() == codigoCliente){
                cliente = clientes[i];
                break;
            }
        }

        for(int i = 0; i < totalLivros; i++){

            if(livros[i].getIsbn().equals(isbn)){
                livro = livros[i];
                break;
            }
        }

        if(cliente == null || livro == null){
            System.out.println("Cliente ou livro nao encontrado");
            return;
        }

        if(livro.getQuantidadeEmEstoque() <= 0){
            System.out.println("Livro sem estoque");
            return;
        }

        livro.setQuantidadeEmEstoque(livro.getQuantidadeEmEstoque()-1);
        livro.setQuantidadeEmprestado(livro.getQuantidadeEmprestado()+1);

        cliente.setEmrestimoAtivo(true);

        Emprestimo novo = new Emprestimo();

        novo.setIdDoEmprestimo(totalEmprestimos);
        novo.setIdDoCliente(cliente.getIdDoCliente());
        novo.setIdDoLivro(livro.getIdDoLivro());
        novo.setIdDoBibliotecario(bibliotecarios[logado].getIdDoBibliotecario());
        novo.setLivroEmPosse(livro.getNomeDoLivro());
        novo.setDataEmprestimo(LocalDate.now().toString());

        emprestimos[totalEmprestimos] = novo;

        totalEmprestimos++;

        System.out.println("Emprestimo realizado com sucesso");
    }
    public static void ListarClientes() {
        Scanner listarScanner = new Scanner(System.in);
        int point = 10;
        boolean loopLista = true;
        int i, j = 0;
        while(loopLista == true){
            for (i = j; i <= point; i++) {
                clientes[i].exibirCliente();
            }
            System.out.println("\n\n Digite 1 para para voltar a pagina e 2 para avançar ");
            System.out.println("Digite 0 para retornar ao menu");
            int escolha = listarScanner.nextInt();
            switch (escolha) {
                case 0:
                    loopLista = false;
                    break;
                case 1:
                    j = j + 10;
                    point = point + 10;
                    break;
                case 2:
                    j = j - 10;
                    point = point - 10;
            }
        }
    }
}