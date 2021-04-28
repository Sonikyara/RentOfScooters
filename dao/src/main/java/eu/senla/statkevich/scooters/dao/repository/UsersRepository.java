package eu.senla.statkevich.scooters.dao.repository;

import eu.senla.statkevich.scooters.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {
}
