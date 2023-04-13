package Apollo_001_공통;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Apollo_Data.Data;
import Apollo_Data.xPath;
import TestNG_Set.APOLLO_TestCase;
import junit.framework.Assert;

public class Apollo_02_공통 extends APOLLO_TestCase {
	
	@Test(description = "A. Hotfix Regression Test : 000-011-001 widget_basic 위젯 + 기본 UI")
	public void TC_000_011_001(Method method) throws Exception {
		
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
		util.click(By.xpath("//android.widget.TextView[contains(@resource-id, 'widget_message')]"));
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
		
		test.log(Status.INFO,"음악 추천해줘 발화 로그 조회");
		//Assert.assertTrue(util.TTS_Assertfunc_ContainsSet(uID, dID, ServerName, Place, Service, data.음악시작_set));
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(util.dataCheck_Contains(tts_message, Data.음악시작_set));
		
		
		test.log(Status.INFO, "다른 앱 위에 그리기 권한 팝업 창 있으면 터치");
		if(util.isElementPresent_Assertfunc(By.id("negativeButton"))) {
			util.click(By.id("negativeButton"));
			util.click(By.id("fixed_player_thumbnail"));
		} else {
			util.tap(92, 1060);
			util.tap(440, 1060);
		}
		

		Assert.assertTrue(util.waitForActivity("com.skt.nugu.visual.media.MusicTemplateActivity"));
		
		util.click(By.id("btn_close"));
		

	}
	
	@Test(description = "A. Hotfix Regression Test : 001-003-001 login_1 T아이디 로그인 이력 X / O")
	public void TC_001_003_001(Method method) throws Exception {
			
		test.log(Status.INFO, "001-003-001 login_1 T아이디 로그인 이력 X / O");
		System.out.println("001-003-001 login_1 T아이디 로그인 이력 X / O");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-23011");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-23011");
		
