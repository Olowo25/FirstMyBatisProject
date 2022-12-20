package com.kambok.spring.boot.Controller;

import java.util.Locale;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kambok.spring.boot.entity.GroupOrder;
import com.kambok.spring.boot.entity.MUser;
import com.kambok.spring.boot.entity.SignupForm;
import com.kambok.spring.boot.service.UserApplicationService;
import com.kambok.spring.boot.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {
@Autowired
private UserApplicationService userApplicationService ;
@Autowired
private UserService userService ;
@Autowired
private ModelMapper modelMapper ; 5

@GetMapping ("/signup" )
public String getSignup(Model model, Locale locale,@ModelAttribute SignupForm form ) {
	
Map<String, Integer> genderMap = userApplicationService.getGenderMap(locale);
model.addAttribute("genderMap" , genderMap );

return "signup" ;
}


@PostMapping ("/signup" )
public String postSignup(Model model , Locale locale ,
		@ModelAttribute @Validated(GroupOrder.class ) SignupForm form ,
BindingResult bindingResult ) {
// Input check result
if (bindingResult .hasErrors()) {
	
	return getSignup(model , locale , form );
	}
	log.info(form .toString());
	// Redirect to login screen
	
	MUser user = modelMapper.map(form , MUser.class );
	// user signup
	userService.signup(user);
	
	return "redirect:/login" ;
	}

	}
