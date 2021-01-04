import com.codeborne.selenide.Condition;
        import com.codeborne.selenide.Configuration;
        import com.codeborne.selenide.Selenide;
        import com.codeborne.selenide.SelenideElement;
        import com.codeborne.selenide.commands.SelectRadio;
        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import javax.swing.plaf.SliderUI;
        import static com.codeborne.selenide.Selectors.*;
        import static com.codeborne.selenide.Selenide.*;
        import static java.lang.Thread.sleep;

public class FBRegistration {
    @Test
    public void myFirstTest() throws InterruptedException {
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://www.facebook.com/";
        System.setProperty("webdriver.chrome.driver", "FILES/chromedriver.exe");
        Configuration.startMaximized = true;

        Selenide.open("https://www.facebook.com/");
        $("#u_0_2").sendKeys(Keys.ENTER);
        $(byName("firstname")).setValue("Lela"); //$("#u_f_b").setValue("Lela"); id -ით ვერ მივწვდი და რატომ?
        $(byName("lastname")).setValue("Gabelaia");
        $(byName("reg_email__")).setValue("lela@ladybug.ge");

        $("#day").selectOption("7"); //$(byName("birthday_day")).selectOption(7); byName -ით ვერ მივწვდი და რატომ?
        $("#month").selectOption("May");
        $("#year").selectOption("1987");

        $(byText("Custom")).click();
        $(byText("Select your pronoun")).shouldBe(Condition.visible);
        $(byName("custom_gender")).shouldBe(Condition.visible);
        $("._7-16").selectOption("He: \"Wish him a happy birthday!\"");
        $(byText("Female")).click();
        $(byText("Select your pronoun")).shouldBe(Condition.hidden);
        $(byName("custom_gender")).shouldBe(Condition.hidden);
    }
}