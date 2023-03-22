/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreria.servicios;

import java.util.ArrayList;
import java.util.List;
import libreria.entidades.Editorial;
import persistencia.EditorialDAO;



/**
 *
 * @author hdsot
 */
public class EditorialServicio {
    private final EditorialDAO DAO;

    public EditorialServicio() {
        this.DAO = new EditorialDAO();
    }
    
    public Editorial crearEditorial(String nombre){
        Editorial editorial = new Editorial();
        try{
            editorial.setNombre(nombre);
            editorial.setAlta(true);
            DAO.guardar(editorial);
            return editorial;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    public List<Editorial> listarEditorial(){
        try{
            return DAO.listarTodos();
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public  boolean eliminarEditorial(String nombre){
        try{
            DAO.eliminar(nombre);
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
public List<Editorial> buscarEditorialPorNombre(String nombre2) {
  List<Editorial> editorial = new ArrayList<>();
  try {
    Editorial editorialBuscada = new Editorial();
    editorialBuscada.setNombre(nombre2);
    editorial.add(editorialBuscada);
    editorial = DAO.buscarEditorialPorNombre(editorial);
  } catch (Exception e) {
    e.printStackTrace();
  }
  return editorial;
}


}
