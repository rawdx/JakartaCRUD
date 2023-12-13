package controladores;

import java.util.List;

import daos.Acceso;
import daos.Usuario;
import servicios.IAccesoServicio;
import servicios.ImplAcceso;

public class Menu {

	public static void main(String[] args) {
		
		Acceso acceso = new Acceso("Usu","Acceso usuarios biblioteca");
		Acceso acceso2 = new Acceso("Emp","Empleados biblioteca");
		Usuario usuario1 = new Usuario("333333D", "Juan", "Chirivella", "59595959", "holajuan@gmail.com", "1234", true, acceso);

		IAccesoServicio ias = new ImplAcceso();
		ias.crearAcceso(acceso);
		Acceso acceso3 = ias.leerAcceso(2L).get(0);
		System.out.println("deseas actualizar?");
		if(true) {
			acceso3.
			ias.actualizarAcceso(acceso3.get(0));
		}
		ias.actualizarAcceso(acceso3.get(0));
		System.out.println();
	}

}
