package rf.com.tienda.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rf.com.tienda.dominio.PedidoCarrito;
import rf.com.tienda.repository.PedidoCarritoRepository;

@Service
public class PedidoCarritoService implements IPedidoCarrito {

	@Autowired
	PedidoCarritoRepository pedidorepo;
	
	
	@Override
	public  List<PedidoCarrito> lista()
	{
		return pedidorepo.findAll();
	}
	
	@Override
	public  PedidoCarrito insertaPedido(PedidoCarrito pedido)
	{
		return pedidorepo.save(pedido);
	}

	
	
	@Override
	public  PedidoCarrito actualizaPedido(PedidoCarrito pedido)
	{
		return pedidorepo.save(pedido);
	}

	
	@Override
	public  void eliminaPedido(Integer id)
	{
		pedidorepo.deleteById(id);
	}

	
	
	
	
	
	
	
	
}
