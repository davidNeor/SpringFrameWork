package rf.com.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rf.com.tienda.dominio.Usuario;
import rf.com.tienda.exception.DomainException;
import rf.com.tienda.services.IUsuario;

@RestController
@RequestMapping("/usuario")
public class UserController {

	@Autowired
	private IUsuario userrepo;
	
	@GetMapping
	public List<Usuario> lista()
	{
		return userrepo.lista();
	}
	
	@PostMapping
	public Usuario insertarUsuario(@RequestBody Usuario user) throws DomainException
	{
		return userrepo.insertaUsuario(user);
	}
	
	
	@PutMapping
	public Usuario actualizaUsuario(@RequestBody Usuario user) throws DomainException
	{
		return userrepo.actualizaUsuario(user);
		
	}
	
	
	@DeleteMapping("/{id}")	
	public void eliminaUsuario(@PathVariable("id") Integer id )
	{
		
		userrepo.eliminaUsuario(id);
		
		
	}
	
}
