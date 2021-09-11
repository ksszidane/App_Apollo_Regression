package SDK_001_실행;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import SDK_000_xPath.xPath;
import TestNG_Set.SDK_TestCase;
import junit.framework.Assert;

public class 앱시작_01 extends SDK_TestCase {
	
	String authToken;
	
	public void authToken얻기() throws Exception {
		
		test.log(Status.INFO, "Main 화면 CommandText에 [노래 들려줘] 입력하기 ");
		util.type(By.xpath(xPath.텍스트커맨드입력), "벅스에서 노래 들려줘");
		
		test.log(Status.INFO, "입력한 CommandText 실행");
		util.click(By.xpath(xPath.메인화면_커맨드입력_Enter));
		
		test.log(Status.INFO, "acceesToken 얻기"); 
	    String actn = util.authToken_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    
	    test.log(Status.INFO, "authToken : " + actn); 
	    System.out.println(actn);
	    authToken = actn;
	    
	    test.log(Status.INFO, "음악중단 [그만] 발화"); 
	    util.sendPost("그만", uID, SampleApp_did, ServerName, Place, authToken);
		
	}
	
	@Test(description = "SDK 리그레이션 TC : 실행_0000")
	public void TC_0000_앱실행(Method method) throws Exception {

		test.log(Status.INFO, "AppActivity으로 화면 확인");
	    util.switchContext("NATIVE_APP");
	    
	    test.log(Status.INFO, "앱 실행 후 authToken 얻기 함수 실행");
	    authToken얻기();
	    
	    test.log(Status.INFO, "테스트용 몇시야 발화"); 
	    util.sendPost("몇시야", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    
	    
	    
	}
	
	
    
}
