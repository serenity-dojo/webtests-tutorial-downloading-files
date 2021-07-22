package com.serenitydojo.webtests.downloads;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://the-internet.herokuapp.com/download")
public class DownloadsPage extends PageObject {

    public void downloadFileCalled(String filename) {
        find(By.linkText(filename)).click();
    }
}
