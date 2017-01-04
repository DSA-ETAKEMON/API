package logica;

import Entity.User;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import Exception.*;
import java.io.IOException;
import java.net.URI;

/**
 * Main class.
 *
 */
public class Main {
    // Base URI the Grizzly HTTP server will listen on
    public static final String BASE_URI = "http://192.168.1.46:9090/etakemon";

    /**
     * Starts Grizzly HTTP server exposing JAX-RS resources defined in this application.
     * @return Grizzly HTTP server.
     */
    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in logica package
        final ResourceConfig rc = new ResourceConfig().packages("logica");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at BASE_URI
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
    }

    /**
     * Main method.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException, FormatException {
      /*  double[] a = new double[2];
        a[0] = 100;
        a[1] = 200;
        double ab = 3600;
        double dis = Gestion.MediaKm(a,ab);*/

       User usr = new User();
        //usr.setName("hicham");
        //usr.setSurname("azouagh");
        usr.setNick("Jona");
        //usr.setEmail("mipinga@a.com");
        usr.setPassword("admin");
        //usr.setPuntuacionTotal(10);
        //usr.setTotalEtakemons(100);
        //usr.insert();

     /*   String res="";
        Login lg = new Login();
        try {
            usr = lg.login(usr);
            res = "ok";
        }catch (NullPointerException e)
        {
        System.out.println(e.toString());
         }
        System.out.print("usuarrio name es :" + usr.getEmail() );
*/
        User a = new User();
        try {
            a.setEmail("asd");
            a.setName("heelo");
            a.setNick("NICK");
            a.setPassword("123");
            a.setPuntuacionTotal(10);
            a.setTotalEtakemons(1);
        } catch (FormatException e )
        {
            System.out.print("-----------" + e.toString());
        }

      //  Login lg = new Login();

       //    String res  = lg.register("mipingaa","123456","qwe","qwe","qwe");
       // System.out.print("-----------" + res);

        //  a = a.selectByNick(a.getNick());
      //  if(a!=null)
      //  a.insert();

        final HttpServer server = startServer();
        System.out.println(String.format("Jersey app started with WADL available at "
                + "%sapplication.wadl\nHit enter to stop it...", BASE_URI));
        System.in.read();
        if(server!=null)
        server.shutdown();
        else
            System.out.println("el servidor esta ya parado !!");
    }
}

