package biblioteca.model;

public class Ebook extends Livros {

    private double tamanhoArquivoMB;
    private String formatoArquivo;
    private String plataforma;
    private String linkDownload;

    public double getTamanhoArquivoMB() {
        return tamanhoArquivoMB;
    }

    public void setTamanhoArquivoMB(double tamanhoArquivoMB) {
        this.tamanhoArquivoMB = tamanhoArquivoMB;
    }

    public String getFormatoArquivo() {
        return formatoArquivo;
    }

    public void setFormatoArquivo(String formatoArquivo) {
        this.formatoArquivo = formatoArquivo;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getLinkDownload() {
        return linkDownload;
    }

    public void setLinkDownload(String linkDownload) {
        this.linkDownload = linkDownload;
    }

    @Override
    public void exibirTipoLivro() {
        System.out.println("Ebook");
    }
}