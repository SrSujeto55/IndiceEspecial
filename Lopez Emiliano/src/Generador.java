import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase pública para crear archivos con ejemplares aleatorios
 * se debe usar solo para el manejo de errores
 */
public class Generador {
    // Atributos de clase :D
    private int numeros = (int) (Math.random() * 10 + 5);
    private Set<Integer> conjunto = new HashSet<Integer>();
    private String path;
    private String ejemplar = "";

    /**
     * Constructor de clase
     * @param path asigna la ruta pasada por parámetros a la ruta de atributos de clase
     */
    public Generador(String path){
        this.path = path;
    }

    /**
     * Método público para crear o llenar el archivo designado con un ejemplar 
     * válido para realizar IndiceEspecial
     */
    public void escribe(){
        try {
            File file = new File(path);
            // crea el archivo si por alguna razón fue eliminado
            if(!file.exists()){
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file, true);

            //Evitamos repeticiones para obtener un ejemplar más limpio
            for (int i = 0; i < numeros; i++) {
                conjunto.add((int)(Math.random()*15));
            }

            for (Integer integer : conjunto) {
                ejemplar += integer + ",";
            }
            ejemplar = ejemplar.substring(0, ejemplar.length() - 1);
            fw.write(ejemplar);
            fw.close();
        }
        catch (Exception e) {
            System.out.println("Error al escribir");
        }
    }
}
