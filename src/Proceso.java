public class Proceso implements Comparable<Proceso> {
    private String nombre;
    private String usuario;
    private int nice;

    /***
     *
     * @param nombre
     * @param usuario
     * @param nice
     */
    public Proceso(String nombre, String usuario, int nice) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.nice = nice;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getNice() {
        return nice;
    }

    public int getPrioridad() {
        return 20 + nice;
    }

    @Override
    public int compareTo(Proceso proceso) {
        return Integer.compare(this.getPrioridad(), proceso.getPrioridad());
    }

    @Override
    public String toString() {
        return nombre + "," + usuario + "," + nice + ",PR=" + getPrioridad();
    }
}
