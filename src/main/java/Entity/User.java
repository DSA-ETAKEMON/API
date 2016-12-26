package Entity;

/**
 * Created by hicham.az on 09/12/2016.
 */
public class User extends DAO.DAO {


    int totalEtakemons, puntuacionTotal;
    String name;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getTotalEtakemons() {
        return totalEtakemons;
    }

    public void setTotalEtakemons(int totalEtakemons) {
        this.totalEtakemons = totalEtakemons;
    }

    public int getPuntuacionTotal() {
        return puntuacionTotal;
    }

    public void setPuntuacionTotal(int puntuacionTotal) {
        this.puntuacionTotal = puntuacionTotal;
    }

    String surname;
    String Nick;
    String Email;
    String Password;

    public User() {
    }

    public User(String name,String apellidos, String nick, String email, String password,int totalPokemons, int punctuacionTotal) {
        this.totalEtakemons = totalPokemons;
        this.puntuacionTotal = punctuacionTotal;
        this.name = name;
        this.surname = apellidos;
        Nick = nick;
        Email = email;
        Password = password;

    }







    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getNick() {
        return Nick;
    }

    public void setNick(String nick) {
        Nick = nick;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }



    public User getUserByNick(String nick)
    {
        User usr = new User();
        usr = usr.selectByNick(nick);
        return usr;
    }
}
