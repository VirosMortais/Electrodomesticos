package Electro;
/**
 * 
 */

/**
 * @author Charl
 *
 */
public class Lavadora extends Eletrodomestico {

	private int carga;
	private static final int cargaDe = 5;

	public Lavadora(String nombre) {
		super(nombre);
		this.carga = cargaDe;
	}

	public Lavadora(String nombre, int carga) {
		super(nombre);
		this.setCarga(carga);
	}

	public Lavadora(String nombre, int precio, int peso, int carga) {
		super(nombre, precio, peso);
		this.setCarga(carga);
	}

	public Lavadora(String nombre, String color, char consumo, int precio, int peso, int carga) {
		super(nombre, color, consumo, precio, peso);
		this.setCarga(carga);
	}

	// Setters y Getters
	/**
	 * @return the carga
	 */
	public int getCarga() {
		return carga;
	}

	/**
	 * @param carga the carga to set
	 */
	public void setCarga(int carga) {
		if (carga < 0) {
			this.carga = cargaDe;
		} else {
			this.carga = carga;
		}
	}

	// metodos

	public String info() {
		String info;
		info = super.info() + "\nCarga: " + getCarga() + " kg";

		return info;
	}

	@Override
	public int precioFinal() {
		int precio = super.getPrecioBase() + super.getPrecioPorPeso() + super.getPrecioPorConsumo();

		if (getCarga() > 8)
			precio += 35;

		return precio;
	}

}
