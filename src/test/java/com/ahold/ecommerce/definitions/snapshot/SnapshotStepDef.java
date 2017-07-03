package com.ahold.ecommerce.definitions.snapshot;

import com.ahold.ecommerce.definitions.BaseStepDef;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Gegeven;
import javax.annotation.PostConstruct;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sherwin on 2-7-2017.
 */
public class SnapshotStepDef extends BaseStepDef {
    private SnapshotPage snapshotPage;

    @PostConstruct
    public void setUp() {
        snapshotPage = PageFactory.initElements(webDriver, SnapshotPage.class);
    }

    @Gegeven("^open ah")
    public void openAH(){
        snapshotPage.navigateToAH();
    }



    @Als("^ik een snapshot \"([^\"]*)\" maak en vergelijk$")
    public void ikEenSnapshotMaakEnVergelijk(String naam)  {
        snapshotPage.takeSnapshotAndCompare(naam,"");
    }
}
