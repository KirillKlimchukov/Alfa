import JsonNetProtocol.InsuranceFull;
import com.google.gson.Gson;
import java.lang.Object;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {
    public static void main (String[] args){
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

        logger.message("Incoming hardcoded Json Parced");
        logger.LogInsFullStruct(insuranceFullReceived);

        //Initialising fakeService object for mocking
            FakeService fakeService = new FakeService();
            String response = fakeService.parceIncomingJsonObj(insuranceFullReceived);

        logger.message("Response received");
        logger.message(response);

        //Mocking a fake service
        FakeService mFakeService = Mockito.mock(FakeService.class);

        //defining a  basic behaviour concept
        Mockito.when(mFakeService.parceIncomingJsonObj(insuranceFullReceived)).thenReturn(response);
        //Verifying a response operation
        Mockito.verify(mFakeService).parceIncomingJsonObj(insuranceFullReceived);
        assertEquals(mFakeService.parceIncomingJsonObj(insuranceFullReceived), response);

        Mockito.doReturn(response).when(mFakeService).parceIncomingJsonObj(insuranceFullReceived);

        // to be continued




    }
}
