import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        PriorityQueue<Proceso> cola = new PriorityQueue<>();
        String archivo = "C:\\Users\\bianc\\IdeaProjects\\HDT8\\procesos.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                String nombre = campos[0];
                String usuario = campos[1];
                int nice = Integer.parseInt(campos[2]);
                cola.offer(new Proceso(nombre, usuario, nice));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            System.exit(1);
        }
        while (true) {
            System.out.println("Presione enter para obtener el siguiente proceso...");
            try {
                System.in.read();
            } catch (IOException e) {
                System.out.println("Error al leer la entrada: " + e.getMessage());
                System.exit(1);
            }
            if (!cola.isEmpty()) {
                Proceso p = cola.remove();
                System.out.println(p.getNombre() + " (" + p.getUsuario() + ", " + p.getNice() + ", PR=" + p.getPrioridad() + ")");
            } else {
                System.out.println("No hay más procesos en la cola.");
                break;
            }
        }
        }
    }
