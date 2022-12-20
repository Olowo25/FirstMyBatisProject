package com.kambok.spring.boot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LogoutController {
/** Redirect to login screen */
	
@GetMapping("/logout" )
public String postLogout() {
	
log.info("Logout" );
return "redirect:/login";
}
}