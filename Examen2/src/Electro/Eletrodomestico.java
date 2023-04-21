package Electro;
/**
 * 
 */

/**
 * @author Charl
 *
 */
public abstract class Eletrodomestico {

	// Constantes
	private static final char[] consumoELetras = new char[] { 'A', 'B', 'C', 'D', 'E', 'F' };
	private static final String[] colorPermi = new String[] { "BLANCO", "NEGRO", "ROJO", "AZUL", "GRIS" };
	private static final int pesoD = 5;
	private static final int precioBaseD = 100;
	private static final int consumoEnergD = 'F';

	// Atributos
	private String nombre;
	private String color;
	private int precioBase;
	private char consumoEnerg;
	private int peso;
	private static int cont = 0;
	private int codigo;

	public Eletrodomestico(String nombre) {
		this.setNombre(nombre);
		this.codigo = ++cont;
	}

	public Eletrodomestico(String nombre, int precio, int peso) {
		this.setNombre(nombre);
		this.setPrecioBase(precio);
		this.setPeso(peso);
		this.codigo = ++cont;
	}

	public Eletrodomestico(String nombre, String color, char consumo, int precio, int peso) {
		this.setNombre(nombre);
		this.setColor(color);
		this.setConsumoEnerg(consumo);
		this.setPrecioBase(precio);
		this.setPeso(peso);
		this.codigo = ++cont;
	}

	// Setters y Getters

	/**
	 * @return the peso
	 */
	public int getPeso() {
		return peso;
	}

	/**
	 * @param peso the peso to set
	 */
	public void setPeso(int peso) {
		if (peso < 0) {
			this.peso = pesoD;
		} else {
			this.peso = peso;
		}

	}

	/**
	 * @return the consumoEnerg
	 */
	public char getConsumoEnerg() {
		return consumoEnerg;
	}

	/**
	 * @param consumoEnerg the consumoEnerg to set
	 */
	public void setConsumoEnerg(char consumoEnerg) {
		if (comprobarConsumoEnergetico(consumoEnerg)) {
			this.consumoEnerg = Character.toUpperCase(consumoEnerg);
		} else {
			this.consumoEnerg = consumoEnergD;
		}
	}

	/**
	 * @return the precioBase
	 */
	public int getPrecioBase() {
		return precioBase;
	}

	/**
	 * @param precioBase the precioBase to set
	 */
	public void setPrecioBase(int precioBase) {
		if (precioBase < 0) {
			this.precioBase = precioBaseD;
		} else {
			this.precioBase = precioBase;
		}

	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		if (comprobarColor(color)) {
			this.color = color.toUpperCase();
		} else {
			this.color = "BLANCO";
		}
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}

	// Metodos

	private boolean comprobarConsumoEnergetico(char letra) {
		letra = Character.toUpperCase(letra);
		boolean sw = false;

		for (int i = 0; i < consumoELetras.length; i++)
			if (letra == consumoELetras[i])
				sw = true;

		return sw;
	}

	private boolean comprobarColor(String color) {
		color.toUpperCase();
		boolean sw = false;

		for (int i = 0; i < colorPermi.length; i++)
			if (color.equalsIgnoreCase(colorPermi[i]))
				sw = true;

		return sw;
	}

	protected int getPrecioPorConsumo() {
		int precio = 0;
		switch (this.consumoEnerg) {
		case 'A':
			precio = 100;
			break;
		case 'B':
			precio = 80;
			break;
		case 'C':
			precio = 60;
			break;
		case 'D':
			precio = 50;
			break;
		case 'E':
			precio = 30;
			break;
		case 'F':
			precio = 10;
			break;
		}
		return precio;
	}

	protected int getPrecioPorPeso() {
		int precio = 0;
		if (this.peso >= 0 && this.peso < 20) {
			precio = 10;
		} else if (this.peso >= 20 && this.peso < 50) {
			precio = 50;
		} else if (this.peso >= 50 && this.peso < 80) {
			precio = 80;
		} else if (this.peso >= 80) {
			precio = 100;
		}
		return precio;
	}

	public abstract int precioFinal();

	public String info() {
		String info;

		info = "\nCodigo producto: " + this.codigo + "\nNombre: " + getNombre() + "\nColor: " + getColor() + "\nPeso: "
				+ getPeso() + " kg" + "\nConsumo: " + getConsumoEnerg() + "\nPrecio: " + precioFinal() + "$";

		return info;
	}
}
