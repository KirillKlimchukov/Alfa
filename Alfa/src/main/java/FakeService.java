import JsonNetProtocol.InsuranceArr;
import JsonNetProtocol.InsuranceFull;
import com.google.gson.Gson;


public class FakeService implements iFakeService {

    // assuming that incoming Json data validation has been done
    public String parceIncomingJsonObj (InsuranceFull insuranceFull){
        String response = "";

        Gson responseJson = new Gson();
        JsonUtils jsonUtils = new JsonUtils();

        // performing some fake logic
        // Skipping type checks, data validation, exception handling

        if((insuranceFull.age < 5) || (insuranceFull.age >18)) {
            response =  jsonUtils.jsonGenRespObjStr(400, "Некорректный возраст");
        }
        else{
            response =  jsonUtils.jsonGenRespObjStr(200, "Возраст подошел, остальное не проверяли");
        }

        return response;
    }




}
