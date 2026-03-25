package biblioteca.model;

public class Emprestimo {

    private int idDoEmprestimo;
    private int idDoLivro;
    private int idDoCliente;
    private int idDoBibliotecario;
    private String dataEmprestimo;
    private String livroEmPosse;

    public int getIdDoEmprestimo() {
        return idDoEmprestimo;
    }

    public void setIdDoEmprestimo(int idDoEmprestimo) {
        this.idDoEmprestimo = idDoEmprestimo;
    }

    public int getIdDoLivro() {
        return idDoLivro;
    }

    public void setIdDoLivro(int idDoLivro) {
        this.idDoLivro = idDoLivro;
    }

    public int getIdDoCliente() {
        return idDoCliente;
    }

    public void setIdDoCliente(int idDoCliente) {
        this.idDoCliente = idDoCliente;
    }

    public int getIdDoBibliotecario() {
        return idDoBibliotecario;
    }

    public void setIdDoBibliotecario(int idDoBibliotecario) {
        this.idDoBibliotecario = idDoBibliotecario;
    }

    public String getLivroEmPosse() {
        return livroEmPosse;
    }

    public void setLivroEmPosse(String livroEmPosse) {
        this.livroEmPosse = livroEmPosse;
    }

    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
}