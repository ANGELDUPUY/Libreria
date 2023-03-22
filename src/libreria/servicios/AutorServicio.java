/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import libreria.entidades.Autor;
import persistencia.AutorDAO;

/**
 *
 * @author hdsot
 */
public class AutorServicio {
    private final AutorDAO DAO;

    public AutorServicio() {
        this.DAO = new AutorDAO();
    }
    public Autor crearAutor(String nombre){
        Autor autor = new Autor();
        try{
            autor.setNombre(nombre);
            autor.setAlta(true);
            DAO.guardar(autor);
            return autor;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<Autor> listarAutor(){
        try{
            return DAO.listarTodos();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean eliminarAutor(String nombre){
        try{
            DAO.eliminar(nombre);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    public List<Autor> listarAutorPorNombre(String nombre){
        try{
            return DAO.buscarPorNombre(nombre);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
       } 
   public List<Autor> buscarAutorPorNombre(String nombre) {
  List<Autor> autores = new ArrayList<>();
  try {
    autores = DAO.buscarAutorPorNombre(nombre);
  } catch (Exception e) {
    e.printStackTrace();
  }
  return autores;
}

}
