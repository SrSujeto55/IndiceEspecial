// import java.util.concurrent.Semaphore;

public class Main {
    
    public static void main(String[] args) {

        // Semaphore semaph = new Semaphore(2); Semaforo para después
        buscadorIndices bs = new buscadorIndices();
        Lector lector = new Lector("Ejemplar.txt");

        //todo Crear hilos de ejecución para acelerar procesos
        // Se crea el hilo
        // Thread hilo = new Thread(new Runnable() {
        //     @Override
        //     public void run() {
        //         // Se llama a la función
        //         System.out.println("El indice es: " + indicEspecial(arr, 0, arr.length - 1));
        //     }
        // });
        // hilo.start();

        int[] arr = lector.getInstanceArr();
            for(int i = 0; i < arr.length; i++){
                System.out.print(arr[i] + " ");
            }
        System.out.println(bs.indiceEspecialARR(arr));
        
    }
}