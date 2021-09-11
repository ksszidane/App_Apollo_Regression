package SDK_001_AudioPlayer_Interface;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import SDK_000_xPath.xPath;
import TestNG_Set.SDK_TestCase;
import junit.framework.Assert;

public class AudioPlayer_Interface extends SDK_TestCase {
	
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
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-01")
	public void TC_01_01_01_AudioState_IDLE에서_PLAYING_전환확인(Method method) throws Exception {

		test.log(Status.INFO, "01_01_01_Audio State IDLE에서 PLAYING 전환 확인");
		System.out.println("01_01_01_Audio State IDLE에서 PLAYING 전환 확인");
		
		test.log(Status.INFO, "AppActivity으로 화면 확인");
	    util.switchContext("NATIVE_APP");
	    
	    test.log(Status.INFO, "앱 실행 후 authToken 얻기 함수 실행");
	    authToken얻기();
	    
	    test.log(Status.INFO, "[노래 들러줘] 발화"); 
	    util.sendPost("노래 들러줘", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "directive_info 값 확인"); 
	    String actn = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    System.out.println(actn);
	    
	    
	    
	    
	}
	
	
    
}
