import JsonNetProtocol.InsuranceFull;
import Utils.JsonUtils;
import Utils.Logger;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    public static void main (String[] args){
        //Creatinf Logger object instance;
        Logger logger = new Logger();

        //Creating hardcoded incoming Json object
        JsonUtils jsonUtils = new JsonUtils();

        InsuranceFull insuranceFull = new InsuranceFull();
        String jsonInputObject = jsonUtils.jsonGenIncObjStr(insuranceFull);

        logger.message("Incoming hardcoded Json created");
        logger.message(jsonInputObject);

        //Parsing "imcoming" json object

        Gson IncomingGson = new Gson();
        InsuranceFull insuranceFullReceived = IncomingGson.fromJson(jsonInputObject, InsuranceFull.class);

        logger.LogInsFullStruct(insuranceFullReceived);

        //Initialising fakeService object just for verification that it works
            FakeService fakeService = new FakeService();
            //Addind the received insurance to storage and removing it
            fakeService.InsuranceAdd(insuranceFullReceived);
            fakeService.InsuranceRemove(insuranceFullReceived);

            // Mocking and doing some tests in test/java/TestFakeService

    }
}
