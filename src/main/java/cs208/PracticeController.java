package cs208;

import org.springframework.boot.convert.Delimiter;
import org.springframework.web.bind.annotation.*;

@RestController
public class PracticeController {
    // TODO: create a GET route with two query parameters
    @GetMapping("/display_name")
    String getSearchWithTwoParameters(
            @RequestParam("first_name") String firstName,
            @RequestParam("last_name") String lastName
    )
    {
        System.out.println("Practice Controller - START");
        System.out.println("first_name sent in the browser URL = " + firstName);
        System.out.println("last_name sent in the browser URL = " + lastName);
        System.out.println("Practice Controller - END");

        return "These are the values of parameters passed in the URL:<br>" +
                "first_name = " + firstName + "<br>" +
                "last_name = " + lastName + "<br><br>";
    }

    // TODO: create a GET route with a path parameter
    @GetMapping("/user/{yourBSUUsername}/profile")
    String getUserProfile(@PathVariable("yourBSUUsername") String userName)
    {
        System.out.println("Practice Controller - START");
        System.out.println("yourBSUUsername = " + userName);
        System.out.println("Practice Controller - END");

        return "<br>" + "The path parameter is: " + userName + "<br>";
    }

    // TODO: create a POST route with two form parameters
    @PostMapping("/create_user")
    String postIssuesWithTwoFormParameters(
            @RequestParam("first_name") String firstName,
            @RequestParam("last_name") String lastName
    )
    {
        System.out.println("Practice Controller - START");
        System.out.println("Parameters received in the body of the POST request:");
        System.out.println("first_name = " + firstName);
        System.out.println("last_name = " + lastName);
        System.out.println("Practice Controller - END");

        return "Parameters received in the body of the POST request:\n" +
               "first_name = " + firstName + "\n" +
               "last_name = " + lastName + "\n\n" +
               "This REST API route would create a new user using the two parameters.\n\n" +
               "<br>" +
               "Find me in the Practice Controller";
    }

    // TODO: create a PATCH route
    @PatchMapping("/user/{yourBSUUsername}/update_profile")
    String patchUserProfile(
            @PathVariable("yourBSUUsername") String userName,
            @RequestParam("theme") String theme,
            @RequestParam("language_code") String langCode
    )
    {
        System.out.println("Practice Controller - START");
        System.out.println("Parameters received in the body of the PATCH request:");
        System.out.println("yourBSUUsername = " + userName);
        System.out.println("theme = " + theme);
        System.out.println("langCode = " + langCode);
        System.out.println("Practice Controller - END");

        return "Parameters received in the body of the PATCH request\n" +
                "yourBSUUsername = " + userName + "\n" +
                "theme = " + theme + "\n" +
                "langCode = " + langCode + "\n" +
                "The REST API route would patch a user using the two parameters.";
    }

    // TODO: create a DELETE route
    @DeleteMapping("/resource/{resourceId}")
    String deleteResource(
        @PathVariable("resourceId") String resourceId,
        @RequestParam("authentication_token") String authenticationToken
    )
    {
        if (isValidToken(authenticationToken))
        {
            System.out.println("Practice Controller - START");
            System.out.println("Resource " + resourceId + " deleted");
            System.out.println("Practice Controller - END");

            return "Resource " + resourceId + " successfully deleted";
        }
        else
        {
            System.out.println("Practice Controller - START");
            System.out.println("Resource " + resourceId + " was not deleted");
            System.out.println("Practice Controller - END");

            return "Resource " + resourceId + " was not deleted";
        }
    }

    private boolean isValidToken(String token)
    {
        return token.equals("jfGvNOpP4tYc59eebAndOtherRandomCharacters");
    }

    // TODO: create a GET API that returns a random resource

}
