import java.util.List;

public class buscadorIndices {
    public String indiceEspecialARR(int[] array){
        int especial = -1;
        int inicio = 0;
        int fin = array.length-1;
        int mid;
        String s;

        while(inicio < fin){
            mid = (int) Math.floor((inicio + fin)/2);
            if(array[mid] == mid){
                especial = mid;
                break;
            }
            else if(array[mid] > mid)
                fin = mid -1;
            else
                inicio = mid + 1;
        }
        //todo arreglar el caso donde el elemento especial es la última iteracion, puede ser como estamos tomando el subarreglo
        // if(array[mid] == mid){
        //         especial = mid;
        // }

        if(especial != -1){
            s = "Elemento encontrado: " + especial;
            return s;
        }else{
            s = "Ningún elemento cumple con condición";
            return s;
        }
    }

    
    public String indiceEspecialLST(List<Integer> list){
        int especial = -1;
        int inicio = 0;
        int fin = list.size() -1;
        int mid;
        String s;

        while(inicio < fin){
            mid = (int) Math.floor((inicio + fin)/2);
            if(list.get(mid) == mid){
                especial = mid;
                break;
            }
            else if(list.get(mid) > mid)
                fin = mid -1;
            else
                inicio = mid + 1;
        }
        if(especial != -1){
            s = "Elemento encontrado: " + especial;
            return s;
        }else{
            s = "Ningún elemento cumple con condición";
            return s;
        }
    }
}
