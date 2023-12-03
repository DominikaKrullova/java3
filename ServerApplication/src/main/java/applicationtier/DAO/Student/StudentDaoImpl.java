package applicationtier.DAO.Student;

import applicationtier.model.StudentModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao
{
    private Connection getConnection() throws SQLException      // This method is used to connect to the database
    {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres?currentSchema=GradingSystem",
                "postgres", "password"
        );
    }

    @Override
    public String addStudent(String id, String userId, String name, String password)
    {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO student_table(id, user_id, name, password) VALUES (?, ?, ?, ?)")) {

            statement.setString(1, id);
            statement.setString(2, userId);
            statement.setString(3, name);
            statement.setString(4, password);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception
        }
        return id;
    }

    @Override
    public String deleteStudent(String id, String userId, String name, String password)
    {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM student_table WHERE id = ?")) {

            statement.setString(1, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception
        }
        return id;
    }

    @Override
    public String editStudent(String id, String userId, String name, String password)
    {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE student_table SET user_id = ?, name = ?, password = ? WHERE id = ?")) {

            statement.setString(1, userId);
            statement.setString(2, name);
            statement.setString(3, password);
            statement.setString(4, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception
        }
        return id;
    }

    @Override
    public StudentModel getStudentById(String id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM student_table WHERE id = ?")) {

            statement.setString(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String userId = resultSet.getString("user_id");
                    String name = resultSet.getString("name");
                    String password = resultSet.getString("password");

                    return new StudentModel(id, userId, name, password);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception
        }

        return null;
    }

    @Override
    public List<StudentModel> getAllStudents() {
        List<StudentModel> students = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM student_table")) {

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String userId = resultSet.getString("user_id");
                    String name = resultSet.getString("name");
                    String password = resultSet.getString("password");

                    StudentModel student = new StudentModel(id, userId, name, password);
                    students.add(student);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception
        }

        return students;
    }

    @Override
    public List<StudentModel> filterStudentsByUsername(String username) {
        List<StudentModel> filteredStudents = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM student_table WHERE user_id = ?")) {

            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String id = resultSet.getString("id");
                    String userId = resultSet.getString("user_id");
                    String name = resultSet.getString("name");
                    String password = resultSet.getString("password");

                    StudentModel student = new StudentModel(id, userId, name, password);
                    filteredStudents.add(student);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception
        }

        return filteredStudents;
    }
}
