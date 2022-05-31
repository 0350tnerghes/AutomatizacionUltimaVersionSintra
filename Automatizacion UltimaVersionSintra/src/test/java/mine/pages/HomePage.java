package mine.pages;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.*;
import java.util.List;

@Slf4j
public class HomePage extends BasePage {

    public static final String pageUrl = "https://citaprevia.demohiberus.com/appointment";

    @FindBy(xpath = "//span[contains(text(), 'Cita previa')]//parent::button")
    private WebElement BOTON_CITA_PREVIA;

    @FindBy(xpath = "//span[contains(text(), 'ES')]//parent::button")
    public WebElement BOTON_CAMBIAR_IDIOMA;
    @FindBy(xpath = "//span[contains(text(), 'ES')]")
    public WebElement language;

    @FindBy(xpath = "//div[@class='cdk-overlay-container']//div[@id='cdk-overlay-0']//button[contains(text(), 'English (EN)')]")
    private WebElement languageDisplayer;

    @FindBy(xpath = "//span[contains(text(), 'Te envío un recordatorio a tu correo')]//parent::button")
    private WebElement botonRecordatorioCita;

    @FindBy(xpath = "mat-expansion-panel-header-0")
    private WebElement idMenuLocalizacion;


    @FindBy(xpath = "//mat-radio-group[@name='location']//div[@class='mat-radio-label-content']//div")
    private WebElement TEXT_RADIO_BUTTONS_LOCALIZACION;

    @FindBy(xpath = "//mat-radio-group[@name='department']//div[@class='mat-radio-label-content']//div[1]")
    private WebElement TEXT_RADIO_BUTTONS_OFICINAS;

    @FindBy(xpath = "//mat-radio-group[@name='job']//div[@class='mat-radio-label-content']//div//div//div[1]")
    private WebElement TEXT_RADIO_BUTTONS_SERVICIOS;

    @FindBy(xpath = "//mat-panel-description")
    private WebElement xpathDescripcion;

    @FindBy(xpath = "mat-expansion-panel-header-1")
    private WebElement idMenuOficina;

    @FindBy(xpath = "mat-expansion-panel-header-2")
    private WebElement idMenuServicios;

    @FindBy(xpath = "mat-expansion-panel-header-3")
    private WebElement idMenuFecha;

    @FindBy(xpath = "//span[contains(text(), ':')]")
    private WebElement XpathHoras;
    @FindBy(xpath = "//span[contains(text(),'2')]")
    private WebElement dayDate;
    @FindBy(xpath = "//span[contains(text(),'15:00')]")
    private WebElement hourDate;

    @FindBy(id = "mat-input-0")
    private WebElement writeName;

    @FindBy(id = "mat-input-6")
    private WebElement dniCamp;

    @FindBy(id = "mat-input-1")
    private WebElement emailCamp;

    @FindBy(id = "mat-input-3")
    private WebElement phoneCamp;

    @FindBy(id = "mat-input-4")
    private WebElement notesCamp;

    @FindBy(xpath = "//div[@class='mat-checkbox-inner-container']")
    private WebElement checkBox;
    @FindBy(xpath = "//button[@type='button']")
    private WebElement requestButton;

    @FindBy(xpath = "//mat-expansion-panel-header")
    private WebElement xpathTodosLosMenus;

    @FindBy(xpath = "//div[contains(text(),'Santa Cruz de Tenerife')]//ancestor::mat-radio-button")
    private WebElement locationLabel;

    @FindBy(xpath = "//div[contains(text(),'Estadio Heliodoro Ródriguez López')]//ancestor::mat-radio-button")
    private WebElement departmentLabel;

    @FindBy(xpath = "//div[contains(text(),'Consultas sobre futbol base')]//ancestor::mat-radio-button")
    private WebElement jobLabel;

    @FindBy(xpath = "//span[contains(text(), 'Santa Cruz de Tenerife')]//parent::button")
    private WebElement localizacionSelectada;

    @FindBy(xpath = "//div[@class='c-detail-appointment__card__content__section']//descendant::p")
    public List<WebElement> clientInformation;

    //Constructor
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    //Elementos de la pagina:

    public void clickDate(){
        dayDate.click();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        hourDate.click();
    }

    public void selectLanguage() {
        Actions actions = new Actions(getDriver());

        actions.moveToElement(language).perform();
        actions.moveToElement(languageDisplayer).click().perform();
    }

    public void clickLocation() {
        locationLabel.click();
    }
    public void clickDepartment() {
        departmentLabel.click();
    }
    public void clickJob() {
        jobLabel.click();
    }

    public void completeName(String completeName){
        writeName.sendKeys(completeName);
    }
    public void fillIdentityDocument(String identityDocument) {
        dniCamp.sendKeys(identityDocument);
    }

    public void completeEmail(String email){
        emailCamp.sendKeys(email);
    }

    public void completePhone(String phone){
        phoneCamp.sendKeys(phone);
    }

    public void completeComments(String notes) { notesCamp.sendKeys(notes);}

    public void checkBox() {checkBox.click();}

    public void requestButton() {requestButton.click();
    }
    public List<WebElement> getClientInformation() {
        return clientInformation;
    }


}


