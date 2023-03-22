/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import libreria.entidades.Autor;

/**
 *
 * @author hdsot
 */
public class AutorDAO extends DAO<Autor> {
    @Override
    public void guardar(Autor autor){
        super.guardar(autor);
    }
    public void eliminar(String nombre)throws Exception{
        List<Autor> autores= buscarPorNombre(nombre);
        for(Autor aut:autores){
            System.out.println(aut);
        super.eliminar(aut);
        }
    }
    public List<Autor> buscarPorNombre(String nombre)throws Exception {
        conectar();
        //List<Autor> autores= em.createQuery("SELECT a FROM Autor a").getResultList();
       List<Autor> autoresEncontrados = em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre").setParameter("nombre", nombre).getResultList();
        desconectar();
        return autoresEncontrados;
    }
    public List<Autor> listarTodos() throws Exception{
        conectar();
        List<Autor> autores= em.createQuery("SELECT a FROM Autor a").getResultList();
        desconectar();
        return autores;
    }
   
 public List<Autor> buscarAutorPorNombre(String nombre1) {
  conectar();
  List<Autor> results = em.createQuery("SELECT a FROM Autor a WHERE a.nombre = :nombre", Autor.class)
                         .setParameter("nombre", nombre1)
                         .getResultList();
                                 
  desconectar();
  if (results.isEmpty()) {
    return null; // o lanzar una excepción si es necesario
  } else {
    return results;
  }
}

}