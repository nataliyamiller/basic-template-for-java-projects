import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main (String[] args) {

    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    get ("/detector", (request,response) -> {
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/detector.vtl");

      String yourInput = request.queryParams("userinput");
      String yourMethodName = yourMethodName(yourInput);

      // Random myRandomGenerator = new Random();
      // Integer randomNumber = myRandomGenerator.nextInt(3);
      // String computerGuess = makeComputerGuess(randomNumber);



      model.put("yourInput", yourInput);
      model.put("yourMethodName", yourMethodName);

      // String checkWinner = checkWinner(userGuess, computerGuess);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());



  }

    public static String yourMethodName (String yourInput){
      String someOutput = "Hi";
      return someOutput;
    }
}
