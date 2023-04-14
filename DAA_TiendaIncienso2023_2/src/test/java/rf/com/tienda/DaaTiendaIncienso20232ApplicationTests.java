package rf.com.tienda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Calendar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import rf.com.tienda.util.Validator;

@SpringBootTest
class DaaTiendaIncienso2023ApplicationTests {

	/**PARA ALFANUMERIC Y CORREO VÁLIDO**/
	private static final String CORREO1="123ased6";
	private static final String CORREO2="AEed123ase";
	private static final String CORREO3="@";
	private static final String CORREO4="juasgh@hotmail.com";
	private static final String CORREO5="juasgh@hotmail2.subdominio.com";
	private static final String CORREO6="juasgh@hotmail..com";
	private static final String CORREO7="juasgh@hotmail.c";
	private static final String CORREO8="@hotmail.com";
	private static final String CORREO9="juasgh@";
	private static final String CORREO10="juasgh@.com";
	private static final String CORREO11="juasgh@@hotmail.com";



	
	
	
	/**PARA ES VACIO**/
	private static final String CADENA1="123ased";
	private static final String CADENA2="";
	private static final String CADENA3=null;
	
	/**PARA CUMPLE PHONE NUMBER **/
	
	private static final String TELEFONO1="968123456789";
	private static final String TELEFONO2="968123";
	private static final String TELEFONO3="A123hyt234";
	private static final String TELEFONO4="968 123 456";

	
	
	/**PARA DNI**/
	
	private static final String DNI1="34.876.564-P";
	private static final String DNI2="76.876.564-f";
	private static final String DNI3="76.876.564-X";
	private static final String DNI4="76.876.564z";
	//comprobamos con un dni que tiene más de 12 dígitos
	private static final String DNI5="767.876.564-z";
	
	/**FECHAS**/
	private static final LocalDate FECHA1=LocalDate.of(2023, 4, 11);
	private static final LocalDate FECHA2=LocalDate.of(2023, 4, 10);
	private static final LocalDate FUTURO=LocalDate.of(2023, 5, 1);
	private static final LocalDate HOY=LocalDate.now();
	private static final LocalDate AYER=HOY.minusDays(1);
	private static final LocalDate MAÑANA=HOY.plusDays(1);
	private static final LocalDate FECHA3=LocalDate.of(2023, 10, 2);
	private static final LocalDate FECHA4=LocalDate.of(2023, 2, 2);
	
	
	
	
	

	
	

	
	/**FECHAS EN CADENAS**/
	
	private static final String FECHACADENA1="10/12/2010";
	private static final String FECHACADENA2="00/00/0000";
	private static final String FECHACADENA3="01/13/1020";

	
	/**PASSWORDS**/
	private static final String PASSWORD1="Legalidad2022@";
	private static final String PASSWORD2="pass@";
	private static final String PASSWORD3="123456";
	private static final String PASSWORD4="asd1234@";
	private static final String PASSWORD5="ASD1234@";


	/**CODIGOS DE PRODUCTO**/
	private static final String CODIGO1="AD123";
	private static final String CODIGO2="asE12";
	private static final String CODIGO3="AEE12";
		
	
	/**FRASES**/
	private static final String CATEGORIA1="categoria1";
	private static final String CATEGORIA2="cat2";
	private static final String CATEGORIA3="JhD3rFgK9l0zNc5M6Vx8Q2wAyG7hbItOYXoE1SkUhjkhkadjhskjahsdkjhaksjdhkajshdkjashdkjhaskdjhaksjdhkjashdkjahsdkjhaskd";
	private static final String CATEGORIA4="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque condimentum semper venenatis. Nulla facilisi. Nunc faucibus sollicitudin libero, vel consectetur elit tristique et. Morbi euismod bibendum elit, a elementum erat fermentum ac. Integer a nisi et nulla venenatis pharetra. In venenatis tempor dolor, at feugiat libero finibus vel. Duis tincidunt felis et rhoncus vestibulum. Fusce ultricies ante quam, in malesuada sapien lacinia in. Nullam maximus, elit id sagittis consequat, dolor arcu cursus elit, et eleifend elit nisl at orci. Pellentesque pellentesque volutpat mauris ac venenatis. Sed suscipit ante id diam bibendum, nec sollicitudin turpis hendrerit. Fusce vel libero vitae velit auctor bibendum. Nulla facilisi.";
	private static final String CATEGORIA5="hola";
	private static final String CATEGORIA6="son unas pocas palabras";
	
	/**PRECIOS**/
	private static final double PRECIO1=99.99;
	private static final double PRECIO2=1.01;
	private static final double PRECIO3=100.23;
	private static final double PRECIO4=0.00;
	
	
			
	
	private static Validator va;
	@BeforeAll
	static void setUpBeforeClass()
	{
		va=new Validator();
	}
	
