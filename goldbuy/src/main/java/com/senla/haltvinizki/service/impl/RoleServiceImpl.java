package com.senla.haltvinizki.service.impl;

import com.senla.haltvinizki.dao.RoleDao;
import com.senla.haltvinizki.dto.role.RoleInfoDto;
import com.senla.haltvinizki.dto.role.RoleWitUsersDto;
import com.senla.haltvinizki.entity.Role;
import com.senla.haltvinizki.service.RoleService;
import com.senla.haltvinizki.service.converter.RoleConverter;
import com.senla.haltvinizki.service.exception.RoleNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Optional.ofNullable;

@Component
@Transactional
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleDao roleDao;
    private final RoleConverter roleConverter;

    @Override
    public RoleInfoDto delete(Long id) {
        return roleConverter.convert(roleDao.delete(id));
    }

    @Override
    public RoleInfoDto create(RoleInfoDto roleDto) {
        Role role = roleConverter.convert(roleDto);
        return roleConverter.convert(roleDao.create(role));
    }

    @Override
    public RoleInfoDto update(RoleInfoDto roleDto) {
        Role role = roleConverter.convert(roleDto);
        return roleConverter.convert(roleDao.update(role));
    }

    @Override
    public RoleInfoDto getById(Long id) {
        final Role role = ofNullable(roleDao.getById(id))
                .orElseThrow(() -> new RoleNotFoundException(id));
        return roleConverter.convert(role);
    }

    @Override
    public RoleWitUsersDto getRoleWithUsers(Long id) {
        return roleConverter.covertWithUser(roleDao.getRoleWithUsers(id));
    }
}

