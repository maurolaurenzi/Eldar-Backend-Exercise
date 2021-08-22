package webapp.repositories;

import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import webapp.domain.MarcaTarjeta;
import webapp.domain.NombreMarca;

import java.util.Optional;
public interface RepositorioMarcaTarjetas extends CrudRepository<MarcaTarjeta,Long> {

}
