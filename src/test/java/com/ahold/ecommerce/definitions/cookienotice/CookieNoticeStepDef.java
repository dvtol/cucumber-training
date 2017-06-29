package com.ahold.ecommerce.definitions.cookienotice;

import com.ahold.ecommerce.definitions._generics.BaseStepDef;
import cucumber.api.java.nl.Dan;
import org.openqa.selenium.support.PageFactory;

import javax.annotation.PostConstruct;

import static org.hamcrest.CoreMatchers.is;


public class CookieNoticeStepDef extends BaseStepDef {

    private CookieNoticePage cookieNoticePage;

    @PostConstruct
    public void setUp() {
        cookieNoticePage = PageFactory.initElements(webDriver, CookieNoticePage.class);
    }

    @Dan("^toont de cookiemelding$")
    public void cookie_notice_visible() {
        cookieNoticePage.isCookieNoticeVisible();
    }
}