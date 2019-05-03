package REST;

import java.io.Serializable;  
import java.util.Date;
import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement; 
@XmlRootElement(name = "kost") 

public class Kostnad  implements Serializable{
    private static final long serialVersionUID = 1L;
    private int kr;
    private Date read;
    
    public Kostnad(){}
    
    public Kostnad(int ke, Date read){
        this.kr = kr;

        this.read = read;
    }
    
    public int getKr() { 
      return kr; 
    }  
    
    @XmlElement 
    public void setKr(int kr) { 
        this.kr = kr; 
    } 
    
    public Date getRead() {
        return read;
    }
   @XmlElement 
    public void setRead(Date read) {
        this.read = read;
    }
}
    