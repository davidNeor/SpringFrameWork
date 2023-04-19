package rf.com.tienda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

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
	//PRECIO
	private static final double PRECIO=88.1;
	private static final double PRECIO2=101.1;
	private static final double PRECIO3=0;
	//FECHAS
	private static final LocalDate FECHA=LocalDate.now();  //fecha actual
	private static final LocalDate FECHA2=LocalDate.of(2023,4,7);  //fecha actual
	private static final LocalDate FECHA3=LocalDate.of(2025,4,19);  //fecha actual
	//CHARACTER
	private static final Character CAR='A';
	private static final Character CAR2='H';
	private static final Character CAR3='a';

	
	
	
	
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
	
	
	@Test
	void setPro_precioTest() throws DomainException
	{
		producto.setPro_precio(PRECIO);
		assertEquals(producto.getPro_precio() , PRECIO);
	}
	
	

	@Test
	void setPro_precioTest2() throws DomainException
	{
		

		Assertions.assertThrows(DomainException.class,()->{
			producto.setPro_precio(PRECIO2);
		});
		
		
	}
	

	@Test
	void setPro_precioTest3() throws DomainException
	{
		

		Assertions.assertThrows(DomainException.class,()->{
			producto.setPro_precio(PRECIO3);
		});
		
		
	}
	
	@Test
	void setPro_fecReposTest()throws DomainException
	{
		producto.setPro_fecRepos(FECHA3);
		assertEquals(producto.getPro_fecRepos(), FECHA3);
		
	}
	
	
	@Test
	void setPro_fecReposTest2()throws DomainException
	{

		Assertions.assertThrows(DomainException.class,()->{
			producto.setPro_fecRepos(FECHA);
		});
		
	}
	
	
	
	@Test
	void setPro_fecActiTest()throws DomainException
	{
		producto.setPro_fecActi(FECHA3);
		assertEquals(producto.getPro_fecActi(), FECHA3);
	}
	

	@Test
	void setPro_fecActiTest2()throws DomainException
	{

		Assertions.assertThrows(DomainException.class,()->{
			producto.setPro_fecActi(FECHA2);
		});
		
	}
	
	
	@Test
	void setPro_fecDesactiTest()throws DomainException
	{
		producto.setPro_fecDesacti(FECHA3);
		assertEquals(producto.getPro_fecDesacti(), FECHA3);

	}
	
	
	
	@Test
	void setPro_statTest()throws DomainException
	{
		producto.setPro_stat(CAR);
		assertEquals(producto.getPro_stat(), CAR);
	}
	
	
	
	@Test
	void setPro_statTest2()throws DomainException
	{

		Assertions.assertThrows(DomainException.class,()->{
			producto.setPro_stat(CAR2);
		});
		
	}
	
	

	@Test
	void setPro_statTest3()throws DomainException
	{

		Assertions.assertThrows(DomainException.class,()->{
			producto.setPro_stat(CAR3);
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
