package rf.com.tienda.interfaces.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import rf.com.tienda.dominio.Categoria;

public interface ICategoria extends JpaRepository<Categoria, Integer>{
	
	
	public Categoria getRegistro(int num);
	public List<Categoria> lista(Categoria c);
	public boolean guardar(Categoria c);
}
