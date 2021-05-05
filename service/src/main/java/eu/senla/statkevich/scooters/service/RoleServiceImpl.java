package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.dao.IGenericDao;
import eu.senla.statkevich.scooters.dao.IRoleDao;
import eu.senla.statkevich.scooters.dao.RoleDAO;
import eu.senla.statkevich.scooters.dao.UserDAO;
import eu.senla.statkevich.scooters.dao.repository.RolesRepository;
import eu.senla.statkevich.scooters.dao.repository.UsersRepository;
import eu.senla.statkevich.scooters.dto.RoleDTO;
import eu.senla.statkevich.scooters.dto.UserDTO;
import eu.senla.statkevich.scooters.entity.Roles;
import eu.senla.statkevich.scooters.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RolesService{

    @Autowired
    private IRoleDao roleDAO;
    //private IGenericDao<Roles> roleDAO;

//    @Autowired
//    private IUserMapper userMapper;

    @Autowired
    private IRoleMapper roleMapper;

    @Override
    public RoleDTO read(final Long id){
        return roleMapper.roleToRoleDto(roleDAO.read(id));
    };


    public RoleDTO readByTitle(String title) {
        //return roleMapper.roleToRoleDto(roleDAO.readByNameTitle(title));
        return roleMapper.roleToRoleDto(roleDAO.readByTitle(title));
    }

    @Override
    public Roles create(String title) {
        //return roleDAO.create(roleMapper.roleTitleToRole(title));
        return null;
    }


}
