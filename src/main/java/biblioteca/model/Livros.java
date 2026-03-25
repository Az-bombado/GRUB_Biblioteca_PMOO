package biblioteca.model;

public class Livros {

    private int idDoLivro;
    private String isbn;
    private String nomeDoLivro;
    private String autor;
    private int dataDeLancamento;
    private int quantidadeEmEstoque;
    private int quantidadeEmprestado;

    public int getIdDoLivro() {
        return idDoLivro;
    }

    public void setIdDoLivro(int idDoLivro) {
        this.idDoLivro = idDoLivro;
    }

    public String getNomeDoLivro() {
        return nomeDoLivro;
    }

    public void setNomeDoLivro(String nomeDoLivro) {
        this.nomeDoLivro = nomeDoLivro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getDataDeLancamento() {
        return dataDeLancamento;
    }

    public void setDataDeLancamento(int dataDeLancamento) {
        this.dataDeLancamento = dataDeLancamento;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public int getQuantidadeEmprestado() {
        return quantidadeEmprestado;
    }

    public void setQuantidadeEmprestado(int quantidadeEmprestado) {
        this.quantidadeEmprestado = quantidadeEmprestado;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}