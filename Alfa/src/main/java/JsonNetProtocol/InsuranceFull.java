package JsonNetProtocol;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class InsuranceFull {

    @SerializedName("start_date")
    @Expose
    public Date startDate;
    @SerializedName("end_date")
    @Expose
    public Date endDate;
    @SerializedName("age")
    @Expose
    public int age;
    @SerializedName("region")
    @Expose
    public String region;
    @SerializedName("city")
    @Expose
    public String city;
    @SerializedName("insurance")
    @Expose
    public List<InsuranceArr> insurance;

}