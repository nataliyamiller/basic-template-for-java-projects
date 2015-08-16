import org.fluentlenium.adapter.FluentTest;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;;

import static org.assertj.core.api.Assertions.assertThat;


public class AppFluentTest extends FluentTest {
  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
      goTo("http://localhost:4567/");
      assertThat(pageSource()).contains("Words that should appear on home page");
  }

  @Test
  public void isResultDisplayed() {
    goTo("http://localhost:4567/");
    fill("#userinput").with("Hello");
    submit(".btn");
    assertThat(pageSource()).contains("Words that should appear on results page given the input");
  }
}
