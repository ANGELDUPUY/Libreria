/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author hdsot
 */
public class DAO<T> {


    protected final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("LibreriaPU");
    protected EntityManager em = EMF.createEntityManager();
   
    //metodo para conectar
    protected void conectar(){
        if(!em.isOpen()){
            em = EMF.createEntityManager();
        }
    }
    //metodo para desconectar
    protected void desconectar(){
        if (em.isOpen()){
            em.close();
        }
    }
    //metodo para persistir
    protected void guardar(T objeto){
        conectar();
        em.getTransaction().begin();
        em.persist(objeto);
        em.getTransaction().commit();//confirma
        desconectar();
    }
    /*modificar una tupla de la base de datos
    recibe como parametro el objeto con los datos modificados
    (debe conservar la llave primaria) y lo reemplaza */
    protected void editar (T objeto){
        conectar();
        em.getTransaction().begin();
        em.merge(objeto);//actualiza una entidad en la base de datos
        em.getTransaction().commit();
        desconectar();
    }
    //metodo para eliminar un registro de la base de datos
    protected void eliminar(T objeto){
        conectar();
        em.getTransaction().begin();
        if (!em.contains(objeto)) {
        objeto = em.merge(objeto);
        }
        em.remove(objeto);
        em.getTransaction().commit();
        desconectar();
    }
}

