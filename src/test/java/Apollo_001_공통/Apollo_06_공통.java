package Apollo_001_공통;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Apollo_Data.Data;
import Apollo_Data.xPath;
import TestNG_Set.APOLLO_TestCase;
import junit.framework.Assert;

public class Apollo_06_공통 extends APOLLO_TestCase {
	
	@Test(description = "A. Hotfix Regression Test : 035-001-001 radio_dux_001 Template + Audio Player")
	public void TC_035_001_001(Method method) throws Exception {
		
		test.log(Status.INFO, "035-001-001 radio_dux_001 Template + Audio Player");
		System.out.println("035-001-001 radio_dux_001 Template + Audio Player");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-21581");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-21581");
		
		test.log(Status.INFO, "홈 화면 이동 확인");
		Thread.sleep(5000);
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		
		test.log(Status.INFO, "미디어 실행 명령어 전송");
		util.A_sendPost("SBS 러브 FM 라디오 들려줘", uID, dID, ServerName);
		
		test.log(Status.INFO, "플로팅 미디어 플레이어 실행 후 확인");
		util.tap(92, 1060);
		util.tap(440, 1060);
		Assert.assertTrue(util.waitForActivity("com.skt.nugu.visual.media.MusicTemplateActivity"));
		
		test.log(Status.INFO, "미디어 일시정지 명령어 전송");
		util.A_sendPost("라디오 일시정지", uID, dID, ServerName);
		
