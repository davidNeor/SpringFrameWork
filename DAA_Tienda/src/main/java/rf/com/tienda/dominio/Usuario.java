package rf.com.tienda.dominio;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import rf.com.tienda.exception.DomainException;
import rf.com.tienda.util.ErrorMessages;
import rf.com.tienda.util.Validator;

@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id_usuario;
	@Column(name = "user_nombre", nullable = false)
	private String user_nombre;
	@Column(name = "user_email", nullable = false)
	private String user_email;
	@Column(name = "user_pass", nullable = false)
	private String user_pass;
	@Column(name = "user_tipo", nullable = false)
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



	public void setUser_nombre(String user_nombre) throws DomainException{
		if(Validator.userNombreValido(user_nombre))
		{
			this.user_nombre = user_nombre;

		}
		else
		{
			throw new DomainException(ErrorMessages.USUERR_001);
		}
	}



	public String getUser_email() {
		return user_email;
	}



	public void setUser_email(String user_email)throws DomainException {
		
		if(Validator.userEmailValido(user_email))
		{
			this.user_email = user_email;
		}
		else
		{
			throw new DomainException(ErrorMessages.USUERR_002);
			
		}
		
	}



	public String getUser_pass() {
		return user_pass;
	}



	public void setUser_pass(String user_pass)throws DomainException {
		if(Validator.userPassValido(user_pass))
		{
			this.user_pass = user_pass;
		}
		else
		{
			throw new DomainException(ErrorMessages.USUERR_003);
			
			
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



	public void setUser_dni(String user_dni)throws DomainException {
		
		if(Validator.userDniValido(user_dni))
		{
			this.user_dni = user_dni;
		}
		else
		{
			throw new DomainException(ErrorMessages.USUERR_004);
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
