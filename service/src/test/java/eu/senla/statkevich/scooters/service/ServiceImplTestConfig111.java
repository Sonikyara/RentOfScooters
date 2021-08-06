package eu.senla.statkevich.scooters.service;

import eu.senla.statkevich.scooters.service.implementations.RoleServiceImpl;
import eu.senla.statkevich.scooters.service.mappers.IRoleMapper;
import eu.senla.statkevich.scooters.service.mappers.IRoleMapperImpl;
import eu.senla.statkevich.scooters.service.services.RolesService;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration //вообще без нее?
public class ServiceImplTestConfig111 {
    @Bean
    public RolesService roleService() {
        return new RoleServiceImpl() {
        };
    }
    @Bean
    public IRoleMapper roleMapper() {
        return new IRoleMapperImpl() {
        };
    }
}
