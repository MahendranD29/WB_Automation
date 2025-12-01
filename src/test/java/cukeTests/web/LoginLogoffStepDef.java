package cukeTests.web;

import io.cucumber.java.en.Given;
import page.LoginLogOffPage;
import qa.data.utils.*;

import net.thucydides.core.annotations.Steps;


public class LoginLogoffStepDef extends LoginLogOffPage {

    String url;

    @Steps
    LoginLogOffPage loginLogOffPage;

    //Read scenario name ar run time
    String ScenarioName = Hooks.scenario.getName();

    @Given("User launches app {string} Environment")
    public void userLaunchesAppEnvironment(String env) throws Exception {
        try {
            System.out.println("Environment: "+ env);
            url = getURL(env);
            System.out.println("Url:"+url);
            log4jBaseClass.info("Url:" + url);

        } catch (Exception ex) {
            System.out.println("No URL Passed via Maven. Default URL is considered");
            url = getURL(env);
            url = prop.getProperty("CloudUrl");
            System.out.println("url is :"+url);
            log4jBaseClass.info("Environment not set via maven. Default url:" + url);

        }

        System.out.println("Scenario Name:***" + ScenarioName + "***");
        initialization(url, prop.getProperty("Browser"), true);
        loginLogOffPage = new LoginLogOffPage();
        System.out.println("title:"+getDriver().getCurrentUrl());
        System.out.println("Cookies on login Page:" + getDriver().manage().getCookies());
        Thread.sleep(DELAY_IN_MILLI_SECS);
    }
}

