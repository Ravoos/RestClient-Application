package REST;



/**
 *
 * @author Patrik
 */

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "response")


public class Response implements Serializable {
    // Add and create everything
    private static long SerialVersionUID = 1L;
    private String message;
    private Boolean status;
    private int value;
    
    public Response() {}
    
    public Response(String message, Boolean status, int value) 
    {
        this.message = message;
        this.status = status;
        this.value = value;
    }

    
    // Return message
    public String getMessage() {
        return message;
    }

    
    // Sets message
    @XmlElement
    public void setMessage(String message) {
        this.message = message;
    }

    
    // Return status
    public Boolean getStatus() {
        return status;
    }

    
    // Sets status
    @XmlElement
    public void setStatus(Boolean status) {
        this.status = status;
    }

    
    // Return value
    public int getValue() {
        return value;
    }

    
    // Sets value
    @XmlElement
    public void setValue(int value) {
        this.value = value;
    }
    
    
}
