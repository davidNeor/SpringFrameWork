package rf.com.tienda.services;

import java.util.List;

import rf.com.tienda.dominio.Categoria;

public interface ICategoria {

	public abstract List<Categoria> lista();
	
	public abstract Categoria insertaCategoria(Categoria categoria);
	
	public abstract Categoria actualizarCategoria(Categoria categoria);
	
	public abstract void eliminarCategoria(Integer id);
	
	
	
	
	
}
