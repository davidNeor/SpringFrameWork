package rf.com.tienda.dominio;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CollectionTable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Column;
import javax.persistence.ElementCollection;


@Entity
public class PedidoCarrito {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id_pedido;
	@OneToOne
	private Usuario id_usuario;
	//como va a ser una relación one-to-many, lo mejor es implementar este campo mediante una colección, aquí irá una relación one-to-many
	@OneToMany(mappedBy="pedido")
	private List<Producto>producto=new ArrayList<Producto>();
	private int car_cantidad;
	private double car_precio;
	//renombramos los campos de direccion para distinguir los campos 
	@Embedded
	 @AttributeOverrides({
	        @AttributeOverride(name = "dir_nombre", column = @Column(name = "envio_nombre")),
	        @AttributeOverride(name = "dir_direccion", column = @Column(name = "envio_direccion")),
	        @AttributeOverride(name = "dir_poblacion", column = @Column(name = "envio_poblacion")),
	        @AttributeOverride(name = "dir_cPostal", column = @Column(name = "envio_cPostal")),
	        @AttributeOverride(name = "dir_provincia", column = @Column(name = "envio_provincia")),
	        @AttributeOverride(name = "dir_pais", column = @Column(name = "envio_pais")),
	        @AttributeOverride(name = "dir_correoE", column = @Column(name = "envio_correoE"))	        
	    })
	private Direccion car_envio;
	@Embedded
	@AttributeOverrides({
        @AttributeOverride(name = "dir_nombre", column = @Column(name = "pago_nombre")),
        @AttributeOverride(name = "dir_direccion", column = @Column(name = "pago_direccion")),
        @AttributeOverride(name = "dir_poblacion", column = @Column(name = "pago_poblacion")),
        @AttributeOverride(name = "dir_cPostal", column = @Column(name = "pago_cPostal")),
        @AttributeOverride(name = "dir_provincia", column = @Column(name = "pago_provincia")),
        @AttributeOverride(name = "dir_pais", column = @Column(name = "pago_pais")),
        @AttributeOverride(name = "dir_correoE", column = @Column(name = "pago_correoE"))	        
    })
	private Direccion car_pago;
	private String car_tarjeta;
	private LocalDate car_feCadud;
	private int car_ccv;
	private String car_nombre;
	private int car_stat;
	@ElementCollection(fetch=FetchType.LAZY)
	@CollectionTable(name="TABLA_FECHAS")
	private List<String> car_feCambio;
	
	
	
	


	public PedidoCarrito() {
		
	}



	public int getId_pedido() {
		return id_pedido;
	}



	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}





	public Usuario getId_usuario() {
		return id_usuario;
	}



	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}



	


	


	public List<Producto> getProducto() {
		return producto;
	}



	public void setProducto(List<Producto> producto) {
		this.producto = producto;
	}



	public int getCar_cantidad() {
		return car_cantidad;
	}



	public void setCar_cantidad(int car_cantidad) {
		this.car_cantidad = car_cantidad;
	}



	public double getCar_precio() {
		return car_precio;
	}



	public void setCar_precio(double car_precio) {
		this.car_precio = car_precio;
	}



	public Direccion getCar_envio() {
		return car_envio;
	}



	public void setCar_envio(Direccion car_envio) {
		this.car_envio = car_envio;
	}



	public Direccion getCar_pago() {
		return car_pago;
	}



	public void setCar_pago(Direccion car_pago) {
		this.car_pago = car_pago;
	}



	public String getCar_tarjeta() {
		return car_tarjeta;
	}



	public void setCar_tarjeta(String car_tarjeta) {
		this.car_tarjeta = car_tarjeta;
	}



	public LocalDate getCar_feCadud() {
		return car_feCadud;
	}



	public void setCar_feCadud(LocalDate car_feCadud) {
		this.car_feCadud = car_feCadud;
	}



	public int getCar_ccv() {
		return car_ccv;
	}



	public void setCar_ccv(int car_ccv) {
		this.car_ccv = car_ccv;
	}



	public String getCar_nombre() {
		return car_nombre;
	}



	public void setCar_nombre(String car_nombre) {
		this.car_nombre = car_nombre;
	}



	public int getCar_stat() {
		return car_stat;
	}



	public void setCar_stat(int car_stat) {
		this.car_stat = car_stat;
	}



	public List<String> getCar_feCambio() {
		return car_feCambio;
	}



	public void setCar_feCambio(List<String> car_feCambio) {
		this.car_feCambio = car_feCambio;
	}



	@Override
	public String toString() {
		return "PedidoCarrito [id_pedido=" + id_pedido + ", id_usuario=" + id_usuario + ", producto=" + producto
				+ ", car_cantidad=" + car_cantidad + ", car_precio=" + car_precio + ", car_envio=" + car_envio
				+ ", car_pago=" + car_pago + ", car_tarjeta=" + car_tarjeta + ", car_feCadud=" + car_feCadud
				+ ", car_ccv=" + car_ccv + ", car_nombre=" + car_nombre + ", car_stat=" + car_stat + ", car_feCambio="
				+ car_feCambio + "]";
	}
	
	
	
	
	
	
	
}
