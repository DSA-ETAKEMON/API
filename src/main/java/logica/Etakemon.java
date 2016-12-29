package logica;

import Entity.Etakemons;
import Entity.User;
import Exception.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by hixam on 29/12/16.
 */
@Path("etakemon")
public class Etakemon {

    @POST
    @Path("/insert")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String register(@FormParam("name") String name, @FormParam("tipo") String tipo,
                           @FormParam("puntos") int puntos) {
        if(name == null || tipo == null)
            throw new BadRequestException("all parameters are mandatory");

        Etakemons etk = new Etakemons();

        String res ="";

        try {
            etk.setNombre(name);
            etk.setPuntos(puntos);
            etk.setTipo(tipo);
        }catch (Exception e)
        {
            System.out.print(e.toString());
            res = e.toString();
        }

        if(etk.getNombre()!=null || etk.getTipo()!=null) {
            try {
                etk.insert();
                res = "Etakemon insertado";
            } catch (Exception e) {
                System.out.print(e.toString());
                res = "error al insertar etkemon ------- "+e.toString();
            }
        }
        return  res;
    }
}
