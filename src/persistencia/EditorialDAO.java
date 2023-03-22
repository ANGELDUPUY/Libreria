/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.persistence.NoResultException;
import libreria.entidades.Editorial;

/**
 *
 * @author hdsot
 */
public class EditorialDAO extends DAO<Editorial> {

    @Override
    public void guardar(Editorial editorial) {
        super.guardar(editorial);
    }

    public void eliminar(int id) throws Exception {
        Editorial editorial = buscarPorId(id);
        super.eliminar(editorial);
    }

    public Editorial buscarPorId(int id) throws Exception {
        conectar();
        Editorial editorial = em.find(Editorial.class, id);
        desconectar();
        return editorial;
    }

    public List<Editorial> buscarPorNombre(String nombre) throws Exception {
        conectar();
        //List<Autor> autores= em.createQuery("SELECT a FROM Autor a").getResultList();
        List<Editorial> editorialesEncontradas = em.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE :nombre").setParameter("nombre", nombre).getResultList();
        desconectar();
        return editorialesEncontradas;
    }

    public List<Editorial> listarTodos() throws Exception {
        conectar();
        List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e").getResultList();
        desconectar();
        return editoriales;
    }

    public void eliminar(String nombre) throws Exception {
        List<Editorial> editorialEliminar = buscarPorNombre(nombre);
        for (Editorial aut : editorialEliminar) {
            System.out.println(aut);
            super.eliminar(aut);
        }
    }

    public List<Editorial> buscarEditorialPorNombre(List<Editorial> editorial1) {
        conectar();
        List<Editorial> results = null;
        if (!editorial1.isEmpty()) {
            try {
                results = em.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :nombre", Editorial.class)
                        .setParameter("nombre", editorial1.get(0).getNombre())
                        .getResultList();
            } catch (NoResultException e) {
                // La consulta no ha devuelto ningún resultado, no hay que hacer nada especial
            }
        }
        desconectar();
        return results;
    }

}
