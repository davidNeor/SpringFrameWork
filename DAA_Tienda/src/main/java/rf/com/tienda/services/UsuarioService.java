package rf.com.tienda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rf.com.tienda.dominio.Usuario;
import rf.com.tienda.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuario{

	@Autowired
	UsuarioRepository userrepo;
	
	@Override
	public List<Usuario> lista()
	{
		
		return userrepo.findAll();
		
	}
	
	
	
	@Override
	public  Usuario insertaUsuario(Usuario user)
	{
		
		return userrepo.save(user);
		
	}
	
	
	@Override
	public  Usuario actualizaUsuario(Usuario user)
	{
		return userrepo.save(user);
	}
	

	@Override
	public  void eliminaUsuario(Integer id)
	{
		userrepo.deleteById(id);
	}
	
	
	
	
	
}
