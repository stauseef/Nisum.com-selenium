package runner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SSLCertifications {
    public static void main(String[] args){
        //Desired Capabilities
        DesiredCapabilities dS = new DesiredCapabilities().chrome();
        dS.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
        dS.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
        //Adding desired capabilities to your chrome browser
        ChromeOptions cO = new ChromeOptions();
        cO.merge(dS);

        WebDriver driver = new ChromeDriver(cO);
    }
}
