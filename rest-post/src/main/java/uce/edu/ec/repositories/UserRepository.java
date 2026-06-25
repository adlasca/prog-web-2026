package uce.edu.ec.repositories;

import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Repository;
import uce.edu.ec.db.User;

@Repository
public interface UserRepository extends FullEntityRepository<User,Integer> {
}
