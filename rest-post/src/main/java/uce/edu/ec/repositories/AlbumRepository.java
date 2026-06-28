package uce.edu.ec.repositories;

import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Repository;

import uce.edu.ec.db.Album;

@Repository
public interface AlbumRepository  extends FullEntityRepository<Album,Integer> {

}
