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
	
	
	@Test(description = "A. Hotfix Regression Test : 000-011-001 widget_basic 위젯 + 기본 UI")
	public void TC_001_011_001_widget_basic(Method method) throws Exception {
		
		test.log(Status.INFO, "000-011-001 widget_basic 위젯 + 기본 UI 확인");
		System.out.println("000-011-001 widget_basic 위젯 + 기본 UI 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-26969");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-26969");
		
		test.log(Status.INFO, "홈 화면 이동 확인");
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		
		test.log(Status.INFO, "Android Home Key 클릭");
		util.Android_HomeKey();
		
		test.log(Status.INFO,"기본 위젯 노출 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("widget_container")));
		
		test.log(Status.INFO,"기본 높이값 / 넓이값 확인");
		String bounds = util.getAttribute(By.xpath("//android.widget.RelativeLayout[contains(@resource-id, 'widget_container')]"), "bounds");
		Assert.assertEquals(bounds, "[50,230][1030,755]");
		
		test.log(Status.INFO,"위젯 구성 요소 확인 : 캐릭터 이미지");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("avatar_icon")));
		
		test.log(Status.INFO,"위젯 구성 요소 확인 : 시간대별 메세지");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("widget_message")));
		
		test.log(Status.INFO,"기본 위젯 터치 홈화면 이동 확인");
		util.click(By.id("widget_container"));
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		
		test.log(Status.INFO, "Android Home Key 클릭");
		util.Android_HomeKey();
		
		test.log(Status.INFO,"기본 위젯 [게임] 서비스 화면 이동 확인");
		util.click(By.xpath("//android.widget.TextView[contains(@text, '게임')]"));
		Assert.assertTrue(util.waitForActivity("com.skt.nugu.visual.game.ui.home.GameHomeActivity"));
		
		
		test.log(Status.INFO, "Android Home Key 클릭");
		util.Android_HomeKey();
		
		test.log(Status.INFO,"기본 위젯 [TV] 서비스 화면 이동 확인");
		util.click(By.xpath("//android.widget.TextView[contains(@text, 'TV')]"));
		Assert.assertTrue(util.waitForActivity("com.skb.mytvlibrary.MyTvActivity"));
		
		test.log(Status.INFO, "Android Home Key 클릭");
		util.Android_BackKey();
		util.Android_HomeKey();
		
		test.log(Status.INFO,"기본 위젯 [포토] 서비스 화면 이동 확인");
		util.click(By.xpath("//android.widget.TextView[contains(@text, '포토')]"));
		Assert.assertTrue(util.waitForActivity("com.skt.nugu.visual.photo.home.PhotoHomeActivity"));
		
		test.log(Status.INFO, "Android Home Key 클릭");
		util.Android_HomeKey();
		
		test.log(Status.INFO,"기본 위젯 [음악추천] 서비스 화면 이동 확인");
		util.click(By.xpath("//android.widget.TextView[contains(@text, '음악추천')]"));
		util.click(By.id("negativeButton"));
		util.click(By.id("fixed_player_thumbnail"));
		Assert.assertTrue(util.waitForActivity("com.skt.nugu.visual.media.MusicTemplateActivity"));
		
		test.log(Status.INFO,"음악 추천해줘 발화 로그 조회");
		String tts = util.TTS_JsonParsing(uID, dID, ServerName, Place, Service);
		System.out.println(tts);
		
		
		

	    
	    

	}

}
