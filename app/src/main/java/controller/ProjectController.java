package controller;

import model.Project;
import util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectController {

    public void save(Project project) {

        String sql = "INSERT INTO projects (name, description, creation_date, modification_date) VALUES (?, ?, ?, ?)";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, Date.valueOf(project.getCreationDate()));
            statement.setDate(4, Date.valueOf(project.getModificationDate()));
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar projeto!" + e.getMessage() + e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void update(Project project) {

        String sql = "UPDATE projects SET" +
                " name = ?," +
                " description = ?," +
                " creation_date = ?," +
                " modification_date = ?" +
                " WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setDate(3, Date.valueOf(project.getCreationDate()));
            statement.setDate(4, Date.valueOf(project.getModificationDate()));
            statement.setInt(5, project.getId());
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar projeto!" + e.getMessage() + e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }

    public void deleteById(int projectId) {

        String sql = "DELETE FROM projects WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setInt(1, projectId);
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar projeto!" + e.getMessage() + e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }

    }

    public List<Project> getAll() {

        String sql = "SELECT * FROM projects";
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        List<Project> projects = new ArrayList<>();

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreationDate(resultSet.getDate("creation_date").toLocalDate());
                project.setModificationDate(resultSet.getDate("modification_date").toLocalDate());

                projects.add(project);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar os projetos!" + e.getMessage() + e);
        } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }

        return projects;
    }

}
