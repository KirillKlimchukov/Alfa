import JsonNetProtocol.InsuranceFull;
import Utils.JsonUtils;

import java.util.ArrayList;


public class FakeService implements iFakeService {
    public String response= "";
    public ArrayList<InsuranceFull> insuranceStorage = new ArrayList<InsuranceFull>() {};




//=====================================================================================================================
    @Override
    public boolean InsuranceAdd (InsuranceFull insuranceFull) {
        JsonUtils jsonUtils = new JsonUtils();
        if((insuranceFull.age < 5) || (insuranceFull.age >18)) {
            System.out.println("FakeService: Incorrect age");
            this.response =  jsonUtils.jsonGenRespObjStr(400, "IncorrectAge");
            System.out.println(response);
            return false;
        }
        else {
            this.insuranceStorage.add(insuranceFull);
            System.out.println("FakeService: Insurance added");
            this.response = jsonUtils.jsonGenRespObjStr(200, "Added");
            System.out.println(response);
            return true;
        }
    }
//======================================================================================================================
    @Override
    public boolean InsuranceRemove (InsuranceFull insuranceFull) {
        JsonUtils jsonUtils = new JsonUtils();

        if (this.insuranceStorage.contains(insuranceFull)){
            System.out.println("RemoveFromStorage: removing insurance from storage");
            this.insuranceStorage.remove(insuranceFull);
            this.response = jsonUtils.jsonGenRespObjStr(200, "Removed");
            System.out.println(response);
            return true;}
        else{
            System.out.println("FakeService: InsuranceRemove: there is no instance with such id in storage");
            this.response = jsonUtils.jsonGenRespObjStr(400, "There is no such insurance");
            System.out.println(response);
            return false;
        }
    }
//======================================================================================================================
    @Override
    public boolean InsuranceVerify (InsuranceFull insuranceFull) {
        JsonUtils jsonUtils = new JsonUtils();
        if (insuranceStorage.contains(insuranceFull)) {
            System.out.println("FAkeService: verifying if insurance is stored");
            this.response = jsonUtils.jsonGenRespObjStr(200, "There is one");
            System.out.println(response);
            return true;
        }
        else {
            System.out.println("FAkeService: no such insuracnce found");
            this.response =  jsonUtils.jsonGenRespObjStr(400, "There is no such");
            System.out.println(response);
            return false;
        }
    }



}