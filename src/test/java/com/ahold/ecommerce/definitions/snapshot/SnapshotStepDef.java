package com.ahold.ecommerce.definitions.snapshot;

import com.ahold.ecommerce.definitions.BaseStepDef;
import cucumber.api.PendingException;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Gegeven;
import javax.annotation.PostConstruct;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sherwin on 2-7-2017.
 */
public class SnapshotStepDef extends BaseStepDef {
    private AllureHelper allureHelper;

    @PostConstruct
    public void setUp() {
        allureHelper = PageFactory.initElements(webDriver, AllureHelper.class);
    }

    @Gegeven("^open ah")
    public void openAH(){
        allureHelper.navigateToAH();
    }



    @Als("^ik een snapshot \"([^\"]*)\" maak en vergelijk$")
    public void ikEenSnapshotMaakEnVergelijk(String naam)  {
        allureHelper.takeSnapshotAndCompare(naam,"");
    }
}
