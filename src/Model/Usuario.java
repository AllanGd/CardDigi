package Model;

public class Usuario {
 private int id ;
 private String Login;
 private String Senha;
 private String Endereco;
 private boolean func_admin;
 
 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return Login;
	}
	public void setLogin(String login) {
		Login = login;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	public boolean isFunc_admin() {
		return func_admin;
	}
	public void setFunc_admin(boolean func_admin) {
		this.func_admin = func_admin;
	}

 
 
	
	
}
