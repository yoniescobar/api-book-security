package com.company.intecap.apibooks.dao;

import com.company.intecap.apibooks.model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

    //metodo para bucar usuario por nombre
     public  Usuario findByNombreUsuario(String nombreUsuario); //finBy + nombre del atributo de la clase Usuario + (parametro) para buscar por nombre de usuario

    //metodo para bucar usuario por nombre
    @Query("select u from Usuario u where u.nombreUsuario=?1")
    public Usuario findByNombreUsuario2(String nombreUsuario);


}


//En Spring Data JPA, se pueden hacer 3 tipos de consultas:
    /*
        1. Query JPA(Java Persistence Query Language) y usa JPQL(Java Persistence Query Language): es un lenguaje de consulta de objetos orientado a entidades.
        @Query("select f from FlyEntity f where f.price<:price")
        Set<FlyEntity> SelectLessPrice(BigDecimal price);
     */

    /*
        2. Query SQL: se usa la anotación @Query y se le pasa el atributo nativeQuery=true
        @Query(value = "SELECT * FROM FlyEntity WHERE price<:price", nativeQuery = true)
        Set<FlyEntity> SelectLessPrice(BigDecimal price);
     */

