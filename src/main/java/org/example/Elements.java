package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.swing.*;

public class Elements {
    public static WebDriver driver;
    public Elements(WebDriver webDriver) {
        driver = webDriver;

    }
    public WebElement txtSearchBox() {
        return driver.findElement(By.id("txtSearchBox"));
    }

    public WebElement product() {
        return driver.findElement(By.cssSelector(".col-6:nth-child(43) .is-initialized > .ng-star-inserted"));
    }
    public WebElement product1() {
        return driver.findElement(By.xpath("/html/body/app-root/cx-storefront/main/cx-page-layout/cx-page-slot[3]" +
                "/eb-product-list/div/section/div/div/div/div[2]/eb-product-scroll/div/div/eb-product-list-item[43]/div" +
                "/eb-generic-link/a/div/h2/span"));
    }
    public WebElement product2() {
        return driver.findElement(By.xpath("/html/body/app-root/cx-storefront/cx-page-slot/eb-breadcrumb/div/div/nav/div/span[5]/span/a/span/a"));
    }
    public WebElement completeShoppingBtn() {
        return driver.findElement(By.id("btnGoToShippingAddress"));
    }
    public WebElement addCartButton() {
        return driver.findElement(By.id("addToCartBtn"));
    }
    public WebElement popUpClose() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/img"));
    }
    public WebElement btnShowCart() {
        return driver.findElement(By.id("btnShowCart"));
    }




}
