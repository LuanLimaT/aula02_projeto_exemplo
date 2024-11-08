package br.edu.ifto.aula02.model.dao;

import br.edu.ifto.aula02.model.entity.Veiculo;
import br.edu.ifto.aula02.model.jdbc.MinhaConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VeiculoDAO {

    private Connection con;

    public VeiculoDAO() {
        con = MinhaConexao.conexao();
    }

    // Buscar todos os veículos
    public List<Veiculo> buscarVeiculos() {
        try {
            String sql = "SELECT * FROM tb_veiculo"; // Use a tabela correta
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Veiculo> veiculos = new ArrayList<>();
            while (rs.next()) {
                Veiculo v = new Veiculo();
                v.setId(rs.getLong("id"));
                v.setMarca(rs.getString("marca"));
                v.setModelo(rs.getString("modelo"));
                v.setPreco(rs.getDouble("preco"));
                v.setAnoFabricacao(rs.getInt("anoFabricacao"));
                veiculos.add(v);
            }
            return veiculos;
        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    // Salvar veículo
    public boolean save(Veiculo veiculo) {
        try {
            String sql = "INSERT INTO tb_veiculo (marca, modelo, preco, anoFabricacao) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, veiculo.getMarca());
            ps.setString(2, veiculo.getModelo());
            ps.setDouble(3, veiculo.getPreco());
            ps.setInt(4, veiculo.getAnoFabricacao());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Remover veículo
    public boolean remove(Long id) {
        try {
            String sql = "DELETE FROM tb_veiculo WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Atualizar veículo
    public boolean update(Veiculo veiculo) {
        try {
            String sql = "UPDATE tb_veiculo SET marca = ?, modelo = ?, preco = ?, anoFabricacao = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, veiculo.getMarca());
            ps.setString(2, veiculo.getModelo());
            ps.setDouble(3, veiculo.getPreco());
            ps.setInt(4, veiculo.getAnoFabricacao());
            ps.setLong(5, veiculo.getId());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Buscar veículo pelo ID
    public Veiculo buscarVeiculo(Long id) {
        Veiculo veiculo = null;
        try {
            String sql = "SELECT * FROM tb_veiculo WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                veiculo = new Veiculo();
                veiculo.setId(rs.getLong("id"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setPreco(rs.getDouble("preco"));
                veiculo.setAnoFabricacao(rs.getInt("anoFabricacao"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return veiculo;
    }
}
