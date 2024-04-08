package examenintento;

import java.util.Scanner;
import java.util.InputMismatchException;

public class EmpleadoMain {

	public static void main(String[] args) {
		System.out.println("Bienvenid@.");

		int userValue = -1;

		Scanner sc = new Scanner(System.in);
		
		Empleado emp;

		do {
			System.out.println("1. Añadir empleado.");
			System.out.println("2. Listar empleados.");
			System.out.println("3. Modificar horas extra.");
			System.out.println("4. Modificar importe horas extra.");
			System.out.println("5. Eliminar empleado.");
			System.out.println("0. Salir.");
			System.out.println();
			
			System.out.println("Escriba la opción a ejecutar: ");
			
			userValue = sc.nextInt();
			sc.nextLine();

			switch (userValue) {

			case 1:

				try {
					System.out.println("Introduzca el DNI del empleado: ");
					String dniE = sc.nextLine();

					System.out.println("Introduzca el nombre del empleado: ");
					String nombreE = sc.nextLine();

					System.out.println("Introduzca el sueldo base del empleado: ");
					double sueldoBaseE = sc.nextDouble();
					sc.nextLine();

					System.out.println("Introduzca las horas extra del empleado: ");
					int horasExtraE = sc.nextInt();
					sc.nextLine();

					emp = new Empleado(dniE, nombreE, sueldoBaseE, horasExtraE);

					if (ListadoEmpleados.anadirEmpleado(emp)) {
						System.out.println("Empleado añadido correctamente.");
					} else {
						System.out.println("El empleado no pudo ser añadido.");
					}

				} catch (InputMismatchException e) {
					sc.nextLine();
					System.err.println("Error. Has introducido un valor no válido. Saliendo del programa...");
				}
				
				emp = null;
				break;

			case 2:
				ListadoEmpleados.listarEmpleados();
				break;
			case 3:
				try {
					System.out.println("Introduzca el DNI del empleado que desee modificar las horas extra: ");
					String dni = sc.nextLine();

					System.out.println("Introduzca las horas extra que quiera asignar al empleado: ");
					int horasExtra = sc.nextInt();
					sc.nextLine();

					emp = new Empleado(dni);

					if (ListadoEmpleados.modificarHorasExtra(emp, horasExtra)) {
						System.out.println("La modificación de las horas extra se realizó correctamente.");
					} else {
						System.out.println("La modificación de las horas extra no se pudo realizar.");
					}

				} catch (InputMismatchException e) {
					sc.nextLine();
					System.err.println("Error. Has introducido un valor no válido. Saliendo del programa...");
				}
				
				emp = null;
				break;

			case 4:

				try {
					System.out.println("Introduzca el nuevo importe de las horas extra: ");

					double importeDeLasHoras = sc.nextDouble();
					sc.nextLine();

					Empleado.setImporteHoraExtra(importeDeLasHoras);
				} catch (InputMismatchException e) {
					sc.nextLine();
					System.err.println("Error. Has introducido un valor no válido. Saliendo del programa...");
				}
				break;
			
			case 5:
				System.out.println("Introduzca el DNI del empleado a eliminar.");
				String dniEliminar = sc.nextLine();
				
				emp = new Empleado(dniEliminar);
				
				if(ListadoEmpleados.eliminarEmpleado(emp)) {
					System.out.println("Se pudo eliminar al empleado correctamente.");
				} else {
					System.out.println("No se pudo eliminar al empleado.");
				}
				
				emp = null;
				break;
				
			case 0:
				System.out.println("Saliendo del sistema...");
				break;

			}
		} while (userValue != 0);

		sc.close();

	}

}
