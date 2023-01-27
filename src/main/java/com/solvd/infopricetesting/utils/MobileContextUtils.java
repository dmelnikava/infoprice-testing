package com.solvd.infopricetesting.utils;

import com.qaprosoft.carina.core.foundation.webdriver.DriverHelper;
import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.ContextAware;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.decorators.Decorated;

import java.util.Set;

public class MobileContextUtils implements IDriverPool {

    private static final Logger LOGGER = (Logger) LogManager.getLogger(MobileContextUtils.class);

    public WebDriver getPureDriver(WebDriver driver) {
        if (driver instanceof Decorated<?>) {
            driver = (WebDriver) ((Decorated<?>) driver).getOriginal();
        }
        return driver;
    }

    public void switchMobileContext(View context) {
        WebDriver driver = getDriver();
        DriverHelper help = new DriverHelper();
        Set<String> contextHandles = help.performIgnoreException(((ContextAware) driver)::getContextHandles);
        String desiredContext = "";
        boolean isContextPresent = false;
        LOGGER.info("Existing contexts: ");
        for (String cont : contextHandles) {
            if (cont.contains(context.getView())) {
                desiredContext = cont;
                isContextPresent = true;
            }
            LOGGER.info(cont);
        }
        if (!isContextPresent) {
            throw new NotFoundException("Desired context is not present");
        }
        LOGGER.info("Switching to context : " + context.getView());
        ((SupportsContextSwitching) driver).context(desiredContext);
    }

    public enum View {
        NATIVE("NATIVE_APP"),
        WEB("WEBVIEW_CHROME");

        String viewName;

        View(String viewName) {
            this.viewName = viewName;
        }

        public String getView() {
            return this.viewName;
        }
    }
}