package lt.codeacademy.invoice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.codeacademy.invoice.entities.User;
import lt.codeacademy.invoice.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public List<User> getUserList(){
		return userRepository.findAll();
	}
	
	public User addUser(User user) {
		return userRepository.save(user);
	}
	
	public User getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		
		if (user.isEmpty()) {
			return null;
		}
		return user.get();
	}
	
	public User updateUserById(Long id, User user) {
		
		return userRepository.save(user);
	}
	
	public String deleteUserById(Long id) {
		boolean exists = userRepository.existsById(id);
		
		if (exists) {
			userRepository.deleteById(id);
			return "User was deleted with id:" + id;
		}
		return "User does not exist";
	}

}
