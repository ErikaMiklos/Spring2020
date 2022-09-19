package sample.data.jpa.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import sample.data.jpa.domain.User;
import sample.data.jpa.exception.ResourceNotFoundException;
import sample.data.jpa.service.UserDao;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
  // Private fields
  @Autowired
  private UserDao userDao;

  /**
   * POST /create  --> Create a new user and save it in the database.
   */
  @PostMapping
  public User create(@RequestBody User user) {
    return userDao.save(user);
  }
  
  /**
   * DELETE /delete  --> Delete the user having the passed id.
   */
  @DeleteMapping("{id}")
  public void delete(@PathVariable long id) {
    User user1 = userDao.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("User", "id", id)
    );
    userDao.delete(user1);
  }

  /**
   * GET /*  --> Return the list of users.
   */
  @GetMapping
  public List<User> getUsers() {
    return userDao.findAll();
  }
  
  /**
   * GET /get-by-email  --> Return the id for user having the passed email.
   * email.
   */
  @GetMapping(path = "{email}")
  public Long getByEmail(@PathVariable(name = "email") String email) {
    User user1 = userDao.findByEmail(email).orElseThrow(
            () -> new ResourceNotFoundException("User", "email", email)
    );
    return user1.getId();
  }
  
  /**
   * PUT /update  --> Update the email and the name for the user in the
   * database having the passed id.
   */
  @PutMapping(path = "{id}")
  public User updateUser(@PathVariable long id, @RequestBody User user) {
    User user1 = userDao.findById(id).orElseThrow(
            () -> new ResourceNotFoundException("User", "id", id)
    );
    user1.setEmail(user.getEmail());
    user1.setName(user.getName());

    return userDao.save(user1);
  }

}