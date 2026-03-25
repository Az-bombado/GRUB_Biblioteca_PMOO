package biblioteca.dao;

import biblioteca.database.Conexao;
import biblioteca.model.Clientes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    // INSERIR CLIENTE
    public void inserirCliente(Clientes cliente) {

        String sql = "INSERT INTO cliente (codigo_cliente, nome_cliente, cpf, emprestimo_ativo, cadastro_ativo) VALUES (?, ?, ?, ?, ?)";

        try {

            Connection conn = Conexao.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, cliente.getCodigoDoCliente());
            ps.setString(2, cliente.getNomeDoCliente());
            ps.setString(3, cliente.getCpfDoCliente());
            ps.setBoolean(4, cliente.isEmprestimoAtivo());
            ps.setBoolean(5, cliente.isCadastroAtivo());

            ps.executeUpdate();

            System.out.println("Cliente inserido com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    // LISTAR CLIENTES
    public List<Clientes> listarClientes() {

        List<Clientes> lista = new ArrayList<>();

        String sql = "SELECT * FROM cliente";

        try {

            Connection conn = Conexao.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Clientes cliente = new Clientes();

                cliente.setIdDoCliente(rs.getInt("pk_cliente"));
                cliente.setCodigoDoCliente(rs.getInt("codigo_cliente"));
                cliente.setNomeDoCliente(rs.getString("nome_cliente"));
                cliente.setCpfDoCliente(rs.getString("cpf"));
                cliente.setEmrestimoAtivo(rs.getBoolean("emprestimo_ativo"));
                cliente.setCadastroAtivo(rs.getBoolean("cadastro_ativo"));

                lista.add(cliente);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }


    // BUSCAR CLIENTE POR CODIGO
    public Clientes buscarCliente(int codigo) {

        String sql = "SELECT * FROM cliente WHERE codigo_cliente = ?";

        try {

            Connection conn = Conexao.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, codigo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                Clientes cliente = new Clientes();

                cliente.setIdDoCliente(rs.getInt("pk_cliente"));
                cliente.setCodigoDoCliente(rs.getInt("codigo_cliente"));
                cliente.setNomeDoCliente(rs.getString("nome_cliente"));
                cliente.setCpfDoCliente(rs.getString("cpf"));
                cliente.setEmrestimoAtivo(rs.getBoolean("emprestimo_ativo"));
                cliente.setCadastroAtivo(rs.getBoolean("cadastro_ativo"));

                return cliente;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    // ATUALIZAR CLIENTE
    public void atualizarCliente(Clientes cliente) {

        String sql = "UPDATE cliente SET nome_cliente = ?, cpf = ?, emprestimo_ativo = ?, cadastro_ativo = ? WHERE codigo_cliente = ?";

        try {

            Connection conn = Conexao.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, cliente.getNomeDoCliente());
            ps.setString(2, cliente.getCpfDoCliente());
            ps.setBoolean(3, cliente.isEmprestimoAtivo());
            ps.setBoolean(4, cliente.isCadastroAtivo());
            ps.setInt(5, cliente.getCodigoDoCliente());

            ps.executeUpdate();

            System.out.println("Cliente atualizado!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    // DELETAR CLIENTE
    public void deletarCliente(int codigo) {

        String sql = "DELETE FROM cliente WHERE codigo_cliente = ?";

        try {

            Connection conn = Conexao.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, codigo);

            ps.executeUpdate();

            System.out.println("Cliente removido!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    // VERIFICAR SE CODIGO JA EXISTE
    public boolean codigoExiste(int codigo){

        String sql = "SELECT 1 FROM cliente WHERE codigo_cliente = ?";

        try{

            Connection conn = Conexao.conectar();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, codigo);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        }catch(Exception e){

            e.printStackTrace();
            return true;

        }

    }

}