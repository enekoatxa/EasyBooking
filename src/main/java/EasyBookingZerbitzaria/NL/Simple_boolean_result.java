package EasyBookingZerbitzaria.NL;


import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

public class Simple_boolean_result implements DF_Printable
{
    private boolean content;
    private JSONParser parser;

    public Simple_boolean_result(String content) throws ParseException {

        this.parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(content);
        this.content = (boolean) json.get("boolean");
    }

    public boolean getContent()
    {
        return content;
    }

    public void setResult(boolean content)
    {
        this.content = content;
    }

    public void print() {
        System.out.println("Content of Simple_pass_result class is: " + this.content);
    }
}