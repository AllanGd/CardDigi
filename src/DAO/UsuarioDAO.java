package DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;

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
	   con.prepareStatement("insert into usuario (, descricao) values (?,?)");
	   p.setString(1, produto.getNome());
	   p.setString(2, produto.getDescricao());
	   p.executeUpdate();
	   p.close();
	}

	public void deletar(Produto produto) throws Exception {
	   PreparedStatement p = con.prepareStatement("delete from produto where id = ?");
	   p.setInt(1, produto.getId());
	   p.executeUpdate();
	   p.close();
	}

	public void update(Produto produto) throws Exception {
	   PreparedStatement p = 
	   con.prepareStatement("update produto set nome = ?, descricao = ? where id = ?");
	   p.setString(1, produto.getNome());
	   p.setString(2, produto.getDescricao());
	   p.setInt(3, produto.getId());
	   p.executeUpdate();
	   p.close();
	}

	public List<Produto> listarTodos() throws Exception{
	   List<Produto> produtos = new ArrayList<Produto>();
	   PreparedStatement p = con.prepareStatement("select * from produto");
	   ResultSet rs = p.executeQuery();
	   while(rs.next()){
	      Produto produto = new Produto();
	      produto.setId(rs.getInt("id"));
	      produto.setNome(rs.getString("nome"));
	      produto.setDescricao(rs.getString("descricao"));
	      produtos.add(produto);
	   }
	   rs.close();
	   p.close();
	   return produtos;
	}

	}//fim da classe ProdutoDAO

}
