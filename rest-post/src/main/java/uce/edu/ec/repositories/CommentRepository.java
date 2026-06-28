package uce.edu.ec.repositories;

import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Repository;

import uce.edu.ec.db.Comment;

@Repository
public interface CommentRepository extends FullEntityRepository<Comment,Integer>{

}
