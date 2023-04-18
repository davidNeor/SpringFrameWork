package rf.com.tienda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rf.com.tienda.dominio.Producto;
import rf.com.tienda.repository.ProductoRepository;

@Service
public class ProductoServicio implements IProducto{

	@Autowired
	ProductoRepository prorepos;
	@Override
	public List<Producto>  lista()
	{
		return prorepos.findAll();
	
	}
	
	@Override
	public  Producto insertaProducto(Producto producto)
	{
		return prorepos.save(producto);
	}
	

	@Override
	public  Producto actualizarProducto(Producto producto)
	{
		return prorepos.save(producto);
	}
	
	@Override
	public  void eliminarCategoria(String id)
	{
		prorepos.deleteById(id);
	}
	

}