	@Test
	void isAlfanumericTest()
	{
		
		assertEquals(va.isAlfanumeric(CORREO1),true);
		assertEquals(va.isAlfanumeric(CORREO2),true);
		assertEquals(va.isAlfanumeric(CORREO3),false);


	}
	@Test
	void isVacioTest()
	{
		

		assertEquals(va.isVacio(CADENA1),false);
		assertEquals(va.isVacio(CADENA2),true);
		assertEquals(va.isVacio(CADENA3),true);


	}
	
	
	@Test
	void cumplePhoneNumberTest()
	{
		

		assertEquals(va.cumplePhoneNumber(TELEFONO1),true);
		assertEquals(va.cumplePhoneNumber(TELEFONO2),false);
		assertEquals(va.cumplePhoneNumber(TELEFONO3),false);
		assertEquals(va.cumplePhoneNumber(TELEFONO4),true);

	

	}
	
	
	@Test
	void isEmailValidoTest()
	{
		
		
		assertEquals(va.isEmailValido(CORREO4),true);
		assertEquals(va.isEmailValido(CORREO5),true);
		assertEquals(va.isEmailValido(CORREO6),false);
		assertEquals(va.isEmailValido(CORREO7),false);




		
		
	}
	
	@Test
	void cumpleDNI()
	{
		

		assertEquals(va.cumpleDNI(DNI1),true);
		assertEquals(va.cumpleDNI(DNI2),true);
		assertEquals(va.cumpleDNI(DNI3),false);
		assertEquals(va.cumpleDNI(DNI4),false);
		assertEquals(va.cumpleDNI(DNI5),false);


		
		
		
	}
	
	@Test
	void cumpleRangoTest()
	{
		
		assertEquals(va.cumpleRango(10, 5, 11), true);
		assertEquals(va.cumpleRango(10.7, 5, 11), true);
		assertEquals(va.cumpleRango(10, 9, 11), true);
		assertEquals(va.cumpleRango(10.7, 9, 11), true);
		assertEquals(va.cumpleRango(10, 5, 10), false);
		assertEquals(va.cumpleRango(10, 10, 20), false);


		
	}
	
	@Test
	void cumpleLongitudMinTest()
	{
		assertEquals(va.cumpleLongitudMin("hola", 4), true);
		assertEquals(va.cumpleLongitudMin("hola", 3), true);
		assertEquals(va.cumpleLongitudMin("afortunado", 20), false);
		assertEquals(va.cumpleLongitudMin("afortunado", 11), false);

		
		
	}
	
	@Test
	void cumpleLongitudMaxTest()
	{
		assertEquals(va.cumpleLongitudMax("hola", 4), true);
		assertEquals(va.cumpleLongitudMax("hola", 5), true);
		assertEquals(va.cumpleLongitudMax("hola", 3), false);
		assertEquals(va.cumpleLongitudMax("hola", 2), false);

		
		
		
	}
	
	
	@Test
	void cumpleLongitudTest()
	{
		assertEquals(va.cumpleLongitud("hola", 3, 5), true);
		assertEquals(va.cumpleLongitud("hola", 4, 4), true);
		assertEquals(va.cumpleLongitud("hola", 5, 8), false);
		assertEquals(va.cumpleLongitud("hola", 2, 3), false);


		
		
	}
	
	@Test
	void valDateMinTest()
	{
		
		assertEquals(va.valDateMin(FECHA1, FECHA2), true);
		assertEquals(va.valDateMin(FECHA2, FECHA1), false);
		//que pasa si le meto la misma fecha
		assertEquals(va.valDateMin(FECHA1, FECHA1), false);

		
		
		
	}
	
