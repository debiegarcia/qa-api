package com.bit2bit.qaapi.service;

import com.bit2bit.qaapi.domain.model.entity.User;
import com.bit2bit.qaapi.domain.persistence.UserRepository;
import com.bit2bit.qaapi.domain.service.UserService;
import com.bit2bit.qaapi.shared.exception.ResourceNotFoundException;
import com.bit2bit.qaapi.shared.exception.ResourceValidationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final static String ENTITY = "User";

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException(ENTITY, userId));
    }

    @Override
    public User create(User request) {
        var existingEmailUser = userRepository.findByEmail(request.getEmail());
        if(existingEmailUser != null)
            throw new ResourceValidationException("An user with the same email already exists");

        try{
            return userRepository.save(request);
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while saving new user");
        }
    }

    @Override
    public User update(Long userId, User request) {
        try{
            return userRepository.findById(userId)
                    .map(user ->
                            userRepository.save(
                                    user.withEmail(request.getEmail())
                                            .withPassword(request.getPassword())
                                            .withFirstName(request.getFirstName())
                                            .withLastName(request.getLastName())
                                            .withBirthDate(request.getBirthDate())
                            )).orElseThrow(()-> new ResourceNotFoundException(ENTITY, userId));
        }
        catch (Exception e){
            throw new ResourceValidationException(ENTITY, "An error occurred while updating user");
        }
    }

    @Override
    public User delete(Long userId) {
        return userRepository.findById(userId)
                .map(user -> {
                    userRepository.delete(user);
                    return user;
                }).orElseThrow(()-> new ResourceNotFoundException(ENTITY, userId));
    }
}
