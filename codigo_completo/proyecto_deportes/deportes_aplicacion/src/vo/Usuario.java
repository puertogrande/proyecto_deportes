package vo;

public class Usuario {
	public String Nick;
	public String Password;
	public String Permiso;
	
	public Usuario(String nick, String password, String permiso) {
		super();
		Nick = nick;
		Password = password;
		Permiso = permiso;
	}
	
	public Usuario(String nick, String permiso) {
		super();
		Nick = nick;
		Permiso = permiso;
	}

	public String getNick() {
		return Nick;
	}

	public void setNick(String nick) {
		Nick = nick;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getPermiso() {
		return Permiso;
	}

	public void setPermiso(String permiso) {
		Permiso = permiso;
	}

	@Override
	public String toString() {
		return "Usuario [Nick=" + Nick + ", Permiso=" + Permiso + "]";
	}
	
}
