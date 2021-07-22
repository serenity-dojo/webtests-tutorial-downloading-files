package com.serenitydojo.webtests.downloads;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.configuration.SessionLocalTempDirectory;
import org.awaitility.Awaitility;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SerenityRunner.class)
public class WhenDownloadingFilesFromAPage {

    @Managed
    WebDriver driver;

    DownloadsPage downloadPage;

    @Before
    public void openTestPage() {
        WebDriverManager.firefoxdriver().setup();

        downloadPage.open();
    }

    @Test
    public void shouldDownloadSimpleTextFiles()  {

        String fileToDownload = "Report.png";

        // Download the file
        downloadPage.downloadFileCalled(fileToDownload);

        File downloadedFile = SessionLocalTempDirectory.forTheCurrentSession().resolve("downloads/" + fileToDownload).toFile();

        Awaitility.await().atMost(10, TimeUnit.SECONDS).until(downloadedFile::exists);

        // Check that the file exists...
        assertThat(downloadedFile).exists();
//
//        Set<String> currentWindows = driver.getWindowHandles();
//        String currentWindow = driver.getWindowHandle();
//        String pdfFileView = currentWindows.stream().filter(window -> !window.equals(currentWindow)).findFirst().get();
//
//        driver.switchTo().window(pdfFileView);
//        assertThat(driver.getTitle()).isEqualTo("My PDF");
    }
}
