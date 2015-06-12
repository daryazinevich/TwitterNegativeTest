package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static void check(WebElement checkBox) {
        setCheckboxTo(checkBox, true);
     }

    public static void uncheck(WebElement checkBox) {
        setCheckboxTo(checkBox, false);
    }

    public static void setCheckboxTo(WebElement checkbox, boolean wishToCheck) {
        if (checkbox.isSelected() != wishToCheck) {
            checkbox.click();
        }
    }
}
