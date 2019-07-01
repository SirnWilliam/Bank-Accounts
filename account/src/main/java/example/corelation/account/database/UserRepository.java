package example.corelation.account.database;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

	User findByUsername(String username);
}
