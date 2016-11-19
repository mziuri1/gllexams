package ge.mziuri.gll.dao;

import ge.mziuri.gll.metainfo.MetaInfo;
import ge.mziuri.gll.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    @Override
    public User GetStudent(Long identification) {

        User u = null;

        try {

            pstmt = con.prepareCall("SELECT * FROM student WHERE identification = ?");

            pstmt.setLong(1, identification);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {

                u.setName(rs.getString("name"));
                u.setSurname(rs.getString("surname"));
                u.setIdentification(identification);
                u.setPassword(rs.getString("password"));

            } else {

                System.out.println("Student Not Found !!!");

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return u;

    }

}
