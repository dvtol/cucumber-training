package com.ahold.ecommerce.definitions.snapshot;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertFalse;
import com.ahold.ecommerce.definitions._generics.BasePage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.After;
import io.qameta.allure.Attachment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.imageio.ImageIO;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

/**
 * Created by sherwin on 2-7-2017.
 */
public class SnapshotPage extends BasePage {
    private WebDriver driver;
    @Setter
    private String resultLocation = "", baselineLocation = "", runType = "";
    @Setter
    private int compareMarge = 0;
    public SnapshotPage(WebDriver webdriver) {
        super(webdriver);
        this.driver = webdriver;
        WebDriverRunner.setWebDriver(this.driver);
    }
    public void navigateToAH() {

        navigateToPage("https://tst8.ah.nl/");
    }

    @After("@Snapshot")
    public void afterSnapshotTest(){
        if(runType.equals("actual")){

        }
    }


    public String getRunTypeNameExtension() {
        if (runType.toLowerCase().equals("baseline")) {
            return "_baseline-attachment.PNG";
        } else if (runType.toLowerCase().equals("actual")) {
            return "_actual-attachment.PNG";
        }
        return "";
    }

    public String getRunTypeNameExtension(String runType) {
        if (runType.toLowerCase().equals("baseline")) {
            return "_baseline-attachment.PNG";
        } else if (runType.toLowerCase().equals("actual")) {
            return "_actual-attachment.PNG";
        } else if (runType.toLowerCase().equals("dif")) {
            return "_dif-attachment.PNG";

        }
        return "";
    }


    public void takeSnapshotAndCompare(String snapshotName, String element) {
        Screenshot screenshot = null;
        if (element.length() < 2) {//check if snapshot is full page or a snapshot of an element
            screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(700)).takeScreenshot(driver);
        } else {
            $(element).shouldBe(Condition.visible).scrollTo();
            WebElement webElement = driver.findElement(By.cssSelector(element));
            screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(700)).takeScreenshot(driver, webElement);
        }

        BufferedImage image = screenshot.getImage();

        String pathToScreen = resultLocation + snapshotName + getRunTypeNameExtension();
        try {
            File dir = new File(resultLocation);
            if (dir.exists()) {

            } else {
                dir.mkdirs();
            }
            ImageIO.write(image, "PNG",
                    new File(pathToScreen));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (runType.equals("actual")) {
            compareAshot(snapshotName);

        }

    }

    public void compareAshot(String snapshotName) {

        ImageDiff diff = null;
        BufferedImage diffImage = null;
        String act_ = resultLocation + snapshotName + getRunTypeNameExtension();
        String exp_ = baselineLocation + snapshotName + getRunTypeNameExtension("baseline");
        String dif_ = resultLocation + snapshotName + getRunTypeNameExtension("dif");

        try {
            diff = new ImageDiffer().makeDiff(stringToImage(act_), stringToImage(exp_));
            diffImage = diff.getMarkedImage(); // comparison result with marked differences
        } catch (Exception e) {
            File file = new java.io.File("");   //Dummy file
            String  abspath=file.getAbsolutePath();
            addFailDetails(getHTMLWhenTestFail(resultLocation));
            assertFalse( "Compare function failed for some reasons. One of the images on location does not exist. Please check if the actual or expected image exist.\n Actual image:  " +abspath+"/"+ act_ + " Expected image: "+abspath+"/" + exp_,true);
        }
        try {
            File dir = new File(resultLocation);
            if (dir.exists()) {

            } else {
                dir.mkdirs();
            }
            ImageIO.write(diffImage, "PNG",
                    new File(dif_));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String dif__ = "- Compare failed because of dif" +
                "ferent marge which is: " + diff.getDiffSize() + " and it should be les than: " + compareMarge + " Snapshotname of failed test is: " + snapshotName;
        actualAttachment(act_);
        expectedAttachment(exp_);
        diffAttachment(dif_);

        if (!(diff.getDiffSize() < compareMarge && compareMarge != 0)) {
            addFailDetails(getHTMLWhenTestFail(resultLocation));
            assertFalse( dif__,diff.hasDiff());
        }


    }

    public BufferedImage stringToImage(String imageString) {
        BufferedImage bImage = null;
        try {
            bImage = ImageIO.read(new File(imageString));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("failed to get BufferImage");
        }

        return bImage;
    }

    @Attachment(value = "diff", type = "image/png")
    public byte[] diffAttachment(String _path) {
        return  convertImageToByte(_path);
    }
    @Attachment(value = "actual", type = "image/png")
    public byte[] actualAttachment(String _path) {
        return  convertImageToByte(_path);
    }
    @Attachment(value = "expected", type = "image/png")
    public byte[] expectedAttachment(String _path) {
      return  convertImageToByte(_path);
    }

    @Attachment(value = "Fail details")
    public String addFailDetails(String details){

        return details;
    }

    public byte[] convertImageToByte(String _path){
        Path path = Paths.get(_path);
        byte[] image = new byte[0];
        try {
            image = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;

    }


    public String getHTMLWhenTestFail(String locationOfScreen){
        File file = new java.io.File("");   //Dummy file
        String  abspath=file.getAbsolutePath();
        abspath = abspath+ "//" + locationOfScreen;
        String currentURL = driver.getCurrentUrl() ;
        return "<!DOCTYPE html>"+
                "<html>"+
                "<body>"+
                "<h1>CurrentURL<h1>"+
                "<p><a href=\"" + currentURL   + "\"target=\"_blank\">"+currentURL+"</a></p>"+
                "<p>Location of screenshots: <br><a href=\"file://"+abspath+"\">"+abspath+"</a></p>"+
                "</body>"+
                "</html>";

    }


}
