// import java.util.concurrent.Semaphore;

import java.util.ArrayList;
import java.util.List;

public class indicEspecial {
    
    public static void main(String[] args) {

        // Semaphore semaph = new Semaphore(2); Semaforo para después
        buscadorIndices bs = new buscadorIndices();
        List<Integer> list = new ArrayList<>();
        // Lista de ejemplo
        list.add(-2);
        list.add(-1);
        list.add(0);
        list.add(3);
        list.add(5);
        list.add(7);
        list.add(9);
        list.add(10);
        list.add(13);
        list.add(21);
        list.add(23);

        //arreglo ejemplo
        int[] arr = new int[list.size()];
        arr[0] = -1;
        arr[1] = -2;
        arr[2] = 0;
        arr[3] = 2;
        arr[4] = 3;
        arr[5] = 4;
        arr[6] = 6;
        arr[7] = 10;
        arr[8] = 13;
        arr[9] = 21;
        arr[10] = 23;

        // Se crea el hilo
        // Thread hilo = new Thread(new Runnable() {
        //     @Override
        //     public void run() {
        //         // Se llama a la función
        //         System.out.println("El indice es: " + indicEspecial(arr, 0, arr.length - 1));
        //     }
        // });
        // hilo.start();
        System.out.println("CON ARREGLOS");
        System.out.println(bs.indiceEspecialARR(arr));
        System.out.println("CON LISTAS");
        System.out.println(bs.indiceEspecialLST(list));

    }
}