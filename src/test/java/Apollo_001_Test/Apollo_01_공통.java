package Apollo_001_Test;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Apollo_000_xPath.xPath;
import TestNG_Set.APOLLO_TestCase;
import junit.framework.Assert;
import unit.Utilities.Direction;

public class Apollo_01_공통 extends APOLLO_TestCase {
	
	
	//@Test(description = "A. Hotfix Regression Test : 000-011-001 widget_basic 위젯 + 기본 UI")
	public void TC_000_011_001_widget_basic(Method method) throws Exception {
		
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
		Thread.sleep(2000);
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
		
		util.click(By.xpath("//android.widget.ImageView[@content-desc='닫기']"));
		
		test.log(Status.INFO,"음악 추천해줘 발화 로그 조회");
		Assert.assertTrue(util.TTS_Assertfunc_ContainsSet(uID, dID, ServerName, Place, Service, data.음악시작_set));


	}
	
	//@Test(description = "A. Hotfix Regression Test : 002-001-004 home common 홈 공통")
	public void TC_002_001_004_home_common_홈_공통(Method method) throws Exception {
		
		test.log(Status.INFO, "002-001-004 home_common 홈_공통");
		System.out.println("002-001-004 home_common 홈_공통");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-20644");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-20644");
		
		test.log(Status.INFO,"Side Menu 레드닷 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("left_menu_red_dot")));
	
		test.log(Status.INFO,"side menu button 버튼 클릭");
		util.click(By.id("left_menu_button"));
		
		test.log(Status.INFO,"side menu [퀘스트] 버튼 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '퀘스트')]")));
		
		test.log(Status.INFO,"side menu [리워드 내역] 버튼 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '리워드 내역')]")));
		
		test.log(Status.INFO,"side menu [캐릭터꾸미기] 버튼 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '캐릭터꾸미기')]")));
		
		test.log(Status.INFO,"side menu 닫기 버튼 클릭");
		util.click(By.id("close_button"));
		
		test.log(Status.INFO,"홈 화면 이동 후 홈 캐릭터 아바타 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("avatar_view_fragment")));
		
		test.log(Status.INFO,"side menu swipe");
		//util.swipeScreen(unit.Utilities.Direction.LEFT);
		util.swipe(10, 1000, 950, 1000);
		
		test.log(Status.INFO,"side menu [퀘스트] 버튼 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '퀘스트')]")));
		
		test.log(Status.INFO,"side menu [리워드 내역] 버튼 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '리워드 내역')]")));
		
		test.log(Status.INFO,"side menu [캐릭터꾸미기] 버튼 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '캐릭터꾸미기')]")));
		
		test.log(Status.INFO,"side menu 닫기 버튼 클릭");
		util.click(By.id("close_button"));
		
		test.log(Status.INFO,"더보기 버튼 클릭");
		util.click(By.id("more_button"));
		
		test.log(Status.INFO,"OS 공유 피커 노출 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, 'Nearby Share')]")));
		util.Android_BackKey();
		
		test.log(Status.INFO,"알림 센터 클릭");
		util.click(By.id("notification_center_button"));
		
		test.log(Status.INFO,"노티 리스트 뷰 영역 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("noti_list")));
		
		test.log(Status.INFO,"알 센터 닫기 버튼 클릭");
		util.click(By.id("action_close"));
		
		test.log(Status.INFO,"홈 화면 이동 후 홈 캐릭터 아바타 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("avatar_view_fragment")));
		
		test.log(Status.INFO,"캐릭터 롱 프레스");
		util.longPress(By.id("avatar_view_fragment"));
		
		test.log(Status.INFO,"꾸미기 버튼 노출 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("btn_show_editor")));
		
		test.log(Status.INFO,"빈 영역 터치시 버튼 비노출 확인");
		util.touchTab(300, 1550);
		Assert.assertFalse(util.isElementPresent_Assertfunc(By.id("btn_show_editor")));
		
		test.log(Status.INFO,"캐릭터 롱 프레스");
		util.longPress(By.id("avatar_view_fragment"));
		util.click(By.id("btn_show_editor"));
		
		
		test.log(Status.INFO,"캐릭터 꾸미기 페이지 이동 확인");
		if(util.isElementPresent_Assertfunc(By.id("positiveButtonText"))) {
			util.click(By.id("positiveButtonText"));
		} 
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("avatar_shop_purchase")));
		
		test.log(Status.INFO,"이전 버튼으로 홈화면 이동 ");
		util.click(By.xpath("//android.widget.ImageButton[contains(@content-desc, '이전')]"));
		
		test.log(Status.INFO,"홈 화면 이동 후 홈 캐릭터 아바타 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("avatar_view_fragment")));
		
		test.log(Status.INFO,"키보드 버튼 클릭");
		util.click(By.id("keyboard_input_button"));
		
		test.log(Status.INFO,"키패드 영역 노출 확인");
		util.click(By.id("home_text_input"));
		util.Android_BackKey();
		
		test.log(Status.INFO,"마이크 버튼 클릭");
		util.click(By.id("voice_input_button"));
		
		test.log(Status.INFO,"보이스 크롬 노출 확인");
		util.click(By.id("voice_chrome_bar"));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '듣고 있어')]")));
		util.Android_BackKey();
		
		test.log(Status.INFO,"날씨 템플릿 호출");
		util.A_sendPost("날씨 알려줘", uID, dID, ServerName);
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '날씨')]")));
		
		test.log(Status.INFO,"스몰톡 초기화 버튼");
		util.click(By.id("refresh"));
		Assert.assertFalse(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '날씨')]")));
		
		
	}
	
	//@Test(description = "A. Hotfix Regression Test : 002-003-001 home glm")
	public void TC_002_003_001_home_glm_홈(Method method) throws Exception {
		
		test.log(Status.INFO, "002-001-004 home_common 홈_공통");
		System.out.println("002-001-004 home_common 홈_공통");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-20661");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-20661");
		
		
	}
	
	//@Test(description = "A. Hotfix Regression Test : 002-004-001 home_taskoriented 홈_TO")
	public void TC_002_004_001_home_taskoriented_홈_TO(Method method) throws Exception {
		
		test.log(Status.INFO, "002-004-001 home_taskoriented 홈_TO");
		System.out.println("002-004-001 home_taskoriented 홈_TO");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-20663");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-20663");
		
		
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 002-005-001 sidemenu_profile 캐릭터 프로필 영역(os 동일)")
	public void TC_002_005_001_sidemenu_profile_캐릭터프로필영역(Method method) throws Exception {
		
		test.log(Status.INFO, "002-005-001 sidemenu_profile 캐릭터 프로필 영역(os 동일)");
		System.out.println("002-005-001 sidemenu_profile 캐릭터 프로필 영역(os 동일)");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-20710");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-20710");
		
		test.log(Status.INFO,"side menu button 버튼 클릭");
		util.click(By.id("left_menu_button"));
		
		test.log(Status.INFO,"설정 버튼 클릭");
		util.click(By.id("setting_button"));
		
		test.log(Status.INFO,"설정 메뉴이동 확인");
		Assert.assertTrue(util.waitForActivity("com.skt.nugu.visual.setting.SettingActivity"));
		
		test.log(Status.INFO,"이전 버튼 클릭");
		util.click(By.xpath("//android.widget.ImageButton[contains(@content-desc, '위로 이동')]"));
		
		test.log(Status.INFO,"사이드드로어 캐릭터 영역 클릭");
		util.click(By.id("character_thumb"));
		
		test.log(Status.INFO,"스토어 화면 노출 확인 주요 엘리먼트 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("filtering_layout")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("decoration_tab_recyclerview")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("character_holder")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("cube_point")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("cone_point")));
		
		test.log(Status.INFO,"이전 버튼 클릭");
		util.click(By.xpath("//android.widget.ImageButton[contains(@content-desc, '이전')]"));
		
		test.log(Status.INFO,"side menu button 버튼 클릭");
		util.click(By.id("left_menu_button"));
		
		test.log(Status.INFO,"재화 영역 노출 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("icon_cone")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("cone_point")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("cube_point")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("icon_cube")));
		
		test.log(Status.INFO,"캐릭터 꾸미기 버튼 클릭");
		util.click(By.xpath("//android.widget.TextView[contains(@text, '캐릭터꾸미기')]"));
		
		test.log(Status.INFO,"스토어 화면 노출 확인 주요 엘리먼트 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("filtering_layout")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("decoration_tab_recyclerview")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("character_holder")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("cube_point")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("cone_point")));
		
		test.log(Status.INFO,"이전 버튼 클릭");
		util.click(By.xpath("//android.widget.ImageButton[contains(@content-desc, '이전')]"));
		
		test.log(Status.INFO,"side menu button 버튼 클릭");
		util.click(By.id("left_menu_button"));
		
		test.log(Status.INFO,"퀘스트 레드닷 확인 ");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView[2]")));
		
		test.log(Status.INFO,"루틴 레드닷 확인 ");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.ImageView[2]")));
		
		
		
	}
	

}
