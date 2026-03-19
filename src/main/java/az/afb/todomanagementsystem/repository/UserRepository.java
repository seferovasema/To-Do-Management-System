package az.afb.todomanagementsystem.repository;

import az.afb.todomanagementsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
