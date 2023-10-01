import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lector {
    // Atributos de clase Bv
    private BufferedReader br;
    private String path;
    private int[] arrInstance;
    private List<Integer> listInstance = new ArrayList<>();
    private Generador gen = new Generador("Ejemplar.txt"); // Para manejo de errores

    /**
     * Constructor de clase, directamente aquí es donde se lee el archivo 
     * Ejemplar.txt y se manejar sus respectivos errores
     * @param path La ruta donde se encuentra nuestro archivo
     */
    public Lector(String path){
        this.path = path;
        try{
            br = new BufferedReader(
                new FileReader(
                    new File(path)));
        }catch(FileNotFoundException e){ // No se encontró el archivo
            gen.escribe(); // Escribimos un arhchivo completamente nuevo bajo ese nombre con valores aleatorios
            try{
                br = new BufferedReader(
                    new FileReader(
                        new File(path)));
            }catch(FileNotFoundException ex){
                System.out.println("Ocurrió un error intentando crear el archivo"); // imposible crear archivo
                System.exit(0);
            }
        }
    }

    /**
     * Método público para crear un arreglo dado el input recibido por el archivo de texto
     * @return Un arreglo ordenado, es un ejemplar correcto sobre el que podemos aplicar IndiceEspecial
     */
    public int[] instanceToArr(){
        String[] parseArr = null;
        try{
            parseArr = br.readLine().split(",");
            br.close();
        }catch(Exception e){
            gen.escribe(); // Si el archivo está vacio, entonces lo rellenamos con valores aleatorios
            try{
                br = new BufferedReader(
                    new FileReader(
                        new File(path)));
                parseArr = br.readLine().split(",");
                br.close();
            }catch(IOException ex){
                System.out.println("Ocurrió un error intentando crear el archivo");
            }
        }
        arrInstance = new int[parseArr.length];
        for(int i = 0; i < parseArr.length; i++){
            try{
               arrInstance[i] = Integer.parseInt(parseArr[i].trim()); 
            }catch(NumberFormatException e){
                System.out.println("Violación del formato de archivo de Texto!"); // Manejor de error de caracteres no deseados
                System.exit(0);
            }
            
        }

        Arrays.sort(arrInstance); // Ordenamos el arreglo, ya que para aplicar este tipo de búsqueda suponemos que está ordenado
        return arrInstance;
    }

    /**
     * Método público para crear una Lista dado el input recibido por el archivo de texto
     * @return Una lista ordenada, es un ejemplar correcto sobre el que podemos aplicar IndiceEspecial
     */
    public List<Integer> instanceToList(){
        String[] parseArr = null;
        try{
            parseArr = br.readLine().split(",");
            br.close();
        }catch(Exception e){
            gen.escribe(); // Si el archivo está vacio, entonces lo rellenamos con valores aleatorios
            try{
                br = new BufferedReader(
                    new FileReader(
                        new File(path)));
                parseArr = br.readLine().split(",");
                br.close();
            }catch(IOException ex){
                System.out.println("Ocurrió un error intentando crear el archivo");
            }
        }
        for(int i = 0; i<parseArr.length; i++){
            try{
               listInstance.add(Integer.parseInt(parseArr[i].trim())); 
            }catch(NumberFormatException e){
                System.out.println("Violación del formato de archivo de Texto!"); // Manejor de error de caracteres no deseados
                System.exit(0);
            }
            
        }
        Collections.sort(listInstance); // Ordenamos la lista, ya que para aplicar este tipo de búsqueda suponemos que está ordenado
        return listInstance;
    }



}
