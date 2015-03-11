package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;

import Model.Usuario;

public class UsuarioDAO {
	

	private Connection con;//objeto connection que será usado nos métodos abaixo

	/*
	* Construtor que recebe como parametro uma conexao com o banco de dado. 
	*/
	public UsuarioDAO(Connection con){
	   this.con = con;
	}

	public void cadastrar(Usuario usuario) throws Exception {
	   PreparedStatement p =
	   con.prepareStatement("insert into usuario (Login, senha, func_admin) values (?,?,?)");
	   
	   p.setString(1, usuario.getLogin());
	   p.setString(2, usuario.getSenha());
	   p.executeUpdate();
	   p.close();
	}

	public void deletar(Usuario usuario) throws Exception {
	   PreparedStatement p = con.prepareStatement("delete from usuario where id = ?");
	   p.setInt(1, usuario.getId());
	   p.executeUpdate();
	   p.close();
	}

	public void update(Usuario usuario) throws Exception {
	   PreparedStatement p = 
	   con.prepareStatement("update usuario set nome = ?, descricao = ? where id = ?");
	   p.setString(1, usuario.getNome());
	   p.setString(2, usuario.getDescricao());
	   p.setInt(3, usuario.getId());
	   p.executeUpdate();
	   p.close();
	}

	public List<usuario> listarTodos() throws Exception{
	   List<usuario> usuarios = new ArrayList<usuario>();
	   PreparedStatement p = con.prepareStatement("select * from usuario");
	   ResultSet rs = p.executeQuery();
	   while(rs.next()){
	      usuario usuario = new usuario();
	      usuario.setId(rs.getInt("id"));
	      usuario.setNome(rs.getString("nome"));
	      usuario.setDescricao(rs.getString("descricao"));
	      usuarios.add(usuario);
	   }
	   rs.close();
	   p.close();
	   return usuarios;
	}

	}//fim da classe usuarioDAO

}
