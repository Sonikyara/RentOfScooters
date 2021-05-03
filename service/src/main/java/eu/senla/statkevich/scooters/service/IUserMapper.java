package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dao.IRoleDao;
import eu.senla.statkevich.scooters.dto.RoleDTO;
import eu.senla.statkevich.scooters.dto.UserDTO;
import eu.senla.statkevich.scooters.entity.Roles;
import eu.senla.statkevich.scooters.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {IRoleMapper.class})
//@Mapper(componentModel = "spring")
public interface IUserMapper{

    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    @Mapping(target = "role", source = "role.title")//,
    UserDTO userToUserDto(final Users  user);

    // defaultExpression = "java()")
    @Mapping(target = "role", expression = "java(null)")//,
    Users userDtoToUser(final UserDTO userDTO);

}
