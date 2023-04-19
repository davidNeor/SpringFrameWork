package rf.com.tienda.util;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.regex.Pattern;


/********************************************************************************************
 * NOMBRE: Validator.java
 * 
 * DESCRIPCION: 
 * 			Clase auxiliar para validar los datos que sean 
 * 			introducidos en la aplicaci�n.
 * 
 *  @version	30/01/2023 
 *  @author 	Miguel Garcia
 *  
 * ******************************************************************************************/
public class Validator {
	
	private static final String ALFANUMERIC_PATTERN = "^[0-9a-zA-Z]+$";
	
	private static final String PASSWORD_PATTERN = 
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	/**
	 * Patr�n para validar el email, evitando puntos finales antes de la @ y que solo contenga
	 * car�cteres alfanum�ricos		 
	 */
	private final static String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
	/**
	 * Permite verificar que un DNI cumple con el patr�n XX.XXX.XXX-L
	 */
	private final static String DNI_PATTERN = "\\d{2}\\.\\d{3}\\.\\d{3}-[a-zA-Z]";
		
	/**
	 * Permite validar un tel�fono, el cual debe contener de 10 a 20 d�gitos
	 * y donde los espacios est�n permitidos
	 */
	private final static String PHONE_PATTERN =  "[\\d ]{10,20}";
	
	/**
	 * Orden de las letras con las cuales se comprobar� la validez del DNI
	 */
	private final static String LETRA_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
	
	/**
	 * Longitud que debe tener todo DNI pasado a la aplicaci�n.
	 */
	private final static int LONGITUD_DNI = 12;
	
	
	/**
	 * comprobamos que la fecha cumple con el estándar
	 */
	private final static String FECHA_PATTERN="^\\d{2}/\\d{2}/\\d{4}$";
	
	/**
	 * Cumple con todo mayusculas y numeros de longitud 5
	 */
	private final static String CODIGO_PATTERN="^[A-Z]{2}\\d{3}$";
	
	
	
	/* ***************************************************************************************
	 * NOMBRE: isAlfanumeric                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 		Permite verificar que el texto pasado solo contiene caracters alfanum�ricos
	 * 
	 * @param texto String a verificar que solo tenga car�cteres alfanum�ricos
	 * 
	 * @return  true, si cumple solo contiene caracters alfanum�ricos. <br> 
	 * 			false en caso contrario
	 * FECHA: Enero 2023
	 * 
	 * AUTOR: Miguel Garcia - Barcelona
	 * 
	 * **************************************************************************************/
	public static boolean isAlfanumeric(String texto){
		Pattern pattern = Pattern.compile(ALFANUMERIC_PATTERN);

		
		
		if(pattern.matches(ALFANUMERIC_PATTERN, texto))
		{
			return true;

		}
		else
		{
			return false;
		}
	}
	
