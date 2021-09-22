package br.com.livro.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarroService {
	private CarroDao db = new CarroDao();

	public List<Carro> getCarros() {
		try {
			List<Carro> carros = db.getCarros();
			return carros;
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Carro>();
		}
	}

	public Carro getCarro(Long id) {
		try {
			return db.getCarroById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean delete(Long id) {
		try {
			db.detele(id);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean save(Carro c) {
		try {
			db.save(c);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public List<Carro> findByName(String nome){
		try {
			return db.findByName(nome);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Carro> findByTipo(String tipo){
		try {
			return db.findByTipo(tipo);
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
