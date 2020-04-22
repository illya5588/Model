package JDBC;

import exceptions.UniqueException;
import model.Subject;
import model.SubjectType;
import org.postgresql.util.PSQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

// TODO make name and term unique +
//TODO create methods for create, delete table subject +
//TODO create method for add subject into table via prepared statement;+
//TODO create Unique subject exception +
//TODO create constants for username and password, port, database +
//TODO create method for get all subject from table (public List<Subject> allSubjects()   ) using ResultSet +
//Maven, gradle
public class PostgreSqlExample {
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "290798is";
    private static final String URL = "jdbc:postgresql://localhost:5432/test2";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test2", LOGIN, PASSWORD)) {
            System.out.println("Connection to Data Base is SUCCESSFUL! ");
           //createNewTable();
            //deleteSubjectTable();
            //addSubjectInToTable("Java",2,"Exam");
            System.out.println(getAllSubjectsFromTable());

        } catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }

    public static void createNewTable() {
        String sql = "CREATE TABLE IF NOT EXISTS subject( subject_id serial PRIMARY KEY,  name VARCHAR (50) NOT NULL UNIQUE, term INTEGER NOT NULL UNIQUE, type VARCHAR (10) NOT NULL, created_on TIMESTAMP NOT NULL, updated_at TIMESTAMP)";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
             Statement stmt = connection.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("New table successfully created! ");

        } catch (SQLException e) {
            System.out.println("Connection failure!");
        }
    }

    public static void deleteSubjectTable () {
        String sql = "DROP TABLE subject";
        try(Connection connection = DriverManager.getConnection(URL,LOGIN,PASSWORD)){
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.execute();
            ps.close();
            System.out.println("Table is successfully deleted! ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void addSubjectInToTable(String name, int term, String type) throws SQLException {
        Calendar calendar = Calendar.getInstance();
        java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
        String sql = "INSERT INTO subject (name, term, type, created_on)"
                + "values(?,?,?,?)";

        try (Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, term);
            preparedStatement.setString(3, type);
            preparedStatement.setDate(4, startDate);

            preparedStatement.executeUpdate();
            System.out.println("Subject is successfully added! ");
        } catch (PSQLException e) {
            throw new UniqueException("This subject is already in the table!!!");
        }
    }

    public static void deleteSubjectFromTable(String name) throws SQLException {
        String sql = "DELETE FROM subject WHERE name = ?";

        Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, name);
        preparedStatement.execute();
        connection.close();
        System.out.println("Subject is successfully deleted! ");

    }

    public static List<Subject> getAllSubjectsFromTable() throws SQLException {
        List<Subject> allSubjects = new ArrayList<>();


        String sql = "SELECT *  FROM subject";
        Connection connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            Subject subject = new Subject();
            subject.setName(rs.getString("name"));
            subject.setTerm(rs.getInt("term"));
            subject.setType(SubjectType.EXAM);
            allSubjects.add(subject);
        }

        rs.close();


        return allSubjects;
    }


}



