package uce.edu.ec.db;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "comments")
@Getter
@Setter
@ToString
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer postId;
    private String name;
    private String email;
    @Column(columnDefinition = "TEXT")
    private String body;

}
