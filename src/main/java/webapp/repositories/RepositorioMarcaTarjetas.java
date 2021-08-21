package webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import webapp.domain.MarcaTarjeta;

public interface RepositorioMarcaTarjetas extends CrudRepository<MarcaTarjeta,Long> {
}
