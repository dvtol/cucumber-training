package com.kvknl.regressie.definitions.kvkor.nieuweinschrijving;

import com.kvknl.regressie.definitions._generics.BaseStepDef;
import com.kvknl.regressie.definitions.kvkor.nieuweinschrijving.Bijlagen.BijlagenPage;
import com.kvknl.regressie.definitions.kvkor.nieuweinschrijving.bestuurderdata.BestuurderDataPage;
import com.kvknl.regressie.definitions.kvkor.nieuweinschrijving.basisgegevensrechtspersoon.BasisgegevensRechtspersoonPage;
import com.kvknl.regressie.definitions.kvkor.nieuweinschrijving.ondernemingdata.OndernemingDataPage;
import com.kvknl.regressie.definitions.kvkor.nieuweinschrijving.overzicht.OverzichtPage;
import com.kvknl.regressie.definitions.kvkor.nieuweinschrijving.referentiedata.ReferentieDataPage;
import com.kvknl.regressie.definitions.kvkor.nieuweinschrijving.samenstellenopgave.SamenstellenOpgavePage;
import cucumber.api.java.nl.Als;
import cucumber.api.java.nl.Dan;
import cucumber.api.java.nl.En;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;

public class NieuweInschrijvingStepDef extends BaseStepDef {

    private SamenstellenOpgavePage samenstellenOpgavePage;
    private BasisgegevensRechtspersoonPage basisgegevensRechtspersoonPage;
    private BestuurderDataPage bestuurderDataPage;
    private OndernemingDataPage ondernemingDataPage;
    private ReferentieDataPage referentieDataPage;
    private OverzichtPage overzichtPage;
    private BijlagenPage bijlagenPage;

    @PostConstruct
    public void setUpNieuweInschrijving() {
        samenstellenOpgavePage = PageFactory.initElements(webDriver, SamenstellenOpgavePage.class);
        basisgegevensRechtspersoonPage = PageFactory.initElements(webDriver, BasisgegevensRechtspersoonPage.class);
        bestuurderDataPage = PageFactory.initElements(webDriver, BestuurderDataPage.class);
        ondernemingDataPage = PageFactory.initElements(webDriver, OndernemingDataPage.class);
        bijlagenPage = PageFactory.initElements(webDriver, BijlagenPage.class);
        referentieDataPage = PageFactory.initElements(webDriver, ReferentieDataPage.class);
        overzichtPage = PageFactory.initElements(webDriver, OverzichtPage.class);
    }

    @Als("^de gebruiker voor een nieuwe inschrijving met als rechtsvorm BV")
    public void selecteer_nieuwe_inschrijving() {
        samenstellenOpgavePage.keuzeRechtsvorm();
    }

    @En("^de benodigde en verplichte gegevens zijn opgevoerd")
    public void vullen_gegevens_inschrijving() {
        basisgegevensRechtspersoonPage.BasisgegevensRechtspersoon();
        bestuurderDataPage.GegevensBestuurder();
        ondernemingDataPage.OpvoerenVestiging();
        bijlagenPage.ToevoegenBijlagen();
        referentieDataPage.VulReferentieInformatie();
    }

    @Dan("^kan de gebruiker de opgave valideren, ondertekenen en indienen$")
    public void valideren_ondertekenen_indienen() {
        overzichtPage.ValiderenOndertekenenIndienen();
    }
}
