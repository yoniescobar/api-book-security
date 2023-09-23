package com.company.intecap.apibooks.controllers;

import com.company.intecap.apibooks.model.Libro;
import com.company.intecap.apibooks.response.LibroResponseRest;
import com.company.intecap.apibooks.service.ILibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = {"http://localhost:3001", "http://localhost:3000","http://localhost:4200"}) // Indica que este controlador REST puede ser accedido desde cualquier origen (dominio) y desde cualquier puerto (3000, 3001, etc)
//@CrossOrigin("http://localhost:3001") // to allow from specific domain
//@CrossOrigin(origins = "http://localhost:3001")// Indica que este controlador REST puede ser accedido desde cualquier origen (dominio)
@RestController
@RequestMapping("/api/v1") //prefijo de la ruta de la api rest  http://localhost:8080/api/v1
public class LibroRestController {

    @Autowired //inyeccion de dependencias
    private ILibroService service;

    @GetMapping("/libros") //ruta de la api rest http://localhost:8080/api/v1/libros
    public ResponseEntity<LibroResponseRest> buscarLibros(){
        return service.buscarLibros();
    }

    @GetMapping("/libros/{id}") //ruta de la api rest http://localhost:8080/api/v1/libros/1
    public ResponseEntity<LibroResponseRest> buscarLibroPorId(@PathVariable Long id){
        return service.buscarLibroPorId(id);
    }

    @PostMapping("/libros") //ruta de la api rest http://localhost:8080/api/v1/libros
    public ResponseEntity<LibroResponseRest> guardarLibro(@RequestBody Libro libro){
        return service.guardarLibro(libro);
    }

    @PutMapping("/libros/{id}") //ruta de la api rest http://localhost:8080/api/v1/libros/1
    public ResponseEntity<LibroResponseRest> actualizarLibro(@RequestBody Libro libro, @PathVariable Long id){
        return service.actualizarLibro(libro, id);
    }

    @DeleteMapping("/libros/{id}") //ruta de la api rest http://localhost:8080/api/v1/libros/1
    public ResponseEntity<LibroResponseRest> eliminarLibro(@PathVariable Long id){
        return service.eliminarLibro(id);
    }

}
