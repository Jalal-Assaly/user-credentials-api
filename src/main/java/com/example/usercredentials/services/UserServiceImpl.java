package com.example.usercredentials.services;

import com.example.usercredentials.documents.User;
import com.example.usercredentials.models.UserDTO;
import com.example.usercredentials.models.mappers.UserMapper;
import com.example.usercredentials.repositories.UserRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream()
                .map(userMapper::toUserDTO)
                .toList();
    }

    @Override
    public UserDTO findUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User was not found"));
        return userMapper.toUserDTO(user);
    }

    @Override
    public UserDTO findUserBySsn(String ssn) {
        User user = userRepository.findUserBySsn(ssn)
                .orElseThrow(() -> new EntityNotFoundException("User was not found"));
        return userMapper.toUserDTO(user);
    }

    @Override
    public void addUser(UserDTO userDTO) {
        User user = userMapper.toUser(userDTO);
        if(userRepository.existsById(user.getId())) {
            throw new EntityExistsException("User already exists");
        } else {
            userRepository.save(user);
        }
    }

    @Override
    public void deleteUser(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User was not found"));
        userRepository.delete(user);
    }

    @Override
    public void updateUser(String id, UserDTO userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User was not found"));
        BeanUtils.copyProperties(userDTO, user, "id");
        userRepository.save(user);
    }
}
