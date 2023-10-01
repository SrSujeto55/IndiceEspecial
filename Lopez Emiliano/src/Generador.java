import java.io.File;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;

public class Generador {
    private int numeros = (int) (Math.random() * 10 + 5);
    private Set<Integer> conjunto = new HashSet<Integer>();
    private String path;
    private String ejemplar = "";

    public Generador(String path){
        this.path = path;
    }

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
