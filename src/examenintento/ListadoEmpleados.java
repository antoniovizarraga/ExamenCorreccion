package examenintento;

public class ListadoEmpleados {
	static private Empleado[] listaEmpleados = new Empleado[10];

	static public int posicionLibre() {
		int posicion = -1;
		int i = 0;

		while (i < listaEmpleados.length && listaEmpleados[i] != null) {
			i++;
		}

		if (i < listaEmpleados.length) {
			posicion = i;
		}

		return posicion;
	}

	static public int buscaEmpleado(Empleado e) {
		int posicion = -1;
		int i = 0;
		
		// Quizás haya que comprobar primero que no valga null?

		while (listaEmpleados == null && listaEmpleados[i] != e && i < listaEmpleados.length) {
			i++;
		}

		if (i < listaEmpleados.length) {
			posicion = i;
		}

		return posicion;
	}

	static public void listarEmpleados() {
		for (Empleado e : listaEmpleados) {
			if (e != null) {
				System.out.println(e);
				System.out.println("-----------------");
			}

		}
	}

	static public boolean anadirEmpleado(Empleado emp) {
		boolean res = false;

		if (buscaEmpleado(emp) != -1) {
			int posicion = posicionLibre();

			if (posicion != -1) {
				listaEmpleados[posicion] = emp;
				res = true;
			}
		}

		return res;
	}

	static public boolean modificarHorasExtra(Empleado emp, int horas) {
		boolean res = false;
		
		int posicion = buscaEmpleado(emp);

		if (posicion != -1) {
			listaEmpleados[posicion].setHorasExtra(horas);
			res = true;
		}

		return res;
	}

	static public boolean eliminarEmpleado(Empleado emp) {
		boolean res = false;
		
		int posicion = buscaEmpleado(emp);
		
		if(posicion != -1) {
			listaEmpleados[posicion] = null;
			res = true;
		}
		
		return res;
	}
}
