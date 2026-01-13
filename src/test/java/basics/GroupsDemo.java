package basics;

import org.testng.annotations.Test;

public class GroupsDemo {

    @Test(groups = {"smoke"})
    public void smokeTest1() {
        System.out.println("Smoke Test 1");
    }

    @Test(groups = {"smoke"})
    public void smokeTest2() {
        System.out.println("Smoke Test 2");
    }

    @Test(groups = {"regression"})
    public void regressionTest1() {
        System.out.println("Regression Test 1");
    }

    @Test(groups = {"regression"})
    public void regressionTest2() {
        System.out.println("Regression Test 2");
    }
}
