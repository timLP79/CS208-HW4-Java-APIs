package cs208;

public class Issue
{
    private int issueId;
    private String title;
    private String body;

    public Issue(int issueId, String title, String body)
    {
        this.issueId = issueId;
        this.title = title;
        this.body = body;
    }

    public int getIssueId()
    {
        return issueId;
    }

    public void setIssueId(int issueId)
    {
        this.issueId = issueId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getBody()
    {
        return body;
    }

    public void setBody(String body)
    {
        this.body = body;
    }

    @Override
    public String toString()
    {
        return "Issue{" +
                "issueId=" + issueId +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    /**
     * @return a JSON representation of the object. For example:
     * {
     *   "issueId": 123,
     *   "title": "value of title of the issue",
     *   "body": "value of content of the issue"
     * }
     */
    public String toJSON()
    {
        return "{" +
                    "\"issueId\": " + issueId + ", " +
                    "\"title\": \"" + title + "\", " +
                    "\"body\": \"" + body + "\"" +
                "}";
    }
}
