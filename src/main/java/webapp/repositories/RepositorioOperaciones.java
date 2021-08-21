package webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import webapp.domain.Operacion;

public interface RepositorioOperaciones extends CrudRepository<Operacion,Long> {
}
