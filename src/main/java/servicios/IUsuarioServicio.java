package servicios;

import daos.Usuario;

public interface IUsuarioServicio {
	void crearUsuario(Usuario Usuario);
	Usuario leerUsuario(Long id);
	void actualizarUsuario(Usuario usuario);
	void eliminarUsuario(Long id);
}
