package mine.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

@Getter
public class PagesFactory {

    private static PagesFactory pagesFactories;
    private final WebDriver driver;

    private final HomePage homePage;


    public PagesFactory(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(driver);
    }

    public static void start(WebDriver driver) {

        pagesFactories = new PagesFactory(driver);
    }

    public static PagesFactory getInstance() {

        return pagesFactories;
    }

}
