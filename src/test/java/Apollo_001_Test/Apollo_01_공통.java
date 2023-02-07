package Apollo_001_Test;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Apollo_000_xPath.xPath;
import TestNG_Set.APOLLO_TestCase;
import junit.framework.Assert;

public class Apollo_01_공통 extends APOLLO_TestCase {
	
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-01")
	public void TC_01_01_01_AudioState_IDLE에서_PLAYING_전환확인(Method method) throws Exception {
		
		test.log(Status.INFO, "01_01_01_Audio State IDLE에서 PLAYING 전환 확인");
		System.out.println("01_01_01_Audio State IDLE에서 PLAYING 전환 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10388");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10388");

	    test.log(Status.INFO, "[노래 들러줘] 발화"); 
	    util.A_sendPost("몇시야", uID, dID, ServerName);
	    

	}

}
