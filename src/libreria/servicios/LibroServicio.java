/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.ArrayList;
import java.util.List;
import libreria.entidades.Libro;
import static libreria.entidades.Libro_.titulo;
import persistencia.LibroDAO;

/**
 *
 * @author hdsot
 */
public class LibroServicio {
    private final LibroDAO DAO;

    public LibroServicio() {
        this.DAO = new LibroDAO();
    }
   public Libro crearLibro (String titulo){
        Libro libro = new Libro();
        try{
            libro.setTitulo(titulo);
            libro.setAlta(true);
            DAO.guardar(libro);
            return libro;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<Libro> listarLibro(){
        try{
            return DAO.listarTodos();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public  boolean eliminarLibro(String nombre){
        try{
            DAO.eliminar(nombre);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    } 
   
  public List<Libro> buscarLibrosPorAutor(String nombreAutor) {
  List<Libro> libros = new ArrayList<>();
  try {
    libros = DAO.buscarLibrosPorAutor(nombreAutor);
  } catch (Exception e) {
    e.printStackTrace();
  }
  return libros;
}
   
  public List<Libro> buscarLibrosPorId (Long idbuscado) {
  List<Libro> libros = new ArrayList<>();
  try {
    libros = DAO.buscarLibrosPorId(idbuscado);
  } catch (Exception e) {
    e.printStackTrace();
  }
  return libros;
}


}
