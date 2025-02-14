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

    // TODO: create a DELETE route (12)
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
    @GetMapping("/superbowl/{yourTeam}/feedback")
    String getFeedbackAboutSuperbowl(@PathVariable("yourTeam") String yourTeam)
    {
        String returnFeedback = "";

        if (yourTeam.equals("eagles"))
        {
            System.out.println("Way to go Kellen Moore and the Eagles!");
            System.out.println("Patrick Mahomes is overrated!");
            returnFeedback =
                    "<html>" +
                            "<head>" +
                            "<title>Congratulations, Kellen Moore & the Eagles!</title>" +
                            "<style>" +
                            "body { background-color: #004C54; color: #A5ACAF; text-align: center; font-family: Arial, sans-serif; }" +
                            "h1 { font-size: 3em; margin-top: 50px; }" +
                            "h2 { font-size: 2em; }" +
                            "img { width: 300px; margin-top: 20px; }" +
                            "</style>" +
                            "</head>" +
                            "<body>" +
                            "<h1>🏆 Congratulations, Kellen Moore! 🏆</h1>" +
                            "<h2>The Philadelphia Eagles are Super Bowl Champions! 🦅</h2>" +
                            "<img src='/eagles.png'>" +
                            "<p>Fly Eagles Fly! 🎉</p>" +
                            "</body>" +
                            "</html>";
        }
        else if (yourTeam.equals("chiefs"))
        {
            System.out.println("Better luck next time! Chiefs");
            returnFeedback =
                    "<html>" +
                            "<head>" +
                            "<title>Congratulations, Kansas City Chiefs!</title>" +
                            "<style>" +
                            "body { background-color: #E31837; color: #FFB612; text-align: center; font-family: Arial, sans-serif; }" +
                            "h1 { font-size: 3em; margin-top: 50px; }" +
                            "h2 { font-size: 2em; }" +
                            "img { width: 300px; margin-top: 20px; }" +
                            "</style>" +
                            "</head>" +
                            "<body>" +
                            "<h1>\uD83D\uDC4E Sorry, Kansas City Chiefs! \uD83D\uDC4E</h1>" +
                            "<h2>NOT Super Bowl Champions!</h2>" +
                            "<p>Not this year... \uD83D\uDE22</p>" +
                            "<img src='/mahomes.webp' alt='Needs Insurance'>" +
                            "</body>" +
                            "</html>";
        }

        return returnFeedback;
    }
}
