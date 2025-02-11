package cs208;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PracticeController {
    // TODO: create a GET route with two query parameters
    @GetMapping("/display_name")
    String getSearchWithTwoParameters(
            @RequestParam("first_name") String parameter1,
            @RequestParam("last_name") String parameter2
    )
    {
        System.out.println("Practice Controller - START");
        System.out.println("first_name sent in the browser URL = " + parameter1);
        System.out.println("last_name sent in the browser URL = " + parameter2);
        System.out.println("Practice Controller - END");

        return "These are the values of parameters passed in the URL:<br>" +
                "first_name = " + parameter1 + "<br>" +
                "last_name = " + parameter2 + "<br><br>";
    }

    // TODO: create a GET route with a path parameter
    @GetMapping("/user/{yourBSUUsername}/profile")
    String getUserProfile(@PathVariable("yourBSUUsername") String username)
    {
        System.out.println("Practice Controller - START");
        System.out.println("yourBSUUsername = " + username);
        System.out.println("Practice Controller - END");

        return "<br>" + "The path parameter is: " + username + "<br>";
    }

    // TODO: create a POST route with two form parameters


    // TODO: create a PATCH route


    // TODO: create a DELETE route


    // TODO: create a GET API that returns a random resource

}
