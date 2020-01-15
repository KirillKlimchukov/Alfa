package JsonNetProtocol;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("status")
    @Expose
    public Integer errCode;
    @SerializedName("message")
    @Expose
    public String message;

}

