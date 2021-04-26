package com.example.gabriel_jayme.repository;

import com.example.gabriel_jayme.domain.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UsersDAO {
    public ArrayList<Users> listarUsuarios(){
        ArrayList<Users> lista = new ArrayList<Users>();
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
                lista.add(new Users(id,nome,senha));
            }

            //fechar as conexões
            stmt.close();
            con.close();

        } catch (Exception e){
            e.printStackTrace();
        }

        return lista;
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
