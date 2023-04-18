package rf.com.tienda;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import rf.com.tienda.dominio.Categoria;
import rf.com.tienda.exception.DomainException;

@SpringBootTest
public class CategoriaTest {

	
	private static final String NOMBRE_CATEGORIA="este es válido";
	private static final String NOMBRE_ERRROR="1234565878127878798738172817238782179827871873289719827381783798178237198732897128931987289739812739872837198273987128937189278317987329817983";
	private static final String NOMBRE_ERROR2="MAL";

	
	private static Categoria cat;
	
	@BeforeAll
	static void inicio()
	{
		cat=new Categoria();
		
	}
	
	
	@Test
	void setCat_nombreTest()throws DomainException
	{
		cat.setCat_nombre(NOMBRE_CATEGORIA);
		assertEquals(cat.getCat_nombre(),NOMBRE_CATEGORIA );
	}
	
	@Test
	void setCat_nombreTest2()throws DomainException
	{

		Assertions.assertThrows(DomainException.class,()->{
			cat.setCat_nombre(NOMBRE_ERROR2);
		});
	}
	
	
	
	@Test
	void setCat_nombreTest3()throws DomainException
	{
		
		Assertions.assertThrows(DomainException.class,()->{
			cat.setCat_nombre(NOMBRE_ERRROR);
		});
	}
	
	
	
	
}
