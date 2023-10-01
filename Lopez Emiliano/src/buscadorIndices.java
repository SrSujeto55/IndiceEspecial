import java.util.List;

public class buscadorIndices {
    //Colores :DDDDDDDDDD
    // Solo son colores :D
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

    /**
     * Método privado para imprimir en pantalla la sección sobre la que se está trabajando 
     * en ese preciso momento para hacer más gráfico el proceso
     * FUNCIONA SOLO PARA ARREGLOS
     * @param inicio indice de inicio
     * @param fin indice de final
     */
    private void printArrSection(int inicio, int fin){
        String section = "[";
        int mid = (int) Math.floor((inicio + fin)/2);

        if(color){// Si usamos colore
            for(int i = inicio; i<=fin; i++){
                if(i == mid){
                    section += ANSI_YELLOW + printableArr[i] + ANSI_RESET + ", "; // coloreamos de amarillo el medio del arreglo
                }else{
                    section += printableArr[i] + ", ";
                }
            }
        }else{// No usamos color
            for(int i = inicio; i<=fin; i++){
                section += printableArr[i] + ", ";
            }
        }
        section = section.substring(0, section.length() - 2);
        section += "]";
        System.out.printf("Espacio de búsqueda it %d: %s \n", iteraciones, section);
    }

    /**
     * Método privado para imprimir en pantalla la sección sobre la que se está trabajando 
     * en ese preciso momento para hacer más gráfico el proceso
     * FUNCIONA SOLO PARA LISTAS
     * @param inicio indice de inicio
     * @param fin indice de final
     */
    private void printLstSection(int inicio, int fin){
        String section = "<";
        int mid = (int) Math.floor((inicio + fin)/2);

        if(color){// Si usamos color
            for(int i = inicio; i<=fin; i++){
                if(i == mid){
                    section += ANSI_YELLOW + printableList.get(i) + ANSI_RESET + ", "; // coloreamos de amarillo el medio del arreglo
                }else{
                    section += printableList.get(i) + ", ";
                }
            }
        }else{// No usamos color
            for(int i = inicio; i<=fin; i++){
                section += printableList.get(i) + ", ";
            }
        }
        section = section.substring(0, section.length() - 2);
        section += ">";
        System.out.printf("Espacio de búsqueda it %d: %s \n", iteraciones, section);
    }

    /**
     * Método público que resuelve el problema de encontrar el 
     * índice especial si es que éste existe
     * Trabaja únicamente con arreglos
     * @param array El arreglo sobre el que vamos a trabajar
     * @return un texto que nos dice si existe dicho índice especial o no.
     */
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
            if(color){ //no usamos color
                s = ANSI_YELLOW + "Elemento encontrado: " + especial + ANSI_RESET;
            }else{ //no usamos color
                s = "Elemento encontrado: " + especial;
            }
            return s;
        }else{
             if(color){//usamos color
                s = ANSI_RED + "Ningún elemento cumple con condición" + ANSI_RESET;
            }else{//no usamos color
                s = "Ningún elemento cumple con condición";
            }
            return s;
        }
    }

    /**
     * Método público que resuelve el problema de encontrar el 
     * índice especial si es que éste existe
     * Trabaja únicamente con listas
     * @param list La lista sobre la que vamos a trabajar
     * @return un texto que nos dice si existe dicho índice especial o no.
     */
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
            if(color){//usamos color
                s = ANSI_YELLOW + "Elemento encontrado: " + especial + ANSI_RESET;
            }else{//no usamos color
                s = "Elemento encontrado: " + especial;
            }
            return s;
        }else{
            if(color){//usamos color
                s = ANSI_RED + "Ningún elemento cumple con condición" + ANSI_RESET;
            }else{//no usamos color
                s = "Ningún elemento cumple con condición";
            }
            return s;
        }
    }

    /**
     * Método para conseguir en texto el número de iteraciones 
     * que nos tomó determinar si el problema tiene un índice especial o no
     * @return texto con total de iteracioens
     */
    public String getIteracionesText(){
        if(color){
            return ANSI_BLUE + "total de iteraciones: "+ iteraciones + ANSI_RESET;
        }else{
            return "total de iteraciones: " + iteraciones;
        }
        
    }
}
