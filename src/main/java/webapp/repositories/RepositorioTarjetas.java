package webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import webapp.domain.Tarjeta;

public interface RepositorioTarjetas extends CrudRepository<Tarjeta,Long> {
}
