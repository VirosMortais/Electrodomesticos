package Electro;
/**
 * 
 */

/**
 * @author Charl
 *
 */
public class Television extends Eletrodomestico {

	// Constantes
	private static final int resolocionD = 20;
	private static final boolean wifiD = false;

	// Atributos
	private int resolucion;
	private boolean wifi;

	public Television(String nombre) {
		super(nombre);
		this.resolucion = resolocionD;
		this.wifi = wifiD;
	}

	public Television(String nombre, int resolocion, boolean wifi) {
		super(nombre);
		this.resolucion = resolocion;
		this.setWifi(wifi);
	}

	public Television(String nombre, int precio, int peso, int resolocion, boolean wifi) {
		super(nombre, precio, peso);
		this.resolucion = resolocion;
		this.setWifi(wifi);
	}

	public Television(String nombre, String color, char consumo, int precio, int peso, int resolocion, boolean wifi) {
		super(nombre, color, consumo, precio, peso);
		this.resolucion = resolocion;
		this.setWifi(wifi);
	}

	/**
	 * @return the wifi
	 */
	public boolean isWifi() {
		return wifi;
	}

	/**
	 * @param wifi the wifi to set
	 */
	public void setWifi(boolean wifi) {
		if (wifi) {
			this.wifi = wifi;
		} else {
			this.wifi = wifiD;
		}
	}

	/**
	 * @return the resolocion
	 */
	public int getResolucion() {
		return resolucion;
	}

	/**
	 * @param resolocion the resolocion to set
	 */
	public void setResolucion(int resolucion) {
		this.resolucion = resolucion;
	}

	// Metodos

	public String info() {
		String info;
		info = super.info() + "\nResolución: " + getResolucion() + "\nWifi: " + tieneWifi();

		return info;
	}

	private String tieneWifi() {
		String wif;

		if (isWifi()) {
			wif = "si";
		} else {
			wif = "no";
		}

		return wif.toUpperCase();

	}

	@Override
	public int precioFinal() {
		int precio = super.getPrecioBase() + super.getPrecioPorPeso() + super.getPrecioPorConsumo();

		if (getResolucion() > 40)
			precio *= 1.30;

		if (isWifi())
			precio += 50;

		return precio;
	}

}
