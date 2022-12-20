package com.kambok.spring.boot.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import com.kambok.spring.boot.entity.MUser;
import org.springframework.stereotype.Controller;
import com.kambok.spring.boot.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import com.kambok.spring.boot.entity.UserDetailForm;

@Controller
@RequestMapping ("/user" )
public class UserDetailController {
@Autowired
private UserService userService ;
@Autowired
private ModelMapper modelMapper ;

@GetMapping ("/detail/{userId:.+}")
public String getUser(UserDetailForm form , Model model ,
@PathVariable  ("userId" ) String userId ) {

MUser user = userService .getUserOne(userId );
user.setPassword(null );

form = modelMapper.map(user , UserDetailForm.class );

model .addAttribute("userDetailForm" , form );

return "user/detail" ;
}

@PostMapping (value = "/detail" , params = "update" )
public String updateUser(UserDetailForm form , Model model ) {

	userService .updateUserOne(form .getUserId(),
	form .getPassword(),
	form .getUserName());

	return "redirect:/user/showdata" ;
	}

	@PostMapping (value = "/detail" , params = "delete" )
	public String deleteUser(UserDetailForm form , Model model ) {

	userService .deleteUserOne(form .getUserId());

	return "redirect:/user/showdata" ;
	}
}