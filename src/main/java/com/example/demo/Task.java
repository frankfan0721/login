package com.example.demo;

import javax.persistence.*;

@Entity
@Table(name = "Task")
public class Task{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }



    @Column(name = "Username")
    private String Username;

    @Column(name = "Description")
    private String Description;




    @Override
    public String toString() {
        return String.format(
                "Task[id=%d, Username='%s', Description='%s']",
                id, Username, Description);
    }

}