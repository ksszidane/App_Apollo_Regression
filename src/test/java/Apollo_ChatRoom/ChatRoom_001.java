package Apollo_ChatRoom;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Apollo_Data.xPath;
import TestNG_Set.APOLLO_TestCase;
import junit.framework.Assert;

public class ChatRoom_001 extends APOLLO_TestCase {
	
	@Test(description = "A. Hotfix Regression Test : 000-001-003 Android + 다른 앱 위에 그리기")
	public void TC_000_001_031(Method method) throws Exception {
		
		test.log(Status.INFO, "000-001-003 Android + 다른 앱 위에 그리기");
		System.out.println("000-001-003 Android + 다른 앱 위에 그리기");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-24187");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-24187");
		
		test.log(Status.INFO, "홈 화면 이동 확인");
		util.waitForIsElementPresent(By.xpath(xPath.탭바_에이전트대화방));
		
		
		test.log(Status.INFO, "탭바 에이전트 대화방 열기");
		util.click(By.xpath(xPath.탭바_에이전트대화방));
		Thread.sleep(10000);
		
		
		
		
	}

}
