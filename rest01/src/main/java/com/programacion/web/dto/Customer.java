package com.programacion.web.dto;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class Customer {
    private Integer id;
    private String name;
    private String direccion;
}
