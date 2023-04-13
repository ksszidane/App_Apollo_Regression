package Apollo_001_공통;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Apollo_Data.Data;
import Apollo_Data.xPath;
import TestNG_Set.APOLLO_TestCase;
import junit.framework.Assert;

public class Apollo_04_공통 extends APOLLO_TestCase {
	
	//@Test(description = "A. Hotfix Regression Test : 016-001-014 alarm_sound_cp 알람 소리_flo에서 선택")
	public void TC_016_001_007(Method method) throws Exception {
		
		test.log(Status.INFO, "016-001-014 alarm_sound_cp 알람 소리_flo에서 선택");
		System.out.println("0016-001-014 alarm_sound_cp 알람 소리_flo에서 선택");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-20288");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-20288");
		
		test.log(Status.INFO, "홈 화면 이동 확인");
		Thread.sleep(5000);
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		
		test.log(Status.INFO,"side menu button 버튼 클릭");
		util.click(By.id("left_menu_button"));
		
		test.log(Status.INFO,"알람 버튼 클릭");
		util.click(By.xpath("//android.widget.TextView[contains(@text, '알람')]"));
		
		test.log(Status.INFO,"알람 등록 버튼 클릭");
		util.click(By.id("register_button"));

		test.log(Status.INFO,"소리 영역 터치");
		String alarm_audio_text_default = util.getText(By.id("alarm_audio_text"));
		util.click(By.id("alarm_audio_button_container"));
		
		test.log(Status.INFO,"FLO에서 선택 체크박스 미선택 확인");
		String unchecked = util.getAttribute(By.id("select_from_flo"), "checked");
		Assert.assertEquals(unchecked, "false");
		
		test.log(Status.INFO,"FLO에서 선택 이동 후 음악 선택");
		util.click(By.id("select_from_flo_container"));
		String songName = util.getText(By.id("song_name"));
		util.click(By.id("song_name"));
		
		test.log(Status.INFO,"'뒤로가기' 동작 후 FLO 선택 저장값 확인");
		util.click(By.id("appbar_back"));
		String song_info = util.getText(By.id("song_info"));
		Assert.assertTrue(song_info.contains(songName));
		String checked = util.getAttribute(By.id("select_from_flo"), "checked");
		Assert.assertEquals(checked, "true");
		
		test.log(Status.INFO,"FLO에서 선택 이동 후 [i] 버튼 터치");
		util.click(By.id("select_from_flo_container"));
		util.click(By.id("appbar_info"));
		
		test.log(Status.INFO,"안내 팝업 창 확인");
		String contentTextView = util.getText(By.id("contentTextView"));
		System.out.println(contentTextView);
		Assert.assertEquals(contentTextView, "* FLO 음악으로 알람음을 설정했더라도 네트워크에 연결되어 있지 않으면 기본 벨소리가 재생됩니다.\n"
				+ "* FLO 계정이 연결되지 않았거나 이용권이 없는 경우, 1분 미리 듣기로 알람음이 반복 재생됩니다\n"
				+ "* A.에서 로그아웃된 경우 알람음이 울리지 않습니다.");
		util.click(By.id("positiveButtonText"));
		
		test.log(Status.INFO, "최근 들은 메뉴 이동 ");
		String clickable;
		util.click(By.xpath("//android.widget.LinearLayout[@content-desc='최근 들은']"));	
		clickable = util.getAttribute(By.xpath("//android.widget.LinearLayout[@content-desc='최근 들은']"), "clickable");
		Assert.assertEquals(clickable, "false");
		
		test.log(Status.INFO, "많이 들은 메뉴 이동 ");
		util.click(By.xpath("//android.widget.LinearLayout[@content-desc='많이 들은']"));	
		clickable = util.getAttribute(By.xpath("//android.widget.LinearLayout[@content-desc='많이 들은']"), "clickable");
		Assert.assertEquals(clickable, "false");
		
