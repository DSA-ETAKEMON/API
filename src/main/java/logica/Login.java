package logica;

import Entity.User;
import Exception.*;
import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by hixam on 26/12/16.
 */
@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Login {

    @POST
    @Path("/login")
    public User login(String miUsr) {
        if(miUsr == null)
            throw new BadRequestException("all parameters are mandatory");

        User us = new User();
        Gson gson = new Gson();
        us = gson.fromJson(miUsr, User.class);
        boolean isOK=false;
        String pass ="";
        User mius = new User();
        String res ="";
        try {
            mius = us.getUserByNick(us.getNick());
            isOK =true;
        }catch (Exception e)
            {
            System.out.print(e.toString());
            // e.toString();
            }
        if(mius!=null && isOK && us.getPassword() != null) {
            pass = mius.getPassword();
            if (us.getPassword().equals(pass))
            res = "Login ok";
            else
                res ="login incorrecto";
        }
        return  mius;
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User register(String miUsr) {
        if(miUsr == null)
            throw new BadRequestException("all parameters are mandatory");

        User us = new User();
        Gson gson = new Gson();
        us = gson.fromJson(miUsr, User.class);
        boolean UserExists=false,insertOK=false;

        String res ="";

<<<<<<< HEAD

            us = us.getUserByNick(nick);
            if(us.getNick()!=null)
=======
        try {
            User usr = new User();
            usr = us.getUserByNick(us.getNick());
            if(usr.getNick()!=null)
>>>>>>> 3a4f91d12f7d21d02b88a560a7495a5d3b78032e
            UserExists =true;


        if(!UserExists) {
            try {
<<<<<<< HEAD
                us.setPuntuacionTotal(10);
                us.setTotalEtakemons(1);
                us.setPassword(password);
                us.setEmail(email);
                us.setSurname(surname);
                us.setName(name);
                us.setNick(nick);
            } catch (FormatException e) {
=======
                us.setTotalEtakemons(0);
                us.setPuntuacionTotal(0);
            } catch (NullPointerException e) {
>>>>>>> 3a4f91d12f7d21d02b88a560a7495a5d3b78032e
                res = "los campos no pueden ser nulos";
            }

            try {
                us.insert();
                res = "Usuario registrado";
                insertOK = true;
            } catch (Exception e) {
                System.out.print(e.toString());
                // e.toString();
            }
        }
        else
        {
            res = "el nick ya existe";
        }
        return  us;
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
