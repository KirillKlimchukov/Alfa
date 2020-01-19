import JsonNetProtocol.InsuranceFull;

import java.util.ArrayList;

public interface iFakeService
{
    boolean InsuranceAdd(InsuranceFull insuranceFull );
    boolean InsuranceRemove(InsuranceFull insuranceFull);
    boolean InsuranceVerify(InsuranceFull insuranceFull);
}
