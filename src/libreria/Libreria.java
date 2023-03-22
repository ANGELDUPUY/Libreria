package libreria;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;
import libreria.servicios.AutorServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;

/**
 *
 * @author hdsot
 */
public class Libreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AutorServicio autorServicio = new AutorServicio();
        EditorialServicio editorialServicio = new EditorialServicio();
        LibroServicio libroServicio = new LibroServicio();
        String nombre;
        String rta = "N";
        int opcion;
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        try {
            do {

                System.out.println("---------MENU-------------");
                System.out.println(" Elija la consulta que desea realizar ");
                System.out.println(" 1- Crear autor ");
                System.out.println(" 2- Nombre de todos los autores ");
                System.out.println(" 3- Eliminar Autor");
                System.out.println(" 4- Crear Editorial");
                System.out.println(" 5- Nombre de todas las Editoriales");
                System.out.println(" 6- Eliminar Editorial");
                System.out.println(" 7- Buscar Autor Por Nombre");
                System.out.println(" 8- Buscar Editorial Por Nombre");
                System.out.println(" 9- Buscar libros por Nombre de autor");
                System.out.println(" 10-Crear Libro");
                System.out.println(" 11-Mostrar todos los libros");
                System.out.println(" 12- Buscar libros por Id ");
                System.out.println(" 13- Salir ");
                opcion = leer.nextInt();

                switch (opcion) {
                    case 1:
                    try {
                        System.out.println("Ingrese nombre del Autor");
                        nombre = leer.next();
                        autorServicio.crearAutor(nombre);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                    }
                    break;
                    case 2:
                    try {
                        autorServicio.listarAutor().forEach((a) -> System.out.println(a.toString()));
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                    }
                    break;
                    case 3:
                    try {
                        System.out.println("Ingrese el nombre del autor que desa eliminar ");
                        String nombreAutorEliminar = leer.next();
                        autorServicio.eliminarAutor(nombreAutorEliminar);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                    }
                    break;
                    case 4:
                    try {
                        System.out.println("Ingrese nombre de la Editorial");
                        String nombreEditorial = leer.next();
                        editorialServicio.crearEditorial(nombreEditorial);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                    }
                    break;
                    case 5:
                    try {
                        editorialServicio.listarEditorial().forEach((e) -> System.out.println(e.toString()));
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                    }
                    break;
                    case 6:
                    try {
                        System.out.println("Ingrese el nombre de la Editorial que desa eliminar ");
                        String nombreEditorialEliminar = leer.next();
                        editorialServicio.eliminarEditorial(nombreEditorialEliminar);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                    }
                    break;
                    case 7:
                    try {
                        System.out.println("Ingrese Nombre del Autor");
                        String nombre1 = leer.next();
                        List<Autor> autoresEncontrados = autorServicio.buscarAutorPorNombre(nombre1);
                        System.out.println(autoresEncontrados);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                    }
                    break;
                    case 8:
                    try {
                        System.out.println("Ingrese Nombre de la Editorial");
                        String nombre2 = leer.next();
                        List<Editorial> editorialesEncontradas = editorialServicio.buscarEditorialPorNombre(nombre2);
                        System.out.println(editorialesEncontradas);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                    }
                    break;

                    case 9:
                      try {
                        System.out.println("Ingrese Nombre del Libro");
                        String nombreAutor = leer.next();
                        List<Libro> librosEncontrados = libroServicio.buscarLibrosPorAutor(nombreAutor);
                        System.out.println(librosEncontrados);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                    }
                    break;
                case 10:
                    try {
                        System.out.println("Ingrese nombre del Libro");
                        nombre = leer.next();
                        libroServicio.crearLibro(nombre);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                    }
                    break;
                   case 11:
                     try {
                        libroServicio.listarLibro().forEach((l) -> System.out.println(l.toString()));
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                    }
                    break;
                          case 12:
                   try {
                        System.out.println("Ingrese el ID del Libro");
                        long idbuscado = leer.nextLong();
                        List<Libro> librosEncontrados = libroServicio.buscarLibrosPorId(idbuscado);
                        System.out.println(librosEncontrados);
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                    }
                    break;          
                    case 13:
                        System.out.println("Fin de Programa");
                        rta = "s";
                        break;
                }

            } while (rta.equalsIgnoreCase("N"));
        } catch (InputMismatchException e) {
            System.out.println("Debe ingresar NUMEROS para acceder al menu");
        }
    }// TODO code application logic here
}
