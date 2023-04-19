package rf.com.tienda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import rf.com.tienda.dominio.Usuario;
import rf.com.tienda.exception.DomainException;

@SpringBootTest
public class UsuarioTest {
	
	//NOMBRES
	private static final String NOMBRE="JUAN PEDRO";
	private static final String NOMBRE2="TAO";
	private static final String NOMBRE3="JUAN PEDRO MARTINEZ DE IRUJO Y GALAPAGAR BADOLATTO LLAÑEZ RODRIGUEZ GARCIA GALAPAGAR JIMENEZ LOPEZ HERNANDEZ";

	
	private static Usuario user;
	
	
	
	@BeforeAll
	static void inicio()
	{
		user=new Usuario();
		
	}
	
	
	@Test
	void setUser_nombreTest()throws DomainException
	{
		
		user.setUser_nombre(NOMBRE);
		assertEquals(user.getUser_nombre(), NOMBRE);
		
	}

	
	@Test
	void setUser_nombreTest2()throws DomainException
	{
		
		Assertions.assertThrows(DomainException.class,()->{
			user.setUser_nombre(NOMBRE2);
		});
		
		
	}

	@Test
	void setUser_nombreTest3()throws DomainException
	{
		
		Assertions.assertThrows(DomainException.class,()->{
			user.setUser_nombre(NOMBRE3);
		});
		
		
	}

	
	
	
	
	
	

}
