package com.company.rll.service.user;

import com.company.rll.entity.user.UserEntity;
import com.company.rll.repository.user.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public UserEntity loginvalidation(String username, String password) {
    Optional<UserEntity> u = this.userRepository.findByUsername(username);
    if (u.isPresent()) {
      if (
        u.get().getUsername().equals(username) && u.get().getPassword().equals(password)
      ) {
        return u.get();
      }
    }
    return null;
  }

  public List<UserEntity> showall() {
    return this.userRepository.findAll();
  }

  public UserEntity register(UserEntity u) {
    Optional<UserEntity> r = this.userRepository.findById((long) u.getUserId());
    if (!r.isPresent()) {
      return this.userRepository.save(u);
    }
    return null;
  }

  public void removeOne(long userId) {
    this.userRepository.deleteById(userId);
  }

  public long totalNumberOfUsers() {
    return this.userRepository.count();
  }
}