	@Test
	void valDateMaxTest()
	{
		
		assertEquals(va.valDateMax(FECHA2, FECHA1), true);
		assertEquals(va.valDateMax(FECHA1, FECHA2), false);
		//que pasa si le meto la misma fecha
		assertEquals(va.valDateMax(FECHA1, FECHA1), false);

		
		
		
	}
	
	
	@Test
	void esFechaValida()
	{
		

		assertEquals(va.esFechaValida(FECHACADENA1), true);
		assertEquals(va.esFechaValida(FECHACADENA2), false);
		assertEquals(va.esFechaValida(FECHACADENA3), false);
		

		
		
	}
	
	
	@Test
	void esPasswordValidaTest()
	{
		assertEquals(va.esPasswordValida(PASSWORD1), true);
		assertEquals(va.esPasswordValida(PASSWORD2), false);
		assertEquals(va.esPasswordValida(PASSWORD3), false);

		
		
		
	}
	
	
	@Test
	void esIdProductoValidoTest()
	{
		
		assertEquals(va.esIdProductoValido(CODIGO1), true);
		assertEquals(va.esIdProductoValido(CODIGO2), false);
		assertEquals(va.esIdProductoValido(CODIGO3), false);

			
	}
	
	
	@Test
	void esDEscripcionValidaTest()
	{
		
		assertEquals(va.esDEscripcionValida(CATEGORIA6), true);
		assertEquals(va.esDEscripcionValida(CATEGORIA5), false);
		assertEquals(va.esDEscripcionValida(CATEGORIA4), false);

	}
	
	
	@Test
	void esDesLargaValidaTest()
	{
		
		assertEquals(va.esDesLargaValida(CATEGORIA6), true);
		assertEquals(va.esDesLargaValida(CATEGORIA5), false);
		assertEquals(va.esDesLargaValida(CATEGORIA4), true);
	
			
		
		
	}
	
	
	@Test
	void proPRecioValidoTest()
	{
		assertEquals(va.proPRecioValido(PRECIO1), true);
		assertEquals(va.proPRecioValido(PRECIO2), true);
		assertEquals(va.proPRecioValido(PRECIO3), false);
		assertEquals(va.proPRecioValido(PRECIO4), false);

	
		
		
	}

	
	@Test
	void proFecReposTest()
	{
		
		assertEquals(va.proFecRepos(FECHA3), true);
		assertEquals(va.proFecRepos(FECHA4), false);
		assertEquals(va.proFecRepos(FECHA1), false);

		
		
		

		
		
		
	}
	
	@Test
	void proFecActivacionTest()
	{
		
		assertEquals(va.proFecActivacion(FECHA3), true);
		assertEquals(va.proFecActivacion(FECHA4), false);
		assertEquals(va.proFecActivacion(FECHA1), false);

	

		
		
		
	}
	
	
	@Test
	void proFecDesactivacionTest()
	{
		
		
		assertEquals(va.proFecDesactivacion(FECHA1), false);
		assertEquals(va.proFecDesactivacion(FECHA1,FECHA2), true);
		assertEquals(va.proFecDesactivacion(FECHA2), false);
		assertEquals(va.proFecDesactivacion(FECHA2,FECHA1), false);

		
		
		
		
		
	}
	
	
	@Test
	void userEmailValidoTest()
	{
		
		
		
		
		assertEquals(va.userEmailValido(CORREO4), true);
		assertEquals(va.userEmailValido(CORREO5), true);
		assertEquals(va.userEmailValido(CORREO8), false);
		assertEquals(va.userEmailValido(CORREO9), false);
		assertEquals(va.userEmailValido(CORREO10), false);
		assertEquals(va.userEmailValido(CORREO11), false);

		
		
		
	}
	
	
	
	@Test
	void userPassValidoTest()
	{
		
		
		assertEquals(va.userPassValido(PASSWORD1), true);
		assertEquals(va.userPassValido(PASSWORD2), false);
		assertEquals(va.userPassValido(PASSWORD3), false);
		assertEquals(va.userPassValido(PASSWORD4), false);
		assertEquals(va.userPassValido(PASSWORD5), false);


		
		
		
		
	}
	
	@Test
	void userDniValidoTest()
	{
		assertEquals(va.userDniValido(DNI1), true);
		assertEquals(va.userDniValido(DNI2), true);
		assertEquals(va.userDniValido(DNI3), false);
		assertEquals(va.userDniValido(DNI4), false);
		assertEquals(va.userDniValido(DNI5), false);

		
		
		
	}
	
	
	@Test
	void userFecAltaTest()
	{
		
		assertEquals(va.userFecAlta(HOY), true);
		assertEquals(va.userFecAlta(MAÑANA), false);
		assertEquals(va.userFecAlta(AYER), false);


		
	}
	
	
	@Test
	void userFecConfirmacion()
	{
		
		
        assertEquals(va.userFecConfirmacion(HOY), true);
        assertEquals(va.userFecConfirmacion(MAÑANA), false);
        assertEquals(va.userFecConfirmacion(AYER), false);

		
	}
	
	@Test
	void catNombreValidoTest()
	{
		
		
		
		assertEquals(va.catNombreValido(CATEGORIA1), true);
		assertEquals(va.catNombreValido(CATEGORIA2), false);
		assertEquals(va.catNombreValido(CATEGORIA3), false);


		
		
	}
	
	
	@Test
	void carFeCadudValidaTest()
	{
		
		assertEquals(va.carFeCadudValida(FUTURO), true);
		assertEquals(va.carFeCadudValida(HOY), false);
		assertEquals(va.carFeCadudValida(AYER), false);

		
		
	}
	
}