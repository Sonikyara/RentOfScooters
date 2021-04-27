package work;

import com.sun.istack.NotNull;

public class UserDTO{

    //@NotNull
    private String name;
    private String phoneNumber;
    private String pass;
    private String role;

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

    public void setRoleTitle(String roleTitle) {
        this.role = roleTitle;
    }

    @Override
    public String toString() {
        return "User: "+
                " name="+name+
                ", role="+role+
                ", phone number= "+phoneNumber+
                ", pass= "+pass;
    }

    public static UserDTO getUserDTO(Users user){
        UserDTO userDTO=new UserDTO();

        userDTO.setName(user.getName());
        userDTO.setPass(user.getPass());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        Roles role=user.getRole();
        userDTO.setRoleTitle(role.getId()+"-"+role.getTitle());

        return userDTO;
    }
}
