package com.ahold.ecommerce.definitions.snapshot;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.Assert.assertFalse;

import com.ahold.ecommerce.definitions.BasePage;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.qameta.allure.Attachment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.junit.Test;
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
public class SnapshotPage extends BasePage{
    private WebDriver driver;
    private String resultLocation = "C:\\screenshots\\", baselineLocation = "C:\\screenshots\\", runType = "actual";
    private int compareMarge = 0;

    public SnapshotPage(WebDriver webdriver) {
        super(webdriver);
        this.driver = webdriver;
    }
    public void navigateToAH() {

        navigateToPage("https://www.ah.nl");
    }

   /* public SnapshotPage(WebDriver driver) {
        this.driver = driver;

    }*/
    @Test
    public void checkIfSnapshotIsCreated(){
        Configuration.browser = "chrome";
        ChromeDriverManager.getInstance().setup();
        open("https://www.ah.nl");
        this.driver = WebDriverRunner.getWebDriver();

        takeSnapshotAndCompare("googlepagina",".article-group.edc-article-group.edc-article-group--inline-headings.small-6");
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

    public void takeSnapshotAndCompare(String snapshotName, String Element) {
        //-attachment
        Screenshot screenshot = null;
        if (Element.length() < 2) {//check if snapshot is full page or a snapshot of an element
            screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(700)).takeScreenshot(driver);
        } else {
            WebElement webElement = driver.findElement(By.cssSelector(Element));
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
        createCompareResultOnScreenshot(createHTMLWithImages(
                snapshotName + getRunTypeNameExtension("baseline"),
                 snapshotName + getRunTypeNameExtension(),
                 snapshotName + getRunTypeNameExtension("dif")));
        try {
            diff = new ImageDiffer().makeDiff(stringToImage(act_), stringToImage(exp_));
            diffImage = diff.getMarkedImage(); // comparison result with marked differences
        } catch (Exception e) {
            System.out.println("Compare failed. Images might not exist");
            assertFalse( "Compare function failed for some reasons. Images location might not exist: " + act_ + " Expected: " + exp_,true);
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
        System.out.println("DIFF SIZE CHECK: " + diff.getDiffSize());
        if (diff.getDiffSize() > compareMarge) {
            compareMarge = 0;

        }

        if (diff.getDiffSize() < compareMarge && compareMarge != 0) {
            System.out.println("Compare result is within the marge and will not fail");
        } else {
            assertFalse( dif__,diff.hasDiff());
        }


    }

    public BufferedImage stringToImage(String imageString) {
        //string to ByteArrayInputStream
        BufferedImage bImage = null;

        try {
            bImage = ImageIO.read(new File(imageString));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("failed to get BufferImage");
        }

        return bImage;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @Attachment(value = "Compare result")
    public String createCompareResultOnScreenshot(String screenShot) {
        return screenShot;
    }

    public String createHTMLWithImages(String exp_,String act_, String diff_){
        return "<!DOCTYPE html>"+
                "<html>"+
                "<head>"+
                "<style>"+
                "img { width:100%;}"+
                "</style>"+
                "</head>"+
                "<body>"+
                "<h1>Differences</h1>"+
                "<img src=\"" +diff_ +"\"alt=\"HTML5 Icon\" style=\"width:50%;height:30%;\">"+
                "<h1>Expected</h1>"+
                "<img src=\""+exp_+"\"alt=\"HTML5 Icon\" style=\"width:50%;height:30%;\">"+
                "<h1>Actual</h1>"+
                "<img src=\""+act_+"\"alt=\"HTML5 Icon\" style=\"width:50%;height:30%;\">"+
                "</body>"+
                "</html>";
    }


}
