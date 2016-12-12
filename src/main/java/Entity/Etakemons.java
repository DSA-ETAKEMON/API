package Entity;

/**
 * Created by hicham.az on 09/12/2016.
 */
public class Etakemons {

    int id;
    String Tipo,Nombre,Puntos;


    public Etakemons(int id, String tipo, String nombre, String puntos) {
        this.id = id;
        Tipo = tipo;
        Nombre = nombre;
        Puntos = puntos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPuntos() {
        return Puntos;
    }

    public void setPuntos(String puntos) {
        Puntos = puntos;
    }

    public Etakemons (){}


}
