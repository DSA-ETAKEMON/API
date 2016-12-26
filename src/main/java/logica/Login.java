package logica;

import Entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by hixam on 26/12/16.
 */
@Path("user")
public class Login {

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String login(@FormParam("nick") String nick, @FormParam("password") String password) {
        if(nick == null || password == null)
            throw new BadRequestException("all parameters are mandatory");
        User us = new User();
        boolean isOK=false;
        String pass ="";

        String res ="";
        try {
            us = us.getUserByNick(nick);
            isOK =true;
        }catch (Exception e)
        {
            System.out.print(e.toString());
            return e.toString();
        }
        if(us!=null && isOK) {
            pass = us.getPassword();
            if (password.equals(pass))
            res = "Login ok";
            else
                res ="login incorrecto";
        }
        return  res;
    }

    @POST
    @Path("/login2")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String login2(@FormParam("nick") String nick, @FormParam("password") String password) {
        if(nick == null || password == null)
            throw new BadRequestException("all parameters are mandatory");

        return  "ok" + nick + password;
    }
}