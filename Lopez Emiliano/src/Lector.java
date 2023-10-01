import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lector {
    private BufferedReader br;
    private int[] arrInstance;
    private List<Integer> listInstance;
    private Generador gen = new Generador("Ejemplar.txt");

    public Lector(String path){
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

    public int[] getInstanceArr(){
        String[] parseArr = null;
        try{
            parseArr = br.readLine().split(",");
            br.close();
        }catch(Exception e){
            System.out.println("error fatal tratando de leer el archivo");
        }
        arrInstance = new int[parseArr.length];
        for(int i = 0; i < parseArr.length; i++){
            arrInstance[i] = Integer.parseInt(parseArr[i].trim());
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
            System.out.println("error fatal tratando de leer el archivo");
        }
        for(int i = 0; i<parseArr.length; i++){
            listInstance.add(Integer.parseInt(parseArr[i].trim()));
        }
        Collections.sort(listInstance); // Ordenamos la lista, ya que para aplicar este tipo de búsqueda suponemos que está ordenado
        return listInstance;
    }



}
