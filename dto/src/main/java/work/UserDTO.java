package work;

import com.sun.istack.NotNull;

public class UserDTO {

    //@NotNull
    private String phoneNumber;
    private String pass;
    private String role;

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

    public String getRole() {
        return role;
    }

    public void setRoleTitle(String roleTitle) {
        this.role = roleTitle;
    }
}
