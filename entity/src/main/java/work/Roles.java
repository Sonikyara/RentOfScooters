package work;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="roles")
public class Roles extends AEntityWithTitle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "role",fetch = FetchType.LAZY)
                //,cascade = CascadeType.ALL ???
    private List<Users> users;

    public Roles() {}

    public Roles(String title) {
        super(title);
        users=new ArrayList<>();
    }

    public List<Users> getUsers() {        return users;    }
    public void setUsers(List<Users> users) {        this.users = users;    }

    @Override
    public String toString() {
        return "Role: "+super.toString();
    }
}
