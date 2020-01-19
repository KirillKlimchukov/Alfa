package Utils;

import JsonNetProtocol.InsuranceArr;
import JsonNetProtocol.InsuranceFull;
import JsonNetProtocol.Response;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;


public class JsonUtils
{

    //Create a hardcoded incoming json object with Gson .
    public String jsonGenIncObjStr(InsuranceFull insuranceFull){
        Calendar startDate = new GregorianCalendar(2020,1,1);
        Calendar endDate = new GregorianCalendar(2021,1,1);

        InsuranceArr insuranceArr = new InsuranceArr();
        insuranceArr.startDate = startDate.getTime();
        insuranceArr.endDate = endDate.getTime();
        insuranceArr.id = 1;

        List<InsuranceArr> list = new ArrayList<InsuranceArr>();
        list.add(insuranceArr);

        insuranceFull.startDate = startDate.getTime();
        insuranceFull.endDate = endDate.getTime();
        insuranceFull.age = 5;
        insuranceFull.region = "RU";
        insuranceFull.city = "Moscow";
        insuranceFull.insurance = list;

        Gson jsonInputData = new Gson();
        return jsonInputData.toJson(insuranceFull);
    }

    //Generate json response from a fake service
    public String jsonGenRespObjStr (int errCode, String message){
        Gson jsonInputData = new Gson();
        Response response = new Response();
        response.message = message;
        response.errCode = errCode;
        return jsonInputData.toJson(response);
    }


}
