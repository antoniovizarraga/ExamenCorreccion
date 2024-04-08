package examenintento;

public class Empleado {

	private String dni = "";

	private String nombre = "";

	private double sueldoBase;

	private int horasExtra;

	private static double importeHoraExtra;

	public Empleado(String dni) {
		if (dni != null && !dni.equals("")) {
			this.dni = dni;
		}

	}

	public Empleado(String dni, String nombre, double sueldoBase, int horasExtra) {
		if (dni != null && !dni.equals("")) {
			this.dni = dni;
		}

		if (nombre != null && !nombre.equals("")) {
			this.nombre = nombre;
		}

		if (sueldoBase > 0) {
			this.sueldoBase = sueldoBase;
		}

		if (horasExtra > 0) {
			this.horasExtra = horasExtra;
		}
	}

	public String getDni() {
		return this.dni;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		if (sueldoBase > 0) {
			this.sueldoBase = sueldoBase;
		}
	}

	public int getHorasExtra() {
		return horasExtra;
	}

	public void setHorasExtra(int horasExtra) {
		if (horasExtra > 0) {
			this.horasExtra = horasExtra;
		}
	}

	public static double getImporteHoraExtra() {
		return importeHoraExtra;
	}

	public static void setImporteHoraExtra(double importeHoraExtra) {
		if (importeHoraExtra > 0) {
			Empleado.importeHoraExtra = importeHoraExtra;
		}
	}

	public String getNombre() {
		return nombre;
	}
	
	public double calcularComplemento() {
		
		double temp = horasExtra * importeHoraExtra;
		
		return temp;
	}
	
	public double sueldoBruto() {
		double temp = calcularComplemento();
		temp += sueldoBase;
		return temp;
	}
	
	@Override
	public String toString() {
		String textoARetornar = "";
		double sueldo = sueldoBruto();
		
		textoARetornar += dni + " " + nombre + "\n";
		textoARetornar += "Horas Extras: " + horasExtra + "\n";
		textoARetornar += "Sueldo bruto: " + sueldo + "\n";
		
		return textoARetornar;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		
		Empleado e = (Empleado) obj;
		
		if(dni.equals(e.dni)) {
			res = true;
		}
		
		return res;
		
	}
}
