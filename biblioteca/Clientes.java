public class Clientes {

    private int idDoCliente;
    private int codigoDoCliente;
    private String nomeDoCliente;
    private String cpfDoCliente;
    private boolean emprestimoAtivo;
    private boolean cadastroAtivo;

    public int getIdDoCliente() {
        return idDoCliente;
    }

    public void setIdDoCliente(int idDoCliente) {
        this.idDoCliente = idDoCliente;
    }

    public int getCodigoDoCliente() {
        return codigoDoCliente;
    }

    public void setCodigoDoCliente(int codigoDoCliente) {
        this.codigoDoCliente = codigoDoCliente;
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    public String getCpfDoCliente() {
        return cpfDoCliente;
    }

    public void setCpfDoCliente(String cpfDoCliente) {
        this.cpfDoCliente = cpfDoCliente;
    }

    public boolean isEmrestimoAtivo() {
        return emprestimoAtivo;
    }

    public void setEmrestimoAtivo(boolean emrestimoAtivo) {
        this.emprestimoAtivo = emrestimoAtivo;
    }

    public boolean isCadastroAtivo() {
        return cadastroAtivo;
    }

    public void setCadastroAtivo(boolean cadastroAtivo) {
        this.cadastroAtivo = cadastroAtivo;
    }

}