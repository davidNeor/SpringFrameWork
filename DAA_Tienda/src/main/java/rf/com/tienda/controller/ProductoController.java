package rf.com.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import rf.com.tienda.dominio.Categoria;
import rf.com.tienda.dominio.Producto;
import rf.com.tienda.exception.DomainException;
import rf.com.tienda.services.ICategoria;
import rf.com.tienda.services.IProducto;

@RestController
public class ProductoController {

@Autowired
private IProducto prod;



@GetMapping
public List<Producto> leerProductos()
{
	
	return prod.lista();
}

@PostMapping
public Producto insertaProducto(@RequestBody Producto proucto) throws DomainException
{
	return prod.insertaProducto(proucto);
	
}

@PutMapping
public Producto actualizaProducto(@RequestBody Producto producto) throws DomainException
{
	return prod.actualizarProducto(producto);
}


@DeleteMapping("/{id}")	
public void eliminaProducto(@PathVariable("id") String id )
{
	
	prod.eliminarCategoria(id);
	
	
}





}
