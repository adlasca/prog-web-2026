package uce.edu.ec.repositories;

import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Repository;

import uce.edu.ec.db.Photo;

@Repository
public interface PhotoRepository extends FullEntityRepository<Photo,Integer>{

}
