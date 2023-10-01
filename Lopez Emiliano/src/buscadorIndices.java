import java.util.List;

public class buscadorIndices {
    //Colores :DDDDDDDDDD
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";
    
    //Atributos de clase
    private boolean color;
    private int iteraciones = 0;
    private int[] printableArr;
    private List<Integer> printableList;

    /**
     * Constructor de clase, nos permite determinar desde el inicio de la instanciación si usaremos colores o no
     * @param color valor booleano que representa si se usará color o no
     */
    public buscadorIndices(boolean color){
        this.color = color;
    }

    private void printArrSection(int inicio, int fin){
        String section = "[";
        int mid = (int) Math.floor((inicio + fin)/2);

        if(color){
            for(int i = inicio; i<=fin; i++){
                if(i == mid){
                    section += ANSI_YELLOW + printableArr[i] + ANSI_RESET + ", "; // coloreamos de amarillo el medio del arreglo
                }else{
                    section += printableArr[i] + ", ";
                }
            }
        }else{
            for(int i = inicio; i<=fin; i++){
                section += printableArr[i] + ", ";
            }
        }
        section = section.substring(0, section.length() - 2);
        section += "]";
        System.out.printf("Espacio de búsqueda it %d: %s \n", iteraciones, section);
    }

    private void printLstSection(int inicio, int fin){
        String section = "<";
        int mid = (int) Math.floor((inicio + fin)/2);

        if(color){
            for(int i = inicio; i<=fin; i++){
                if(i == mid){
                    section += ANSI_YELLOW + printableList.get(i) + ANSI_RESET + ", "; // coloreamos de amarillo el medio del arreglo
                }else{
                    section += printableList.get(i) + ", ";
                }
            }
        }else{
            for(int i = inicio; i<=fin; i++){
                section += printableList.get(i) + ", ";
            }
        }
        section = section.substring(0, section.length() - 2);
        section += ">";
        System.out.printf("Espacio de búsqueda it %d: %s \n", iteraciones, section);
    }


    public String indiceEspecialARR(int[] array){
        iteraciones = 0;
        this.printableArr = array;
        int especial = -1;
        int inicio = 0;
        int fin = array.length-1;
        int mid;
        String s;

        while(inicio < fin){
            iteraciones++;
            mid = (int) Math.floor((inicio + fin)/2);
            printArrSection(inicio, fin);
            if(array[mid] == mid){
                especial = mid;
                break;
            }
            else if(array[mid] < mid){
                inicio = mid + 1;
            }else{
                fin = mid;
            }
        }

        if(especial != -1){
            if(color){
                s = ANSI_YELLOW + "Elemento encontrado: " + especial + ANSI_RESET;
            }else{
                s = "Elemento encontrado: " + especial;
            }
            return s;
        }else{
            s = "Ningún elemento cumple con condición";
            return s;
        }
    }

    
    public String indiceEspecialLST(List<Integer> list){
        iteraciones = 0;
        this.printableList = list;
        int especial = -1;
        int inicio = 0;
        int fin = list.size() -1;
        int mid;
        String s;

        while(inicio < fin){
            iteraciones++;
            mid = (int) Math.floor((inicio + fin)/2);
            printLstSection(inicio, fin);
            if(list.get(mid) == mid){
                especial = mid;
                break;
            }
            else if(list.get(mid) < mid){
                inicio = mid + 1;
            }else{
                fin = mid;
            }
        }

        if(especial != -1){
            if(color){
                s = ANSI_YELLOW + "Elemento encontrado: " + especial + ANSI_RESET;
            }else{
                s = "Elemento encontrado: " + especial;
            }
            return s;
        }else{
            if(color){
                s = ANSI_RED + "Ningún elemento cumple con condición" + ANSI_RESET;
            }else{
                s = "Ningún elemento cumple con condición";
            }
            return s;
        }
    }

    public String getIteracionesText(){
        if(color){
            return ANSI_BLUE + "total de iteraciones: "+ iteraciones + ANSI_RESET;
        }else{
            return "total de iteraciones: " + iteraciones;
        }
        
    }
}
