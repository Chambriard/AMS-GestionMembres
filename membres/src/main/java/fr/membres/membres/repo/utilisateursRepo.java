package fr.membres.membres.repo;


import fr.membres.membres.entities.membres;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface utilisateursRepo extends CrudRepository<membres,Long> {

}
