package rf.com.tienda.dominio;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import rf.com.tienda.util.ErrorMessages;
import rf.com.tienda.util.Validator;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_usuario;
	private String user_nombre;
	private String user_email;
	private String user_pass;
	private int user_tipo;
	private String user_dni;
	private LocalDate user_fecAlta;
	private LocalDate user_fecConfirmacion;
	
	
	
	public Usuario() {
		
	}



	public int getId_usuario() {
		return id_usuario;
	}



	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}



	public String getUser_nombre() {
		return user_nombre;
	}



	public void setUser_nombre(String user_nombre) {
		if(Validator.userNombreValido(user_nombre))
		{
			this.user_nombre = user_nombre;

		}
		else
		{
			System.out.println(ErrorMessages.USUERR_001);
		}
	}



	public String getUser_email() {
		return user_email;
	}



	public void setUser_email(String user_email) {
		
		if(Validator.userEmailValido(user_email))
		{
			this.user_email = user_email;
		}
		else
		{
			System.out.println(ErrorMessages.USUERR_002);
		}
		
	}



	public String getUser_pass() {
		return user_pass;
	}



	public void setUser_pass(String user_pass) {
		if(Validator.userPassValido(user_pass))
		{
			this.user_pass = user_pass;
		}
		else
		{
			System.out.println(ErrorMessages.USUERR_003);
		}
		
	}



	public int getUser_tipo() {
		return user_tipo;
	}



	public void setUser_tipo(int user_tipo) {
		this.user_tipo = user_tipo;
	}



	public String getUser_dni() {
		return user_dni;
	}



	public void setUser_dni(String user_dni) {
		
		if(Validator.userDniValido(user_dni))
		{
			this.user_dni = user_dni;
		}
		else
		{
			System.out.println(ErrorMessages.USUERR_004);
		}
	}



	public LocalDate getUser_fecAlta() {
		return user_fecAlta;
	}



	public void setUser_fecAlta(LocalDate user_fecAlta) {
		
		if(Validator.userFecAlta(user_fecAlta))
		{
			this.user_fecAlta = user_fecAlta;
		}
		else
		{
			System.out.println(ErrorMessages.USUERR_005);
		}
		
	}



	public LocalDate getUser_fecConfirmacion() {
		return user_fecConfirmacion;
	}



	public void setUser_fecConfirmacion(LocalDate user_fecConfirmacion) {
		
		if(Validator.userFecConfirmacion(user_fecConfirmacion))
		{
			this.user_fecConfirmacion = user_fecConfirmacion;
		}
		else
		{
			System.out.println(ErrorMessages.USUERR_005);
		}
		
	}



	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", user_nombre=" + user_nombre + ", user_email=" + user_email
				+ ", user_pass=" + user_pass + ", user_tipo=" + user_tipo + ", user_dni=" + user_dni + ", user_fecAlta="
				+ user_fecAlta + ", user_fecConfirmacion=" + user_fecConfirmacion + "]";
	}
	
	
	

	
}
