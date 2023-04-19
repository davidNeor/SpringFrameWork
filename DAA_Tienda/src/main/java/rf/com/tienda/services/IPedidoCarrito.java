package rf.com.tienda.services;

import java.util.List;

import rf.com.tienda.dominio.PedidoCarrito;

public interface IPedidoCarrito {

	public abstract List<PedidoCarrito> lista();
	
	public abstract PedidoCarrito insertaPedido(PedidoCarrito pedido);
	
	public abstract PedidoCarrito actualizaPedido(PedidoCarrito pedido);
	
	public abstract void eliminaPedido(Integer id);
	
	
	
	
}
