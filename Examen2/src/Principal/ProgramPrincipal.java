/**
 * 
 */
package Principal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

import Electro.Lavadora;
import Electro.Television;

/**
 * @author Charl
 *
 */
public class ProgramPrincipal {

	/**
	 * @param args
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		int opcion = 0;

		do {
			mostrarMenu();
			opcion = Integer.parseInt(in.readLine());
			try {
				menuSw(opcion);
			} catch (Exception e) {

			}
		} while (opcion != 0);

		System.out.println("===============FIM==============");
	}

	public static void mostrarMenu() {
		System.out.println("-----------MENU-----------");
		System.out.print("1. Añadir electrodoméstoco.\n" + "2.Mostrar todos los electrodomésticos.\n"
				+ "3.Borrar un electrodoméstico.\n" + "4.Mostrar lavdoras de más de 8 kg de carga.\n" + "0.Salir...\n"
				+ "\n  OPCION: ");
	}

	public static void menuSw(int opcion) throws Exception {

		System.out.println("\n\n================================");
		switch (opcion) {
		case 1:
			int elc = opcion1();
			if (elc < 1 || elc > 2) {
				throw new Exception("Opcion no valida");
			} else {
				anadirElec(elc);
			}
			break;
		case 2:
			ListaElectrodomesticos.mostrarElectros();
			break;
		case 3:
			ListaElectrodomesticos.borrarElectros(borrarProducto());
			break;
		case 4:
			ListaElectrodomesticos.mostrarLavadora8kg();
			break;
		case 0:
			System.out.println("Salindo...");
			break;
		default:
			System.err.println("Opcion no valida");
		}
		System.out.println("================================\n\n");
	}

	private static int opcion1() throws Exception {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int elec = 0;
		System.out.print("================================\n");
		System.out.print("1. Lavadora.\n" + "2. Television.\n" + "Opcion: ");

		try {
			elec = Integer.parseInt(sc.readLine());
			
		} catch (NumberFormatException e) {
			System.err.println("[ERRO] Tiene que ser un numero intero.");
		} catch (IOException e) {
			System.err.println("[ERROR]Opcion no valida");
		}
		System.out.print("\n================================\n");
		return elec;
	}

	public static void anadirElec(int num) {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		String nombre;
		String color;
		char consumo = 'F';
		int peso;
		int precio;
		int carga;
		int resolucion;
		boolean wifi;
		System.out.println("================================");
		try {
			System.out.print("Nombre: ");
			nombre = sc.readLine();
			System.out.print("Color: ");
			color = sc.readLine();
			System.out.print("Peso: ");
			peso = Integer.parseInt(sc.readLine());
			System.out.print("Precio: ");
			precio = Integer.parseInt(sc.readLine());
			System.out.print("Consumo Engertico: ");
			consumo = (char) sc.read();

			sc.readLine();// Limpar el buffer

			if (num == 1) {
				System.out.print("Carga: ");
				carga = Integer.parseInt(sc.readLine());
				crearLavadora(nombre, color, consumo, peso, precio, carga);
			} else if (num == 2) {
				System.out.print("Resolución: ");
				resolucion = Integer.parseInt(sc.readLine());
				System.out.print("Tiene wifi? SI/NO: ");
				wifi = tieneWifi(sc.readLine());

				crearTelevision(nombre, color, consumo, peso, precio, resolucion, wifi);
			}
		} catch (InputMismatchException e) {
			System.err.println("[ERROR] dato introduzido no es valido");
		} catch (IOException e) {
			System.err.println("[ERROR] dato introduzido no es valido");
		} catch (NumberFormatException e) {
			System.err.println("[ERROR] Formato de numero incorrecto.");
		}
		System.out.println("================================");

	}

	public static String borrarProducto() {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		String nombre = "";
		boolean sw = false;
		do {
			try {
				System.out.print("Nombre del producto que quieres borrar: ");
				nombre = sc.readLine();
				sw = false;
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InputMismatchException e) {
				System.err.println("[Error]");
				sw = true;
			}
			;
		} while (sw);

		return nombre;
	}

	private static boolean tieneWifi(String valor) {
		boolean sw = false;
		if (valor.equalsIgnoreCase("SI"))
			sw = true;
		return sw;

	}

	private static void crearLavadora(String nombre, String color, char consumo, int peso, int precio, int carga) {
		ListaElectrodomesticos.anadirElectro(new Lavadora(nombre, color, consumo, precio, peso, carga));
		System.out.println("Articulo añadido");
	}

	private static void crearTelevision(String nombre, String color, char consumo, int peso, int precio, int resolucion,
			boolean wifi) {
		ListaElectrodomesticos.anadirElectro(new Television(nombre, color, consumo, precio, peso, resolucion, wifi));
		System.out.println("Articulo añadido");
	}
}
