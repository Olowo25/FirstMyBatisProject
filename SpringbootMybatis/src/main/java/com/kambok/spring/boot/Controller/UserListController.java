package com.kambok.spring.boot.Controller;

import org.springframework.stereotype.Controller;
import com.kambok.spring.boot.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import java.util.List;
import com.kambok.spring.boot.entity.MUser;

@Controller
@RequestMapping ("/user" )
public class UserListController {
@Autowired
private UserService userService ;
/** Display user list screen */
@GetMapping ("/list" )
public String getUserList(Model model ) {
// Get user list
List<MUser> userList = userService.getUsers();
// Registered in Model
model .addAttribute("userList" , userList );
// Display user list screen
return "user/list" ;
}


@GetMapping ("/showdata" )
public String showUserList(Model model ) {
// Get user list
List<MUser> userList = userService .getUsers();
// Registered in Model
model .addAttribute("userList" , userList );
// Display user list screen
return "user/viewlist" ;
}
}