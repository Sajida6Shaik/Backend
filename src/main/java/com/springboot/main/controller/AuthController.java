//package com.springboot.main.controller;
//
// 
//	
//	
//	import java.security.Principal;
//
//	import org.springframework.beans.factory.annotation.Autowired;
//	import org.springframework.http.HttpStatus;
//	import org.springframework.http.ResponseEntity;
//	import org.springframework.web.bind.annotation.CrossOrigin;
//	import org.springframework.web.bind.annotation.PostMapping;
//	import org.springframework.web.bind.annotation.RestController;
//
//import com.springboot.main.exception.InvalidIdException;
//import com.springboot.main.model.Admin;
//import com.springboot.main.model.Customer;
//import com.springboot.main.model.Host;
//import com.springboot.main.model.User;
//import com.springboot.main.service.AdminService;
//import com.springboot.main.service.CustomerService;
//import com.springboot.main.service.HostService;
//import com.springboot.main.service.UserService;
//
//	 
//	@RestController
//	@CrossOrigin(origins = {"http://localhost:3000"})
//	public class AuthController {
//		@Autowired
//		private UserService userService;
//		
//
//		@Autowired
//		private HostService hostService;
//		
//		@Autowired
//		private AdminService adminService;
//		
//		@Autowired
//		private CustomerService customerService;
//		
//		 
		
//		@PostMapping("/user/login")
//		public User login(Principal principal) {
//			System.out.println("hi");
//			String username= principal.getName();
//			User user=(User) userService.loadUserByUsername(username);
//			System.out.println(user);
//			return user;
//		}
//		@PostMapping("/auth/login")
//		public ResponseEntity<?> userLogin(Principal principal) throws InvalidIdException {
//		    String username = principal.getName();
//		    User user = (User) userService.loadUserByUsername(username);
//		    System.out.println(user);
//
//		    if (user != null) {
//		        switch (user.getRole()) {
//	            case CUSTOMER:
//		                // Handle login for CUSTOMER role
//		                Customer customer = customerService.getById(user.getId());
//		                return ResponseEntity.ok().body(customer);
//		            case ADMIN:
//		                // Handle login for ADMIN role
//		                Admin  busOperator = adminService.getById(user.getId());
//		                return ResponseEntity.ok().body(busOperator);
//		            case HOST:
//		                // Handle login for HOST role
//		                Host host = hostService.getById(user.getId());
//		                return ResponseEntity.ok().body(host);
//		            default:
//		                // Handle other roles or provide an error response
//		                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Unknown user role");
//		        }
//		    }
//
//		    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
//		}
//	}
//
//
