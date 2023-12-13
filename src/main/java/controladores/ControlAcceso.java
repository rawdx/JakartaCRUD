package controladores;

import java.util.List;
import java.util.Scanner;

import daos.Acceso;
import servicios.GestionAcceso;
import servicios.IGestionAcceso;
import servicios.IMenu;
import servicios.MenuAcceso;;

public class ControlAcceso {

	public static void main(String[] args) {
		try {
			IGestionAcceso gestorAcceso = new GestionAcceso();
			IMenu menu = new MenuAcceso();

			Scanner sc = new Scanner(System.in);

			String codigo = "";
			String descripcion = "";

			int opcion;
			do {
				opcion = menu.mostrarMenu();

				switch (opcion) {
				case 1:
					System.out.print("Introduce el código para el nuevo tipo de acceso: ");
					codigo = sc.nextLine();

					System.out.print("Introduce su descripción: ");
					descripcion = sc.nextLine();

					gestorAcceso.insertarAcceso(new Acceso(codigo, descripcion));
					break;

				case 2:
					System.out.print("Introduce el id del tipo de acceso que quieras mostrar: ");
					System.out.println(gestorAcceso.leerAcceso(sc.nextLong()));
					break;

				case 3:
					List<Acceso> accesos = gestorAcceso.leerAcceso(null);
					
					System.out.println("\nNumero de accesos: " + accesos.size());
					
					for (Acceso acceso : accesos)
						System.out.println(acceso.toString());
					break;

				case 4:
					System.out.print("Introduce el id del tipo de acceso que quieras actualizar: ");

					List<Acceso> listaAcceso = gestorAcceso.leerAcceso(sc.nextLong());

					if (listaAcceso.size() == 1) {
						Acceso acceso = listaAcceso.get(0);

						System.out.print("\nIntroduce un nuevo código: ");
						sc.nextLine();
						acceso.setCodigo(sc.nextLine());

						System.out.print("Introduce una nueva descripción: ");
						acceso.setDescripcion(sc.nextLine());

						gestorAcceso.actualizarAcceso(acceso);
					} else {
						System.err.println("El tipo de acceso no existe.");
					}
					break;

				case 5:
					System.out.print("\nIntroduce el id del tipo de acceso que quieras borrar: ");
					gestorAcceso.eliminarAcceso(sc.nextLong());
					break;
				}
			} while (opcion != 6);

		} catch (Exception e) {
			System.err.println("\nHa ocurrido un error: " + e);
		}
	}
}
