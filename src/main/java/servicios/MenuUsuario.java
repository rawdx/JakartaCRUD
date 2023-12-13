package servicios;

import java.util.Scanner;

public class MenuUsuario implements IMenu {

	@Override
	public int mostrarMenu() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nAdministrador de usuarios");
		System.out.println("--------------------------");
		System.out.println("1. Crear nuevo usuario");
		System.out.println("2. Mostrar datos de un usuario");
		System.out.println("3. Mostrar los datos de todos los usuarios");
		System.out.println("4. Actualizar datos de un usuario");
		System.out.println("5. Eliminar usuario");
		System.out.println("6. Salir");
		System.out.print("\nElige una opción: ");
		
		int opcion = sc.nextInt();
		
		while(opcion < 1 || opcion > 6) {
			System.out.println("[Error] Introduce un numero válido.");
			opcion = sc.nextInt();
		}
		return opcion;
	}
	
}
