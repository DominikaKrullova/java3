package applicationtier.DAO.Exam;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
public class ExamDaoImpl implements ExamDao
{

        public ExamDaoImpl()
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

        @Override public String addExam(String NameOfExam, int grade, String dt, String class_)
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

        @Override public String deleteExam(String NameOfExam, int grade, String dt, String class_)
        {
            try (Connection connection = getConnection()) {

            } catch (SQLException e) {
                // Handle SQL exceptions
                return "Error adding class: " + e.getMessage();
            }
            return "Class added successfully";
        }

        @Override public String editExam(String NameOfExam, int grade, String dt, String class_)
        {
            try (Connection connection = getConnection()) {

            } catch (SQLException e) {
                // Handle SQL exceptions
                return "Error adding class: " + e.getMessage();
            }
return "Class added successfully";
        }

        @Override public String getAllExams()
        {
            try (Connection connection = getConnection()) {

            } catch (SQLException e) {
                // Handle SQL exceptions
                return "Error adding class: " + e.getMessage();
            }
            return "Class added successfully";
        }

        @Override public String filterExams(String NameOfExam, int grade, String dt, String class_)
        {
            try (Connection connection = getConnection()) {

            } catch (SQLException e) {
                // Handle SQL exceptions
                return "Error adding class: " + e.getMessage();
            }
            return "Class added successfully";
        }

        @Override public String filter(String NameOfExam, int grade, String dt, String class_)
        {
            try (Connection connection = getConnection()) {

            } catch (SQLException e) {
                // Handle SQL exceptions
                return "Error adding class: " + e.getMessage();
            }
            return "Class added successfully";
        }
}
