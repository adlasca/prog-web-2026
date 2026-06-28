package uce.edu.ec;

import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import uce.edu.ec.rest.AlbumRest;
import uce.edu.ec.rest.CommentRest;
import uce.edu.ec.rest.PhotoRest;
import uce.edu.ec.rest.PostRest;
import uce.edu.ec.rest.TodoRest;
import uce.edu.ec.rest.UserRest;

@ApplicationPath("/")
public class MyApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        //Las clases que seran consideradas al Path
        return  Set.of(
                UserRest.class,
                AlbumRest.class,
                CommentRest.class,
                PhotoRest.class,
                PostRest.class,
                TodoRest.class
        );
    }
}
