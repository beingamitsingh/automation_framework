package framework;

import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.HashMap;

public class Harness {

    public static HashMap<String, ArrayList<String>> allObjects;

    @BeforeSuite
    public void setUp() {
        //Load config variables
        new Config();

        //Fetch all objects from repository
        allObjects = Support.getAllObjects();
    }
}
