package com.senla.haltvinizki.service.impl;


import com.senla.haltvinizki.dao.CredentialsDao;
import com.senla.haltvinizki.dto.credentials.CredentialsInfoDto;
import com.senla.haltvinizki.dto.credentials.CredentialsWithUserDto;
import com.senla.haltvinizki.entity.Credentials;
import com.senla.haltvinizki.service.CredentialsService;
import com.senla.haltvinizki.service.converter.CredentialsConverter;
import com.senla.haltvinizki.service.exception.CredentialsNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static java.util.Optional.ofNullable;


@Component
@Transactional
@RequiredArgsConstructor
public class CredentialsServiceImpl implements CredentialsService {

    private final CredentialsDao credentialsDao;
    private final CredentialsConverter credentialsConverter;
    private final PasswordEncoder passwordEncoder;

    @Override
    public CredentialsInfoDto delete(Long id) {
        return credentialsConverter.convert(credentialsDao.delete(id));
    }

    @Override
    public CredentialsInfoDto create(CredentialsInfoDto credentialsDto) {
        Credentials credentials = credentialsConverter.convertCreate(credentialsDto,passwordEncoder);
        return credentialsConverter.convert(credentialsDao.create(credentials));
    }

    @Override
    public CredentialsInfoDto update(CredentialsInfoDto credentialsDto) {
        Credentials credentials = credentialsConverter.convert(credentialsDto);
        return credentialsConverter.convert(credentialsDao.update(credentials));
    }

    @Override
    public CredentialsInfoDto getById(Long id) {
        final Credentials credentials = ofNullable(credentialsDao.getById(id))
                .orElseThrow(() -> new CredentialsNotFoundException(id));
        return credentialsConverter.convert(credentials);
    }

    @Override
    public CredentialsWithUserDto getCredentialsWithUser(Long id) {
        return credentialsConverter.covert(credentialsDao.getCredentialsWithUser(id));
    }
}
