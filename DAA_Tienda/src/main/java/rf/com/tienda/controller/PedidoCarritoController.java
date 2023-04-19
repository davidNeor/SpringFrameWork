package rf.com.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rf.com.tienda.dominio.PedidoCarrito;
import rf.com.tienda.services.IPedidoCarrito;

@RestController
@RequestMapping("/pedido")
public class PedidoCarritoController {

	@Autowired
	IPedidoCarrito pedidointeface;
	
	
	@GetMapping
	public List<PedidoCarrito> lista()
	{
		return pedidointeface.lista();
	}
	
	
	@PostMapping
	public PedidoCarrito insertaPedido(@RequestBody PedidoCarrito pedido)
	{
		
		return pedidointeface.insertaPedido(pedido);
	}
	
	
	@PutMapping
	public PedidoCarrito actualizaPedido(@RequestBody PedidoCarrito pedido)
	{
		return pedidointeface.actualizaPedido(pedido);
	}
	
	
	@DeleteMapping("/{id}")	
	public void eliminaPedido(@PathVariable("id") Integer id )
	{
		
		pedidointeface.eliminaPedido(id);
		
		
	}
	
	
}
