package models;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Table(name="UserList")
@NamedQueries({
    @NamedQuery(
            name = "getAllUser",
            query = "SELECT u FROM UserList AS u ORDER BY u.id DESC"
          ),
    @NamedQuery(
            name = "getUserCount",
            query = "SELECT COUNT(u) FROM UserList AS u"
          ),
    @NamedQuery(
            name = "checkRegisterdUserId",
            query = "SELECT u FROM UserList AS u WHERE u.user_id = :user_id"
          ),
    @NamedQuery(
            name = "checkRegisterdUserIdCount",
            query = "SELECT COUNT(u) FROM UserList AS u WHERE u.user_id = :user_id"
          ),
    @NamedQuery(
            name = "checkLoginUserIdAndPassWord",
            query = "SELECT u FROM UserList AS u WHERE u.delete_flag = 0 AND u.user_id = :user_id AND u.password = :pass"
          )
})
@Entity
public class UserList {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="user_id", nullable = false , unique = true)
    private String user_id;

    @Column(name="user_name", nullable = false)
    private String user_name;

    @Column(name="password", length = 64 , nullable = false)
    private String password;

    @Column(name="admin_flag", nullable = false)
    private Integer admin_flag;

    @Column(name = "created_at", nullable = false)
    private Timestamp created_at;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updated_at;

    @Column(name = "delete_flag", nullable = false)
    private Integer delete_flag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAdmin_flag() {
        return admin_flag;
    }

    public void setAdmin_flag(Integer admin_flag) {
        this.admin_flag = admin_flag;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Integer getDelete_flag() {
        return delete_flag;
    }

    public void setDelete_flag(Integer delete_flag) {
        this.delete_flag = delete_flag;
    }


}
