package controller;

import model.Task;
import util.ConnectionFactory;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TaskController {

    public void save(Task task) {

        String sql = "INSERT INTO tasks (idProject, name, description, status, notes, deadline, creation_date, modification_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isDone());
            statement.setString(5, task.getNotes());
            statement.setDate(6, Date.valueOf(task.getDeadline()));
            statement.setDate(7, Date.valueOf(task.getCreationDate()));
            statement.setDate(8, Date.valueOf(task.getModificationDate()));
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar a tarefa!" + e.getMessage() + e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public void update(Task task) {

        String sql = "UPDATE tasks SET" +
                " idProject = ?," +
                " name = ?," +
                " description = ?," +
                " status = ?," +
                " notes = ?," +
                " deadline = ?," +
                " creation_date = ?," +
                " modification_date = ?" +
                " WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isDone());
            statement.setString(5, task.getNotes());
            statement.setDate(6, Date.valueOf(task.getDeadline()));
            statement.setDate(7, Date.valueOf(task.getCreationDate()));
            statement.setDate(8, Date.valueOf(task.getModificationDate()));
            statement.setInt(9, task.getId());
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar a tarefa!" + e.getMessage() + e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public void deleteById(int taskId) {
        String sql = "DELETE FROM tasks WHERE id = ?";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, taskId);
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar a tarefa!" + e.getMessage() + e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public List<Task> getAll(int idProject) {

        String sql = "SELECT * FROM tasks WHERE idProject = ?";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Task> tasks = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, idProject);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Task task = new Task();
                task.setId(resultSet.getInt("id"));
                task.setIdProject(resultSet.getInt("idProject"));
                task.setName(resultSet.getString("name"));
                task.setDescription(resultSet.getString("description"));
                task.setDone(resultSet.getBoolean("status"));
                task.setNotes(resultSet.getString("notes"));
                task.setDeadline(resultSet.getDate("deadline").toLocalDate());
                task.setCreationDate(resultSet.getDate("creation_date").toLocalDate());
                task.setModificationDate(resultSet.getDate("modification_date").toLocalDate());

                tasks.add(task);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar as tarefas!" + e.getMessage() + e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }

        return tasks;
    }

}
