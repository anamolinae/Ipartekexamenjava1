package com.ipartek.examen.ana.accesodatos;

public interface Dao<T> {
	Iterable<T> obtenerTodos();

	void insertar(T objeto);
	// void modificar(T objeto);
	// void borrar(Long id);
	// los anteriores estan escritos por si en un futuro quiero agregarlos

}
