package rf.com.tienda.services;

import java.util.List;

import rf.com.tienda.dominio.Usuario;

public interface IUsuario {

	public abstract List<Usuario> lista();
	
	public abstract Usuario insertaUsuario(Usuario user);
	
	public abstract Usuario actualizaUsuario(Usuario user);
	
	public abstract void eliminaUsuario(Integer id);
	
	
}
