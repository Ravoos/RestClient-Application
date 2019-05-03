package REST;

import java.io.Serializable;  
import java.util.Date;
import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement; 
@XmlRootElement(name = "temp") 

public class Tempratur  implements Serializable{
    private static final long serialVersionUID = 1L;
    private int temp;
    private Date read;
    
    public Tempratur(){}
    
    public Tempratur(int id, String title, Date read){

        this.temp = temp;

        this.read = read;
    }

    public int getTemp() {
        return temp;
    }
    
   @XmlElement 
    public void setTemp(int temp) {
        this.temp = temp;
    }

    public Date getRead() {
        return read;
    }
   @XmlElement 
    public void setRead(Date read) {
        this.read = read;
    }
}
    