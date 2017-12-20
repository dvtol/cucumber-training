package com.kvknl.regressie.definitions.kvkor.nieuweinschrijving;

import com.kvknl.regressie.definitions._generics.BaseStepDef;
import com.kvknl.regressie.definitions.kvkor.nieuweinschrijving.bestuurderdata.BestuurderDataPage;
import com.kvknl.regressie.definitions.kvkor.nieuweinschrijving.basisgegevensrechtspersoon.BasisgegevensRechtspersoonPage;
import com.kvknl.regressie.definitions.kvkor.nieuweinschrijving.samenstellenopgave.SamenstellenOpgavePage;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.En;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;

public class NieuweInschrijvingStepDef extends BaseStepDef {

    private SamenstellenOpgavePage samenstellenOpgavePage;
    private BasisgegevensRechtspersoonPage basisgegevensRechtspersoonPage;
    private BestuurderDataPage bestuurderDataPage;

    @PostConstruct
    public void setUpNieuweInschrijving() {
        samenstellenOpgavePage = PageFactory.initElements(webDriver, SamenstellenOpgavePage.class);
        basisgegevensRechtspersoonPage = PageFactory.initElements(webDriver, BasisgegevensRechtspersoonPage.class);
        bestuurderDataPage = PageFactory.initElements(webDriver, BestuurderDataPage.class);
    }

    @Als("^de gebruiker voor een nieuwe inschrijving met als rechtsvorm BV")
    public void selecteer_nieuwe_inschrijving() {
        samenstellenOpgavePage.keuzeRechtsvorm();
    }

    @En("^de benodigde en verplichte gegevens zijn opvoerd")
    public void vullen_gegevens_inschrijving() {
        basisgegevensRechtspersoonPage.BasisgegevensRechtspersoon();
        bestuurderDataPage.GegevensBestuurder();
    }
}
