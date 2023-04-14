package rf.com.tienda.interfaces.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import rf.com.tienda.dominio.PedidoCarrito;

public interface iPedidoCarrito extends JpaRepository<PedidoCarrito, Integer> {

}
