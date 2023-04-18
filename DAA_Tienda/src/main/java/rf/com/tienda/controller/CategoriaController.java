package rf.com.tienda.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rf.com.tienda.dominio.Categoria;
import rf.com.tienda.exception.DomainException;
import rf.com.tienda.services.CategoriaServicio;
import rf.com.tienda.services.ICategoria;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private ICategoria catService;
	
	
	@GetMapping
	public List<Categoria> leerCategorias()
	{
		
		return catService.lista();
	}
	
	@PostMapping
	public Categoria insertaCategoria(@RequestBody Categoria cat) throws DomainException
	{
		return catService.insertaCategoria(cat);
		
	}
	
	@PutMapping
	public Categoria actualizaCategoria(@RequestBody Categoria cat) throws DomainException
	{
		return catService.actualizarCategoria(cat);
	}
	
	
	@DeleteMapping("/{id}")	
	public void eliminaCategoria(@PathVariable("id") Integer id )
	{
		
		catService.eliminarCategoria(id);
		
		
	}
	
	

}
