package REST;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;


public class main {
    
    private static ClientConfig config = new DefaultClientConfig();
    private static Client client = Client.create(config);
    private static WebResource service = client.resource(
    UriBuilder.fromUri("http://localhost:8080/RESTAnlaggning").build());
    
    public static void main(String[] args) throws IOException {
        int choise = 0;
        
        Scanner cc = new Scanner(System.in);
        
        do {
            System.out.println("1) Visa tempratur");
            System.out.println("2) Visa kostnad");
            System.out.println("3) Visa förbruk");
            System.out.println("4) Tempratur rapport");
            System.out.println("5) Förbruk/Kostnad rapport");
            System.out.println("6) Senaste kostnad/förbruk och tempratur");
            System.out.println("7) Lägg till tempratur");
            System.out.println("8) Lägg till kostnad");
            System.out.println("9) Exit");
            choise = cc.nextInt();
            switch (choise) {
                case 1:
                    
                    Tempratur currentTemp = service.path("rest/Services/temp").accept(MediaType.APPLICATION_XML).get(Tempratur.class);
        
                    
                    System.out.println("Date: " + currentTemp.getRead() + ". Temp: " + currentTemp.getTemp());
                break;
                
                case 2:
                    Kostnad currentKr = service.path("rest/Services/kr").accept(MediaType.APPLICATION_XML).get(Kostnad.class);
                    
                    System.out.println("Date: " + currentKr.getRead() + ". KR: " + currentKr.getKr());
                break;
                    
                case 3:
                    Forbruk currentWatt = service.path("rest/Services/watt").accept(MediaType.APPLICATION_XML).get(Forbruk.class);
                    
                    System.out.println("Date: " + currentWatt.getRead() + ". Watt: " + currentWatt.getWatt());
                break;
                
                case 4:
                    int sum = 0;
                    int max = 1;
                    int min = 100;
                    Tempratur[] tempArray = service.path("rest/Services/tempReport").accept(MediaType.APPLICATION_XML).get(Tempratur[].class);
                    
                    for (Tempratur t : tempArray){
                        System.out.println("Date: " + t.getRead() + " C*: " + t.getTemp());
                        if (t.getTemp() < min) {
                            min = t.getTemp();
                        }
                        
                        if (t.getTemp() > max) {
                            max = t.getTemp();
                        }
                        sum += t.getTemp();
                    }
                    int arg = sum/tempArray.length;
                    
                    System.out.println("Max value: " + max);
                    System.out.println("Min value: " + min);
                    System.out.println("Median: " + arg);
                    break;
                    
                case 5:
                    int wattSum = 0;
                    int wattMax = 1;
                    int wattMin = 100;
                    
                    int krSum = 0;
                    int krMax = 1;
                    int krMin = 100;
                    
                    Forbruk[] wattArray = service.path("rest/Services/wattReport").accept(MediaType.APPLICATION_XML).get(Forbruk[].class);
                    Kostnad[] krArray = service.path("rest/Services/krReport").accept(MediaType.APPLICATION_XML).get(Kostnad[].class);
                    
                    for (Forbruk f : wattArray) {
                        System.out.println("Date: " + f.getRead() + " KW " + f.getWatt());
                        
                        if (f.getWatt() < wattMin) {
                            min = f.getWatt();
                        }
                        
                        if (f.getWatt() > wattMax) {
                            max = f.getWatt();
                        }
                        krSum += f.getWatt();
                    }
                    for (Kostnad k : krArray) {
                        System.out.println("Date: " + k.getRead() + ". SEK: " + k.getKr());
                        
                        if (k.getKr() < krMin) {
                            min = k.getKr();
                        }
                        
                        if(k.getKr() > krMax) {
                            krMax = k.getKr();
                        }
                        krSum += k.getKr();
                    }
                    int wattArg = wattSum/wattArray.length;
                    int krArg = krSum/krArray.length;
                        
                    System.out.println("Max kgW: " + wattMax);
                    System.out.println("Max SEK: " + krMax);
                    System.out.println("Min kgW: " + wattMin);
                    System.out.println("Min SEK: " + krMin);
                    System.out.println("Median kgW: " + wattArg);
                    System.out.println("Median SEK: " + krArg);
                    break;
                    
                case 6:
                    Tempratur currentTemp2 = service.path("rest/Services/temp").accept(MediaType.APPLICATION_XML).get(Tempratur.class);
                    Kostnad currentKr2 = service.path("rest/Services/kr").accept(MediaType.APPLICATION_XML).get(Kostnad.class);
                    Forbruk currentWatt2 = service.path("rest/Services/watt").accept(MediaType.APPLICATION_XML).get(Forbruk.class);
                    
                    System.out.println("Date: " + currentTemp2.getRead() + ". Temp: " +currentTemp2.getTemp());
                    System.out.println("Date: " + currentKr2.getRead() + ". SEK: " +currentKr2.getKr());
                    System.out.println("Date: " + currentWatt2.getRead() + ". kgW: " +currentWatt2.getWatt());
                    break;
                    
                case 7:
                    Tempratur newTemp = new Tempratur();
                    System.out.println("Vad är tempraturen nu? ");
                    newTemp.setTemp(cc.nextInt());
                    
                    ClientResponse addTem = service.path("rest/Services/temp/add").accept(MediaType.APPLICATION_XML).post(ClientResponse.class, newTemp);
                    System.out.println("Added: " + addTem.getEntity(String.class));
                    break;
                    
                case 8:
                    Kostnad newKr = new Kostnad();
                    System.out.println("Vad är kostnaden? ");
                    newKr.setKr(cc.nextInt());
                    
                    ClientResponse addKr = service.path("rest/Services/kr/add").accept(MediaType.APPLICATION_XML).post(ClientResponse.class, newKr);
                    System.out.println("Added: " + addKr.getEntity(String.class));
                    break;
                    
                case 9:
                    System.out.println("Bye!");
                    break;
            }} while (choise != 9);
    }
    
}