		throw new SkipException("Skipping this exception");
				
	}
	
	@Test(description = "A. Hotfix Regression Test : 001-004-002 login_14 서비스 계정 연결")
	public void TC_001_004_002(Method method) throws Exception {
			
		test.log(Status.INFO, "001-004-002 login_14 서비스 계정 연결");
		System.out.println("001-004-002 login_14 서비스 계정 연결");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-19913");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-199131");
		
		throw new SkipException("Skipping this exception");
				
	}
	
	@Test(description = "A. Hotfix Regression Test : 002-001-004 home common 홈 공통")
	public void TC_002_001_004(Method method) throws Exception {
		
		test.log(Status.INFO, "002-001-004 home_common 홈_공통");
		System.out.println("002-001-004 home_common 홈_공통");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-20644");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-20644");
		
		test.log(Status.INFO, "홈 화면 이동 확인");
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		
		test.log(Status.INFO,"Side Menu 레드닷 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("left_menu_button_container")));
	
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
		
		//test.log(Status.INFO,"더보기 버튼 클릭");
		//util.click(By.id("more_button"));
		
		//test.log(Status.INFO,"OS 공유 피커 노출 확인");
		//Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, 'Nearby Share')]")));
		//util.Android_BackKey();
		
		test.log(Status.INFO,"알림 센터 클릭");
		util.click(By.id("notification_center_button"));
		
		test.log(Status.INFO,"노티 리스트 뷰 영역 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("noti_list")));
		
		test.log(Status.INFO,"알람 센터 닫기 버튼 클릭");
		util.click(By.id("button_close"));
		
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
		util.click(By.xpath("//android.widget.ImageView[contains(@content-desc, '이전')]"));
		
		
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
		
		String 날씨메세지;
		test.log(Status.INFO,"날씨 템플릿 호출");
		util.A_sendPost("날씨 알려줘", uID, dID, ServerName);
		날씨메세지 = util.getText(By.id("message"));
		System.out.println(날씨메세지);
		Assert.assertTrue(날씨메세지.contains("날씨"));

		test.log(Status.INFO,"스몰톡 초기화 버튼");
		util.click(By.id("refresh"));
		날씨메세지 = util.getText(By.id("message"));
		System.out.println(날씨메세지);
		Assert.assertFalse(날씨메세지.contains("날씨"));
		
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 002-003-001 home glm")
	public void TC_002_003_001(Method method) throws Exception {
		
		test.log(Status.INFO, "002-001-004 home_common 홈_공통");
		System.out.println("002-001-004 home_common 홈_공통");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-20661");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-20661");
		
		throw new SkipException("Skipping this exception");
		
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 002-004-001 home_taskoriented 홈_TO")
	public void TC_002_004_001(Method method) throws Exception {
		
		test.log(Status.INFO, "002-004-001 home_taskoriented 홈_TO");
		System.out.println("002-004-001 home_taskoriented 홈_TO");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-20663");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-20663");
		
		throw new SkipException("Skipping this exception");
		
		
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 002-005-001 sidemenu_profile 캐릭터 프로필 영역(os 동일)")
	public void TC_002_005_001(Method method) throws Exception {
		
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
		util.click(By.xpath("//android.widget.ImageView[contains(@content-desc, '이전')]"));
		
		test.log(Status.INFO,"side menu button 버튼 클릭");
		util.click(By.id("left_menu_button"));
		
		test.log(Status.INFO,"사이드드로어 캐릭터 영역 클릭");
		util.click(By.id("character_thumb"));
		
		test.log(Status.INFO,"캐릭터 꾸미기 팝업창 있으면 확인 버튼 터치");
		if(util.isElementPresent_Assertfunc(By.id("positiveButtonText"))) {
			util.click(By.id("positiveButtonText"));
		} 
		
		test.log(Status.INFO,"스토어 화면 노출 확인 주요 엘리먼트 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("filtering_layout")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("decoration_tab_recyclerview")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("character_holder")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("cube_point")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("cone_point")));
		
		test.log(Status.INFO,"이전 버튼 클릭");
		util.click(By.xpath("//android.widget.ImageView[contains(@content-desc, '이전')]"));
		
		test.log(Status.INFO,"side menu button 버튼 클릭");
		util.click(By.id("left_menu_button"));
		
		test.log(Status.INFO,"재화 영역 노출 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("icon_cone")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("cone_point")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("cube_point")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("icon_cube")));
		
		test.log(Status.INFO,"캐릭터 꾸미기 버튼 클릭");
		util.click(By.xpath("//android.widget.TextView[contains(@text, '캐릭터꾸미기')]"));
		
		test.log(Status.INFO,"캐릭터 꾸미기 팝업창 있으면 확인 버튼 터치");
		if(util.isElementPresent_Assertfunc(By.id("positiveButtonText"))) {
			util.click(By.id("positiveButtonText"));
		} 
		
		test.log(Status.INFO,"스토어 화면 노출 확인 주요 엘리먼트 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("filtering_layout")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("decoration_tab_recyclerview")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("character_holder")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("cube_point")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("cone_point")));
		
		test.log(Status.INFO,"이전 버튼 클릭");
		util.click(By.xpath("//android.widget.ImageView[contains(@content-desc, '이전')]"));
		
		test.log(Status.INFO,"side menu button 버튼 클릭");
		util.click(By.id("left_menu_button"));
		
		test.log(Status.INFO,"퀘스트 레드닷 확인 ");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.ImageView[2]")));
		
		test.log(Status.INFO,"루틴 레드닷 확인 ");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.ImageView[2]")));
		
		
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 002-005-015 Sidemenu_1 사이드메뉴 프로필 영역")
	public void TC_002_005_015(Method method) throws Exception {
		
		//002-005-001케이스와 종속됨.
		test.log(Status.INFO, "002-005-015 Sidemenu_1 사이드메뉴 프로필 영역");
		System.out.println("002-005-015 Sidemenu_1 사이드메뉴 프로필 영역");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-25915");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-25915");
		
		test.log(Status.INFO, "페이지 하단으로 스크롤");
		util.scrollDown();
	
		test.log(Status.INFO, "튜토리얼 버튼 위치 및 버튼명 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '튜토리얼')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.appcompat.widget.LinearLayoutCompat[2]/android.view.ViewGroup/android.widget.TextView")));
		
		test.log(Status.INFO, "페이지 상단으로 스크롤");
		util.scrollUp();
		
		test.log(Status.INFO, "캐릭터 네임 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '아폴로')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("character_name")));
		
		test.log(Status.INFO,"재화 영역 노출 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("icon_cone")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("cone_point")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("cube_point")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("icon_cube")));
		
		test.log(Status.INFO,"재화 영역 클릭");
		util.click(By.id("cone_point"));
		
		test.log(Status.INFO,"재화 영역 클릭시 팝업 비노출, 캐릭터 프로필 설정으로 연결 확인");
		if(util.isElementPresent_Assertfunc(By.id("positiveButtonText"))) {
			util.click(By.id("positiveButtonText"));
		} 
		
		test.log(Status.INFO,"스토어 화면 노출 확인 주요 엘리먼트 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("filtering_layout")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("decoration_tab_recyclerview")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("character_holder")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("cube_point")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("cone_point")));
		
		test.log(Status.INFO,"이전 버튼 클릭");
		util.click(By.xpath("//android.widget.ImageView[contains(@content-desc, '이전')]"));
		
		test.log(Status.INFO,"side menu button 버튼 클릭");
		util.click(By.id("left_menu_button"));
		
		test.log(Status.INFO,"캐릭터 프로필 설정 버튼 클릭");
		util.click(By.id("character_profile_setting"));
		
		test.log(Status.INFO,"캐릭터 프로필 설정 화면 타이틀 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '캐릭터 프로필 설정')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '캐릭터 이름')]")));
		
		test.log(Status.INFO,"back 버튼 클릭수 다시 side menu button 버튼 클릭");
		util.click(By.id("back_button"));
		util.click(By.id("left_menu_button"));
		
		test.log(Status.INFO,"리워드 내역 버튼명 확인");
		String 리워드내역 = util.getText(By.xpath("//android.widget.LinearLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.TextView"));
		Assert.assertEquals(리워드내역, "리워드 내역");
		
		test.log(Status.INFO,"리워드 레드닷 비노출 확인");
		Assert.assertFalse(util.isElementPresent_Assertfunc(By.xpath("//android.widget.LinearLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.ImageView[2]")));
		
		test.log(Status.INFO,"퀘스트 메뉴 노출 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '퀘스트')]")));
		
		test.log(Status.INFO,"리워드 내역 메뉴 노출 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '리워드 내역')]")));
		
		test.log(Status.INFO,"캐릭터꾸미기 내역 메뉴 노출 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '캐릭터꾸미기')]")));
		
		test.log(Status.INFO, "루틴 내역 메뉴 노출 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '루틴')]")));
		
		test.log(Status.INFO, "캘린더 내역 메뉴 노출 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '캘린더')]")));
		
		test.log(Status.INFO, "알람 내역 메뉴 노출 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '알람')]")));
		
		test.log(Status.INFO, "TMAP 내역 메뉴 노출 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, 'TMAP')]")));
		
		test.log(Status.INFO, "TV 내역 메뉴 노출 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, 'TV')]")));
		
		test.log(Status.INFO, "프로야구 내역 메뉴 노출 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '프로야구')]")));	
		
		test.log(Status.INFO, "게임 내역 메뉴 노출 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '게임')]")));
		
		test.log(Status.INFO, "포토 내역 메뉴 노출 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '포토')]")));
		
		test.log(Status.INFO, "음악추천 내역 메뉴 노출 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '음악추천')]")));
		util.scrollDown();
		
		test.log(Status.INFO, "큐피드 내역 메뉴 노출 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '큐피드')]")));
		
		test.log(Status.INFO, "튜터 내역 메뉴 노출 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '튜터')]")));
		util.click(By.id("close_button"));
	}
	
	@Test(description = "A. Hotfix Regression Test : 002-006-001 home Web Viewer 웹 뷰어")
	public void TC_002_006_001(Method method) throws Exception {
		
		test.log(Status.INFO, "002-006-001 home Web Viewer 웹 뷰어");
		System.out.println("002-006-001 home Web Viewer 웹 뷰어");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-25915");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-25915");
		
		test.log(Status.INFO, "큐피드 웹뷰 호출");
		util.A_sendPost("큐피드", uID, dID, ServerName);
		
		test.log(Status.INFO, "큐피드 웹뷰 타이틀 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("toolbar_title")));
		
		test.log(Status.INFO, "큐피드 웹뷰 닫기 터치");
		util.click(By.id("toolbar_button_close"));
		
		test.log(Status.INFO, "홈 화면 이동 확인");
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		
		test.log(Status.INFO, "라이트라인 게임 웹뷰 호출");
		util.A_sendPost("라이트라인 게임", uID, dID, ServerName);
		Thread.sleep(3000);
		
		test.log(Status.INFO, "사운드 설정 토글 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("app_toolbar")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("button_sound")));
		
		test.log(Status.INFO, "큐피드 웹뷰 닫기 터치");
		util.click(By.id("button_close"));
		
		test.log(Status.INFO, "설정 명령어 전송");
		util.A_sendPost("설정", uID, dID, ServerName);
		util.click(By.xpath("//android.widget.TextView[contains(@text, '설정 보기')]"));
		
		util.click(By.xpath("//android.widget.TextView[contains(@text, '개인 정보')]"));
		util.click(By.xpath("//android.widget.TextView[contains(@text, '계정 관리')]"));
		
		test.log(Status.INFO, "웹뷰하단 네비바 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.Button[contains(@text, '이전')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.Button[contains(@text, '다음')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.Button[contains(@text, '새로고침')]")));
		
		test.log(Status.INFO, "이전/새로고침 확인");
		util.click(By.xpath("//android.widget.TextView[contains(@text, '닉네임')]"));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '비밀번호 확인')]")));
		util.type(By.xpath("//android.widget.EditText"), "123123");
		
		String getPW1 = util.getText(By.xpath("//android.widget.EditText"));
		util.click(By.xpath("//android.widget.Button[contains(@text, '새로고침')]"));
		
		String getPW2 = util.getText(By.xpath("//android.widget.EditText"));
		Assert.assertFalse(getPW2.contains(getPW1));
		
		util.click(By.xpath("//android.widget.Button[contains(@text, '이전')]"));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, 'T아이디 정보관리')]")));
		util.Android_BackKey();
		util.Android_BackKey();
		util.Android_BackKey();
		util.Android_BackKey();
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 003-002-004 setting_privacy_4 설정 + 개인 정보 + 로그아웃")
	public void TC_003_002_004(Method method) throws Exception {
		
		test.log(Status.INFO, "003-002-004 setting_privacy_4 설정 + 개인 정보 + 로그아웃");
		System.out.println("003-002-004 setting_privacy_4 설정 + 개인 정보 + 로그아웃");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-23008");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-23008");
		
		test.log(Status.INFO, "홈 화면 이동 확인");
		Thread.sleep(5000);
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		
		test.log(Status.INFO, "설정 명령어 전송 후 로그아웃 버튼 클릭");
		util.A_sendPost("설정", uID, dID, ServerName);
		Thread.sleep(1000);
		util.click(By.xpath("//android.widget.TextView[contains(@text, '설정 보기')]"));
		
		util.click(By.xpath("//android.widget.TextView[contains(@text, '개인 정보')]"));
		util.click(By.xpath("//android.widget.TextView[contains(@text, '로그아웃')]"));
		
		test.log(Status.INFO, "팝업 메세지 및 버튼 확인");
		String 로그아웃메세지 = util.getText(By.id("titleTextView"));
		Assert.assertEquals(로그아웃메세지, "로그아웃 하시겠습니까?\n"
				+ "로그아웃 후에 앱이 종료됩니다."); 
		
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("negativeButton")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("positiveButtonText")));
		
		test.log(Status.INFO, "취소 버튼 터치 후 팝업 사라짐 확인");
		util.click(By.id("negativeButton"));
		Assert.assertFalse(util.isElementPresent_Assertfunc(By.id("dialogLayout")));
		
		test.log(Status.INFO, "로그아웃 버튼 클릭 후 로그아웃 처리 확인");
		util.click(By.xpath("//android.widget.TextView[contains(@text, '로그아웃')]"));
		util.click(By.id("positiveButtonText"));
		
		String 로그아웃완료 = util.getText(By.id("titleTextView"));
		Assert.assertEquals(로그아웃완료, "계정 연결 해제"); 
		

		test.log(Status.INFO, "앱 종료 후 다시 시작");
		util.click(By.id("positiveButtonText"));
		util.resetApp();
		util.click(By.id("intro_login_button"));
		
		Thread.sleep(2000);
		//util.switchContext("WEBVIEW");
		//util.click(By.xpath("//ul[@class='account-list']/li[1]"));
		//util.switchContext("NATIVE_APP");
		util.click(By.xpath("//android.webkit.WebView/android.view.View[2]/android.view.View/android.widget.ListView/android.view.View"));
		
		
		util.click(By.id("btn_confirm"));
		util.click(By.id("coach_mark_layer_close_btn"));
		
		test.log(Status.INFO, "홈 화면 이동 확인");
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));

		
		
		
	}

}
