package comspring.serviceImpl;

import comspring.entites.User;
import comspring.repository.UserRepo;
import comspring.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserRepo userRepo;

    @Override
    public User createUser(User user) {
        System.out.println("Call Save"+user);
        logger.info("create User", user);
        return userRepo.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> optionalUser = userRepo.findById(id);
        return optionalUser.orElse(null);
    }

    @Override
    public User updateUser(Long id, User userDetails) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUName(userDetails.getUName());
            user.setUEmail(userDetails.getUEmail());
            user.setPassword(userDetails.getPassword());
            return userRepo.save(user);
        }
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        logger.info("call getAll Users ");
        System.out.println("Call");
        return userRepo.findAll();
    }
}
