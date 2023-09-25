package Apollo_001_공통;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Apollo_Data.xPath;
import TestNG_Set.APOLLO_TestCase;
import junit.framework.Assert;

public class LLM_Message_Test extends APOLLO_TestCase {
	
	@Test(description = "Test")
	public void TC_001(Method method) throws Exception {
		
	
		test.log(Status.INFO, "홈 화면 이동 확인");
		Thread.sleep(5000);
		
		test.log(Status.INFO, "에이전트 대화방 호출");
		util.click(By.xpath("//android.view.View[@content-desc='채팅']"));
		Thread.sleep(3000);
		
		test.log(Status.INFO, "키패드 호출");
		util.click(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.widget.Button[3]"));
		Thread.sleep(3000);
		
		test.log(Status.INFO, "명령어 입력 후 결과 값 비교 확인");
		util.LLM_func("안녕", "안녕하세요");
		
		
		Thread.sleep(10000);
		
	}


}
