package hooks;

import factory.DriverFactory;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utils.ActionHelper;
import utils.LogHelper;

public class Hooks {

    private static final Logger log = LogHelper.getLogger(Hooks.class);


    @Before(order = 1)
    public void start(){
        log.info(" $$$$$$\\  $$$$$$$\\   $$$$$$\\  $$\\   $$\\  $$$$$$\\  $$$$$$$$\\       $$\\   $$\\ $$$$$$$\\  $$\\      $$\\        $$$$$$\\  $$\\   $$\\ $$$$$$$$\\  $$$$$$\\  $$\\      $$\\  $$$$$$\\ $$$$$$$$\\ $$$$$$\\  $$$$$$\\  $$\\   $$\\ \n" +
                "$$  __$$\\ $$  __$$\\ $$  __$$\\ $$$\\  $$ |$$  __$$\\ $$  _____|      $$ |  $$ |$$  __$$\\ $$$\\    $$$ |      $$  __$$\\ $$ |  $$ |\\__$$  __|$$  __$$\\ $$$\\    $$$ |$$  __$$\\\\__$$  __|\\_$$  _|$$  __$$\\ $$$\\  $$ |\n" +
                "$$ /  $$ |$$ |  $$ |$$ /  $$ |$$$$\\ $$ |$$ /  \\__|$$ |            $$ |  $$ |$$ |  $$ |$$$$\\  $$$$ |      $$ /  $$ |$$ |  $$ |   $$ |   $$ /  $$ |$$$$\\  $$$$ |$$ /  $$ |  $$ |     $$ |  $$ /  $$ |$$$$\\ $$ |\n" +
                "$$ |  $$ |$$$$$$$  |$$$$$$$$ |$$ $$\\$$ |$$ |$$$$\\ $$$$$\\          $$$$$$$$ |$$$$$$$  |$$\\$$\\$$ $$ |      $$$$$$$$ |$$ |  $$ |   $$ |   $$ |  $$ |$$\\$$\\$$ $$ |$$$$$$$$ |  $$ |     $$ |  $$ |  $$ |$$ $$\\$$ |\n" +
                "$$ |  $$ |$$  __$$< $$  __$$ |$$ \\$$$$ |$$ |\\_$$ |$$  __|         $$  __$$ |$$  __$$< $$ \\$$$  $$ |      $$  __$$ |$$ |  $$ |   $$ |   $$ |  $$ |$$ \\$$$  $$ |$$  __$$ |  $$ |     $$ |  $$ |  $$ |$$ \\$$$$ |\n" +
                "$$ |  $$ |$$ |  $$ |$$ |  $$ |$$ |\\$$$ |$$ |  $$ |$$ |            $$ |  $$ |$$ |  $$ |$$ |\\$  /$$ |      $$ |  $$ |$$ |  $$ |   $$ |   $$ |  $$ |$$ |\\$  /$$ |$$ |  $$ |  $$ |     $$ |  $$ |  $$ |$$ |\\$$$ |\n" +
                " $$$$$$  |$$ |  $$ |$$ |  $$ |$$ | \\$$ |\\$$$$$$  |$$$$$$$$\\       $$ |  $$ |$$ |  $$ |$$ | \\_/ $$ |      $$ |  $$ |\\$$$$$$  |   $$ |    $$$$$$  |$$ | \\_/ $$ |$$ |  $$ |  $$ |   $$$$$$\\  $$$$$$  |$$ | \\$$ |\n" +
                " \\______/ \\__|  \\__|\\__|  \\__|\\__|  \\__| \\______/ \\________|      \\__|  \\__|\\__|  \\__|\\__|     \\__|      \\__|  \\__| \\______/    \\__|    \\______/ \\__|     \\__|\\__|  \\__|  \\__|   \\______| \\______/ \\__|  \\__|\n" +
                "                                                                                                                                                                                                             \n" +
                "                                                                                                                                                                                                             \n" +
                "                                                                                                                                                                                                             ");
    }
    @Before(order = 2)
    public void setup(){
        log.info("Launching Browser.....");
        DriverFactory.initDriver();
    }

    @After
    public  void tearDown(Scenario scenario){

        if(scenario.isFailed()){
            String path = new ActionHelper().takeScreenshot(scenario.getName().replaceAll(" ","_"));
            log.error("Scenario failed.. Screenshot at :" +path);
        }
        log.info("Qutting Browser....");
        DriverFactory.quitDriver();
    }
}
