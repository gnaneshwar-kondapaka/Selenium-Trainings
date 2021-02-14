package ConstantsPackage;


public class Constants 
{
	//Browser Configuration
	public static final String browser = "chrome";
	public static final String url = "http://qualitypointtech.net/timesheetdemo/index.php";
	public static final String userDirectory = System.getProperty("user.dir");
	public static final String chromeDriverPath =  "\\src\\main\\resources\\Executables\\chromedriver.exe";
	public static final String firefoxDriverPath = "\\src\\main\\resources\\Executables\\geckodriver.exe";
	public static final String internetExplorerDriverPath = "\\src\\main\\resources\\Executables\\IEDriverServer.exe";
	public static final String extentReportPath = "//Reports//ExtendReport.html";
	
	//Extent Report Configuration
	public static final String resourceType = "Automation Tester";
	public static final String resourceName = "Gnaneshwar K";
	public static final String org = "Organization";
	public static final String orgName = "Acs Solutions";
	
	//Excel Configuration
	public static String pageTitle = "Online Timesheet • Qualitypointtech.com";
	public static String testDataFile = userDirectory+"\\src\\test\\resources\\ExcelFiles\\TestData.xlsx";
	public static String userSheet = "Users";
	public static String loginSheet = "LoginCredits";
	public static String timeSheet = "TimeSheet";
	
	
	//Delays
	public static final int vs_time = 5;
	public static final int s_time = 10;
	public static final int l_time = 15;
	public static final int vl_time = 20;
	public static final int count = 1;
	
	//Excel Column Names
	public static final String userNameKey = "UserName";
	public static final String firstNameKey = "FirstName" ;
	public static final String lastNameKey = "LastName" ;
	public static final String passwordKey = "Password" ;
	public static final String confirmPasswordKey = "ConfirmationPassword" ;
	public static final String dateOfJoiningKey = "DateOfJoining" ;
	public static final String ratePerHrKey = "RatePerHour" ;
	public static final String mobileNoKey = "MobileNumber" ;
	public static final String officeNoKey = "OfficeNumber" ;
	public static final String emailIdKey = "EmailID" ;
	public static final String addressOneKey = "AddressOne" ;
	public static final String addressTwokey = "AddressTwo" ;
	public static final String countryKey = "Country" ;
	public static final String areaOfInterestKey =  "AreaOfInterest" ;
	public static final String startDateKey = "StartDate";
	public static final String endDateKey = "EndDate";
	
	//Arraylist Handles 
	public static final int firstSet = 0;
	public static final int secondSet = 2;
	public static final int thirdSet = 3;
	
 
}
