package servicios;

import java.util.List;

import daos.Acceso;

public interface IAccesoServicio {
	void crearAcceso(Acceso acceso);
	List<Acceso> leerAcceso(Long id);
	void actualizarAcceso(Acceso acceso);
	void eliminarAcceso(Long id);
}
