import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

    public static VectorHeap<Proceso> leerProcesos(String archivo) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(archivo));
        VectorHeap<Proceso> procesos = new VectorHeap<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] campos = line.split(",");

            String nombre = campos[0];
            String usuario = campos[1];
            int nice = Integer.parseInt(campos[2]);

            Proceso proceso = new Proceso(nombre, usuario, nice);
            procesos.add(proceso);
        }

        return procesos;
    }
}
