package com.ipartek.examen.ana.accesodatos;

import java.util.TreeMap;

import com.ipartek.examen.ana.entidades.Coche;

public class DaoCocheMemoria implements DaoCoche {
	private static final TreeMap<Long, Coche> coches = new TreeMap<>();

	static {
		coches.put(1L, new Coche(1L, "1234BCD", "Jeep", "Cherokee", "Negro", null, null));
		coches.put(2L, new Coche(2L, "1234BCD", "Jeep", "Commander", "Rojo", null, null));
		coches.put(3L, new Coche(3L, "1234BCD", "Jeep", "Compass", "Verde", null, null));
		coches.put(4L, new Coche(4L, "1234BCD", "Jeep", "Gladiator", "Negro", null, null));
		coches.put(5L, new Coche(5L, "1234BCD", "Jeep", "Grand Cherokee", "Negro", null, null));
	}

//		
	// SINGLETON
	private DaoCocheMemoria() {
	}

	private static final DaoCocheMemoria INSTANCIA = new DaoCocheMemoria();

	public static DaoCocheMemoria getInstancia() {
		return INSTANCIA;
	}

	@Override
	public Iterable<Coche> obtenerTodos() {
		return coches.values();
	}

	@Override
	public void insertar(Coche coche) {
		Long id = coches.size() > 0 ? coches.lastKey() + 1L : 1L;
		coche.setId(id);
		coches.put(coche.getId(), coche);
	}

}
