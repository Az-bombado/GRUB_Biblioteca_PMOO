package biblioteca.model;

public class LivroFisico extends Livros {

    private String editora;
    private int numeroDePaginas;
    private String localizacaoNaBiblioteca;
    private String estadoConservacao;

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public String getLocalizacaoNaBiblioteca() {
        return localizacaoNaBiblioteca;
    }

    public void setLocalizacaoNaBiblioteca(String localizacaoNaBiblioteca) {
        this.localizacaoNaBiblioteca = localizacaoNaBiblioteca;
    }

    public String getEstadoConservacao() {
        return estadoConservacao;
    }

    public void setEstadoConservacao(String estadoConservacao) {
        this.estadoConservacao = estadoConservacao;
    }

    @Override
    public void exibirTipoLivro() {
        System.out.println("Livro Fisico");
    }
}