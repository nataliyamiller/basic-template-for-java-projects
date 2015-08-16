import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main (String[] args) {

    /* Spark Stuff */

    staticFileLocation("/public"); /*locate css and js files*/
    String layout = "templates/layout.vtl"; /*locate layout file */

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/home.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine()); /* Makes homepage "http://localhost:4567/",
    will search for file in public/templates/form.vtl*/



    get ("/detector", (request,response) -> { /*make a results page */
      Map<String, Object> model = new HashMap<String,Object>();
      model.put("template", "templates/detector.vtl");

      String yourInput = request.queryParams("userinput"); /*grabs whatever you typed in as $userinput*/
      /*Integer userInput = Integer.parseInt(yourInput); /*just example, it turns it into an Integer if needed*/
      String yourMethodName = yourMethodName(yourInput);
      model.put("yourInput", yourInput);
      model.put("yourMethodName", yourMethodName); /*sticks your calculated output where it says "$result" on the /results page*/

      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }

    /* put your method(s) here */

}
