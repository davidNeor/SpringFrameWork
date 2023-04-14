package rf.com.tienda.interfaces.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import rf.com.tienda.dominio.Producto;

public interface IProducto extends JpaRepository<Producto, String> {

}
