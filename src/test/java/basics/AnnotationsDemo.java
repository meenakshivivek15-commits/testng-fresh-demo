package basics;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationsDemo {

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod");
    }

    @Test
    public void testA() {
        System.out.println("Test A");
    }

    @Test
    public void testB() {
        System.out.println("Test B");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod");
    }
}
