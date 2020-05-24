package EasyBookingZerbitzaria.NL;


import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

public class Simple_pass_result implements DF_Printable
{
    private String content;
    private JSONParser parser;

    public Simple_pass_result(String content) throws ParseException {

        this.parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(content);
        this.content = (String) json.get("Password");
    }

    public String getContent()
    {
        return content;
    }

    public void setResult(String content)
    {
        this.content = content;
    }

    public long getContentNumber()
    {
        return Long.parseLong(content);
    }

    public void print() {
        System.out.println("Content of Simple_pass_result class is: " + this.content);
    }
}