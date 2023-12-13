package servicios;

import java.util.List;

import daos.Acceso;

public interface IGestionAcceso {
	void insertarAcceso(Acceso acceso);
	List<Acceso> leerAcceso(Long id);
	void actualizarAcceso(Acceso acceso);
	void eliminarAcceso(Long id);
}
