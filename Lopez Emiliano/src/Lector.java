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
    private BufferedReader br;
    private String path;
    private int[] arrInstance;
    private List<Integer> listInstance = new ArrayList<>();
    private Generador gen = new Generador("Ejemplar.txt");

    public Lector(String path){
        this.path = path;
        try{
            br = new BufferedReader(
                new FileReader(
                    new File(path)));
        }catch(FileNotFoundException e){
            gen.escribe();
            try{
                br = new BufferedReader(
                    new FileReader(
                        new File(path)));
            }catch(FileNotFoundException ex){
                System.out.println("Ocurrió un error intentando crear el archivo");
            }
        }
    }

    public int[] instanceToArr(){
        String[] parseArr = null;
        try{
            parseArr = br.readLine().split(",");
            br.close();
        }catch(Exception e){
            gen.escribe();
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
                System.out.println("Violación del formato de archivo de Texto!");
                System.exit(0);
            }
            
        }

        Arrays.sort(arrInstance); // Ordenamos el arreglo, ya que para aplicar este tipo de búsqueda suponemos que está ordenado
        return arrInstance;
    }

    public List<Integer> instanceToList(){
        String[] parseArr = null;
        try{
            parseArr = br.readLine().split(",");
            br.close();
        }catch(Exception e){
            gen.escribe();
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
                System.out.println("Violación del formato de archivo de Texto!");
                System.exit(0);
            }
            
        }
        Collections.sort(listInstance); // Ordenamos la lista, ya que para aplicar este tipo de búsqueda suponemos que está ordenado
        return listInstance;
    }



}
