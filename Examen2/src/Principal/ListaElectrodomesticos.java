/**
 * 
 */
package Principal;

import java.util.ArrayList;

import Electro.Eletrodomestico;
import Electro.Lavadora;

/**
 * @author Charl
 *
 */
public class ListaElectrodomesticos {

	private static ArrayList<Eletrodomestico> eletrodomestico = new ArrayList<>();

	public static void anadirElectro(Eletrodomestico ele) {
		eletrodomestico.add(ele);
	}

	public static void mostrarElectros() {
		boolean sw = false;
		for (Eletrodomestico el : eletrodomestico) {
			System.out.println("-----" + el.getClass().getSimpleName() + "-----");
			System.out.println(el.info());
			sw = true;
			System.out.println("--------------------");
		}
		
		if(!sw) {
			System.out.println("No hay articulos en la lista.");
		}
	}

	public static void borrarElectros(String nombre) {
		boolean sw = false;
		for (Eletrodomestico el : eletrodomestico) {
			if (el.getNombre().equalsIgnoreCase(nombre)) {
				eletrodomestico.remove(el);
				sw = true;
				System.out.println("Producto borrado con sucesso!!!");
			}
		}
		
		if(!sw) {
			System.out.println("No hay ese articulos en la lista.");
		}
	}

	public static void mostrarLavadora8kg() {
		for (Eletrodomestico el : eletrodomestico) {
			if (el instanceof Lavadora) {
				{
					Lavadora lav = (Lavadora) el;
					if (lav.getCarga() >= 8) {
						System.out.println("+-----" + el.getClass().getSimpleName() + "-----+");
						System.out.println(lav.info());
						System.out.println("+-------------------+");
					}
				}

			}
		}
	}
}
