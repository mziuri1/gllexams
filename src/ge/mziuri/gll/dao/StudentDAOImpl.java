package ge.mziuri.gll.dao;

import ge.mziuri.gll.metainfo.MetaInfo;
import ge.mziuri.gll.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAOImpl implements StudentDAO {

    private Connection con;

    private PreparedStatement pstmt;

    public StudentDAOImpl() {

        try {

            Class.forName("org.postgresql.Driver");

            con = DriverManager.getConnection(MetaInfo.DatabaseURL, MetaInfo.Username, MetaInfo.Password);

        } catch (ClassNotFoundException | SQLException ex) {

            System.out.println(ex.getMessage());

        }

    }

    @Override
    public void AddStudent(User u) {

        try {

            pstmt = con.prepareStatement("INSERT INTO student (name, surname, identification, password) VALUES (?,?,?,?)");

            pstmt.setString(1, u.getName());
            pstmt.setString(2, u.getSurname());
            pstmt.setLong(3, u.getIdentification());
            pstmt.setString(4, u.getPassword());

            pstmt.executeUpdate();

        } catch (SQLException ex) {

            System.out.println(ex.getMessage());

        }

    }

    @Override
    public void RemoveStudent(User u) {

    }

}
