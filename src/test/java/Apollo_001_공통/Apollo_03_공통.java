package Apollo_001_공통;

import java.lang.reflect.Method;
import java.util.Random;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Apollo_Data.Data;
import Apollo_Data.xPath;
import TestNG_Set.APOLLO_TestCase;
import junit.framework.Assert;

public class Apollo_03_공통 extends APOLLO_TestCase {
	
	@Test(description = "A. Hotfix Regression Test : 006-004-007 calc_case1_001 계산 기능 + 출력 가능 범위")
	public void TC_006_004_007(Method method) throws Exception {
		
		test.log(Status.INFO, "006-004-007 calc_case1_001 계산 기능 + 출력 가능 범위");
		System.out.println("006-004-007 calc_case1_001 계산 기능 + 출력 가능 범위");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-21685");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-21685");
		
		test.log(Status.INFO, "홈 화면 이동 확인");
		Thread.sleep(5000);
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		
		
		String 템플릿텍스트1;
		String 템플릿텍스트2;
		
		test.log(Status.INFO, "'111 플러스 222' 명령어 전송 ");
		util.A_sendPost("111 플러스 222", uID, dID, ServerName);
		test.log(Status.INFO, "'111 플러스 222'템플릿 노출 확인");
		util.waitForIsElementPresent(By.id("banner_container"));
		템플릿텍스트1 = util.getText(By.id("text1"));
		Assert.assertEquals(템플릿텍스트1, "111 + 222");
		템플릿텍스트2 = util.getText(By.id("text2"));
		Assert.assertEquals(템플릿텍스트2, "= 333");
		
		test.log(Status.INFO, "'로그 2는 얼마야 ' 명령어 전송");
		util.A_sendPost("1로그 2는 얼마야", uID, dID, ServerName);
		test.log(Status.INFO, "'로그 2는 얼마야 '템플릿 노출 확인");
		util.waitForIsElementPresent(By.id("banner_container"));
		템플릿텍스트1 = util.getText(By.id("text1"));
		Assert.assertEquals(템플릿텍스트1, "log2");
		템플릿텍스트2 = util.getText(By.id("text2"));
		Assert.assertEquals(템플릿텍스트2, "= 0.3010299957");

		//test.log(Status.INFO, "'루트 2 더하기 루트 2는 뭐야' 명령어 전송 ");
		//util.A_sendPost("루트 2 더하기 루트 2는 뭐야", uID, dID, ServerName);
		//test.log(Status.INFO, "'루트 2 더하기 루트 2는 뭐야 '템플릿 노출 확인");
		//util.waitForIsElementPresent(By.id("banner_container"));
		//템플릿텍스트1 = util.getText(By.id("text1"));
		//Assert.assertEquals(템플릿텍스트1, "√2 + √2");
		//템플릿텍스트2 = util.getText(By.id("text2"));
		//Assert.assertEquals(템플릿텍스트2, "= 2.8284271247");
		
		test.log(Status.INFO, "'탄젠트 45 마이너스 5 ' 명령어 전송");
		util.A_sendPost("탄젠트 45 마이너스 5 ", uID, dID, ServerName);
		test.log(Status.INFO, "'탄젠트 45 마이너스 5  '템플릿 노출 확인");
		util.waitForIsElementPresent(By.id("banner_container"));
		템플릿텍스트1 = util.getText(By.id("text1"));
		Assert.assertEquals(템플릿텍스트1, "tan(45) - 5");
		템플릿텍스트2 = util.getText(By.id("text2"));
		Assert.assertEquals(템플릿텍스트2, "= -3.3802248095");
		
		test.log(Status.INFO, "'괄호 열고 5 더하기 3 괄호 닫고 곱하기 5는? ' 명령어 전송 후 로그아웃 버튼 클릭");
		util.A_sendPost("괄호 열고 5 더하기 3 괄호 닫고 곱하기 5는?  ", uID, dID, ServerName);
		test.log(Status.INFO, "'괄호 열고 5 더하기 3 괄호 닫고 곱하기 5는?   '템플릿 노출 확인");
		util.waitForIsElementPresent(By.id("banner_container"));
		템플릿텍스트1 = util.getText(By.id("text1"));
		Assert.assertEquals(템플릿텍스트1, "(5 + 3) × 5");
		템플릿텍스트2 = util.getText(By.id("text2"));
		Assert.assertEquals(템플릿텍스트2, "= 40");
		
