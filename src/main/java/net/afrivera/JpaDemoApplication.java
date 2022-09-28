package net.afrivera;

import net.afrivera.model.Categoria;
import net.afrivera.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	@Autowired
	private CategoriasRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// este metodo es para que la app corra como una app cli
		// System.out.println(repo);
		// guardar();
		// buscarPorId();
		// modificar();
		// eliminar();
		// contar();
		// eliminartodo();
		encontrarPorIds();
	}

	private void encontrarPorIds(){
		List<Integer> ids = new LinkedList<>();
		ids.add(1);
		ids.add(4);
		ids.add(10);
		Iterable<Categoria> categorias =  repo.findAllById(ids);
		for (Categoria cat : categorias){
			System.out.println(cat);
		}
	}

	private void eliminartodo(){
		// se recomiend no usar con cientos de registros
		repo.deleteAll();
	}

	private void contar(){
		long cont = repo.count();
		System.out.println("Total de Categorias: " + cont);
	}

	private void modificar(){
		Optional<Categoria> optional =  repo.findById(1);
		if(optional.isPresent()){
			Categoria catImp = optional.get();
			catImp.setNombre("Ing. de Software");
			catImp.setDescripcion("Desarrollo de Sistemas");
			repo.save(catImp);
			System.out.println(catImp);
		} else {
			System.out.println("Categoria no encontrada");
		}
	}

	private void buscarPorId(){
		Optional<Categoria> optional =  repo.findById(2);
		if(optional.isPresent()){
			System.out.println(optional.get());
		} else {
			System.out.println("Categoria no encontrada");
		}
	}

	private void guardar(){
		// System.out.println("Insertando un registro");
		Categoria cat = new Categoria();
		cat.setNombre("Finanzas");
		cat.setDescripcion("Trabajos relacionados con finanzas y contabilidad");

		repo.save(cat);
		System.out.println(cat);
	}

	private void eliminar(){
		// System.out.println("Eliminando un registro");
		int idCategoria = 1;
		repo.deleteById(idCategoria);
	}

}
