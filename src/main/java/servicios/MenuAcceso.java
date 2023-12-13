package servicios;

import java.util.Scanner;

public class MenuAcceso implements IMenu {

	@Override
	public int mostrarMenu() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nAdministrador de accesos");
		System.out.println("--------------------------");
		System.out.println("1. Crear nuevo tipo de acceso");
		System.out.println("2. Mostrar un acceso");
		System.out.println("3. Mostrar todos los accesos");
		System.out.println("4. Actualizar datos de un acceso");
		System.out.println("5. Eliminar un acceso");
		System.out.println("6. Salir");
		System.out.print("\nElige una opción: ");
		
		int opcion = sc.nextInt();
		
		while(opcion < 1 || opcion > 6) {
			System.err.print("[Error] Introduce un numero válido: ");
			opcion = sc.nextInt();
		}
		return opcion;
	}

}
