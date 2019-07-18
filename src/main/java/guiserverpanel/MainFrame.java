package guiserverpanel;


import com.google.gson.Gson;
import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.looks.plastic.PlasticLookAndFeel;
import com.jgoodies.looks.plastic.theme.LightGray;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.simple.JSONObject;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.devtools.remote.client.HttpHeaderInterceptor;
import org.springframework.http.*;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import model.ServerStatus;

@SpringBootApplication
public class MainFrame
{


    public String baseUrl;

    public String username;
    public String password;



    public ServerPanel spanel;

    public ServerStatus sstatus;

    public static HttpHeaders authenticationHeaders;
    public static HttpEntity<Void> httpEntity;
    public static java.util.List<ClientHttpRequestInterceptor> interceptors;
    private static RestTemplate restTemplate = new RestTemplate();

    public static Gson gson;

    public MainFrame()
    {

        baseUrl = new String("http://localhost:8080/guipanel/");

        username = new String("demouser");
        password = new String("demouser");


        JFrame frame = new JFrame();
        try
        {
            PlasticLookAndFeel.setPlasticTheme(new LightGray());
            UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        Container contentPane = frame.getContentPane();
        contentPane.setLayout(new BorderLayout());


        spanel = new ServerPanel();
        contentPane.add(spanel, BorderLayout.CENTER);


        // http://localhost:8080/guipanel/


        frame.setSize(585, 310);
        frame.setVisible(true);



        //httpInterceptor();
        registerClient();


        starth2serverdatabase(sstatus);

        System.out.print("Das ist guidata");
    }




    public static void main(String[] args)
    {
        MainFrame mframe = new MainFrame();

    }




    public HttpEntity<Void> registerClient()
    {

        ClientHttpRequestFactory factory = new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory());

        restTemplate = new RestTemplate(factory);



        String userCredential = username + ":" + password;
        byte[] base64UserCredentialData = Base64.encodeBase64(userCredential.getBytes());

        authenticationHeaders = new HttpHeaders();
        authenticationHeaders.set("Authorization", "Basic " + new String(base64UserCredentialData));


        httpEntity = new HttpEntity<>(authenticationHeaders);

        ResponseEntity<String> response = restTemplate.exchange("http://localhost:8080/user", //
                HttpMethod.GET, httpEntity, String.class);
        //MediaType contentType = response.getHeaders().setCookie
        //List<Void> result = response.getBody();
        java.util.List<String> listresponsecookies = response.getHeaders().get("Set-Cookie");

        String xsrftoken = (String) listresponsecookies.get(0);
       // xsrftoken.substring(11,47);


        //String jessionid = (String) listresponsecookies.get(1);

        // get string only --- > token
        // authenticationHeaders.set("X-CSRF-TOKEN", xsrftoken.substring(11,47));
        //authenticationHeaders.set("", jessionid);

        // Csrf-token
        authenticationHeaders.set("XSRF-TOKEN", xsrftoken.substring(11,47));
        //java.util.List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors = new ArrayList<>();

        interceptors.add(new HttpHeaderInterceptor("Accept", MediaType.APPLICATION_JSON_VALUE));
        interceptors.add(new HttpHeaderInterceptor("ContentType", "application/json;charset=UTF-8"));
        interceptors.add(new HttpHeaderInterceptor("Authorization", "Basic " + new String(base64UserCredentialData)));
        interceptors.add(new HttpHeaderInterceptor("XSRF-TOKEN", xsrftoken.substring(11,47)));

        restTemplate.setInterceptors(interceptors);

        httpEntity = new HttpEntity<Void>(authenticationHeaders);


        return httpEntity;
    }


    public ServerStatus starth2serverdatabase(ServerStatus sstatus)
    {



        JSONObject sampleObject = new JSONObject();
        sampleObject.put("server", "start");
   
        
        restTemplate.postForObject(baseUrl + "starth2server", sampleObject, JSONObject.class);

        return sstatus;
    }



}