		test.log(Status.INFO, "AudioPlayer.Template 구성요소 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("iv_image")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("iv_logo")));
		String title = util.getText(By.xpath("//android.widget.TextView[contains(@resource-id, 'tv_title')]"));
		Assert.assertEquals(title, "라디오");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("tv_header")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("iv_favorite")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("btn_show_playlist")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("btn_prev")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("btn_play")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("btn_next")));
		Assert.assertFalse(util.isElementPresent_Assertfunc(By.id("sb_progress")));
		
		test.log(Status.INFO, "1 TestCase ");
		test.log(Status.INFO, "1 TestCase ");

	}
	
	@Test(description = "A. Hotfix Regression Test : 035-009-002 apollo_radio_control_next_002 다음 / 다른 채널 재생 + 일시정지 / 재생중 + 즐겨찾기 채널 재생 X")
	public void TC_035_009_002(Method method) throws Exception {
		
		test.log(Status.INFO, "035-009-002 apollo_radio_control_next_002 다음 / 다른 채널 재생 + 일시정지 / 재생중 + 즐겨찾기 채널 재생 X");
		System.out.println("0035-009-002 apollo_radio_control_next_002 다음 / 다른 채널 재생 + 일시정지 / 재생중 + 즐겨찾기 채널 재생 X");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-21621");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-21621");
		
		test.log(Status.INFO, "현재 라디오 채널 저장");
		String 현재라디오채널 = util.getText(By.id("tv_header"));
		
		test.log(Status.INFO, "미디어 다음 실행 명령어 전송");
		util.A_sendPost("다음 재생", uID, dID, ServerName);
		
		test.log(Status.INFO, "다음 라디오 채널 저장");
		String 다음라디오채널 = util.getText(By.id("tv_header"));
		Assert.assertFalse(다음라디오채널.contains("현재라디오채널"));
		
		test.log(Status.INFO, "미디어 이전 실행 명령어 전송");
		util.A_sendPost("이전 라디오", uID, dID, ServerName);
		
		test.log(Status.INFO, "이전 라디오 채널 저장");
		String 이전라디오채널 = util.getText(By.id("tv_header"));
		Assert.assertEquals(이전라디오채널, 현재라디오채널);
		
		util.click(By.id("btn_close"));
		
		test.log(Status.INFO, "1 TestCase ");
		test.log(Status.INFO, "1 TestCase ");
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 035-015-001 apollo_radio_ask_schedule_001 전체 편성표 정보 + 전체 라디오 편성표 정보 요청")
	public void TC_035_015_001(Method method) throws Exception {
		
		test.log(Status.INFO, "035-015-001 apollo_radio_ask_schedule_001 전체 편성표 정보 + 전체 라디오 편성표 정보 요청");
		System.out.println("035-015-001 apollo_radio_ask_schedule_001 전체 편성표 정보 + 전체 라디오 편성표 정보 요청");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-26046");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-26046");
		
		test.log(Status.INFO, "홈 화면 이동 확인");
		Thread.sleep(5000);
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		
		test.log(Status.INFO, "'라디오 편성표 보여줘' 실행 명령어 전송");
		util.A_sendPost("라디오 편성표 보여줘", uID, dID, ServerName);
		
		test.log(Status.INFO, "'TTS 및 모션 확인 및 템플릿타입 확인");
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(tts_message.contains("오늘 라디오 편성표 정보야"));
		//Assert.assertTrue(util.TemplateType_JsonParsing(uID, dID, ServerName, Service, "라디오 편성표 보여줘").contains("TimetableFullProgramSchedule"));
		
		test.log(Status.INFO, "'라디오 채널 순서 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[1]/android.widget.TextView[contains(@text,'KBS 1Radio')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[2]/android.widget.TextView[contains(@text,'KBS 2Radio')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[3]/android.widget.TextView[contains(@text,'KBS 3Radio')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[4]/android.widget.TextView[contains(@text,'KBS ClassicFM')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[5]/android.widget.TextView[contains(@text,'KBS CoolFM')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[6]/android.widget.TextView[contains(@text,'KBS 월드라디오')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[7]/android.widget.TextView[contains(@text,'KBS 한민족방송')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[8]/android.widget.TextView[contains(@text,'MBC FM4U')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[9]/android.widget.TextView[contains(@text,'MBC 라디오')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[10]/android.widget.TextView[contains(@text,'SBS 러브FM')]")));
		
		test.log(Status.INFO, "어제/오늘/내일 날짜 구하기");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M.d");
		//DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("H");
		
		
		LocalDate today = LocalDate.now();
		LocalDateTime Time = LocalDateTime.now();
		LocalDate tomorrow = today.plusDays(1);
		LocalDate yesterday = today.plusDays(-1);
		
		String formattedToday = today.format(formatter);
		System.out.println(formattedToday);
		String formattedTomorrow = tomorrow.format(formatter);
		System.out.println(formattedTomorrow);
		String formattedYesterday = yesterday.format(formatter);
		System.out.println(formattedYesterday);
		//String formattedTime = Time.format(formatter2);
		int hour = Time.getHour();
		//String 현재시간1 = formattedTime +":00";
		String 현재시간 = hour +":00";
		System.out.println(현재시간);
		
		test.log(Status.INFO, "오늘 날짜 테이블 확인");
		String 오늘날짜 = util.getText(By.id("date"));
		Assert.assertTrue(오늘날짜.contains(formattedToday));
		test.log(Status.INFO, "오늘 라디오 표시선 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("current")));
		
		test.log(Status.INFO, "어제 날짜 테이블 확인");
		util.click(By.xpath("//android.widget.ImageButton[contains(@resource-id, 'previous')]"));
		Thread.sleep(1500);
		String 어제날짜 = util.getText(By.id("date"));
		Assert.assertTrue(어제날짜.contains(formattedYesterday));
		test.log(Status.INFO, "오늘 라디오 표시선 미표시 확인");
		Assert.assertFalse(util.isElementPresent_Assertfunc(By.id("current")));
		
		test.log(Status.INFO, "내일 날짜 테이블 확인");
		util.click(By.xpath("//android.widget.ImageButton[contains(@resource-id, 'next')]"));
		Thread.sleep(1500);
		util.click(By.xpath("//android.widget.ImageButton[contains(@resource-id, 'next')]"));
		Thread.sleep(1500);
		String 내일날짜 = util.getText(By.id("date"));
		Assert.assertTrue(내일날짜.contains(formattedTomorrow));
		test.log(Status.INFO, "오늘 라디오 표시선 미표시 확인");
		Assert.assertFalse(util.isElementPresent_Assertfunc(By.id("current")));
		util.click(By.xpath("//android.widget.ImageButton[contains(@resource-id, 'previous')]"));
		
		test.log(Status.INFO, "채널별 편성표 상세 확인  (SBS 파워FM)");
		util.scrollDown();
		util.click(By.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[11]/android.widget.TextView[contains(@text,'SBS 파워FM')]"));
		String tts_message1 = util.getText(By.id("message"));
		Assert.assertTrue(tts_message1.contains("SBS 파워FM 오늘 편성표 정보야"));
		
		test.log(Status.INFO, "오늘 날짜 테이블 확인");
		오늘날짜 = util.getText(By.id("date"));
		Assert.assertTrue(오늘날짜.contains(formattedToday));
		
		test.log(Status.INFO, "어제 날짜 테이블 확인");
		util.click(By.xpath("//android.widget.ImageButton[contains(@resource-id, 'previous')]"));
		Thread.sleep(1500);
		어제날짜 = util.getText(By.id("date"));
		Assert.assertTrue(어제날짜.contains(formattedYesterday));
		
		test.log(Status.INFO, "내일 날짜 테이블 확인");
		util.click(By.xpath("//android.widget.ImageButton[contains(@resource-id, 'next')]"));
		Thread.sleep(1500);
		util.click(By.xpath("//android.widget.ImageButton[contains(@resource-id, 'next')]"));
		Thread.sleep(1500);
		내일날짜 = util.getText(By.id("date"));
		Assert.assertTrue(내일날짜.contains(formattedTomorrow));
		util.click(By.xpath("//android.widget.ImageButton[contains(@resource-id, 'previous')]"));
		Thread.sleep(1500);
		
		test.log(Status.INFO, "현재 방송중인 라디오 선택 후 재생 확인");
		String 현재방송명 = "";
		
		System.out.println(현재방송명);
		util.click(By.xpath("//android.widget.TextView[contains(@text,'"+현재방송명+"')]"));
		/*
		test.log(Status.INFO, "'TTS 및 모션 확인 및 템플릿타입 확인");
		String tts_message3 = util.getText(By.id("message"));
		Assert.assertTrue(tts_message3.contains("SBS 파워FM"));
		
		test.log(Status.INFO, "플로팅 미디어 플레이어 실행 후 확인");
		util.tap(92, 1060);
		util.tap(440, 1060);
		Assert.assertTrue(util.waitForActivity("com.skt.nugu.visual.media.MusicTemplateActivity"));
		
		test.log(Status.INFO, "미디어 일시정지 명령어 전송");
		util.A_sendPost("라디오 일시정지", uID, dID, ServerName);
		
		util.click(By.id("btn_close"));
		*/
		test.log(Status.INFO, "3 TestCase ");
		test.log(Status.INFO, "3 TestCase ");
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 036-001-001 서비스 설정")
	public void TC_036_001_001(Method method) throws Exception {
		
		test.log(Status.INFO, "036-001-001 서비스 설정");
		System.out.println("036-001-001 서비스 설정");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-23110");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-23110");
		
		test.log(Status.INFO, "홈 화면 이동 확인");
		Thread.sleep(5000);
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		
		test.log(Status.INFO, "'서비스 설정' 실행 명령어 전송");
		util.A_sendPost("서비스 설정", uID, dID, ServerName);
		
		test.log(Status.INFO, "'TTS 및 모션 확인 ");
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(tts_message.contains("설정에서 확인해 봐"));
		//Assert.assertTrue(util.dataCheck_Contains(util.Motion_JsonParsing(uID, dID, ServerName, Service, "서비스 설정"), Data.서비스설정모션코드_set));
		
		test.log(Status.INFO, "'설정 바로 가기 버튼 클릭 후 화면 랜딩 확안");
		util.click(By.xpath("//android.widget.TextView[contains(@text, '설정 보기')]"));
		Thread.sleep(2000);
		String title = util.getText(By.id("toolbar_title"));
		Assert.assertTrue(title.contains("설정"));
		util.Android_BackKey();
		
		test.log(Status.INFO, "2 TestCase ");
		test.log(Status.INFO, "2 TestCase ");
	}


}
