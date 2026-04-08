package biblioteca.model;

public class AudioBook extends Livros {

    private String narrador;
    private int duracaoMinutos;
    private String formatoAudio;
    private String idioma;

    public String getNarrador() {
        return narrador;
    }

    public void setNarrador(String narrador) {
        this.narrador = narrador;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    public String getFormatoAudio() {
        return formatoAudio;
    }

    public void setFormatoAudio(String formatoAudio) {
        this.formatoAudio = formatoAudio;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    @Override
    public void exibirTipoLivro() {
        System.out.println("AudioBook");
    }
}