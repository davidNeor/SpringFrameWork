package rf.com.tienda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import rf.com.tienda.dominio.Producto;
import rf.com.tienda.exception.DomainException;
import rf.com.tienda.util.ErrorMessages;
import rf.com.tienda.util.Validator;

@SpringBootTest
public class ProductoTest {

	
	//ID de producto
	private static final String ID1="AD345";
	private static final String ID2="ADDASASAS345";
	//DESCRIPCION
	private static final String DESCRIPCION="primera descripción para ver si cumple";
	private static final String DESCRIPCION2="primera descripción para ver si cumple, esta no cumple porque es más larga, así que vamos a ver si esta sabemos que no cumple,asi que seguimos escribiendo a ver si llegamos a los 100 caracteres";
	private static final String DESCRIPCION3="hola";

	
	
	
	
	
	private static Producto producto;
	
	
	@BeforeAll
	 static void  inicio()
	{
		producto=new Producto();
	}
	
	
	@Test
	void setId_productoTest() throws DomainException
	{
		 producto.setId_producto(ID1);
		 assertEquals(producto.getId_producto(), ID1);
		
	}
	
	

	@Test
	void setId_productoTest2() throws DomainException
	{

		Assertions.assertThrows(DomainException.class,()->{
			producto.setId_producto(ID2);
		});
		
	}
	
	
	@Test
	void setPro_descripcionTest() throws DomainException
	{
		
		producto.setPro_descripcion(DESCRIPCION);
		assertEquals(producto.getPro_descripcion(), DESCRIPCION);
		
	}
	
	
	@Test
	void setPro_descripcionTest2() throws DomainException
	{
		
		Assertions.assertThrows(DomainException.class,()->{
			producto.setPro_descripcion(DESCRIPCION2);
		});
		
	}
	
	

	@Test
	void setPro_desLargaTest() throws DomainException
	{
		
		producto.setPro_desLarga(DESCRIPCION2);
		assertEquals(producto.getPro_desLarga(), DESCRIPCION2);
		
	}
	
	

	@Test
	void setPro_desLargaTes2t() throws DomainException
	{
		

		Assertions.assertThrows(DomainException.class,()->{
			producto.setPro_desLarga(DESCRIPCION3);
		});
		
	}
	
	
	
	
	
	
	
	
	/*
	 * public void setId_producto(String id_producto) throws DomainException  {
		
		if(Validator.esIdProductoValido(id_producto))
		{
			this.id_producto = id_producto;
		}
		else
		{
			throw new DomainException(ErrorMessages.PROERR_002);
		}
		
	}

	 */
	
	
	
	
}