		test.log(Status.INFO, "좋아요 메뉴 이동 ");
		util.click(By.xpath("//android.widget.LinearLayout[@content-desc='좋아요']"));	
		clickable = util.getAttribute(By.xpath("//android.widget.LinearLayout[@content-desc='좋아요']"), "clickable");
		Assert.assertEquals(clickable, "false");
		
		test.log(Status.INFO, "FLO차트 메뉴 이동 ");
		util.click(By.xpath("//android.widget.LinearLayout[@content-desc='FLO차트']"));	
		clickable = util.getAttribute(By.xpath("//android.widget.LinearLayout[@content-desc='FLO차트']"), "clickable");
		Assert.assertEquals(clickable, "false");
		
		test.log(Status.INFO, "많이 들은 메뉴 이동 ");
		util.click(By.xpath("//android.widget.LinearLayout[@content-desc='많이 들은']"));	
		clickable = util.getAttribute(By.xpath("//android.widget.LinearLayout[@content-desc='많이 들은']"), "clickable");
		Assert.assertEquals(clickable, "false");
		
		test.log(Status.INFO, "많이 들은 첫번쨰 음악 선택 후 노래 재생 애니메이션 확인");
		util.click(By.id("song_name"));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("play_animation_view")));	
		util.click(By.id("appbar_back"));
		util.click(By.id("appbar_back"));
		
		test.log(Status.INFO, "소리에 FLO 음원 선택 확인");
		String alarm_audio_text = util.getText(By.id("alarm_audio_text"));
		Assert.assertFalse(alarm_audio_text_default.contains(alarm_audio_text));
		
		test.log(Status.INFO, "알람 저장");
		util.click(By.id("alert_save_button"));
		
		test.log(Status.INFO, "알람 삭제");
		util.click(By.xpath("//android.widget.TextView[contains(@text,'편집')]"));
		util.click(By.id("check_all_button"));
		util.click(By.id("register_button"));
		
		test.log(Status.INFO, "알람 삭제 확인");
		String empty_guide_text = util.getText(By.id("empty_guide_text"));
		Assert.assertTrue(empty_guide_text.contains("등록한 알람이 없습니다"));
		
		test.log(Status.INFO, "4번 볼륨 조절 케이스는 스킵 처리함");
		util.Android_BackKey();
	}
	
	//@Test(description = "A. Hotfix Regression Test : 016-003-001 apollo_alarm_set_add_001 알람 설정 + 시간 Entity 없이 발화 했을 때, 알람을 설정함")
	public void TC_016_003_001(Method method) throws Exception {
		
		test.log(Status.INFO, "016-003-001 apollo_alarm_set_add_001 알람 설정 + 시간 Entity 없이 발화 했을 때, 알람을 설정함");
		System.out.println("016-003-001 apollo_alarm_set_add_001 알람 설정 + 시간 Entity 없이 발화 했을 때, 알람을 설정함");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-19309");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-19309");
		
		test.log(Status.INFO, "홈 화면 이동 확인");
		Thread.sleep(5000);
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		
		test.log(Status.INFO, "'알람' 시간 Entuty 없이 발화 랜덤 명령어 전송");
		String 발화 = util.ramdomCommand(Data.알람발화);
		util.A_sendPost(발화, uID, dID, ServerName);
		
		test.log(Status.INFO,"알람 발화 로그 조회");
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(tts_message.contains("몇 시로 설정할까?"));
		
		test.log(Status.INFO,"하단 액션 버튼 확인 chips");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '오전 7시')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '매일 오전 8시')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '매일 정오')]")));
		
	}
	
	//@Test(description = "A. Hotfix Regression Test : 017-001-011 기본캘린더로 설정된 구글 캘린더 삭제 (Blue ver.)")
	public void TC_017_001_011(Method method) throws Exception {
		
		test.log(Status.INFO, "017-001-011 기본캘린더로 설정된 구글 캘린더 삭제 (Blue ver.)");
		System.out.println("017-001-011 기본캘린더로 설정된 구글 캘린더 삭제 (Blue ver.)");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-27183");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-27183");
		
		test.log(Status.INFO,"side menu button 버튼 클릭");
		util.click(By.id("left_menu_button"));
		
		test.log(Status.INFO,"캘린더 버튼 클릭");
		util.click(By.xpath("//android.widget.TextView[contains(@text, '캘린더')]"));
		
		test.log(Status.INFO,"동기화 진행 로딩 대기");
		if (util.isElementPresent(By.id("layout_bottom_loading"))) {
			Thread.sleep(3000);
		} 
		
		test.log(Status.INFO,"캘린더 메뉴 버튼 클릭");
		util.click(By.id("btn_side_menu"));
		
		test.log(Status.INFO, "구글 캘린더 테스트 캘린더 노출 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '에이닷 테스트 캘린더')]")));
		
		test.log(Status.INFO,"캘린더 설정 버튼 클릭 후 기본캐린더 구글 설정");
		util.click(By.id("setting_button"));
		util.click(By.id("default_calendar_setting_layout"));
		util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.ImageView[2]"));
		util.click(By.id("save_button"));
		Thread.sleep(1500);
		
		test.log(Status.INFO, "디바이스 홈 화면 이동");
		util.Android_HomeKey();
		
		test.log(Status.INFO, "크롬 앱 실행");
		util.click(By.xpath("//android.widget.TextView[contains(@text, 'Chrome')]"));
		
		test.log(Status.INFO, "크롬 웹뷰 전환");
		util.switchContext("WEBVIEW_chrome");
		
		test.log(Status.INFO, "크롬 앱 URL 입력 후 페이지 이동");
		test.log(Status.INFO, "이동페이지 URL : https://calendar.google.com/calendar/u/1/r/settings?pli=1");
		util.get("https://calendar.google.com/calendar/u/1/r/settings?pli=1");
		
		test.log(Status.INFO, "[웹뷰] 구글캘린더 설정 페이지 이동 후 '에이닷 테스트 캘린더'삭제 ");
		util.click(By.xpath("//*[contains(text(), '에이닷 테스트 캘린더')]"));
		///util.scrollDown(20);
		util.click(By.xpath("//button/span[contains(text(), '삭제')]"));
		
		test.log(Status.INFO, "'네이티브 전환");
		util.switchContext("NATIVE_APP");
		
		util.click(By.xpath("//android.widget.Button[contains(@text, '완전히 삭제')]"));
		Thread.sleep(7000);
		
		
		test.log(Status.INFO, "디바이스 홈 화면 이동");
		util.Android_HomeKey();
		
		test.log(Status.INFO,"기본 위젯 터치 홈화면 이동 확인");
		util.click(By.xpath("//android.widget.TextView[contains(@resource-id, 'widget_message')]"));
		
		test.log(Status.INFO,"캘린더 백키 버튼 클릭");
		util.click(By.id("back_button"));
		
		test.log(Status.INFO,"캘린더 동기화 버튼 클릭");
		util.click(By.id("side_sync_textview"));
		test.log(Status.INFO,"동기화 진행 로딩 대기");
		if (util.isElementPresent(By.id("layout_bottom_loading"))) {
			Thread.sleep(3000);
		} 
		
		test.log(Status.INFO,"캘린더 설정 버튼 클릭 후 기본캐린더 설정 확인");
		util.click(By.id("setting_button"));
		String default_calendar = util.getText(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView"));
		Assert.assertEquals(default_calendar, "기본 캘린더");
		
		test.log(Status.INFO, "디바이스 홈 화면 이동");
		util.Android_HomeKey();
		
		test.log(Status.INFO, "크롬 앱 실행");
		util.click(By.xpath("//android.widget.TextView[contains(@text, 'Chrome')]"));
		
		test.log(Status.INFO, "크롬 웹뷰 전환");
		util.switchContext("WEBVIEW_chrome");
		
		test.log(Status.INFO, "크롬 앱 URL 입력 후 페이지 이동");
		test.log(Status.INFO, "이동페이지 URL : https://calendar.google.com/calendar/u/1/r/settings?pli=1");
		util.get("https://calendar.google.com/calendar/u/1/r/settings?pli=1");
		
		test.log(Status.INFO, "새 캘린더 추가");
		util.click(By.xpath("//*[contains(text(), '캘린더 추가')]"));
		util.click(By.xpath("//*[contains(text(), '새 캘린더 만들기')]"));
		util.type(By.xpath("//label/input[@type='text']"), "에이닷 테스트 캘린더");
		
		test.log(Status.INFO, "'네이티브 전환");
		util.switchContext("NATIVE_APP");
		util.Android_BackKey();
		util.Android_TabKey();
		util.Android_TabKey();
		util.Android_TabKey();
		util.Android_EnterKey();
		Thread.sleep(7000);
		
		test.log(Status.INFO, "디바이스 홈 화면 이동");
		util.Android_HomeKey();
		
		test.log(Status.INFO,"기본 위젯 터치 홈화면 이동 확인");
		util.click(By.xpath("//android.widget.TextView[contains(@resource-id, 'widget_message')]"));
		
		test.log(Status.INFO,"캘린더 백키 버튼 클릭");
		util.click(By.id("back_button"));
		
		test.log(Status.INFO,"캘린더 동기화 버튼 클릭");
		util.click(By.id("side_sync_textview"));
		test.log(Status.INFO,"동기화 진행 로딩 대기");
		if (util.isElementPresent(By.id("layout_bottom_loading"))) {
			Thread.sleep(3000);
		} 
		
		test.log(Status.INFO,"캘린더 설정 버튼 클릭 후 기본캐린더 구글 설정");
		util.click(By.id("setting_button"));
		util.click(By.id("default_calendar_setting_layout"));
		util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[2]/android.widget.ImageView[2]"));
		util.click(By.id("save_button"));
		Thread.sleep(1500);
		
		test.log(Status.INFO, "디바이스 홈 화면 이동");
		util.Android_HomeKey();
		
		test.log(Status.INFO, "크롬 앱 실행");
		util.click(By.xpath("//android.widget.TextView[contains(@text, 'Chrome')]"));
		
		test.log(Status.INFO, "크롬 웹뷰 전환");
		util.switchContext("WEBVIEW_chrome");
		
		test.log(Status.INFO, "크롬 앱 URL 입력 후 페이지 이동");
		test.log(Status.INFO, "이동페이지 URL : https://calendar.google.com/calendar/u/1/r/settings?pli=1");
		util.get("https://calendar.google.com/calendar/u/1/r/settings?pli=1");
		
		test.log(Status.INFO, "[웹뷰] 구글캘린더 설정 페이지 이동 후 '에이닷 테스트 캘린더'삭제 ");
		util.click(By.xpath("//*[contains(text(), '에이닷 테스트 캘린더')]"));
		///util.scrollDown(20);
		util.click(By.xpath("//button/span[contains(text(), '삭제')]"));
		
		test.log(Status.INFO, "'네이티브 전환");
		util.switchContext("NATIVE_APP");
		
		util.click(By.xpath("//android.widget.Button[contains(@text, '완전히 삭제')]"));
		
		Thread.sleep(7000);
		
		test.log(Status.INFO, "디바이스 홈 화면 이동");
		util.Android_HomeKey();
		
		test.log(Status.INFO,"기본 위젯 터치 홈화면 이동 확인");
		util.click(By.xpath("//android.widget.TextView[contains(@resource-id, 'widget_message')]"));
		
		test.log(Status.INFO,"에이닷 홈으로 이동");
		util.Android_BackKey();
		util.Android_BackKey();
		util.Android_BackKey();
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		
		test.log(Status.INFO,"오늘 23시 취침 일정 등록해줘 발화 명령어 전송");
		util.A_sendPost("오늘 23시 취침 일정 등록해줘", uID, dID, ServerName);
		
		test.log(Status.INFO,"캘린더 바로 가기 버튼 클릭");
		util.click(By.xpath("//android.widget.TextView[contains(@text, '캘린더 바로가기')]"));
		
		test.log(Status.INFO,"일뷰로 전환");
		util.click(By.id("day"));
		
		test.log(Status.INFO,"등록된 스케쥴 상세로 이동");
		util.click(By.id("schedule_title_textview"));
		
		test.log(Status.INFO,"등록된 기본 캘린더가 A.캘린더 인지 확인");
		String 캘린더명 = util.getText(By.id("tv_calendar_name"));
		Assert.assertEquals(캘린더명, "기본 캘린더");
		
		test.log(Status.INFO,"캘린더 삭제");
		util.click(By.id("bt_delete"));
		util.click(By.id("positiveButton"));
		
		test.log(Status.INFO,"에이닷 홈으로 이동");
		util.Android_BackKey();
		util.Android_BackKey();
		util.Android_BackKey();
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		
		test.log(Status.INFO, "디바이스 홈 화면 이동");
		util.Android_HomeKey();
		
		test.log(Status.INFO, "크롬 앱 실행");
		util.click(By.xpath("//android.widget.TextView[contains(@text, 'Chrome')]"));
		
		test.log(Status.INFO, "크롬 웹뷰 전환");
		util.switchContext("WEBVIEW_chrome");
		
		test.log(Status.INFO, "크롬 앱 URL 입력 후 페이지 이동");
		test.log(Status.INFO, "이동페이지 URL : https://calendar.google.com/calendar/u/1/r/settings?pli=1");
		util.get("https://calendar.google.com/calendar/u/1/r/settings?pli=1");
		
		test.log(Status.INFO, "새 캘린더 추가");
		util.click(By.xpath("//*[contains(text(), '캘린더 추가')]"));
		util.click(By.xpath("//*[contains(text(), '새 캘린더 만들기')]"));
		util.type(By.xpath("//label/input[@type='text']"), "에이닷 테스트 캘린더");
		
		test.log(Status.INFO, "'네이티브 전환");
		util.switchContext("NATIVE_APP");
		util.Android_BackKey();
		util.Android_TabKey();
		util.Android_TabKey();
		util.Android_TabKey();
		util.Android_EnterKey();
		Thread.sleep(7000);
		
		test.log(Status.INFO, "디바이스 홈 화면 이동");
		util.Android_HomeKey();
		test.log(Status.INFO, "'네이티브 전환");
		util.switchContext("NATIVE_APP");
		
		test.log(Status.INFO,"기본 위젯 터치 홈화면 이동 확인");
		util.click(By.xpath("//android.widget.TextView[contains(@resource-id, 'widget_message')]"));
	}
	
	//@Test(description = "A. Hotfix Regression Test : 017-004-001 설정 / 4-1. 설정 (Blue ver.)") 
	public void TC_017_004_001(Method method) throws Exception {
		
		test.log(Status.INFO, "017-004-001 설정 / 4-1. 설정 (Blue ver.)");
		System.out.println("017-004-001 설정 / 4-1. 설정 (Blue ver.)");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-19727");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-19727");
		
		test.log(Status.INFO, "홈 화면 이동 확인");
		Thread.sleep(5000);
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		
		
		test.log(Status.INFO,"side menu button 버튼 클릭");
		util.click(By.id("left_menu_button"));
		
		test.log(Status.INFO,"캘린더 버튼 클릭");
		util.click(By.xpath("//android.widget.TextView[contains(@text, '캘린더')]"));
		
		test.log(Status.INFO,"동기화 진행 로딩 대기");
		if (util.isElementPresent(By.id("layout_bottom_loading"))) {
			Thread.sleep(3000);
		} 
		
		test.log(Status.INFO,"캘린더 메뉴 버튼 클릭");
		util.click(By.id("btn_side_menu"));
		
		test.log(Status.INFO,"캘린더 설정 버튼 클릭");
		util.click(By.id("setting_button"));
		
		test.log(Status.INFO,"캘린더 설정 페이지 구성요소 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '일정')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("default_calendar_setting_layout")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("external_calendar_setting_layout")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '할일')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("default_todo_setting_layout")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '알림')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("notification_receive_setting_layout")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("default_notification_time_setting_layout")));
		
		test.log(Status.INFO,"이전 버튼 클릭 후 페이지 복귀 확인");
		util.click(By.id("back_button"));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("setting_button")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("calendar_info_recyclerview")));
		
		test.log(Status.INFO,"캘린더 설정 버튼 클릭");
		util.click(By.id("setting_button"));
		
		test.log(Status.INFO,"기본 캘린더 설정 확인");
		String default_calendar = util.getText(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.TextView"));
		Assert.assertEquals(default_calendar, "기본 캘린더");
		
		test.log(Status.INFO,"외부 캘린더 연동관리 랜딩 확인");
		util.click(By.id("external_calendar_setting_layout"));
		String title_textview1 = util.getText(By.id("title_textview"));
		Assert.assertEquals(title_textview1, "외부 캘린더 연동 관리");
		String account_textview = util.getText(By.id("account_textview"));
		Assert.assertEquals(account_textview, "agentqa.skt@gmail.com");
		util.click(By.id("back_button"));
		
		test.log(Status.INFO,"기본 할일 목록 연동관리 랜딩 확인");
		util.click(By.id("default_todo_setting_layout"));
		String title_textview2 = util.getText(By.id("title_textview"));
		Assert.assertEquals(title_textview2, "기본 할일 목록 설정");
		util.click(By.id("back_button"));
		
		test.log(Status.INFO,"알림 수신 설정 랜딩 확인");
		util.click(By.id("notification_receive_setting_layout"));
		String title_textview3 = util.getText(By.id("title_textview"));
		Assert.assertEquals(title_textview3, "알림 수신 설정");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '일정 브리핑')]")));
		util.click(By.id("back_button"));
		
		test.log(Status.INFO,"기본 알림 시간 설정랜딩 확인");
		util.click(By.id("default_notification_time_setting_layout"));
		String title_textview4 = util.getText(By.id("title_textview"));
		Assert.assertEquals(title_textview4, "기본 알림 시간 설정");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '시간 일정 알림')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '종일 일정 알림')]")));
		util.click(By.id("back_button"));

		test.log(Status.INFO,"동기화 버튼 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, '동기화')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("sync_textview")));
		
		test.log(Status.INFO,"최근 동기화 시간 영역 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("sync_time_textview")));
		
	}
	
	//@Test(description = "A. Hotfix Regression Test : 017-004-001 설정 / 4-1. 설정 (Blue ver.)") 
	public void TC_017_004_004(Method method) throws Exception {
		
		test.log(Status.INFO, "017-004-004 4-3. 외부 캘린더 연동 관리 (Blue ver.)");
		System.out.println("017-004-004 4-3. 외부 캘린더 연동 관리 (Blue ver.))");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-26337");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-26337");
		
		test.log(Status.INFO,"외부 캘린더 연동관리 랜딩 확인");
		util.click(By.id("external_calendar_setting_layout"));
		String description_textview = util.getText(By.id("description_textview"));
		System.out.println(description_textview);
		Assert.assertEquals(description_textview, "외부 캘린더를\n"
				+ "연동하거나 해제 할 수 있습니다.");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text, 'Google 캘린더')]")));
		String account_textview = util.getText(By.id("account_textview"));
		Assert.assertEquals(account_textview, "agentqa.skt@gmail.com");
		
		test.log(Status.INFO,"연동중인 경우 [연동해제] 버튼 노출 확인");
		String link_btn = util.getText(By.id("link_btn"));
		Assert.assertEquals(link_btn, "연동해제");
		util.click(By.id("link_btn"));
		
		test.log(Status.INFO,"[연동해제] 시도시 팝업 버튼 노출 확인");
		String titleTextView = util.getText(By.id("titleTextView"));
		Assert.assertEquals(titleTextView, "연동을 해제하시겠습니까?\n"
				+ "더 이상 해당 캘린더의 내용을 볼 수 없습니다.");
		util.click(By.id("positiveButton"));
		
		test.log(Status.INFO,"[연동해제] 버튼 사라지고 [구글] 버튼 노출 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("google_btn")));
		
		test.log(Status.INFO,"[구글]연동 버튼 클릭 후 연동 시도");
		util.click(By.id("google_btn"));
		util.click(By.xpath("//android.view.View[@content-desc='김성수 agentqa.skt@gmail.com']"));
		util.click(By.xpath("//android.widget.Button[contains(@text, '취소')]"));
		
		test.log(Status.INFO,"구글 연동 실패 후 토스트 메세지 확인");
		if (util.isElementPresent(By.xpath("//android.widget.Toast[contains(@text, 'Google 캘린더 연동에 실패했습니다.)]"))) {
			Thread.sleep(3000);
		}
		
		test.log(Status.INFO,"구글 연동 재 시도");
		util.click(By.id("google_btn"));
		util.click(By.xpath("//android.view.View[@content-desc='김성수 agentqa.skt@gmail.com']"));
		util.click(By.xpath("//android.widget.Button[contains(@text, '계속')]"));
		
		String link_btn1 = util.getText(By.id("link_btn"));
		Assert.assertEquals(link_btn1, "연동중");
		
		test.log(Status.INFO,"연동 진행 중 로딩 대기");
			Thread.sleep(5000);
	
		String link_btn2 = util.getText(By.id("link_btn"));
		Assert.assertEquals(link_btn2, "연동해제");
		
		util.Android_BackKey();
		util.Android_BackKey();
		util.Android_BackKey();
		util.Android_BackKey();
	}
	
	//@Test(description = "A. Hotfix Regression Test : 017-007-001 calendar_ask.event_001 기본 발화") 
	public void TC_017_007_001(Method method) throws Exception {
		
		test.log(Status.INFO, "017-007-001 calendar_ask.event_001 기본 발화");
		System.out.println("017-007-001 calendar_ask.event_001 기본 발화");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-19541");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-19541");
		
		test.log(Status.INFO, "홈 화면 이동 확인");
		Thread.sleep(5000);
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		
		test.log(Status.INFO, "'일정' 발화 명령어 전송");
		util.A_sendPost("일정", uID, dID, ServerName);
		Thread.sleep(2500);
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(tts_message.contains("일주일 동안 등록된 일정이 없어"));
		
		test.log(Status.INFO, "'캘린더 바로 가기 버튼 클릭 후 화면 랜딩 확안");
		util.click(By.xpath("//android.widget.TextView[contains(@text, '캘린더 바로가기')]"));
		Thread.sleep(2000);
		util.getAttribute_Assertfunc(By.id("calendar"), "clickable", "false");
		util.Android_BackKey();
		
		
	}
	
	//@Test(description = "A. Hotfix Regression Test : 017-016-002 calendar_menu_002 할일 화면 이동") 
	public void TC_017_016_002(Method method) throws Exception {
		
		test.log(Status.INFO, "017-016-002 calendar_menu_002 할일 화면 이동");
		System.out.println("017-016-002 calendar_menu_002 할일 화면 이동");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-20639");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-20639");
		
		test.log(Status.INFO, "'할일' 발화 랜덤 명령어 전송");
		String 발화 = util.ramdomCommand(Data.할일);
		util.A_sendPost(발화, uID, dID, ServerName);
		Thread.sleep(2500);
		
		test.log(Status.INFO, "'할일 화면 랜딩 확안");
		util.getAttribute_Assertfunc(By.id("todo"), "clickable", "false");
		util.click(By.id("btn_close"));
		
		test.log(Status.INFO, "'할일 화면 랜딩 TTS 확안");
		String TTS = util.TTS_JsonParsing_retry(uID, dID, ServerName, Service, 발화);
		Assert.assertTrue(TTS.contains("할일목록으로 이동할게"));
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 018-001-005 apolloMusic_sgc_01_005 선택된 재생CP 를 지원하는 POC + 로그인 + 재생 목록 있음 + 지원 이용권 + 일반 재생 요청") 
	public void TC_018_001_005(Method method) throws Exception {
		
		test.log(Status.INFO, "018-001-005 apolloMusic_sgc_01_005 선택된 재생CP 를 지원하는 POC + 로그인 + 재생 목록 있음 + 지원 이용권 + 일반 재생 요청");
		System.out.println("018-001-005 apolloMusic_sgc_01_005 선택된 재생CP 를 지원하는 POC + 로그인 + 재생 목록 있음 + 지원 이용권 + 일반 재생 요청");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-19780");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-19780");
		Thread.sleep(5000);
		test.log(Status.INFO, "'FLO' 발화 랜덤 명령어 전송");
		String 발화 = util.ramdomCommand(Data.FLO);
		util.A_sendPost(발화, uID, dID, ServerName);
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(tts_message.contains("FLO에서 최근 감상한 음악 들려줄게"));
		Thread.sleep(1500);
		
		test.log(Status.INFO, "플로팅 미디어 플레이어 실행 후 확인");
		util.tap(92, 1060);
		util.tap(440, 1060);
		Assert.assertTrue(util.waitForActivity("com.skt.nugu.visual.media.MusicTemplateActivity"));
		util.A_sendPost("일시정지", uID, dID, ServerName);
		
		String tv_title = util.getText(By.id("tv_title"));
		Assert.assertEquals(tv_title, "FLO");
		
		test.log(Status.INFO, "플로팅 미디어 플레이어 닫기");
		util.click(By.id("btn_close"));
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 018-006-007 apolloMusic_play_01_006  ~ 008 ASMR") 
	public void TC_018_006_007(Method method) throws Exception {
		
		test.log(Status.INFO, "018-006-007 apolloMusic_play_01_006  ~ 008 ASMR");
		System.out.println("018-006-007 apolloMusic_play_01_006  ~ 008 ASMR");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-19809");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-19809");
		
		test.log(Status.INFO, "'FLO' 발화 랜덤 명령어 전송");
		String 발화 = util.ramdomCommand(Data.ASMR);
		util.A_sendPost(발화, uID, dID, ServerName);
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(tts_message.contains("ASMR 들려줄게"));
		
		test.log(Status.INFO, "플로팅 미디어 플레이어 실행 후 확인");
		util.tap(92, 1060);
		util.tap(440, 1060);
		Assert.assertTrue(util.waitForActivity("com.skt.nugu.visual.media.MusicTemplateActivity"));
		util.A_sendPost("일시정지", uID, dID, ServerName);
		
		String tv_title = util.getText(By.id("tv_title"));
		Assert.assertEquals(tv_title, "ASMR");
		
		test.log(Status.INFO, "플로팅 미디어 플레이어 닫기");
		util.click(By.id("btn_close"));
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 019-002-006 모션_6 꾸미기 화면 + 진입") 
	public void TC_019_002_006(Method method) throws Exception {
		
		test.log(Status.INFO, "019-002-006 모션_6 꾸미기 화면 + 진입");
		System.out.println("019-002-006 모션_6 꾸미기 화면 + 진입");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-19501");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-19501");
		
		util.A_sendPost("안녕", uID, dID, ServerName);
		
		test.log(Status.INFO,"캐릭터 롱 프레스");
		util.longPress(By.id("avatar_view_fragment"));
		util.click(By.id("btn_show_editor"));
		
		test.log(Status.INFO,"캐릭터 꾸미기 페이지 이동 확인");
		if(util.isElementPresent_Assertfunc(By.id("positiveButtonText"))) {
			util.click(By.id("positiveButtonText"));
		} 
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("avatar_shop_purchase")));
		
	}

}
