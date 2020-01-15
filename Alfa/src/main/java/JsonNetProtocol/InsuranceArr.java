package JsonNetProtocol;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class InsuranceArr {

    @SerializedName("id")
    @Expose
    public int id;
    @SerializedName("end_date")
    @Expose
    public Date endDate;
    @SerializedName("start_date")
    @Expose
    public Date startDate;

}