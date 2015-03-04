/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

/**
 *
 * @author Architect
 */
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Column;

@Entity
@Table(name = "player")
public class Player {

    private Integer player_id;
    private String first_name;
    private String last_name;
    private Position position;
    private Integer jersey_number;
    private String university;

    public Player() {
    }

    public String outputString() {
        return String.format("%-16s%-16s%-20s%-10d%s", first_name, last_name, position.getPositionName(), jersey_number, university);
    }

    public String outputString2() {
        return String.format("%-3s%-16s%-16s%-20s%-10d%s", player_id, first_name, last_name, position.getPositionName(), jersey_number, university);
    }

    @Id
    @GeneratedValue
    @Column(name = "player_id")
    public Integer getPlayerID() {
        return player_id;
    }

    public void setPlayerID(Integer player_id) {
        this.player_id = player_id;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    @ManyToOne
    @JoinColumn(name = "position")
    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Column(name = "jersey_number")
    public Integer getJerseyNumber() {
        return jersey_number;
    }

    public void setJerseyNumber(Integer jersey_number) {
        this.jersey_number = jersey_number;
    }

    @Column(name = "university")
    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