		test.log(Status.INFO, "'3π 값 알려줘  ' 명령어 전송");
		util.A_sendPost("3π 값 알려줘", uID, dID, ServerName);
		test.log(Status.INFO, "'3π 값 알려줘 '템플릿 노출 확인");
		util.waitForIsElementPresent(By.id("banner_container"));
		템플릿텍스트1 = util.getText(By.id("text1"));
		Assert.assertEquals(템플릿텍스트1, "3π");
		템플릿텍스트2 = util.getText(By.id("text2"));
		Assert.assertEquals(템플릿텍스트2, "= 9.4247779608");
		

	}
	

	//@Test(description = "A. Hotfix Regression Test : 007-001-001 apollo_news_audio_player_DUX_1 뉴스재생 + Floating Player")
	public void TC_007_001_001(Method method) throws Exception {
		
		test.log(Status.INFO, "007-001-001 apollo_news_audio_player_DUX_1 뉴스재생 + Floating Player");
		System.out.println("007-001-001 apollo_news_audio_player_DUX_1 뉴스재생 + Floating Player");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-18248");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-18248");
		
		test.log(Status.INFO, "'뉴스 들러줘' 명령어 전송 후 로그아웃 버튼 클릭");
		util.A_sendPost("뉴스 들러줘", uID, dID, ServerName);
		
		test.log(Status.INFO, "다른 앱 위에 그리기 권한 팝업 창 있으면 터치");
		if(util.isElementPresent_Assertfunc(By.id("negativeButton"))) {
			util.click(By.id("negativeButton"));
			util.click(By.id("fixed_player_thumbnail"));
		} else {
			test.log(Status.INFO, "권한 있음 - 플레이어 확장 ");
			util.tap(92, 1060);
			util.tap(440, 1060);
		}
		
		test.log(Status.INFO, "미디어 플레이어 이미지 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("iv_image")));
		
		test.log(Status.INFO, "미디어 플레이어 닫기");
		util.click(By.id("btn_close"));
		
	}
	

	@Test(description = "A. Hotfix Regression Test : 007-003-001 apollo_news_play_recent_001 뉴스 재생")
	public void TC_007_003_001(Method method) throws Exception {
		
		test.log(Status.INFO, "007-003-001 apollo_news_play_recent_001 뉴스 재생");
		System.out.println("007-003-001 apollo_news_play_recent_001 뉴스 재생");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-18260");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-18260");
		
		test.log(Status.INFO, "홈 화면 이동 확인");
		Thread.sleep(5000);
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		
		
		test.log(Status.INFO, "'뉴스 들려줘' 발화 랜덤 명령어 전송");
		util.A_sendPost(util.ramdomCommand(Data.뉴스발화), uID, dID, ServerName);
		
		test.log(Status.INFO, "'TTS 및 모션 확인");
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(util.dataCheck_Contains(tts_message, Data.뉴스시작_set));
		Assert.assertTrue(util.Motion_JsonParsing(uID, dID, ServerName, Service).contains("L_News_0001"));
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 008-001-002 fortune_dux_002 Template + CardTableScrollable")
	public void TC_008_001_002(Method method) throws Exception {
		
		test.log(Status.INFO, "008-001-002 fortune_dux_002 Template + CardTableScrollable");
		System.out.println("008-001-002 fortune_dux_002 Template + CardTableScrollable");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-18227");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-18227");
		
		test.log(Status.INFO, "홈 화면 이동 확인");
		Thread.sleep(5000);
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		
		
		test.log(Status.INFO, "'뉴스 들려줘' 발화 랜덤 명령어 전송");
		util.A_sendPost("90년 1월 1일생 운세알려줘", uID, dID, ServerName);
		
		test.log(Status.INFO, "'TTS 및 모션 확인");
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(tts_message.contains("오늘 운세를 알려줄게"));
		Assert.assertTrue(util.Motion_JsonParsing(uID, dID, ServerName, Service).contains("L_Fortune_0001"));
		Assert.assertTrue(util.TemplateType_JsonParsing(uID, dID, ServerName, Service).contains("CenterCard"));
		
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text,'1990년 1월 1일생 운세')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text,'재물운')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text,'애정운')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text,'건강운')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("key")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("value")));
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 008-004-001 fortune_zodiac_001 띠 운세 + 날짜 지정 + 띠 이름 O")
	public void TC_008_004_002(Method method) throws Exception {
		
		test.log(Status.INFO, "008-004-001 fortune_zodiac_001 띠 운세 + 날짜 지정 + 띠 이름 O");
		System.out.println("008-004-001 fortune_zodiac_001 띠 운세 + 날짜 지정 + 띠 이름 O");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-21892");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-21892");
		
		test.log(Status.INFO, "'띠운세' 발화 랜덤 명령어 전송");
		util.A_sendPost(util.ramdomCommand(Data.띠운세발화), uID, dID, ServerName);
		
		test.log(Status.INFO, "'TTS 및 모션 확인");
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(tts_message.contains("운세를 알려줄게"));
		Assert.assertTrue(util.Motion_JsonParsing(uID, dID, ServerName, Service).contains("L_Fortune_0001"));
		Assert.assertTrue(util.TemplateType_JsonParsing(uID, dID, ServerName, Service).contains("CenterCard"));
		
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 010-003-001 weather_cast_default_001 시간/날짜 미지정")
	public void TC_010_003_001(Method method) throws Exception {
		
		test.log(Status.INFO, "010-003-001 weather_cast_default_001 시간/날짜 미지정");
		System.out.println("010-003-001 weather_cast_default_001 시간/날짜 미지정");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-18262");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-18262");

		test.log(Status.INFO, "'날씨' 발화 랜덤 명령어 전송");
		util.A_sendPost(util.ramdomCommand(Data.날씨발화), uID, dID, ServerName);
		
		test.log(Status.INFO, "'TTS 및 모션 확인");
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(tts_message.contains("날씨"));
		
		Assert.assertTrue(util.dataCheck_Contains(util.Motion_JsonParsing(uID, dID, ServerName, Service), Data.날씨모션코드_set));
		Assert.assertTrue(util.TemplateType_JsonParsing(uID, dID, ServerName, Service).contains("TopRollingBanner"));

		
	}
	
	
	
	

}
