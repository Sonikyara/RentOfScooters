package eu.senla.statkevich.scooters.dto;

import eu.senla.statkevich.scooters.entity.Roles;
import eu.senla.statkevich.scooters.entity.Users;

public class UserDTO{

    private Long id;
    //@NotNull
    private String name;
    private String phoneNumber;
    private String pass;
    //private RoleDTO roleDTO;
    private String role;

    public Long getId() {        return id;    }
    public void setId(Long id) {        this.id = id;    }

    public String getName() {        return name;    }
    public void setName(String name) {        this.name = name;    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {        return role;    }
    public void setRole(String role) {        this.role = role;    }

//    public RoleDTO getRoleDTO() {        return roleDTO;    }
//    public void setRoleDTO(RoleDTO roleDTO) {        this.roleDTO = roleDTO;    }

    @Override
    public String toString() {
        return "User: "+
                " id="+id+
                " name="+name+
                //", role="+roleDTO.getTitle()+
                ", role="+role+
                ", phone number= "+phoneNumber+
                ", pass= "+pass;
    }
}
