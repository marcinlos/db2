package pl.edu.agh.iisg.bd213lg.hellodb.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 4152742428120658920L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private String userId;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name = "age")
    private Integer age;

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
