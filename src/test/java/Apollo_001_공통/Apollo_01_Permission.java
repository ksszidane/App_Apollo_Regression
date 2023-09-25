package Apollo_001_공통;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Apollo_Data.xPath;
import TestNG_Set.APOLLO_TestCase;
import junit.framework.Assert;

public class Apollo_01_Permission extends APOLLO_TestCase {
	
	@Test(description = "A. Hotfix Regression Test : 000-001-003 Android + 다른 앱 위에 그리기")
	public void TC_000_001_031(Method method) throws Exception {
		
		test.log(Status.INFO, "000-001-003 Android + 다른 앱 위에 그리기");
		System.out.println("000-001-003 Android + 다른 앱 위에 그리기");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-24187");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-24187");
		
		test.log(Status.INFO, "홈 화면 이동 확인");
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		util.closeApp();
		
		util.Android_APP_SWITCH();
		util.click(By.xpath("//android.widget.Button[contains(@resource-id, 'clear_all_button')]"));
		
		test.log(Status.INFO, " '다른 앱 위에 표시 ' 권한 적용 후 앱 재실행");
		if(ServerName.contains("STG")) {
			adb.permission_draw_over_other_apps_Off(udid, "com.skt.nugu.apollo.stg");
		} else {
			adb.permission_draw_over_other_apps_Off(udid, "com.skt.nugu.apollo");
		}
		
		util.click(By.xpath("//android.widget.TextView[contains(@resource-id, 'widget_message')]"));
		Thread.sleep(7000);
		
		test.log(Status.INFO, "미디어 실행 명령어 전송");
		util.A_sendPost("라디오 들려줘", uID, dID, ServerName);
		
		test.log(Status.INFO, "'다른 앱 위에 표시' 팝업 확인");
		String 권한설정팝업타이틀1 = util.getText(By.id("titleTextView"));
		Assert.assertEquals(권한설정팝업타이틀1, "권한 설정");
		
		String 권한설정팝업내용1 = util.getText(By.id("contentTextView"));
		Assert.assertEquals(권한설정팝업내용1, "'다른 앱 위에 표시' 권한을 허용하시면\n"
				+ "음악을 쉽고 빠르게 컨트롤 할 수 있어요.");
		
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("negativeButton")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("positiveButtonText")));
		
		String 다음에하기1 = util.getText(By.id("negativeButton"));
		Assert.assertEquals(다음에하기1, "다음에 하기");
		String 설정하기1 = util.getText(By.id("positiveButtonText"));
		Assert.assertEquals(설정하기1, "설정하기");
		util.Android_BackKey();
		
		test.log(Status.INFO, "알람 편집 화면 이동");
		util.click(By.id("left_menu_button"));
		util.click(By.xpath("//android.widget.TextView[contains(@text, '알람')]"));
		
		test.log(Status.INFO, "'다른 앱 위에 표시' 팝업 확인");
		String 권한설정팝업타이틀2 = util.getText(By.id("titleTextView"));
		Assert.assertEquals(권한설정팝업타이틀2, "권한 설정");
		
		String 권한설정팝업내용2 = util.getText(By.id("contentTextView"));
		Assert.assertEquals(권한설정팝업내용2, "'다른 앱 위에 표시' 권한을 허용하시면\n"
				+ "알람을 쉽고 빠르게 확인할 수 있어요.");
		
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("negativeButton")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("positiveButtonText")));
		
		String 다음에하기2 = util.getText(By.id("negativeButton"));
		Assert.assertEquals(다음에하기2, "다음에 하기");
		String 설정하기2 = util.getText(By.id("positiveButtonText"));
		Assert.assertEquals(설정하기2, "설정하기");
		
		test.log(Status.INFO, "[다음에 하기] 버튼 터치 후 팝업 닫기");
		util.click(By.id("negativeButton"));
		
		test.log(Status.INFO, "팝업 비노출 확인");
		Assert.assertFalse(util.isElementPresent_Assertfunc(By.id("dialogLayout")));
		util.Android_BackKey();
		
		test.log(Status.INFO, "알람 편집 화면 이동");
		util.click(By.id("left_menu_button"));
		util.click(By.xpath("//android.widget.TextView[contains(@text, '알람')]"));
		
		test.log(Status.INFO, "[설정하기] 버튼 터치");
		util.click(By.id("positiveButtonText"));
		
		test.log(Status.INFO, " '다른 앱 위에 표시 ' 단말 설정 페이지 이동 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '다른 앱 위에 표시')]")));
		util.Android_BackKey();
		util.closeApp();
		
		test.log(Status.INFO, " '다른 앱 위에 표시 ' 권한 적용 후 앱 종료");
		if(ServerName.contains("STG")) {
			adb.permission_draw_over_other_apps_On(udid, "com.skt.nugu.apollo.stg");
		} else {
			adb.permission_draw_over_other_apps_On(udid, "com.skt.nugu.apollo");
		}
		
		test.log(Status.INFO, "위젯으로 앱 실행");
		util.click(By.id("widget_message"));
		
		test.log(Status.INFO, "홈 화면 이동 확인");
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		Thread.sleep(5000);
		
		test.log(Status.INFO, "미디어 실행 명령어 전송");
		util.A_sendPost("라디오 들려줘", uID, dID, ServerName);
		
		test.log(Status.INFO, "권한 팝업 비노출 확인");
		Assert.assertFalse(util.isElementPresent_Assertfunc(By.id("dialogLayout")));
		
		test.log(Status.INFO, "앱 BG 상태 전환 후 타 앱 실행");
		util.Android_HomeKey();
		util.click(By.xpath("//android.widget.TextView[contains(@text, '네이트')]"));
		Thread.sleep(3000);
		
		test.log(Status.INFO, "플로팅 미디어 플레이어 실행 후 확인");
		util.tap(92, 1060);
		util.tap(440, 1060);
		Assert.assertTrue(util.waitForActivity("com.skt.nugu.visual.media.MusicTemplateActivity"));
		util.click(By.id("btn_close"));
		
	}


}
