package TestCases;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.GenericLibrary.BaseClass;
import com.pageObjectLib.HomePage;
//import com.GenericLib.ExcelLib;
@Listeners(com.GenericLibrary.SampleListner.class)
public class Employee_CreationTest extends BaseClass {

	@Test  
	public void EmployeeCreationTestcase() throws Exception 
	{ 
      home.ClickPIM_Module();
      pim.ClickAddEmployee();
      pim.EnterFirstName("john");
      pim.EnterLastName("Doe");
      pim.ClickLogincheck();

	}
}