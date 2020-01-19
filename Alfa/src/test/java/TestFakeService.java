import JsonNetProtocol.InsuranceFull;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;


public class TestFakeService
{
        //FakeService fakeService = mock(FakeService.class);

        ArrayList<InsuranceFull> insuranceFullArrayList= new ArrayList<InsuranceFull>();

        public void CreateArrayOfObjects(){
                for (int age = 1; age < 20; age++){
                     InsuranceFull insuranceFull = new InsuranceFull(age);
                     insuranceFullArrayList.add(insuranceFull);
                }
        }

        @Mock FakeService fakeService;
        @Rule public MockitoRule rule = MockitoJUnit.rule();


        @Before
        public void setUp(){
                this.CreateArrayOfObjects();
                for (InsuranceFull insuranceFull: insuranceFullArrayList) {
                        fakeService.InsuranceAdd(insuranceFull);

                }
        }

        @Test
        public void testPerform(){
               // this.CreateArrayOfObjects();
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
