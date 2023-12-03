package applicationtier.DAO.Class;

import applicationtier.model.ClassModel;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class ClassDaoImpl implements ClassDao
{

    public ClassDaoImpl()
    {
        try
        {
            Class.forName("org.postgresql.Driver");
        }
        catch (ClassNotFoundException e)
        {
            throw new RuntimeException("PostgreSQL driver not found", e);
        }
    }

    private Connection getConnection() throws SQLException
    {
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres?currentSchema=GradingSystem",
                "postgres", "password");
    }

    @Override public String addClass(String className, int classId)
    {
        try (Connection connection = getConnection()) {
            // Implement the logic to add a class to the database
            // You may use PreparedStatement for SQL operations
            // Example: PreparedStatement statement = connection.prepareStatement("INSERT INTO ...");
        } catch (SQLException e) {
            // Handle SQL exceptions
            return "Error adding class: " + e.getMessage();
        }
        return "Class added successfully";
    }

    @Override public String deleteClass(String className, int classId)
    {
        try (Connection connection = getConnection()) {

        } catch (SQLException e) {
            // Handle SQL exceptions
            return "Error adding class: " + e.getMessage();
        }
        return "Class added successfully";
    }

    @Override public String editClass(String className, int classId)
    {
        try (Connection connection = getConnection()) {

        } catch (SQLException e) {
            // Handle SQL exceptions
            return "Error adding class: " + e.getMessage();
        }
        return "Class added successfully";
    }

    @Override
    public List<ClassModel> getAllClasses() {
        List<ClassModel> classes = new ArrayList<>();

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM class_table")) {

            while (resultSet.next()) {
                String className = resultSet.getString("class_name_column");
                int classId = resultSet.getInt("class_id_column");

                ClassModel classModel = new ClassModel(className, classId);
                classes.add(classModel);
            }

        } catch (SQLException e) {
            // Handle SQL exceptions
            e.printStackTrace(); // Log the exception or throw a runtime exception
        }

        return classes;
    }

    @Override
    public List<ClassModel> filterClasses(String className) {
        List<ClassModel> filteredClasses = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM class_table WHERE class_name_column = ?")) {

            statement.setString(1, className);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    String resultClassName = resultSet.getString("class_name_column");
                    int resultClassId = resultSet.getInt("class_id_column");

                    ClassModel classModel = new ClassModel(resultClassName, resultClassId);
                    filteredClasses.add(classModel);
                }
            }

        } catch (SQLException e) {
            // Handle SQL exceptions
            e.printStackTrace(); // Log the exception or throw a runtime exception
        }

        return filteredClasses;
    }


    @Override
    public List<ClassModel> filter(String className, String... attrs) {
        List<ClassModel> filteredClasses = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM class_table WHERE attribute_column = ?")) {

            for (String attr : attrs) {
                statement.setString(1, attr);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        String resultClassName = resultSet.getString("class_name_column");
                        int resultClassId = resultSet.getInt("class_id_column");

                        ClassModel classModel = new ClassModel(resultClassName, resultClassId);
                        filteredClasses.add(classModel);
                    }
                }
            }

        } catch (SQLException e) {
            // Handle SQL exceptions
            e.printStackTrace(); // Log the exception or throw a runtime exception
        }

        return filteredClasses;
    }

}
