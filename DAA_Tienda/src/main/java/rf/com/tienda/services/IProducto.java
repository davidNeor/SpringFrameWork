package rf.com.tienda.services;

import java.util.List;

import rf.com.tienda.dominio.Categoria;
import rf.com.tienda.dominio.Producto;

public interface IProducto {

	public abstract List<Producto> lista();
	
	public abstract Producto insertaProducto(Producto producto);
	
	public abstract Producto actualizarProducto(Producto producto);
	
	public abstract void eliminarCategoria(String id);
}
