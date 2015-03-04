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
import javax.persistence.Column;
import java.lang.Integer;

@Entity
@Table(name = "position")
public class Position {

    private Integer position_id;
    private String position_name;

    public Position() {
    }

    @Id
    @GeneratedValue
    @Column(name = "position_id")
    public Integer getPositionID() {
        return position_id;
    }

    public void setPositionID(Integer position_id) {
        this.position_id = position_id;
    }

    @Column(name = "position_name")
    public String getPositionName() {
        return position_name;
    }

    public void setPositionName(String position_name) {
        this.position_name = position_name;
    }
}
