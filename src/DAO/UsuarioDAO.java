package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;

import Model.Usuario;

public class UsuarioDAO {
	

	private Connection con;//objeto connection que será usado nos métodos abaixo

			//Construtor que recebe como parametro uma conexao com o banco de dado. 
	
	public UsuarioDAO(Connection con){
	   this.con = con;
	}

	public void cadastrar(Usuario usuario) throws Exception {
	   PreparedStatement p =
	   con.prepareStatement("insert into usuario (Login, senha, func_admin) values (?,?,?,?)");
	   p.setInt(1, usuario.getId());
	   p.setString(2, usuario.getLogin());
	   p.setString(3, usuario.getSenha());
	   p.setBoolean(4, usuario.isFunc_admin());
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
	   p.setString(1, usuario.getLogin());
	   p.setString(2, usuario.getSenha());
	   p.setInt(3, usuario.getId());
	   p.executeUpdate();
	   p.close();
	}

	public List<Usuario> listarTodos() throws Exception{
	   List<Usuario> usuarios = new ArrayList<Usuario>();
	   PreparedStatement p = con.prepareStatement("select * from usuario");
	   ResultSet rs = p.executeQuery();
	   while(rs.next()){
	      Usuario usuario = new Usuario();
	      usuario.setId(rs.getInt("id"));
	      usuario.setLogin(rs.getString("Login"));
	      usuario.setSenha(rs.getString("Senha"));
	      usuarios.add(usuario);
	   }
	   rs.close();
	   p.close();
	   return usuarios;
	}

	}//fim da classe usuarioDAO


