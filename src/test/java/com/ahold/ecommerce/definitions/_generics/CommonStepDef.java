package com.ahold.ecommerce.definitions._generics;

import com.ahold.ecommerce.definitions.cookienotice.CookieNoticePage;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;

public class CommonStepDef extends BaseStepDef {

    private CookieNoticePage cookieNoticePage;

    @PostConstruct
    public void setUp() {
        cookieNoticePage = PageFactory.initElements(webDriver, CookieNoticePage.class);
    }

    /* Sample for ah.nl
    @Gegeven("^gebruiker is op de ah.nl web-omgeving \"([^\"]*)\"$")
    public void open_appie_today_website(String environment) {
        basePage.navigateToEnvironment(environment);
    }

    @Gegeven("^de gebruiker heeft de cookies geaccepteert")
    public void accepteren_cookie_melding() {
        basePage.addCookie("cookie_agreed", "true");
        basePage.refreshPage();
        basePage.isCookieNoticeVisible();
        basePage.buttonClick("accept-cookies");
    }
    */
}
