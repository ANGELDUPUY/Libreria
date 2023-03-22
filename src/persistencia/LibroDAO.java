/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.persistence.NoResultException;
import libreria.entidades.Libro;

/**
 *
 * @author hdsot
 */
public class LibroDAO extends DAO<Libro> {
    @Override
    public void guardar(Libro libro){
        super.guardar(libro);
    }
    public void eliminar(String nombre)throws Exception{
        Libro libro= buscarPorNombre(nombre);
        super.eliminar(libro);
    }
    public Libro buscarPorNombre(String nombre)throws Exception {
        conectar();
        Libro libro = em.find(Libro.class, nombre);
        desconectar();
        return libro;
    }
    public List<Libro> listarTodos() throws Exception{
        conectar();
        List<Libro> libros= em.createQuery("SELECT l FROM Libro l").getResultList();
        desconectar();
        return libros;
    }
  
    
    public List<Libro> buscarLibrosPorAutor(String nombreAutor) {
  conectar();
  List<Libro> libros = null;
  try {
    libros = em.createQuery("SELECT l.titulo FROM Libro l WHERE l.autor.nombre = :nombreAutor", Libro.class)
              .setParameter("nombreAutor", nombreAutor)
              .getResultList();
  } catch (NoResultException e) {
    // La consulta no ha devuelto ningún resultado, no hay que hacer nada especial
  }
  desconectar();
  return libros;
}
    
    public List<Libro> buscarLibrosPorId(Long id) {
  conectar();
  List<Libro> libros = null;
  try {
    libros = em.createQuery("SELECT l.titulo FROM Libro l WHERE l.id = :idLibro", Libro.class)
             .setParameter("idLibro", id)
              .getResultList();
  } catch (NoResultException e) {
    // La consulta no ha devuelto ningún resultado, no hay que hacer nada especial
  }
  desconectar();
  return libros;
}    

}


//SELECT l.titulo FROM Libro l WHERE l.id = :idLibro
