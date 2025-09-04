package myproject.steps;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

public class Hooks {
    private static ThreadLocal<WebDriver> threadLocalWebdriver=new ThreadLocal<>();
    private static boolean usuario_creado=false;





    //Aqui creamos un usuario por request, ya que la pagina de prueba borras las credenciales despues de un tiempo
    public static synchronized void crearUsuario() throws Exception {
        if(usuario_creado){return;}

        String formData = "customer.firstName=Test&customer.lastName=Test&customer.address.street=Test&customer.address.city=Test&customer.address.state=Test&customer.address.zipCode=1234&customer.phoneNumber=1234&customer.ssn=1234&customer.username=test12353453&customer.password=123456&repeatedPassword=123456";

//        SSLContext sslContext = SSLContext.getInstance("TLS");
//        sslContext.init(null, new TrustManager[]{ new X509TrustManager() {
//            public X509Certificate[] getAcceptedIssuers() { return null; }
//            public void checkClientTrusted(X509Certificate[] certs, String authType) {}
//            public void checkServerTrusted(X509Certificate[] certs, String authType) {}
//        }}, new java.security.SecureRandom());




        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);


        HttpClient client = HttpClient.newBuilder()//.sslContext(sslContext)
                .cookieHandler(cookieManager)//.proxy(ProxySelector.of(new InetSocketAddress("127.0.0.1", 8080)))
                .build();

        HttpRequest request1 = HttpRequest.newBuilder()
                .uri(URI.create("https://parabank.parasoft.com/parabank/register.htm"))
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/139.0.0.0 Safari/537.36")
                .GET()
                .build();

        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create("https://parabank.parasoft.com/parabank/register.htm"))
                .header("Content-Type", "application/x-www-form-urlencoded")
                .header("Origin", "https://parabank.parasoft.com")
                .header("Referer", "https://parabank.parasoft.com/parabank/register.htm")
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/139.0.0.0 Safari/537.36")
                .header("Cache-Control", "max-age=0")
                .header("Upgrade-Insecure-Requests", "1")
                .header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
                .header("Accept-Language", "es-419,es;q=0.9")
                .header("Sec-Fetch-Site", "same-origin")
                .header("Sec-Fetch-Mode", "navigate")
                .header("Sec-Fetch-User", "?1")
                .header("Sec-Fetch-Dest", "document")
                .header("Accept-Encoding", "gzip, deflate, br")
                .header("Priority", "u=0, i ")


                .POST(HttpRequest.BodyPublishers.ofString(formData))
                .build();



        HttpResponse response1;
        HttpResponse response2;

        for (int i = 0; i < 3; i++) {

            response1 = client.send(request1, HttpResponse.BodyHandlers.ofString());

            response2 = client.send(request2, HttpResponse.BodyHandlers.ofString());
            System.out.println("Intento " + (i+1) + ": " + response2.statusCode());

            if (response2.statusCode() == 200 || response2.statusCode() == 302) {
                System.out.println("SE HA CREADO EL USUARIO");
                usuario_creado=true;
                return;
            }
            Thread.sleep(1000);
        }
        throw new Exception("ERROR AL CREAR EL USUARIO");
    }


    @Before
    public void setUpDriver(){

        final Map<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        chromePrefs.put("profile.password_manager_leak_detection", false);

        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", chromePrefs);

        threadLocalWebdriver.set(new ChromeDriver(chromeOptions));
    }
    public static WebDriver getDriver(){
        return threadLocalWebdriver.get();
    }

    @After
    public void tearDownDriver(){
        WebDriver driver=threadLocalWebdriver.get();
        if(driver != null){
            driver.quit();
            threadLocalWebdriver.remove();
        }

        System.out.println("CLOSED DRIVER");
    }

}
