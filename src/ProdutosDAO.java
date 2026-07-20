/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public boolean cadastrarProduto (ProdutosDTO produto){
        String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";
        
        try {
            conn = new conectaDAO().connectDB();
            if (conn == null) {
                return false;
            }
            prep = conn.prepareStatement(sql);
            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            prep.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (prep != null) {
                    prep.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        listagem = new ArrayList<>();
        String sql = "SELECT id, nome, valor, status FROM produtos";
        
        try {
            conn = new conectaDAO().connectDB();
            if (conn == null) {
                return listagem;
            }
            prep = conn.prepareStatement(sql);
            resultset = prep.executeQuery();
            
            while (resultset.next()) {
                ProdutosDTO item = new ProdutosDTO();
                item.setId(resultset.getInt("id"));
                item.setNome(resultset.getString("nome"));
                item.setValor(resultset.getInt("valor"));
                item.setStatus(resultset.getString("status"));
                listagem.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultset != null) {
                    resultset.close();
                }
                if (prep != null) {
                    prep.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return listagem;
    }
    
    public boolean venderProduto(int id) {
        String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";
        
        try {
            conn = new conectaDAO().connectDB();
            if (conn == null) {
                return false;
            }
            prep = conn.prepareStatement(sql);
            prep.setInt(1, id);
            return prep.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (prep != null) {
                    prep.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public ArrayList<ProdutosDTO> listarProdutosVendidos() {
        listagem = new ArrayList<>();
        String sql = "SELECT id, nome, valor, status FROM produtos WHERE status = 'Vendido'";
        
        try {
            conn = new conectaDAO().connectDB();
            if (conn == null) {
                return listagem;
            }
            prep = conn.prepareStatement(sql);
            resultset = prep.executeQuery();
            
            while (resultset.next()) {
                ProdutosDTO item = new ProdutosDTO();
                item.setId(resultset.getInt("id"));
                item.setNome(resultset.getString("nome"));
                item.setValor(resultset.getInt("valor"));
                item.setStatus(resultset.getString("status"));
                listagem.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultset != null) {
                    resultset.close();
                }
                if (prep != null) {
                    prep.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return listagem;
    }
    
}

