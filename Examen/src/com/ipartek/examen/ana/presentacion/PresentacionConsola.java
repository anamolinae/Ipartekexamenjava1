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
		pl("1. Mostrar todos");
		pl("2. Insertar coche");
		pl("3. Insertar otro coche");
		pl("4. Salir");
	}

	private static int pedirOpcion() {
		return pedirInt("Selecciona una de las opciones del menu");
	}

	private static void procesarOpcion(int opcion) {
		switch (opcion) {
		case 1:
			mostrarTodos();
			break;

		case 2:
			insertar();
			break;

		case 0:
			pl("Gracias por utilizar la aplicacion");
			break;

		default:
			errorPl("por favor elige una opcion existente");

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
