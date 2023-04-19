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
	//CORREOS
	private static final String CORREO="juahkas@gmail.com";
	private static final String CORREO2="juahkas@gmail";
	private static final String CORREO3="@gmail.com";
	//CONTRASEÑAS
	private static final String PASSWORD="ASegura12@";
	private static final String PASSWORD2="ASegura12";
	private static final String PASSWORD3="seegura12@";
	//DNI
	private static final String DNI="34.567.897-R";
	private static final String DNI2="34.567.897-Z";
	private static final String DNI3="34567.897-R";

	
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

	
	@Test
	void setUser_emailTest()throws DomainException
	{
		user.setUser_email(CORREO);
		assertEquals(user.getUser_email(), CORREO );
		
	}
	
	
	@Test
	void setUser_emailTest2()throws DomainException
	{

		Assertions.assertThrows(DomainException.class,()->{
			user.setUser_email(CORREO2);
		});
		
		
	}
	
	
	@Test
	void setUser_emailTest3()throws DomainException
	{

		Assertions.assertThrows(DomainException.class,()->{
			user.setUser_email(CORREO3);
		});
		
		
	}
	
	
	
	@Test 
	void setUser_passTest()throws DomainException
	{
		user.setUser_pass(PASSWORD);
		assertEquals(user.getUser_pass(), PASSWORD);
		
		
	}
	
	
	@Test 
	void setUser_passTest2()throws DomainException
	{
		Assertions.assertThrows(DomainException.class,()->{
			user.setUser_pass(PASSWORD2);
		});
		
		
		
	}
	
	
	

	@Test 
	void setUser_passTest3()throws DomainException
	{
		Assertions.assertThrows(DomainException.class,()->{
			user.setUser_pass(PASSWORD3);
		});
		
		
		
	}
	
	
	
	@Test
	void setUser_dniTest()throws DomainException
	{
		user.setUser_dni(DNI);
		assertEquals(user.getUser_dni(), DNI);
		
		
	}
	
	

	@Test
	void setUser_dniTes2()throws DomainException
	{

		Assertions.assertThrows(DomainException.class,()->{
			user.setUser_dni(DNI2);
		});
		
		
	}
	
	
	

	@Test
	void setUser_dniTes3()throws DomainException
	{

		Assertions.assertThrows(DomainException.class,()->{
			user.setUser_dni(DNI3);
		});
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
