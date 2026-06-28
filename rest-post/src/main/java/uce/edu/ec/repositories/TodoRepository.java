package uce.edu.ec.repositories;

import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Repository;

import uce.edu.ec.db.Todo;

@Repository
public interface TodoRepository extends FullEntityRepository<Todo,Integer>{

}
