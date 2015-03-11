package Model;

public class Usuario {
 private int id_Usuario ;
 private String Nome_usuario;
 private String Senha_Usuario;
 private boolean func_admin;
 
 public int getId_Usuario() {
		return id_Usuario;
	}
	public void setId_Usuario(int id_Usuario) {
		this.id_Usuario = id_Usuario;
	}
	public String getLogin_Usuario() {
		return Login_Usuario;
	}
	public void setLogin_Usuario(String login_Usuario) {
		Login_Usuario = login_Usuario;
	}
	public String getSenha_Usuario() {
		return Senha_Usuario;
	}
	public void setSenha_Usuario(String senha_Usuario) {
		Senha_Usuario = senha_Usuario;
	}
	public boolean isFunc_admin() {
		return func_admin;
	}
	public void setFunc_admin(boolean func_admin) {
		this.func_admin = func_admin;
	} 
 
	
	
}
