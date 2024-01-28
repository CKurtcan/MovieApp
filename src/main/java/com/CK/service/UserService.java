package com.CK.service;

import com.CK.dto.request.LoginRequestDto;
import com.CK.dto.request.RegisterRequestDto;
import com.CK.dto.response.LoginResponseDto;
import com.CK.dto.response.RegisterResponseDto;
import com.CK.entity.User;
import com.CK.mapper.UserMapper;
import com.CK.repository.UserRepository;
import com.CK.utility.EStatus;
import com.CK.utility.EUserType;
import com.CK.utility.ICrudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService implements ICrudService<User,Long> {
    private final UserRepository userRepository;
    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public Iterable<User> saveAll(Iterable<User> t) {
        return null;
    }

    @Override
    public Optional<User> findById(Long Id) {
        Optional<User> user = userRepository.findById(Id);
        if (user.isPresent()){
            return user;
        }else{
            throw new NullPointerException("User not found");
        }
    }

    @Override
    public List<User> findAll() {
        List<User> userList = userRepository.findAll();
        if (userList.isEmpty()){
            throw new NullPointerException("User list is empty");
        }
        return userList;
    }

    public User deleteById(Long Id) {
        Optional<User> user = userRepository.findById(Id);
        if(user.isPresent()){
            user.get().setStatus(EStatus.INACTIVE);
            return userRepository.save(user.get());
        }else {
            throw new NullPointerException("User not found");
        }
    }

    @Override
    public Optional<User> findByProductNameIgnoreCase(String productName) {
        return Optional.empty();
    }

    @Override
    public List<User> findByProductNameContainsIgnoreCase(String productName) {
        return null;
    }

    @Override
    public List<User> findByProductPriceBetween(Double startPrice, Double endPrice) {
        return null;
    }

    @Override
    public List<User> findByProductUnitInStockGreaterThan(Integer minStockQuantity) {
        return null;
    }

    @Override
    public List<User> findByProductPriceGreaterThanEqual(Double price) {
        return null;
    }

    @Override
    public Long countByProductCategory(String productCategory) {
        return null;
    }

    @Override
    public Integer countByProductName(String productName) {
        return null;
    }

    @Override
    public boolean existsByProductCategory(String productCategory) {
        return false;
    }

    @Override
    public List<User> findByProductCategoryIsNull() {
        return null;
    }

    @Override
    public List<User> findByProductCategoryStartingWith(char startChar) {
        return null;
    }

    public User register(String name,String surname,String email,String password, String rePassword){
        User registeredUser = User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .rePassword(rePassword)
                .build();
        if (!password.equals(rePassword) || password.isBlank()){
            throw new RuntimeException("Password not match");
        }else {
            userRepository.save(registeredUser);
            return registeredUser;
        }
    }

    public User login(String email, String password){
        Optional<User> user = userRepository.findByEmailAndPassword(email, password);
        if (user.isEmpty()){
            throw  new RuntimeException("User not found");
        }
        return user.get();
    }

    public RegisterResponseDto registerDto(RegisterRequestDto dto){

        User user = User.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .rePassword(dto.getRePassword())
                .build();
        if (!user.getPassword().equals(user.getRePassword()) || user.getPassword().isBlank()){
            throw new RuntimeException("Password not match");
        }
        userRepository.save(user);
        //RequestDto -> User -> ResponseDto
        //User'ın içini Request dto ile, Response'un içini oluşturduğumuz user'ın değerleriyle doldurmalıyız
        return RegisterResponseDto.builder()
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .build();
    }

    public LoginResponseDto loginDto(LoginRequestDto dto){
        Optional<User> optionalUser = userRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (optionalUser.isEmpty()){
            throw new RuntimeException("User not found");
        }else {
            User user = optionalUser.get();
            return LoginResponseDto.builder()
                    .email(user.getEmail())
                    .build();
        }
    }

    public LoginResponseDto loginMapper(LoginRequestDto dto){
        Optional<User> optionalUser = userRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
        if (optionalUser.isEmpty()){
            throw new RuntimeException("User not found");
        }
        return UserMapper.INSTANCE.fromUserToLoginResponseDto(optionalUser.get());
    }

    public RegisterResponseDto registerMapper(RegisterRequestDto dto){
        String email = dto.getEmail();
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("E-mail is already registered");
        }
        User user = UserMapper.INSTANCE.fromRegisterRequestDtoToUser(dto);
        if (!user.getPassword().equals(user.getRePassword()) || user.getPassword().isBlank()){
            throw new RuntimeException("Password not match");
        }
        if (email.toLowerCase().contains("admin")) {
            user.setStatus(EStatus.ACTIVE);
            user.setUserType(EUserType.ADMIN);
        }
        userRepository.save(user);

        return UserMapper.INSTANCE.fromUserToRegisterResponseDto(user);
    }

    public List<User> listByName(){
        List<User> userList = userRepository.findAll();
        if (userList.isEmpty()){
            throw new NullPointerException("User list is empty");
        }
        return userList.stream()
                .sorted(Comparator.comparing(User::getName))
                .collect(Collectors.toList());
    }

    public Boolean checkUserName(String name) {
        List<User> userList = userRepository.findAll();
        if (userList.isEmpty()){
            throw new NullPointerException("User list is empty");
        }
        return userList.stream()
                .anyMatch(user -> user.getName().equals(name));
    }

    public List<User> searchUsers(String keyword) {
        return userRepository.findAll().stream().
                filter(user -> user.getName().contains(keyword))
                .collect(Collectors.toList());
    }
}
