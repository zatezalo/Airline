package rs.raf.Airline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import rs.raf.Airline.model.MyUser;

//@CrossOrigin("http://localhost:4200")
public interface UserRepository extends JpaRepository<MyUser, Long> {
    MyUser findByUsername(String username);
}