	public static boolean isVacio( String prueba ){
		if(prueba==null||prueba.isEmpty())
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	/* ***************************************************************************************
	 * NOMBRE: cumplePhoneNumber                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 		El phone number debe tener un total de entre 10 y 20, contando d�gitos y espacios.
	 * 		M�nimo aceptable son 10 d�gitos.
	 * 
	 * @param phoneNumber String con el n�mero de telefono de entre 10 y 20 d�gitos. 
	 * 		Puede tener espacios, pero siempre con 10 d�gitos como m�nimo.
	 * 
	 * @return true, si cumple todas las condiciones
	 *
	 * FECHA: Enero 2023
	 * AUTOR: Miguel Garcia
	 * 
	 * **************************************************************************************/
	public static boolean cumplePhoneNumber(String phoneNumber){
		
		Pattern pattern=Pattern.compile(PHONE_PATTERN);
		
		if(pattern.matches(PHONE_PATTERN, phoneNumber))
		{
			return true;

		}
		else
		{
			return false;
		}
		
	}

	/* ***************************************************************************************
	 * NOMBRE: isEmailValido                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 			Comprueba si el email tiene un formato que pueda ser v�lido.
	 * 
	 * @param email String a comprobar
	 * 
	 * @return true, en caso que el formato sea v�lido
	 * FECHA: Enero 2023
	 * 
	 * AUTOR: Miguel Garcia
	 * 
	 * **************************************************************************************/
	public static boolean isEmailValido(String email){
		
		Pattern pattern=Pattern.compile(EMAIL_PATTERN);
		
		if(pattern.matches(EMAIL_PATTERN, email))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	/* ***************************************************************************************
	 * NOMBRE: cumpleDNI                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 			Esta funci�n verifica que el DNI cumple el siguiente formato: xx.xxx.xxx-L <br>
	 * 			El DNI ha de tener longitud 12
	 * 
	 * @param dni String con DNI a ser validado
	 * 
	 * @return true, si el DNI cumple el estandar nacional.
	 * FECHA: Enero 2023
	 * AUTOR: Miguel Garcia
	 * 
	 * **************************************************************************************/
	public static boolean cumpleDNI(String dni){
		
		Pattern pattern=Pattern.compile(DNI_PATTERN);
		boolean cumple=false;
		if(pattern.matches(DNI_PATTERN, dni))
		{
			//si cumple la expresión regular vamos a ver si el modulo de la cifra  se corresponde con la letra, por lo que vamos a sacar los números de la cadena
			String cifra="";
			String letra="";
			
			
			//extraemos los números y la letra del dni
			for(int i=0;i<dni.length();i++)
			{
				if(Character.isDigit(dni.charAt(i)))
				{
					cifra +=dni.charAt(i);
				}
				
				if(Character.isLetter(dni.charAt(i)))
				{
					letra+=dni.charAt(i);
				}	
			
			
			}
			
			//sacamos el modulo de la cifra
			int Numero=Integer.parseInt(cifra);
			int numLetra=Numero%23;
			//comparamos si el numLetra coincide con la posicion de la cadena
			Character Mayuscula=Character.toUpperCase(letra.charAt(0));
			if(Mayuscula==LETRA_DNI.charAt(numLetra))
			{
				cumple=true;
			}
			
		}
		
		return cumple;
		
		
		
	}
	

	/** ***************************************************************************************
	 * NOMBRE: cumpleRango                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 		Comprueba que un N�mero se necuentra entre 2 valores
	 * 
	 * @param valor (int)/(double) N�mero a comprobar
	 * @param valorMinimo (int) N�mero valor aceptable
	 * @param valorMaximo (int) M�N�mero valor aceptable
	 * 
	 * @return true si valorMinimo > valor > valorMaximo
	 * FECHA: Enero 2023
	 * AUTOR: Miguel Garcia 
	 * 
	 * **************************************************************************************/
	public static boolean cumpleRango(
			int valor, 
			int valorMinimo,
			int valorMaximo){
		
		if(valor>valorMinimo&&valor<valorMaximo)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
	
	public static boolean cumpleRango(
			double valor, 
			int valorMinimo,
			int valorMaximo){
		
		//parseamos el double a entero
		int valorParseado=(int)valor;
		if(valorParseado>valorMinimo&&valorParseado<valorMaximo)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}


	/* ***************************************************************************************
	 * NOMBRE: cumpleLongitudMin                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 		Comprobar que el texto pasado tiene una longitud de al menos x caracteres, siendo
	 * 		x el entero pasado como par�metro
	 * 
	 * @param texto String texto a comprobar
	 * @param longitudMinima int que indique longitud m�nima.
	 * 
	 * @return cierto, si la longitud del texto es mayor o igual que longitudMinima
	 * FECHA: Enero 2023
	 * AUTOR: Miguel Garcia
	 * 
	 * **************************************************************************************/
	public static boolean cumpleLongitudMin(
			String texto, 
			int longitudMinima){
		
		if(texto.length()>=longitudMinima)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}


	/* ***************************************************************************************
	 * NOMBRE: cumpleLongitudMax                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 		Comprobar que el texto pasado tiene una longitud de, como mucho, x caracteres, siendo
	 * 		x el entero pasado como par�metro
	 * 
	 * @param texto String con el texto a comprobar
	 * @param longitudMaxima int con la longitud m�xima del texto
	 * 
	 * @return true, si el texto es menor o igual que la longitud m�xima.
	 * FECHA: Enero 2023 
	 * AUTOR: Miguel Garcia 
	 * 
	 * **************************************************************************************/
	public static boolean cumpleLongitudMax(
			String texto, 
			int longitudMaxima){
		
		if(texto.length()<=longitudMaxima)
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}


	/****************************************************************************************
	 * NOMBRE: cumpleLongitud                                                                 *
	 * 
	 * DESCRIPCI�N: *//**
	 * 		Comprobar que la longitud de un texto se encuentra entre unos valores m�ximos y m�nimos 
	 * 
	 * @param texto String con el texto que a validar
	 * @param longitudMinima (int) M�nima longitud del texto
	 * @param longitudMaxima (int) M�xima longitud v�lida para el texo
	 * 
	 * @return true, si la longitud del texto cumple: longitudMinima
	 *               <= longitudTexto <=longitudMaxima
	 * FECHA: Enero 2023 
	 * AUTOR: Miguel Garcia - Barcelona
	 * 
	 * **************************************************************************************/
	public static boolean cumpleLongitud(
			String texto, 
			int longitudMinima, 
			int longitudMaxima){
		
		if(texto.length()>=longitudMinima&&texto.length()<=longitudMaxima)
		{
			return true;
		}
		else
		{
			return false;
		}

		
		

	}
	/**
	 * Valida una fecha calendar con m�nimo min
	 * @param fecha
	 * @param min
	 * @return
	 */
	
	public static boolean valDateMin(LocalDate fecha, LocalDate min){
		//entiendo que hay que comprobar si la fecha es mayor que la mínima
		
		if(fecha.isAfter(min))
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
		
	}
	
	/**
	 * Valida una fecha calendar con m�ximo max
	 * @param fecha
	 * @param max
	 * @return
	 */
	public static boolean valDateMax(LocalDate fecha, LocalDate max){
		//comprobar si la fecha es anterior a la fecha máxima
		
		if(fecha.isBefore(max))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}	
	
	/**
	 * esFechaValida
	 * Recibe una string con formato fecha dd/mm/aaaa y comprueba el formato
	 * @param fecha
	 * @return
	 */
	public static boolean esFechaValida(String fecha){
		//compruebo si la cadena tiene la cantidad de digitos para cumplir con el estándar y luego veo si los valores són validos
		boolean valido=false;
		Pattern pattern=Pattern.compile(FECHA_PATTERN);
		
		if(pattern.matches(FECHA_PATTERN, fecha))
		{
			String numeros[]=new String[3];
			String cadena="";
			int posArray=0;
			//en la posición 0 tendremos los dias, en la 1 los meses y en la 2 los años
			for(int i=0;i<fecha.length();i++)
			{
				if(fecha.charAt(i)!='/')
				{
					cadena+=fecha.charAt(i);
				}
				else if(i==(fecha.length()-1))
				{
					cadena+=fecha.charAt(i);
					numeros[posArray]=cadena;
					posArray++;
					
				}
				else
				{
					numeros[posArray]=cadena;
					cadena="";
					posArray++;
				}
			}
			
			if (!cadena.isEmpty()) {
			    numeros[posArray] = cadena;
			}
			
			//ahora ya tenemos cada cosa por separado y podemos comprobar
			//primero los dias,pero primero los parseamos
			int dias=Integer.parseInt(numeros[0]);
			if(dias<1||dias>31)
			{
				return false;
			}
			//recuperamos los meses
			int meses=Integer.parseInt(numeros[1]);
			if(meses<1||meses>12)
			{
				return false;
			}
			//recuperamos los años
			
			int años=Integer.parseInt(numeros[2]);
			
					
			if(años<1)
			{
				return false;
			}
			else
			{
				valido=true;
			}
			
			
			
			
		}
		
		return valido;
		
		
	}
	
	/**
	 * Nombre esPasswordValida
	 * Descripcion Comprueba que la cadena recibida cumpla con lasnormas de contrase�a
	 * @param password string con la contrase�a introducida
	 * @return true si cumple con las especificaciones
	 */
	public static boolean esPasswordValida(String password){
		
		Pattern pattern=Pattern.compile(PASSWORD_PATTERN);
		if(pattern.matches(PASSWORD_PATTERN, password))
		{
			
			return true;
		}
		else
		{
			return false;
		}
		
		
		

	}
	
	
	/*
	 * a partir de aquí empiezan los métodos de las tablas
	 */
	/* ****************************************************************************
	 * TABLA PRODUCTOS
	 * ****************************************************************************/
	/**
	 * Campo: id_producto
	 * 
	 * Descripción: Comprueba que solo haya mayúsculas y números
	 * @param codigo de producto string
	 * @return true si cumple las especificaciones
	 * 
	 */
	
	public static boolean esIdProductoValido(String codigo)
	{
		
		Pattern pattern=Pattern.compile(CODIGO_PATTERN);
		
		if(pattern.matches(CODIGO_PATTERN, codigo))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	
	/**
	 * Campo: pro_descripcion
	 * Descripción: comprueba la longitud de la descripción corta
	 * @param descripcion string
	 * @return true si la cumple con la longitud
	 * 
	 * */
	public static boolean esDEscripcionValida(String desc)
	{
		if(cumpleLongitud(desc, 5, 100))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Campo: pro_desLarga
	 * Descripción: comprueba la longitud de la descripción larga
	 * @param descripcion string
	 * @return true si la cumple con la longitud
	 * 
	 * */
	
	public static boolean esDesLargaValida(String desc)
	{
		
		if(cumpleLongitud(desc, 5, 2000))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	
	/**
	 * Campo: pro_precio
	 * Descripción: el precio del producto
	 * @param precio double
	 * @return true si el precio cumple con el formato(2 decimales)
	 */
	
	
	public static boolean proPRecioValido(double precio)
	{
		
			//comprobamos si cumple el rango
			if(cumpleRango(precio, 0, 100))
			{
				return true;
			}
			else
			{
				return false;
			}
		
		
		
	}
	
	
	/**
	 * Campo:  pro_fecRepos
	 * Descripción: fecha prevista de reposición
	 * @param fecha LocalDate
	 * @return true sila fecha de reposición es mayor que la actual
	 */
	
	
	public static boolean proFecRepos(LocalDate repos)
	{
		LocalDate fechaActual=LocalDate.now();
		if(valDateMax(fechaActual, repos))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Campo: pro_fecActi
	 * Descripción: fecha de activación del producto
	 * @param fecha de activación LocalDate
	 * @return true si la fecha de activación es mayor que la actual
	 */

	public static boolean proFecActivacion(LocalDate fecAct)
	{
		LocalDate fechaActual=LocalDate.now();
		if(valDateMax(fechaActual, fecAct))
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
		
	}
	/**
	 * Campo: pro_fecDesacti
	 * Descripción: Fecha de desactivación del producto
	 * @param fecha desactivacion LocalDate
	 * @param fechac activación LocalDate que por defecto sera null
	 * @return true si la fecha de desactivación es mayor que la actual en caso que la fecha de 
	 * activacion sea null, y mayor que la fecha de activacion en caso contrario
	 */
	
	public static boolean proFecDesactivacion(LocalDate fecDesac, LocalDate fecAct)
	{
		
		if(fecDesac.isAfter(fecAct))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	public static boolean proFecDesactivacion(LocalDate fecDesac)
	{
		
		LocalDate actual=LocalDate.now();
		if(fecDesac.isAfter(actual))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * Campo: pro_stat
	 * Descripción: Estado
	 * @param estado Character
	 * @return true si el carácter es A o B
	 */
	
	
	/* ****************************************************************************
	 * TABLA USUARIOS
	 * ****************************************************************************/
	
	/**
	 * Campo: user_nombre
	 * Descripción: Nombre de usuario
	 * @param nombre string
	 * @return true si el nombre cumple el rango de longitud(5,100)
	 */
	
	public static boolean userNombreValido(String nomb)
	{
		if(cumpleLongitud(nomb, 5, 100))
		{
			return true;
		}
		else
		{
			return false;
		}
	}


	/**
	 * Campo: user_email
	 * Descripción: Correo electrónico
	 * @param correo string
	 * @return true si el correo es válido
	 */
	
	
	public static boolean userEmailValido(String correo)
	{
		
		boolean cumple=false;
		if(isEmailValido(correo))
		{
			//comprobamos tb que la longitud esté entre 5 y 100, ambos inclusive
			if(cumpleLongitud(correo, 5, 100))
			{
				cumple=true;
			}
		}
		
		return cumple;
		
	}
	
	/**
	 * Campo: user_pass
	 * Descripción: Contraseña del usuario
	 * @param contraseña string 
	 * @return true si la contraseña cumple las condiciones(minimo 1 número,1 letra min y otra mayuscula y un carácter especial) y con longitud mínima
	 */
	
	
	public static boolean userPassValido(String pass)
	{
		boolean valido=false;
		//primero comprbamos la longitud
		if(cumpleLongitud(pass, 8, 20))
		{
			if(esPasswordValida(pass))
			{
				valido=true;
			}
		}
		
		return valido;
		
	}
	
	/**
	 * Campo: user_dni
	 * Descripción: dni de usuario
	 * @param dni string 
	 * @return true si cumple el filtro de dni
	 */
	
	public static boolean userDniValido(String dni )
	{
		if(cumpleDNI(dni))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	/**
	 * Campo: user_fecAlta
	 * Descripción: comprueba la fecha de alta coincide con la actual
	 * @param fecha LocalDate
	 * @return true si la fecha coincide con la actual
	 */
	
	public static boolean userFecAlta(LocalDate fec)
	{
		LocalDate hoy=LocalDate.now();
		
		
		if(hoy.equals(fec))			
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	/**
	 * Campo: user_fecConfirmacion
	 * Descripción: Comprueba que la fecha de confirmación sea la de hoy
	 * @param fecha LocalDate
	 * @return 
	 * 
	 */
	 public static boolean userFecConfirmacion(LocalDate fec)
	 {
		 
		 	LocalDate hoy=LocalDate.now();
			
			
			
			if(hoy.equals(fec))			
			{
				return true;
			}
			else
			{
				return false;
			}
		 
		 
		 
	 }
	

		/* ****************************************************************************
		 * TABLA CATEGORIA
		 * ****************************************************************************/
	
	 /**
	  * Campo: cat_nombre
	  * Descripción: nombre de la categría
	  * @param nombre string
	  * @return true si la longitud si cumple la longitud(5,50)
	  */
	
	 
	 public static boolean catNombreValido(String cat)
	 {
		 
		 if(cumpleLongitud(cat, 5, 50))
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
		 
		 
	 }
	 
	 /* ****************************************************************************
	  * TABLA PEDIDO/CARRITO
	  * ****************************************************************************/
	 
	 /**
	  * Campo: car_cantidad
	  * Descripción: cantidad de productos que hay en una linea de producto
	  * @param cantidad int
	  * @return true 
	  * 
	  */
	 
	  	
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 /**
	  * Campo: car_feCadud
	  * Descripción: fecha de caducidad de la tarjeta de crédito
	  * @param fecha LocalDate
	  * @return true si la fecha de caducidad es mayor a la actual
	  */
	 
	 
	 public static boolean carFeCadudValida(LocalDate fecha)
	 {
		 LocalDate hoy=LocalDate.now();
		 
		 if(fecha.isAfter(hoy))
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
		 
		 
	 }
	 
	 
	 
	
	
}
