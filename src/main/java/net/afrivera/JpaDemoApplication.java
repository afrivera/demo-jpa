package net.afrivera;

import net.afrivera.model.Categoria;
import net.afrivera.repository.CategoriasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
		guardar();
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
		System.out.println("Eliminando un registro");
	}

}
