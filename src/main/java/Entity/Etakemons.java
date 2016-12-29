package Entity;

import DAO.DAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hicham.az on 09/12/2016.
 */
public class Etakemons extends DAO {

    int id;
int Puntos;
    String Tipo,Nombre;

/*
    public Etakemons(int id, String tipo, String nombre, String puntos) {
        this.id = id;
        Tipo = tipo;
        Nombre = nombre;
        Puntos = puntos;
    }
*/

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

    public int getPuntos() {
        return Puntos;
    }

    public void setPuntos(int puntos) {
        Puntos = puntos;
    }

    public Etakemons (){}

    public List<Etakemons> getEtakemons(String nick)
    {
        List<Etakemons> miLista = new ArrayList<Etakemons>();
        Etakemons etk = new Etakemons();
        miLista = etk.selectEtakemonByidUser(nick);
        return miLista;
    }

    public Etakemons getEtakemon(int id)
    {
        Etakemons etk  = new Etakemons();
        return etk.selectUnEtakemon(id);
    }

}
