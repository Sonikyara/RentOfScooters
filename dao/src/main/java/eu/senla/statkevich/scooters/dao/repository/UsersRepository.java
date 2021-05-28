package eu.senla.statkevich.scooters.dao.repository;

import eu.senla.statkevich.scooters.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users,Long> {//CrudRepository<Users,Long>
}
