package DAO;
import Entity.Etakemons;
import Entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by hixam on 21/12/16.
 */
public class DAO extends DAOConnection{
   public void insert() {
        String query = getInsertQuery();
        System.out.println(query);
        Connection con = getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            addClassFieldsParameters(preparedStatement);
            preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                setIntField(generatedKeys.getInt(1), "id", this);
            }
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void select(int primaryKey) {
        String query = getSelectQuery();
        System.out.println(query);
        Connection con = getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            int position = 1;
            addPrimaryKeyParameter(preparedStatement, position, primaryKey);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()) {
                setFieldsFromResultSet(resultSet, resultSetMetaData, this);
            }
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Etakemons selectUnEtakemon(int primaryKey) {
        String query = getSelectQuery();
        System.out.println(query);
        Etakemons etk = new Etakemons();
        Connection con = getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            int position = 1;
            addPrimaryKeyParameter(preparedStatement, position, primaryKey);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()) {
                etk.setId(resultSet.getInt("id"));
                etk.setIdUser(resultSet.getInt("idUser"));
                etk.setTipo(resultSet.getString("tipo"));
                etk.setPuntos(resultSet.getString("puntos"));
                // setFieldsFromResultSet(resultSet, resultSetMetaData, this);
            }
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return etk;
    }



    public List<Etakemons> selectEtakemonByidUser(String nick) {
        String query = getSelectQueryByIDUser();
        System.out.println(query);
        Etakemons etk = new Etakemons();
        List<Etakemons> miLista = new ArrayList<Etakemons>();
        Connection con = getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            int position = 1;
            // addPrimaryKeyParameter(preparedStatement, position, primaryKey);
            ResultSet rs = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            while (rs.next()) {


                    etk.setId(rs.getInt("id"));
                    etk.setIdUser(rs.getInt("idUser"));
                    etk.setTipo(rs.getString("tipo"));
                    etk.setPuntos(rs.getString("puntos"));
                    miLista.add(etk);

                // setFieldsFromResultSet(resultSet, resultSetMetaData, this);
            }
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return miLista;
    }


    public User selectByNick(String nick) {
        String query = getSelectQueryByNick();
        System.out.println(query);
        User user = new User();;
        Connection con = getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            int position = 1;
           // addPrimaryKeyParameter(preparedStatement, position, primaryKey);
            ResultSet rs = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = rs.getMetaData();
            while (rs.next()) {
                if (rs.next()) {

                    user.setId(rs.getInt("id"));
                    user.setNick(rs.getString("nick"));
                    user.setEmail(rs.getString("email"));
                    user.setName(rs.getString("name"));
                }
               // setFieldsFromResultSet(resultSet, resultSetMetaData, this);
            }
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void update() {
        String query = getUpdateQuery();
        System.out.println(query);
        Connection con = getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            addClassFieldsParameters(preparedStatement);
            int primaryKey = getPrimaryKeyParameter();
            int position = (this.getClass().getDeclaredFields().length + 1);
            addPrimaryKeyParameter(preparedStatement, position, primaryKey);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete() {
        String query = getDeleteQuery();
        System.out.println(query);
        Connection con = getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            int position = 1;
            int primaryKey = getPrimaryKeyParameter();
            addPrimaryKeyParameter(preparedStatement, position, primaryKey);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

     public List selectAll() {
        List<Object> objects = new ArrayList<>();
        String query = getSelectAllQuery();
        System.out.println(query);
        Connection con = getConnection();
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()) {
                Class classToLoad = this.getClass();
                Object newObject = classToLoad.newInstance();
                setFieldsFromResultSet(resultSet, resultSetMetaData, newObject);
                objects.add(newObject);
            }
            preparedStatement.close();
            con.close();
        } catch (SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return objects;
    }
}
