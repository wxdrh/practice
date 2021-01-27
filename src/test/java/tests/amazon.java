package tests;

import org.testng.annotations.Test;
import pageClass.Ecom;

import java.io.*;
import java.util.Properties;


@Test
public class amazon {
    Ecom a = new Ecom();

    @Test(groups = { "amazon"})
    public void searchAmazon() {
        a.searchAmazon();
        a.quit();
    }
    @Test(groups = { "daraz"})
    public void searchDaraz() {
        a.searchDaraz();
        a.quit();
    }



}
