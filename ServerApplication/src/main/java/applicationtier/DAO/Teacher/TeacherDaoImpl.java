package applicationtier.DAO.Teacher;

import applicationtier.model.TeacherModel;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherDaoImpl implements TeacherDao
{
    private Connection getConnection() throws SQLException      // This method is used to connect to the database
    {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres?currentSchema=GradingSystem",
                "postgres", "password"
        );
    }

    @Override
    public TeacherModel addTeacher(TeacherModel teacherModel)
    {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("INSERT INTO teacher_table(id, user_id, name, password) VALUES (?, ?, ?, ?)")) {

            statement.setString(1, teacherModel.id());
            statement.setString(2, teacherModel.userId());
            statement.setString(3, teacherModel.name());
            statement.setString(4, teacherModel.password());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception
        }
        return teacherModel;
    }

    @Override
    public String deleteTeacher(String id)
    {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM teacher_table WHERE id = ?")) {

            statement.setString(1, id);

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception
        }
        return id;
    }

    @Override
    public String editTeacher(TeacherModel student)
    {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("UPDATE teacher_table SET user_id = ?, name = ?, password = ? WHERE id = ?")) {

            statement.setString(1, student.userId());
            statement.setString(2, student.name());
            statement.setString(3, student.password());
            statement.setString(4, student.id());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception
        }
        return student.id();
    }

    @Override
    public TeacherModel getTeacherById(String id) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM teacher_table WHERE id = ?")) {

            statement.setString(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String userId = resultSet.getString("user_id");
                    String name = resultSet.getString("name");
                    String password = resultSet.getString("password");

                    return new TeacherModel(id, userId, name, password);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception
        }

        return null;
    }

    @Override
    public List<TeacherModel> getAllTeachers() {
        List<TeacherModel> teachers = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM teacher_table")) {

            executeTeacherQuery(teachers, statement);

        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception
        }

        return teachers;
    }

    @Override
    public List<TeacherModel> filterTeachersByUsername(String username) {
        List<TeacherModel> filteredTeachers = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM teacher_table WHERE user_id = ?")) {

            statement.setString(1, username);

            executeTeacherQuery(filteredTeachers, statement);

        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception
        }

        return filteredTeachers;
    }

    private void executeTeacherQuery(List<TeacherModel> teachers, PreparedStatement statement) throws SQLException {
        try (ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String userId = resultSet.getString("user_id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");

                TeacherModel teacher = new TeacherModel(id, userId, name, password);
                teachers.add(teacher);
            }
        }
    }
}
