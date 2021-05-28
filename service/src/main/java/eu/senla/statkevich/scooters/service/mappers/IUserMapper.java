package eu.senla.statkevich.scooters.service.mappers;

import eu.senla.statkevich.scooters.dto.UserDTO;
import eu.senla.statkevich.scooters.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {IRoleMapper.class})
//@Mapper(componentModel = "spring")
public interface IUserMapper {

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    @Mapping(target = "role", source = "role.title")
    UserDTO userToUserDto(final Users user);

    // defaultExpression = "java()")
    @Mapping(target = "role", expression = "java(null)")
    Users userDtoToUser(final UserDTO userDTO);

}
