package REST;

import java.io.Serializable;  
import java.util.Date;
import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement; 
@XmlRootElement(name = "book") 

public class Forbruk implements Serializable{
    private static final long serialVersionUID = 1L;
    private Date read;
    private int watt;
    
    public Forbruk(){}
    
    public Forbruk(int watt, Date read){
        this.watt = watt;
        this.read = read;
    }
    
    public int getWatt() { 
      return watt; 
    }  
    
    @XmlElement 
    public void setWatt(int watt) { 
        this.watt = watt; 
    } 

    public Date getRead() {
        return read;
    }
   @XmlElement 
    public void setRead(Date read) {
        this.read = read;
    }
}
    