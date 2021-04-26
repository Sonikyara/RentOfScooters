package work;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServlet;
import java.io.IOException;

@RestController
public class UserController extends HttpServlet {

	@Autowired
	public UserService userService;

	@GetMapping(value = "/users/getUser",produces = {MediaType.APPLICATION_JSON_VALUE})
	protected UserDTO getUserFromDB(@PathVariable("id")int id)
			throws IOException {
	            return userService.getUserById(id);
	}

    //@PostMapping
	@RequestMapping(value = "/users/saveUser",
			method = RequestMethod.POST,
			produces = { MediaType.APPLICATION_JSON_VALUE})
	public void saveNewUserToDB(@RequestBody Users user) {
		userService.saveUserById(user);
	}


//	@GetMapping("/users/getUser")
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		response.setContentType("text/html");
//		PrintWriter writer = response.getWriter();
////	        String id = request.getParameter("id");
////	        String name = request.getParameter("name");
////	        try {
//		System.out.print("print");
//		writer.println("Scooter's servlet");
////	        } finally {
////	            writer.close();
////	        }
//	}

}
