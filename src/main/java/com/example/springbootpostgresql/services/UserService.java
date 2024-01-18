package com.example.springbootpostgresql.services;

import com.example.springbootpostgresql.dto.UserDTO;
import com.example.springbootpostgresql.entity.Adress;
import com.example.springbootpostgresql.entity.User;
import com.example.springbootpostgresql.repo.IAdresRepository;
import com.example.springbootpostgresql.repo.IUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository _userRepository;
    private final IAdresRepository _adresRepository;
    @Override
    @Transactional
    public UserDTO save(UserDTO userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setLastname(userDto.getLastname());
        final User userDb = _userRepository.save(user);
        List<Adress> list = new ArrayList<>();
        userDto.getAdresses().forEach(item-> {
            Adress adress = new Adress();
            adress.setAdress(item);
            adress.setAdressType(Adress.AdressType.Other);
            adress.setActive(true);
            adress.setUser(userDb);
            list.add(adress);
        });
        _adresRepository.saveAll(list);
        userDto.setId(userDto.getId());
        return userDto;
    };

    @Override
    public void delete(Long Id) {

    }
    @Override
    public List<UserDTO> getAll() {
        List<User> users = _userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        users. forEach(item-> {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(item.getId());
            userDTO.setName(item.getName());
            userDTO.setLastname(item.getLastname());
            userDTO.setAdresses(item.getAdresses().stream().map(Adress::getAdress).collect(Collectors.toList()));
            userDTOS.add(userDTO);
        });
        return userDTOS ;
    }

    @Override
    public Page<UserDTO> getAll(Pageable pageable) {
        return null;
    }
}
