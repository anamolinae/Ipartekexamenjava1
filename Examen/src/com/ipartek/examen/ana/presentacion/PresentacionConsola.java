package com.ipartek.examen.ana.presentacion;

import static com.ipartek.examen.ana.bibliotecas.Consola.*;

import com.ipartek.examen.ana.accesodatos.DaoCoche;
import com.ipartek.examen.ana.accesodatos.DaoCocheMemoria;
import com.ipartek.examen.ana.entidades.Coche;

public class PresentacionConsola {
	private static final DaoCoche DAO = DaoCocheMemoria.getInstancia();

	public static void main(String[] args) {
		int opcion;

		do {
			mostrarMenu();
			opcion = pedirOpcion();
			procesarOpcion(opcion);
		} while (opcion != 0);
	}

	private static void mostrarMenu() {
		pl("1. Insertar coche");
		pl("2. Mostar todos");
		pl("3. salir");
//		pl("4. Salir");
	}

	private static int pedirOpcion() {
		return pedirInt("Selecciona una de las opciones del menu");
	}

	private static void procesarOpcion(int opcion) {
		if( opcion == 1) {
			insertar();
			}
		else if (opcion == 2) {
			mostrarTodos();
		}
		else (opcion == 3){
			pl("Gracias por usar la aplicacion");
			
			
		}
	
	}

	private static void mostrarTodos() {
		for (Coche e : DAO.obtenerTodos()) {
			mostrarLinea(e);
		}
	}

	private static void insertar() {
		String matricula = pedirString("Matricula");
		String marca = pedirString("Marca");
		String modelo = pedirString("Modelo");
		String color = pedirString("Color");
		Integer potencia = pedirInt("Potencia");
		Integer cilindros = pedirInt("Cilindros");

		Coche coche = new Coche(null, matricula, marca, modelo, color, potencia, cilindros);

		DAO.insertar(coche);

	}

	private static void mostrarLinea(Coche coche) {
		pl(coche);
	}

}
