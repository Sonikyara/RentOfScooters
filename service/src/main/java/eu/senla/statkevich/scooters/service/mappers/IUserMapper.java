package eu.senla.statkevich.scooters.service.mappers;

import eu.senla.statkevich.scooters.dto.UserDTO;
import eu.senla.statkevich.scooters.entities.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {IRoleMapper.class})
public interface IUserMapper {

    @Mapping(target = "role", source = "role.title")
    @Mapping(target = "pass", expression = "java(null)")
    UserDTO userToUserDto(final Users user);

    // defaultExpression = "java()")
    @Mapping(target = "role", expression = "java(null)")
    Users userDtoToUser(final UserDTO userDTO);

}
