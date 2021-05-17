package servidorExterno;


import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

public class Simple_pass_result implements Print
{
    private String content;
    private JSONParser parser;

    public Simple_pass_result(String content) throws ParseException {

    	System.out.println("Entra en el parseo");
        // We need to parse the input as data is coming from python
        this.parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(content);
        this.content = (String) json.get("Password");
        System.out.println("El codigo es: " + this.content);
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

    @Override
    public void print() {
        System.out.println("Content of Simple_pass_result class is: " + this.content);
    }
}
