import JsonNetProtocol.InsuranceFull;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;


public class TestFakeService
{
        //Creatinfg a fake storage for testing purposes
        ArrayList<InsuranceFull> insuranceFullArrayList= new ArrayList<InsuranceFull>();

        // A method that fills the collection with some test data
        public void CreateArrayOfObjects(){
                for (int age = 1; age < 20; age++){
                     InsuranceFull insuranceFull = new InsuranceFull(age);
                     insuranceFullArrayList.add(insuranceFull);
                }
        }

        //Mocking the fake service
        @Mock FakeService fakeService;
        @Rule public MockitoRule rule = MockitoJUnit.rule(); //FakeService fakeService = mock(FakeService.class);

        //Setting up test Data
        @Before
        public void TestSetUp(){
                this.CreateArrayOfObjects();
                for (InsuranceFull insuranceFull: insuranceFullArrayList) {
                        fakeService.InsuranceAdd(insuranceFull);

                }
        }
        //Performing some trivial tests
        //The test can be run from the code using jUnit debug configuration set in the project
        @Test
        public void TestPerform(){
                when(fakeService.InsuranceVerify(insuranceFullArrayList.get(1))).thenReturn(false);
                assertFalse(fakeService.InsuranceVerify(insuranceFullArrayList.get(1)));
                verify(fakeService).InsuranceVerify(insuranceFullArrayList.get(1));

                when(fakeService.InsuranceAdd(insuranceFullArrayList.get(1))).thenReturn(false);
                assertFalse(fakeService.InsuranceVerify(insuranceFullArrayList.get(1)));
                verify(fakeService).InsuranceAdd(insuranceFullArrayList.get(1));

                when(fakeService.InsuranceRemove(insuranceFullArrayList.get(6))).thenReturn(true);
                assertTrue(fakeService.InsuranceRemove(insuranceFullArrayList.get(6)));
                verify(fakeService).InsuranceRemove(insuranceFullArrayList.get(6));


        }

}
