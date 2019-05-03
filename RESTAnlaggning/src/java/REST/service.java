package REST;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Path("/Services")

public class service 
{
    static dao DAO = new dao();
    
    @GET
    @Path("/temp")
    @Produces(MediaType.APPLICATION_XML)
    public Tempratur getLatestTemp() {
        try {
            return DAO.getLatestTempSQL();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    @GET
    @Path("/kr")
    @Produces(MediaType.APPLICATION_XML)
    public Kostnad getLatestKr() {
        try {
            return DAO.getLatestKostnad();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    @GET
    @Path("/watt")
    @Produces(MediaType.APPLICATION_XML)
    public Forbruk getLatestWatt() {
        try {
            return DAO.getLatestWatt();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    @GET
    @Path("/tempReport")
    @Produces(MediaType.APPLICATION_XML)
    public List<Tempratur> getAllTemp() {
        try {
            return DAO.getAllTempSQL();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    @GET
    @Path("/wattReport")
    @Produces(MediaType.APPLICATION_XML)
    public List<Forbruk> getAllWatt() {
        try {
            return DAO.getAllWattSQL();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    @GET
    @Path("/krReport")
    @Produces(MediaType.APPLICATION_XML)
    public List<Kostnad> getAllKr() {
        try {
            return DAO.getAllKrSQL();
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    @POST
    @Path("/temp/add")
    @Produces(MediaType.APPLICATION_XML)
    public Response addNewTemp(Tempratur t) throws IOException, FileNotFoundException, ClassNotFoundException {
        Response res = new Response("Lägg i en ny tempratur: ", Boolean.FALSE);
        
        DAO.addTemp(t);
        res.setStatus(Boolean.TRUE);
        return res;        
    }
    
    @POST
    @Path("/kr/add")
    @Produces(MediaType.APPLICATION_XML)
    public Response addNewKr(Kostnad k) throws IOException, FileNotFoundException, ClassNotFoundException {
        Response res = new Response("Lägg i en ny kostnad: ", Boolean.FALSE);
        
        DAO.addKr(k);
        res.setStatus(Boolean.TRUE);
        return res;        
    }
}
