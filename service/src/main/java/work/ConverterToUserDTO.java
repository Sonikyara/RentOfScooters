package work;

public class ConverterToUserDTO {

    public static UserDTO convertUserToUserDTO(Users user){
        UserDTO userDTO=new UserDTO();

        userDTO.setPass(user.getPass());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        Roles role=user.getRole();
        userDTO.setRoleTitle(role.getId()+role.getTitle());

        return userDTO;
    }
}
