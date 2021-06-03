package eu.senla.statkevich.scooters.service.mappers;

import eu.senla.statkevich.scooters.dto.UserDTO;
import eu.senla.statkevich.scooters.entity.entities.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {IRoleMapper.class})
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    @Mapping(target = "role", source = "role.title")
    @Mapping(target = "pass", expression = "java(null)")
    UserDTO userToUserDto(final Users user);

    // defaultExpression = "java()")
    @Mapping(target = "role", expression = "java(null)")
    Users userDtoToUser(final UserDTO userDTO);

}
