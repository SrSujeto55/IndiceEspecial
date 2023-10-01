import java.util.List;

public class Main {
    public static void uso(){
        System.out.println("Uso: java Main <-l | -a> <-c | > \n (-l List) \n (-a Array) \n (Opcional: -c)");
        System.exit(0);
    }
    
    public static void main(String[] args) {
        boolean flagC = false; // Decidimos si se usará o no colores dentro de la terminal
        boolean flagTipo = false; // Decidimos entre el uso de arreglos o listas, por default usaremos listas
        buscadorIndices bi; 
        //Manejo de errores de terminal
        if(args.length > 2){
            uso();
        }

        //Manejo de bandera color en terminal
        if(args.length == 2){
            flagC = args[1].equals("-c");
        }

        // Si se usa la bandera -a, el valor será true y por ende usaremos arrays
        // por default usaremos false: list
        if(args.length > 0){
            flagTipo = args[0].equals("-a");
            if(!flagC){
              flagC = args[0].equals("-c");  
            }
            
        }

        if(flagC){
            bi = new buscadorIndices(true);
        }else{
            bi = new buscadorIndices(false);
        }

        Lector lector = new Lector("Ejemplar.txt");

        // Manejamos mediante el uso de flagTipo el tipo de estructura que se usará entre Lista y Arreglo
        if(flagTipo){
            int[] arr = lector.instanceToArr();
            System.out.println(bi.indiceEspecialARR(arr));
            System.out.println(bi.getIteracionesText());
        }else{
            List<Integer> list = lector.instanceToList();
            System.out.println(bi.indiceEspecialLST(list));
            System.out.println(bi.getIteracionesText());
        }
    }
}