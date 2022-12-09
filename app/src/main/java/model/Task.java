/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 * @author gpmrks
 */
public class Task {

    private int id;
    private int idProject;
    private String name;
    private String description;
    private String notes;
    private boolean done;
    private LocalDate deadline;
    private LocalDate creationDate;
    private LocalDate modificationDate;

    public Task() {

    }

    public Task(int id, int idProject, String name, String description, String notes, boolean status, LocalDate deadline, LocalDate creationDate, LocalDate modificationDate) {
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.description = description;
        this.notes = notes;
        this.done = status;
        this.deadline = deadline;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean status) {
        this.done = status;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDate modificationDate) {
        this.modificationDate = modificationDate;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", idProject=" + idProject + ", name=" + name + ", description=" + description + ", notes=" + notes + ", status=" + done + ", deadline=" + deadline + ", creationDate=" + creationDate + ", modificationDate=" + modificationDate + '}';
    }

}
