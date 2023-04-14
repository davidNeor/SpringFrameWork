package rf.com.tienda.interfaces.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import rf.com.tienda.dominio.Usuario;

public interface IUsuario extends JpaRepository<Usuario, Integer> {

}
