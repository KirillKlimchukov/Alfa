import JsonNetProtocol.InsuranceArr;
import JsonNetProtocol.InsuranceFull;
import JsonNetProtocol.Response;

public class Logger {

    public void message(String message){
        System.out.println(message);
    }

    public void LogInsFullStruct(InsuranceFull insuranceFull){
        System.out.println("Incoming hardcoded Json created parced");
        System.out.println("start_date: "+ insuranceFull.startDate);
        System.out.println("end_date: "+ insuranceFull.endDate);
        System.out.println("age: "+ insuranceFull.age);
        System.out.println("Region: "+ insuranceFull.region);
        System.out.println("City: "+ insuranceFull.city);
        for (InsuranceArr insuranceArr : insuranceFull.insurance)
        {
            System.out.println("insurance id: "+insuranceArr.id);
            System.out.println("insurance start_date: "+insuranceArr.startDate);
            System.out.println("insurance end_date: "+insuranceArr.endDate);
        }
    }

    public void LogFakeSrvResponse(Response response){
        System.out.println("errCode: "+ response.errCode);
        System.out.println("message: "+ response.message);
    }

}
