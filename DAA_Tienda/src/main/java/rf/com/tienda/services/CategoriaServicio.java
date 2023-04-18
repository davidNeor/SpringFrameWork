package rf.com.tienda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rf.com.tienda.dominio.Categoria;
import rf.com.tienda.repository.CategoriaRepository;
@Service
public class CategoriaServicio implements ICategoria{

	@Autowired
	private CategoriaRepository repositorio;
	
	@Override
	public List<Categoria> lista()
	{
		
		List<Categoria> pepito= repositorio.findAll();
		System.out.println(pepito);
		return pepito;
	}
	
	
	@Override
	public Categoria insertaCategoria(Categoria categoria)
	{
		return repositorio.save(categoria);
	}
	
	
	@Override
	public Categoria actualizarCategoria(Categoria categoria)
	{
		return repositorio.save(categoria);
	}
	
	
	@Override
	public void eliminarCategoria(Integer id)
	{
		repositorio.deleteById(id);
	}
	
}
