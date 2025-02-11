package cs208;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TutorialController
{

// =====================================================================================================================
// Example routes
// ---------------------------------------------------------------------------------------------------------------------
// All GET routes (paths) should be accessible from the browser at
//       http://localhost:8080/<ROUTE_NAME>
// or
//       http://127.0.0.1:8080/<ROUTE_NAME>
//
// For example, the route
//      GET /issues/new
// will be available at
//      http://localhost:8080/issues/new
//
//
// All other routes that use POST, PUT, PATCH or DELETE will be accessible using a tool like
//      Insomnia https://insomnia.rest/download
// or
//      Postman https://www.postman.com/
// =====================================================================================================================


    // http://localhost:8080/
    // GET /
    @GetMapping("/")
    String getIndex()
    {
        return
            "Congratulations, you're up and running!<br><br>" +
            "<hr>" +
            "Find me in file src/main/java/cs208/TutorialController.java in the getIndex() method";
    }


    // http://localhost:8080/issues
    // GET /issues
    @GetMapping("/issues")
    String getIssues()
    {
        return "this is the return value of the TutorialController.getIssues() method";
    }


    // http://localhost:8080/issues/new
    // GET /issues/new
    @GetMapping("/issues/new")
    String getIssuesNew()
    {
        // the route path can have multiple "nesting" levels or "sub-folders" like
        //      "/issues/new" or
        //      "/issues/123/new" or
        //      "/organization/repository/issues/new" or

        return "this is the return value of the TutorialController.getIssuesNew() method";
    }


    // http://localhost:8080/search_with_one_parameter?parameter1=value1
    // GET /search_with_one_parameter?parameter1=value1
    @GetMapping("/search_with_one_parameter")
    String getSearchWithOneParameter(@RequestParam("parameter1") String parameter1OrAnyOtherNameIWantToUse)
    {
        // These print statements will be displayed in the IDE console along with the Java server output, and not in the browser
        System.out.println("TutorialController.getSearchWithOneParameter - START");
        System.out.println("parameter1 sent in the browser URL = " + parameter1OrAnyOtherNameIWantToUse);
        System.out.println("TutorialController.getSearchWithOneParameter - END");

        String valueReturnedToBrowser =
            "This is the value of the parameter passed in the browser URL:<br>" +
            "parameter1 = " + parameter1OrAnyOtherNameIWantToUse + "<br><br>" +
            "TODO: Change the value of 'parameter1' in the URL and refresh the page to see the new value.<br><br>" +
            "TODO: Change the parameter name in the URL and see the 'Bad Request' 400 error.<br><br>" +
            "<hr>" +
            "Find me in the TutorialController.getSearchWithOneParameter() method";

        return valueReturnedToBrowser;
    }

    // http://localhost:8080/search_with_two_parameters?parameter1=value1&parameter2=value2
    // GET /search_with_two_parameters?parameter1=value1&parameter2=value2
    @GetMapping("/search_with_two_parameters")
    String getSearchWithTwoParameters(
            @RequestParam("parameter1") String parameter1,
            @RequestParam("parameter2") String parameter2
    )
    {
        System.out.println("TutorialController.getSearchWithTwoParameters - START");
        System.out.println("parameter1 sent in the browser URL = " + parameter1);
        System.out.println("parameter2 sent in the browser URL = " + parameter2);
        System.out.println("TutorialController.getSearchWithTwoParameters - END");

        String valueReturnedToBrowser =
            "These are the values of parameters passed in the URL:<br>" +
            "parameter1 = " + parameter1 + "<br>" +
            "parameter2 = " + parameter2 + "<br><br>" +
            "NOTE: the parameters are separated in the URL by an ampersand (&amp;) character.<br><br>" +
            "<hr>" +
            "Find me in the TutorialController.getSearchWithTwoParameters() method";

        return valueReturnedToBrowser;
    }


    // The following URLs are equivalent:
    // http://localhost:8080/search_with_one_parameter_having_spaces_in_its_value?parameter1=hello+world+sentence+containing+spaces
    // http://localhost:8080/search_with_one_parameter_having_spaces_in_its_value?parameter1=hello%20world%20sentence%20containing%20spaces
    //
    // Some browsers display the above URLs as:
    // http://localhost:8080/search_with_one_parameter_having_spaces_in_its_value?parameter1=hello world sentence containing spaces
    //
    // GET /search_with_one_parameter_having_spaces_in_its_value?parameter1=hello world sentence containing spaces
    @GetMapping("/search_with_one_parameter_having_spaces_in_its_value")
    String getSearchWithOneParameterHavingSpacesInItsValue(@RequestParam("parameter1") String parameter1)
    {
        System.out.println("TutorialController.getSearchWithOneParameterHavingSpacesInItsValue - START");
        System.out.println("parameter1 sent in the browser URL that contains spaces = " + parameter1);
        System.out.println("TutorialController.getSearchWithOneParameterHavingSpacesInItsValue - END");

        String valueReturnedToBrowser =
            "This is the value of the parameter passed in the URL:<br>" +
            "parameter1 = " + parameter1 + "<br><br>" +
            "NOTE: Depending on the browser, client and the server implementation, the spaces in the URL are encoded as either:<br>" +
            "<ul>" +
            "  <li>a '+' (plus) character or</li>" +
            "  <li>a '%20' encoding (i.e., 20 in hexadecimal, which equals 32 in decimal, which is the ASCII code for a space)</li>" +
            "</ul>" +
            "<hr>" +
            "Find me in the TutorialController.getSearchWithOneParameterHavingSpacesInItsValue() method";

        return valueReturnedToBrowser;
    }


    // http://localhost:8080/search_with_one_parameter_having_encoded_characters_in_its_value?parameter1=%7B%22hello%22%3A%20%22%5B%5Eworld%3F%5D%22%7D
    // GET /search_with_one_parameter_having_encoded_characters_in_its_value?parameter1=%7B%22hello%22%3A%20%22%5B%5Eworld%3F%5D%22%7D
    @GetMapping("/search_with_one_parameter_having_encoded_characters_in_its_value")
    String getSearchWithOneParameterHavingEncodedCharactersInItsValue(@RequestParam("parameter1") String parameter1)
    {
        System.out.println("TutorialController.getSearchWithOneParameterHavingEncodedCharactersInItsValue - START");
        System.out.println("parameter1 sent in the browser URL that contains encoded characters = " + parameter1);
        System.out.println("TutorialController.getSearchWithOneParameterHavingEncodedCharactersInItsValue - END");

        String valueReturnedToBrowser =
            "This is the value of the parameter passed in the URL:<br>" +
            "parameter1 = " + parameter1 + "<br><br>" +
            "Below is an excerpt from the <a href='https://www.asciitable.com/' target='_blank'>ASCII characters table</a> explaining the URL decoding:<br>" +
            getASubsetOfASCIICharactersAsHTMLTable() +
            "<hr>" +
            "Find me in the TutorialController.getSearchWithOneParameterHavingEncodedCharactersInItsValue() method";

        return valueReturnedToBrowser;
    }

    private String getASubsetOfASCIICharactersAsHTMLTable()
    {
        return
            "<table border=\"1\">\n" +
            "    <tr>\n" +
            "        <th>Encoded value in Hexadecimal</th>\n" +
            "        <th>Value in Decimal</th>\n" +
            "        <th>Decoded ASCII value</th>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td>%20</td>\n" +
            "        <td>2 * 16 + 0 = 32</td>\n" +
            "        <td>&nbsp; (i.e., space)</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td>%22</td>\n" +
            "        <td>2 * 16 + 2 = 34</td>\n" +
            "        <td>\"</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td>%3A</td>\n" +
            "        <td>3 * 16 + 10 = 58</td>\n" +
            "        <td>:</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td>%3F</td>\n" +
            "        <td>3 * 16 + 15 = 63</td>\n" +
            "        <td>?</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td>%5B</td>\n" +
            "        <td>5 * 16 + 11 = 91</td>\n" +
            "        <td>[</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td>%5D</td>\n" +
            "        <td>5 * 16 + 13 = 93</td>\n" +
            "        <td>]</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td>%5E</td>\n" +
            "        <td>5 * 16 + 14 = 94</td>\n" +
            "        <td>^</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td>%7B</td>\n" +
            "        <td>7 * 16 + 11 = 123</td>\n" +
            "        <td>{</td>\n" +
            "    </tr>\n" +
            "    <tr>\n" +
            "        <td>%7D</td>\n" +
            "        <td>7 * 16 + 13 = 125</td>\n" +
            "        <td>}</td>\n" +
            "    </tr>\n" +
            "</table>";
    }


    // http://localhost:8080/issues/search?query=this%20is%20what%20I%27m%20searching%20for&sort=created-ascending&author=Alice
    // GET /issues/search?query=this is what I'm searching for&sort=created-asc&author=Alice
    @GetMapping("/issues/search")
    String getIssuesSearchWithThreeParameters(
            @RequestParam("query") String query,
            @RequestParam("sort") String sort,
            @RequestParam("author") String author
    )
    {
        System.out.println("TutorialController.getIssuesSearchWithThreeParameters - START");
        System.out.println("Parameters received from the URL:");
        System.out.println("query  = " + query);
        System.out.println("sort   = " + sort);
        System.out.println("author = " + author);
        System.out.println("TutorialController.getIssuesSearchWithThreeParameters - END");

        String valueReturnedToBrowser =
            "Parameters received from the URL:<br>" +
            "query = " + query + "<br>" +
            "sort = " + sort + "<br>" +
            "author = " + author + "<br><br>" +
            "In a real application, we would use these parameters received in the URL to perform some database lookup " +
            "and after that, return the results to the browser.<br><br>" +
            "<hr>" +
            "Find me in the TutorialController.getIssuesSearchWithThreeParameters() method";

        return valueReturnedToBrowser;
    }


    // Try all these URLs:
    // http://localhost:8080/issues/search_with_optional_and_default_parameter_values?query=my%20search%20terms&sort=created-ascending&author=Alice
    // http://localhost:8080/issues/search_with_optional_and_default_parameter_values?query=my%20search%20terms&author=Alice
    // http://localhost:8080/issues/search_with_optional_and_default_parameter_values?query=my%20search%20terms&sort=created-ascending
    // http://localhost:8080/issues/search_with_optional_and_default_parameter_values?query=my%20search%20terms
    //
    // GET /issues/search_with_optional_and_default_parameter_values?query=my search terms&sort=created-ascending&author=Alice
    // NOTE:
    //   - parameters "sort" and "author" are optional, and do not need to be specified in the URL
    //   - parameter "sort" will have a default value of "last-modified-descending" if it's not specified in the URL
    @GetMapping(value = "/issues/search_with_optional_and_default_parameter_values")
    String getIssuesSearchWithOptionalAndDefaultParameterValues(
            @RequestParam("query") String query,
            @RequestParam(name = "sort", required = false, defaultValue = "last-modified-descending") String sort,
            @RequestParam(name = "author", required = false) String author
    )
    {
        System.out.println("TutorialController.getIssuesSearchWithOptionalAndDefaultParameterValues - START");
        System.out.println("Parameters received from the URL:");
        System.out.println("query  = " + query);
        System.out.println("sort   = " + sort);
        System.out.println("author = " + author);
        System.out.println("TutorialController.getIssuesSearchWithOptionalAndDefaultParameterValues - END");

        String valueReturnedToBrowser =
            "Parameters received from the URL:<br>" +
            "query = " + query + "<br>" +
            "sort* = " + sort + "<br>" +
            "author** = " + author + "<br><br>" +
            "* sort is an optional parameter with a default value<br>" +
            "** author is an optional parameter without a default value (i.e., if it's not specified in the URL, its value would be null)<br><br>" +
            "<hr>" +
            "Find me in the TutorialController.getIssuesSearchWithOptionalAndDefaultParameterValues() method";

        return valueReturnedToBrowser;
    }


    // Try all these URLs:
    // http://localhost:8080/issues_with_string_path_variable/123
    // http://localhost:8080/issues_with_string_path_variable/456
    // http://localhost:8080/issues_with_string_path_variable/abc
    //
    // GET /issues_with_string_path_variable/{issue_id}
    // NOTE:
    //   - {issue_id} is a PathVariable (i.e., path parameter), not a RequestParam (i.e., query parameter)
    //   - any value after "/issues_with_string_path_variable/" that is passed in the URL will be assigned to the {issue_id} variable
    @GetMapping("/issues_with_string_path_variable/{issue_id}")
    String getIssuesWithStringPathVariableCalledIssueId(@PathVariable("issue_id") String issue_id)
    {
        System.out.println("TutorialController.getIssuesWithStringPathVariableCalledIssueId - START");
        System.out.println("Parameter received in the path of the URL:");
        System.out.println("issue_id = " + issue_id);
        System.out.println("TutorialController.getIssuesWithStringPathVariableCalledIssueId - END");

        String valueReturnedToBrowser =
            "Parameter received in the path of the URL:<br>" +
            "issue_id = " + issue_id + "<br><br>" +
            "<hr>" +
            "Find me in the TutorialController.getIssuesWithStringPathVariableCalledIssueId() method";

        return valueReturnedToBrowser;
    }


    // Try all these URLs:
    // http://localhost:8080/issues_with_int_path_variable/123
    // http://localhost:8080/issues_with_int_path_variable/456
    // http://localhost:8080/issues_with_int_path_variable/abc  => expect a 400 error ("abc" cannot be converted to an int)
    //
    // GET /issues_with_int_path_variable/{issue_id}
    @GetMapping("/issues_with_int_path_variable/{issue_id}")
    String getIssuesWithIntPathVariableCalledIssueId(@PathVariable("issue_id") int issue_id)
    {
        System.out.println("TutorialController.getIssuesWithIntPathVariableCalledIssueId - START");
        System.out.println("Parameter received in the path of the URL:");
        System.out.println("issue_id = " + issue_id);
        System.out.println("TutorialController.getIssuesWithIntPathVariableCalledIssueId - END");

        String valueReturnedToBrowser =
            "Parameter received in the path of the URL:<br>" +
            "issue_id = " + issue_id + "<br><br>" +
            "This is the preferred way of passing parameters in REST APIs that can be used to locate records in the database.<br>" +
            "Typically, in REST APIs we pass the id (primary key) of the table as a path parameter.<br><br>" +
            "<hr>" +
            "Find me in the TutorialController.getIssuesWithIntPathVariableCalledIssueId() method";

        return valueReturnedToBrowser;
    }


    // Try all these URLs:
    // http://localhost:8080/issues/123/comments
    // http://localhost:8080/issues/456/comments
    //
    // GET /issues/{issue_id}/comments
    @GetMapping("/issues/{issue_id}/comments")
    String getIssuesWithIntPathVariableCalledIssueIdAndComments(@PathVariable("issue_id") int issue_id)
    {
        System.out.println("TutorialController.getIssuesWithIntPathVariableCalledIssueIdAndComments - START");
        System.out.println("Parameter received in the path of the URL:");
        System.out.println("issue_id = " + issue_id);
        System.out.println("TutorialController.getIssuesWithIntPathVariableCalledIssueIdAndComments - END");

        String valueReturnedToBrowser =
            "Parameter received in the path of the URL:<br>" +
            "issue_id = " + issue_id + "<br><br>" +
            "This REST API route would display all the comments for issue with id " + issue_id + ".<br><br>" +
            "<hr>" +
            "Find me in the TutorialController.getIssuesWithIntPathVariableCalledIssueIdAndComments() method";

        return valueReturnedToBrowser;
    }


    // Try all these URLs:
    // http://localhost:8080/issues/123/comments/789
    // http://localhost:8080/issues/456/comments/1011
    //
    // GET /issues/{issue_id}/comments/{comment_id}
    @GetMapping("/issues/{issue_id}/comments/{comment_id}")
    String getIssuesWithIssueIdPathVariableAndCommentsWithCommentIdPathVariable(
            @PathVariable("issue_id") int issue_id,
            @PathVariable("comment_id") int comment_id
    )
    {
        System.out.println("TutorialController.getIssuesWithIssueIdPathVariableAndCommentsWithCommentIdPathVariable - START");
        System.out.println("Parameters received in the path of the URL:");
        System.out.println("issue_id   = " + issue_id);
        System.out.println("comment_id = " + comment_id);
        System.out.println("TutorialController.getIssuesWithIssueIdPathVariableAndCommentsWithCommentIdPathVariable - END");

        String valueReturnedToBrowser =
            "Parameters received in the path of the URL:<br>" +
            "issue_id = " + issue_id + "<br>" +
            "comment_id = " + comment_id + "<br><br>" +
            "This REST API route would display the comment with id " + comment_id + " that belongs to issue with id " + issue_id + ".<br><br>" +
            "<hr>" +
            "Find me in the TutorialController.getIssuesWithIssueIdPathVariableAndCommentsWithCommentIdPathVariable() method";

        return valueReturnedToBrowser;
    }


    // Try all these URLs:
    // http://localhost:8080/issues/123/comments/789/edit?theme=dark-modern
    // http://localhost:8080/issues/456/comments/1011/edit?theme=light-default
    //
    // GET /issues/{issue_id}/comments/{comment_id}/edit?theme=dark-modern
    @GetMapping("/issues/{issue_id}/comments/{comment_id}/edit")
    String getIssuesCommentsEditWithTwoPathVariablesAndOneQueryParameter(
            @PathVariable("issue_id") int issue_id,
            @PathVariable("comment_id") int comment_id,
            @RequestParam("theme") String theme
    )
    {
        System.out.println("TutorialController.getIssuesCommentsEditWithTwoPathVariablesAndOneQueryParameter - START");
        System.out.println("Parameters received in the path of the URL:");
        System.out.println("issue_id   = " + issue_id);
        System.out.println("comment_id = " + comment_id);
        System.out.println("Query parameter received in the URL:");
        System.out.println("theme      = " + theme);
        System.out.println("TutorialController.getIssuesCommentsEditWithTwoPathVariablesAndOneQueryParameter - END");

        String valueReturnedToBrowser =
            "Parameters received in the path of the URL:<br>" +
            "issue_id = " + issue_id + "<br>" +
            "comment_id = " + comment_id + "<br><br>" +
            "Query parameter received in the URL:<br>" +
            "theme = " + theme + "<br><br>" +
            "This REST API route would display a form to edit the comment with id " + comment_id + " " +
            "that belongs to issue with id " + issue_id + " while using the '" + theme + "' theme.<br><br>" +
            "<hr>" +
            "Find me in the TutorialController.getIssuesCommentsEditWithTwoPathVariablesAndOneQueryParameter() method";

        return valueReturnedToBrowser;
    }



// =====================================================================================================================
// Example routes that require Insomnia or Postman to send POST, PUT, PATCH or DELETE requests
// =====================================================================================================================


    // POST
    //      http://localhost:8080/issues
    // with the following form parameters:
    //      title = title for the new issue
    //      description = description of the new issue
    //
    // POST /issues
    @PostMapping("/issues")
    String postIssuesWithTwoFormParameters(
            @RequestParam("title") String title,
            @RequestParam("description") String description
    )
    {
        System.out.println("TutorialController.postIssuesWithTwoFormParameters - START");
        System.out.println("Parameters received in the body of the POST request:");
        System.out.println("title       = " + title);
        System.out.println("description = " + description);
        System.out.println("TutorialController.postIssuesWithTwoFormParameters - END");

        String valueReturnedToClient =
            "Parameters received in the body of the POST request:\n" +
            "title       = " + title + "\n" +
            "description = " + description + "\n\n" +
            "This REST API route would create a new issue with the title and description specified in the parameters.\n\n" +
            "<hr>" +
            "Find me in the TutorialController.postIssuesWithTwoFormParameters() method";

        return valueReturnedToClient;
    }


    // POST
    //      http://localhost:8080/issues/123/comments
    // with the following form parameters:
    //      comment_author_id = 10
    //      comment_content = content of the new comment
    //
    // POST /issues/{issue_id}/comments
    @PostMapping("/issues/{issue_id}/comments")
    String postIssuesCommentsWithOnePathVariableAndTwoFormParameters(
            @PathVariable("issue_id") String issue_id,
            @RequestParam("comment_author_id") String comment_author_id,
            @RequestParam("comment_content") String comment_content
    )
    {
        System.out.println("TutorialController.postIssuesCommentsWithOnePathVariableAndTwoFormParameters - START");
        System.out.println("Parameter received in the path of the URL:");
        System.out.println("issue_id          = " + issue_id);
        System.out.println("Parameters received in the body of the POST request:");
        System.out.println("comment_author_id = " + comment_author_id);
        System.out.println("comment_content   = " + comment_content);
        System.out.println("TutorialController.postIssuesCommentsWithOnePathVariableAndTwoFormParameters - END");

        String valueReturnedToClient =
            "Parameter received in the path of the URL:\n" +
            "issue_id          = " + issue_id + "\n\n" +
            "Parameters received in the body of the POST request:\n" +
            "comment_author_id = " + comment_author_id + "\n" +
            "comment_content   = " + comment_content + "\n\n" +
            "This REST API route would create a new comment in issue with id " + issue_id + ".\n" +
            "The comment will be authored by the user with id " + comment_author_id + " and will have the content '" + comment_content + "'.\n\n" +
            "<hr>" +
            "Find me in the TutorialController.postIssuesCommentsWithOnePathVariableAndTwoFormParameters() method";

        return valueReturnedToClient;
    }


    // PUT
    //      http://localhost:8080/issues/123
    // with the following form parameters:
    //      title = edited title value
    //      description = edited description of the issue
    //
    // PUT /issues/{issue_id}
    @PutMapping("/issues/{issue_id}")
    String putIssuesWithOnePathVariableAndTwoFormParameters(
            @PathVariable("issue_id") String issue_id,
            @RequestParam("title") String title,
            @RequestParam("description") String description
    )
    {
        System.out.println("TutorialController.putIssuesWithOnePathVariableAndTwoFormParameters - START");
        System.out.println("Parameter received in the path of the URL:");
        System.out.println("issue_id    = " + issue_id);
        System.out.println("Parameters received in the body of the PUT request:");
        System.out.println("title       = " + title);
        System.out.println("description = " + description);
        System.out.println("TutorialController.putIssuesWithOnePathVariableAndTwoFormParameters - END");

        String valueReturnedToClient =
            "Parameter received in the path of the URL:\n" +
            "issue_id    = " + issue_id + "\n\n" +
            "Parameters received in the body of the PUT request:\n" +
            "title       = " + title + "\n" +
            "description = " + description + "\n\n" +
            "This REST API route would update issue with id " + issue_id + " with the " +
            "new title and description values passed in the body of the PUT request.\n\n" +
            "<hr>" +
            "Find me in the TutorialController.putIssuesWithOnePathVariableAndTwoFormParameters() method";

        return valueReturnedToClient;
    }


    // PATCH
    //      http://localhost:8080/issues/123
    // with the following form parameters:
    //      title = this is the only field that should be updated in the issue
    //
    // PATCH /issues/{issue_id}
    @PatchMapping("/issues/{issue_id}")
    String patchIssuesWithOnePathVariableAndOneFormParameter(
            @PathVariable("issue_id") String issue_id,
            @RequestParam("title") String title
    )
    {
        System.out.println("TutorialController.patchIssuesWithOnePathVariableAndOneFormParameter - START");
        System.out.println("Parameter received in the path of the URL:");
        System.out.println("issue_id = " + issue_id);
        System.out.println("Parameter received in the body of the PATCH request:");
        System.out.println("title    = " + title);
        System.out.println("TutorialController.patchIssuesWithOnePathVariableAndOneFormParameter - END");

        String valueReturnedToClient =
            "Parameter received in the path of the URL:\n" +
            "issue_id = " + issue_id + "\n\n" +
            "Parameter received in the body of the PATCH request:\n" +
            "title    = " + title + "\n\n" +
            "This REST API route would update issue with id " + issue_id + " with the " +
            "new title value passed in the body of the PATCH request.\n\n" +
            "<hr>" +
            "Find me in the TutorialController.patchIssuesWithOnePathVariableAndOneFormParameter() method";

        return valueReturnedToClient;
    }


    // http://localhost:8080/what_is_the_difference_between_put_and_patch
    // GET /what_is_the_difference_between_put_and_patch
    @GetMapping("/what_is_the_difference_between_put_and_patch")
    String getWhatIsTheDifferenceBetweenPutAndPatch()
    {
        return
            "<h2>What is the difference between PATCH and PUT?</h1>" +
            "<p>PUT is typically used to update an entire resource " +
            "(e.g., all the fields of a user, issue, student, class, etc.).</p>" +
            "<p>PATCH is typically used to update only a subset (or part) of a resource " +
            "(e.g., update only the title of an issue, but not its description).</p>";
    }


    // DELETE http://localhost:8080/issues/123
    //
    // DELETE /issues/{issue_id}
    @DeleteMapping("/issues/{issue_id}")
    String deleteIssuesWithOnePathVariable(@PathVariable("issue_id") String issue_id)
    {
        System.out.println("TutorialController.deleteIssuesWithOnePathVariable - START");
        System.out.println("Parameter received in the path of the URL:");
        System.out.println("issue_id = " + issue_id);
        System.out.println("TutorialController.deleteIssuesWithOnePathVariable - END");

        String valueReturnedToClient =
            "Parameter received in the path of the URL:\n" +
            "issue_id = " + issue_id + "\n\n" +
            "This REST API route would delete the issue with id " + issue_id + ".\n\n" +
            "<hr>" +
            "Find me in the TutorialController.deleteIssuesWithOnePathVariable() method";

        return valueReturnedToClient;
    }


    // DELETE http://localhost:8080/issues/123/comments/456
    //
    // DELETE /issues/{issue_id}/comments/{comment_id}
    @DeleteMapping("/issues/{issue_id}/comments/{comment_id}")
    String deleteIssuesWithTwoPathVariables(
            @PathVariable("issue_id") String issue_id,
            @PathVariable("comment_id") String comment_id
    )
    {
        System.out.println("TutorialController.deleteIssuesWithTwoPathVariables - START");
        System.out.println("Parameters received in the path of the URL:");
        System.out.println("issue_id   = " + issue_id);
        System.out.println("comment_id = " + comment_id);
        System.out.println("TutorialController.deleteIssuesWithTwoPathVariables - END");

        String valueReturnedToClient =
            "Parameters received in the path of the URL:\n" +
            "issue_id   = " + issue_id + "\n" +
            "comment_id = " + comment_id + "\n\n" +
            "This REST API route would delete the comment with id " + comment_id + ", which is part of the issue with id " + issue_id + ".\n\n" +
            "<hr>" +
            "Find me in the TutorialController.deleteIssuesWithTwoPathVariables() method";

        return valueReturnedToClient;
    }



// =====================================================================================================================
// Example of routes that share the same path, but have different HTTP verbs:
// ---------------------------------------------------------------------------------------------------------------------
// GET /items
// POST /items
// PUT /items
// PATCH /items
// DELETE /items
//
// The examples below are accessible at the following URL:
//      http://localhost:8080/items
// using the HTTP verbs mentioned above.
// =====================================================================================================================


    // GET /items
    @GetMapping("/items")
    String getItems()
    {
        return "received a GET request";
    }

    // POST /items
    @PostMapping("/items")
    String postItems()
    {
        return "received a POST request";
    }

    // PUT /items
    @PutMapping("/items")
    String putItems()
    {
        return "received a PUT request";
    }

    // PATCH /items
    @PatchMapping("/items")
    String patchItems()
    {
        return "received a PATCH request";
    }

    // DELETE /items
    @DeleteMapping("/items")
    String deleteItems()
    {
        return "received a DELETE request";
    }



// =====================================================================================================================
// Example routes that return JSON
// ---------------------------------------------------------------------------------------------------------------------
// NOTE: the following annotation needs to be used
//       produces = MediaType.APPLICATION_JSON_VALUE
// which is just a constant for the string
//       "application/json"
// =====================================================================================================================


    // http://localhost:8080/return_a_simple_string_formatted_as_json
    // GET /return_a_simple_string_formatted_as_json
    @GetMapping(value = "/return_a_simple_string_formatted_as_json", produces = MediaType.APPLICATION_JSON_VALUE)
    String returnASimpleStringFormattedAsJSON()
    {
        return "{ \"key\": \"value\" }";
    }


    // http://localhost:8080/return_json_for_an_issue_using_our_custom_code_for_creating_json
    // GET /return_json_for_an_issue_using_our_custom_code_for_creating_json
    @GetMapping(value = "/return_json_for_an_issue_using_our_custom_code_for_creating_json", produces = MediaType.APPLICATION_JSON_VALUE)
    String returnJSONForAnIssueUsingOurCustomCodeForCreatingJSON()
    {
        // assume we perform a database lookup that returns the following issue
        Issue issueFromDatabase = new Issue(123, "title value for our issue", "actual body content for our issue");

        // toJSON is our own custom method created in the Issue class
        return issueFromDatabase.toJSON();
    }


    // http://localhost:8080/return_json_for_an_issue
    // GET /return_json_for_an_issue
    @GetMapping(value = "/return_json_for_an_issue", produces = MediaType.APPLICATION_JSON_VALUE)
    Issue returnJSONForAnIssue()
    {
        // assume we perform a database lookup that returns the following issue
        Issue issueFromDatabase = new Issue(123, "title value for our issue", "actual body content for our issue");

        // because we used the following annotation:
        //      produces = MediaType.APPLICATION_JSON_VALUE
        // in the method declaration, when we return the issueFromDatabase object,
        // the internal libraries of the Spring framework will automatically convert the issueFromDatabase object
        // to JSON format and return it to the client
        //
        // NOTE: Only the fields that have getters in the Issues class will be included in the JSON
        return issueFromDatabase;
    }

}
