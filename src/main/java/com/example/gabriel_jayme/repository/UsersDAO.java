package com.example.gabriel_jayme.repository;

import com.example.gabriel_jayme.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class UsersDAO {
    public ArrayList<User> listarUsuarios(){
        ArrayList<User> lista = new ArrayList<User>();
        String nome,senha;
        int id;

        try {
            //Inicializa a database
            Connection con = DatabaseConnection.initializeDatabase();

            //cria a statement
            Statement stmt = con.createStatement();
            ResultSet rs;

            //cria a consulta
            rs = stmt.executeQuery("SELECT * FROM users");

            while ( rs.next() ) {
                id = rs.getInt("id");
                nome = rs.getString("name");
                senha = rs.getString("password");
                lista.add(new User(id,nome,senha));
            }

            //fechar as conexões
            stmt.close();
            con.close();

        } catch (Exception e){
            e.printStackTrace();
        }

        return lista;
    }

    public User getUser(String password) throws SQLException, ClassNotFoundException {

        Connection con = DatabaseConnection.initializeDatabase();

        String sql = "SELECT * FROM users WHERE password = ?";
        User user = new User();

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, password);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()){
            String name = rs.getString("name");
            String pw = rs.getString("password");

            user.setName(name);
            user.setPassword(pw);
        }

        return user;
    }

    //Insere um elemento na DB
    public void inserirEnderecos(String name, String password){
        try {
            //Inicializar a database
            Connection con = DatabaseConnection.initializeDatabase();

            //Criar um SQL
            PreparedStatement st = con.prepareStatement("INSERT INTO users(name,password) VALUES(?,?)");

            //Configurar os parâmetros do statement
            st.setString(1, name);
            st.setString(2, password);

            //Execução que modifica a database
            st.executeUpdate();

            //fechar as conexões
            st.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
