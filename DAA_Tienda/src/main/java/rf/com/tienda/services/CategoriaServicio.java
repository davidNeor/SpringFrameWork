package rf.com.tienda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import rf.com.tienda.dominio.Categoria;
import rf.com.tienda.repository.CategoriaRepository;

public class CategoriaServicio implements ICategoria{

	@Autowired
	private CategoriaRepository repositorio;
	
	@Override
	public List<Categoria> lista()
	{
		
		return repositorio.findAll();
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
