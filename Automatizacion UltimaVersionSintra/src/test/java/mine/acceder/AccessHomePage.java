package mine.acceder;
import java.util.*;
import mine.pages.PagesFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import mine.pages.HomePage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class AccessHomePage {

    public static WebDriver driver;

    public static WebDriverWait wait;

    @Before
    public void setUp() {
        //Paso 1 inicializar el WebDriverManager
        WebDriverManager.chromedriver().setup();
       // Paso 2 Segundo paso, configurar WebDriver
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, 10, 500);
        // Paso 3 Cargar las páginas de la factoría
        PagesFactory.start(driver);
        driver.get(HomePage.pageUrl);
    }

    @Test
    public void selectLanguage(){
        PagesFactory pf = PagesFactory.getInstance();
        HomePage homePage = pf.getHomePage();
        homePage.selectLanguage();
        // Validar que el cambio de idioma se ha realizado llevándonos a homePage en íngles
        String language= driver.findElement(By.xpath("//span[contains(text(), 'EN')]")).getText();
        Assert.assertEquals("No se cambio la idioma", "EN", language);
    }

    @Test
    public void selectLocationTest(){
        PagesFactory pf = PagesFactory.getInstance();
        HomePage appointmentPage= pf.getHomePage();
        appointmentPage.clickLocation();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String location= driver.findElement(By.xpath("//mat-panel-description[contains(text(),'Santa Cruz de Tenerife')]")).getText();

        Assert.assertEquals("Failed to select location", "Santa Cruz de Tenerife", location);
    }

    @Test
    public void selectDepartment(){
        PagesFactory pf = PagesFactory.getInstance();
        HomePage homePage= pf.getHomePage();
        homePage.clickLocation();
        homePage.clickDepartment();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String department= driver.findElement(By.xpath("//mat-panel-description[contains(text(),'Estadio Heliodoro Ródriguez López')]")).getText();
        Assert.assertEquals("Department not selected", "Estadio Heliodoro Ródriguez López", department);
    }

    @Test
    public void selectJob(){
        PagesFactory pf = PagesFactory.getInstance();
        HomePage homePage= pf.getHomePage();
        homePage.clickLocation();
        homePage.clickDepartment();
        homePage.clickJob();
        String job = driver.findElement(By.xpath("//div[contains(text(),'Consultas sobre futbol base')]")).getText();
        Assert.assertEquals("Job not selected", "emoji_people Consultas sobre futbol base", job);;
    }
    //metodo para verificar si un menu esta desplegado
    public static boolean estaMenuDesplegado(WebDriver driver, String idMenu) {
        boolean estaDesplegada = false;
        try  {
            WebElement menuLocalizacion = driver.findElement(By.id(idMenu));
            estaDesplegada = Boolean.parseBoolean(menuLocalizacion.getAttribute("aria-expanded"));
        } catch (NoSuchElementException nsee) {
            fail("No se ha encontrado el elemento:\n" + nsee.getMessage());
        } catch (Exception e) {
        }
        return estaDesplegada;
    }

    @Test
    public void selectDate(){
        PagesFactory pf = PagesFactory.getInstance();
        HomePage homePage= pf.getHomePage();
        homePage.clickLocation();
        homePage.clickDepartment();
        homePage.clickJob();
        homePage.clickDate();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String date = driver.findElement(By.xpath("//mat-panel-description[contains(text(),'02/06/2022 15:00')]")).getText();
        Assert.assertEquals("Wrong date", "02/06/2022 15:00", date);
    }


    @Test
    public void completeName(){
        PagesFactory pf = PagesFactory.getInstance();
        HomePage homePage= pf.getHomePage();
        homePage.clickLocation();
        homePage.clickDepartment();
        homePage.clickJob();
        homePage.clickDate();
        homePage.completeName("Tamara");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       String completeName = driver.findElement(By.xpath("//mat-panel-description[contains(text(),'Tamara')]")).getText();
        Assert.assertEquals("Complete name not matches","Tamara , ", completeName );
    }
    @Test
    public void fillIdentityDocument() {

        PagesFactory pf = PagesFactory.getInstance();
        HomePage homePage= pf.getHomePage();
        homePage.clickLocation();
        homePage.clickDepartment();
        homePage.clickJob();
        homePage.clickDate();
        homePage.completeName("Tamara");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        homePage.fillIdentityDocument("24339278B");
        String idDocument= driver.findElement(By.xpath("//mat-panel-description[contains(text(),'Tamara')]")).getText();
        Assert.assertEquals("ERROR","Tamara , 24339278B", idDocument );
    }

    @Test
    public void fillForm(){
        PagesFactory pf = PagesFactory.getInstance();
        HomePage homePage= pf.getHomePage();
        homePage.clickLocation();
        homePage.clickDepartment();
        homePage.clickJob();
        homePage.clickDate();
        homePage.completeName("Tamara");
        homePage.fillIdentityDocument("24339278B");
        homePage.completeEmail("123@yahoo.com.com");
        homePage.completePhone("642333444");
        homePage.completeComments("LAALALA");
        homePage.checkBox();
        homePage.requestButton();
        String locationName=  homePage.getClientInformation().get(0).getText();
        String departmentName=  homePage.getClientInformation().get(1).getText();
        String jobName=  homePage.getClientInformation().get(3).getText();
        String completeName=  homePage.getClientInformation().get(5).getText();
        String idCardNumber=  homePage.getClientInformation().get(6).getText();
        String phoneNumber =  homePage.getClientInformation().get(7).getText();
        String email=  homePage.getClientInformation().get(8).getText();
        String notes=  homePage.getClientInformation().get(9).getText();
        String date=  homePage.getClientInformation().get(11).getText();

        Assert.assertEquals("Location doesn't match", "Santa Cruz de Tenerife", locationName);
        Assert.assertEquals("Department doesn't match","Estadio Heliodoro Ródriguez López", departmentName );
        Assert.assertEquals("Job doesn't match","Consultas sobre futbol base", jobName );
        Assert.assertEquals("Complete name doesn't match", "Tamara", completeName);
        Assert.assertEquals("ID card doesn't match","24339278B", idCardNumber );
        Assert.assertEquals("Phone number doesn't match","+34642333444", phoneNumber );
        Assert.assertEquals("Email name doesn't match", "tamara.tamaran@yahoo.com.com", email);
        Assert.assertEquals("Notes don't match","LALALA", notes );
        Assert.assertEquals("Date doesn't match","02/06/2022 15:00", date );
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
