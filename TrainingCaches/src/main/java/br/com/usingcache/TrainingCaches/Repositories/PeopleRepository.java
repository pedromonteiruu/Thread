package br.com.usingcache.TrainingCaches.Repositories;


import br.com.usingcache.TrainingCaches.Entities.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {

}
