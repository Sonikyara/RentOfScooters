package work;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @OneToMany(mappedBy = "role",fetch = FetchType.LAZY)//"role"-поле в классе users //одна роль ко многим пользователям
                //,cascade = CascadeType.ALL ???
    private List<Users> users;

    public Roles() {}

    public Roles(String title) {
        this.title = title;
        users=new ArrayList<>();
    }

    public int getId() {        return id;    }

    public String getTitle() {        return title;    }

    public void setTitle(String title) {        this.title = title;    }

    public List<Users> getUsers() {        return users;    }
    public void setUsers(List<Users> users) {        this.users = users;    }

    @Override
    public String toString() {
        return "Role: "+
                "id= "+id+
                ", title= "+title;
    }
}
