package rf.com.tienda;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import rf.com.tienda.dominio.Producto;
import rf.com.tienda.exception.DomainException;
import rf.com.tienda.util.ErrorMessages;
import rf.com.tienda.util.Validator;

@SpringBootTest
public class ProductoTest {

	
	
	
	private static Producto producto;
	
	
	@BeforeAll
	 static void  inicio()
	{
		producto=new Producto();
	}
	
	
	@Test
	void setId_productoTest() throws DomainException
	{
		
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
