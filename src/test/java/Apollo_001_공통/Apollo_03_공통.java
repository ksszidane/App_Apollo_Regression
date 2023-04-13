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
	

	@Test(description = "A. Hotfix Regression Test : 007-001-001 apollo_news_audio_player_DUX_1 뉴스재생 + Floating Player")
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
		
		test.log(Status.INFO, "'뉴스 종료' 발화 명령어 전송");
		util.A_sendPost("뉴스 종료", uID, dID, ServerName);
		
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
		String 발화 = util.ramdomCommand(Data.뉴스발화);
		util.A_sendPost(발화, uID, dID, ServerName);
		
		test.log(Status.INFO, "'TTS 및 모션 확인");
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(util.dataCheck_Contains(tts_message, Data.뉴스시작_set));
		
		util.A_sendPost("뉴스 종료", uID, dID, ServerName);
		Assert.assertTrue(util.Motion_JsonParsing(uID, dID, ServerName, Service, 발화).contains("L_News_0001"));
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 008-001-002 fortune_dux_002 Template + CardTableScrollable")
	public void TC_008_001_002(Method method) throws Exception {
		
		test.log(Status.INFO, "008-001-002 fortune_dux_002 Template + CardTableScrollable");
		System.out.println("008-001-002 fortune_dux_002 Template + CardTableScrollable");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-18227");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-18227");
		
		test.log(Status.INFO, "'뉴스 들려줘' 발화 랜덤 명령어 전송");
		util.A_sendPost("90년 1월 1일생 운세알려줘", uID, dID, ServerName);
		
		test.log(Status.INFO, "'TTS 및 모션 확인");
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(tts_message.contains("오늘 운세를 알려줄게"));
		Assert.assertTrue(util.Motion_JsonParsing(uID, dID, ServerName, Service, "90년 1월 1일생 운세알려줘").contains("L_Fortune_0001"));
		Assert.assertTrue(util.TemplateType_JsonParsing(uID, dID, ServerName, Service, "90년 1월 1일생 운세알려줘").contains("CenterCard"));
		
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
		String 발화 = util.ramdomCommand(Data.띠운세발화);
		util.A_sendPost(발화, uID, dID, ServerName);
		
		test.log(Status.INFO, "'TTS 및 모션 확인");
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(tts_message.contains("운세를 알려줄게"));
		Assert.assertTrue(util.Motion_JsonParsing(uID, dID, ServerName, Service, 발화).contains("L_Fortune_0001"));
		Assert.assertTrue(util.TemplateType_JsonParsing(uID, dID, ServerName, Service, 발화).contains("CenterCard"));
		
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 010-003-001 weather_cast_default_001 시간/날짜 미지정")
	public void TC_010_003_001(Method method) throws Exception {
		
		test.log(Status.INFO, "010-003-001 weather_cast_default_001 시간/날짜 미지정");
		System.out.println("010-003-001 weather_cast_default_001 시간/날짜 미지정");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-18262");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-18262");

		test.log(Status.INFO, "'날씨' 발화 랜덤 명령어 전송");
		String 발화 = util.ramdomCommand(Data.날씨발화);
		util.A_sendPost(발화, uID, dID, ServerName);
		
		test.log(Status.INFO, "'TTS 및 모션 확인");
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(tts_message.contains("날씨"));
		
		Assert.assertTrue(util.dataCheck_Contains(util.Motion_JsonParsing(uID, dID, ServerName, Service, 발화), Data.날씨모션코드_set));
		Assert.assertTrue(util.TemplateType_JsonParsing(uID, dID, ServerName, Service, 발화).contains("TopRollingBanner"));

		
	}
	
	@Test(description = "A. Hotfix Regression Test : 011-010-001 apollo_tmap_show_recent_001 apollo_tmap_show_recent_002 최근 목적지 요청")
	public void TC_011_001_001(Method method) throws Exception {
		
		test.log(Status.INFO, "011-010-001 apollo_tmap_show_recent_001 apollo_tmap_show_recent_002 최근 목적지 요청");
		System.out.println("011-010-001 apollo_tmap_show_recent_001 apollo_tmap_show_recent_002 최근 목적지 요청");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-19424");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-19424");

		test.log(Status.INFO, "'티맵' 발화 랜덤 명령어 전송");
		String 발화 = util.ramdomCommand(Data.티맵발화);
		util.A_sendPost(발화, uID, dID, ServerName);
		
		test.log(Status.INFO, "'TTS 확인");
		Assert.assertTrue(util.dataCheck_Contains(util.TTS_JsonParsing_retry(uID, dID, ServerName, Service, 발화), Data.티맵TTS_set));
		
		test.log(Status.INFO, "'웹뷰 전환");
		util.switchContext("WEBVIEW");

		test.log(Status.INFO, "'최근목적지 타이틀 확인");
		Assert.assertTrue(util.getText_Assertfunc(By.xpath(xPath.Tmap최근목적지Text_web), "최근 목적지"));
		
		test.log(Status.INFO, "'최근목적지 즐겨찾기 아이콘 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath(xPath.Tmap즐겨찾기아이콘_web)));
		
		test.log(Status.INFO, "'최근목적지 목록 확인");
		Assert.assertTrue(util.getText_Assertfunc(By.xpath(xPath.Tmap최근목적지POI_text_web), "대전광역시"));
		
		test.log(Status.INFO, "'네이티브 전환");
		util.switchContext("NATIVE_APP");
		
		test.log(Status.INFO, "웹뷰 닫기");
		util.click(By.id("toolbar_button_close"));

		
	}
	
	@Test(description = "A. Hotfix Regression Test : 013-002-001 wordchain_start_004 난이도 설정 없이 쿵쿵따맨 먼저 게임을 시작하는 경우")
	public void TC_013_002_001(Method method) throws Exception {
		
		test.log(Status.INFO, "013-002-001 wordchain_start_004 난이도 설정 없이 쿵쿵따맨 먼저 게임을 시작하는 경우");
		System.out.println("013-002-001 wordchain_start_004 난이도 설정 없이 쿵쿵따맨 먼저 게임을 시작하는 경우");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-18785");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-18785");
		
		test.log(Status.INFO, "'끝말잇기' 발화 명령어 전송");
		util.A_sendPost("끝말잇기 키보드로 시작", uID, dID, ServerName);
		
		test.log(Status.INFO, "'TTS 및 모션 확인");
		String TTS = util.TTS_JsonParsing_retry(uID, dID, ServerName, Service, "끝말잇기 키보드로 시작");
		Assert.assertTrue(TTS.contains("좋아. 끝말잇기를 해보자. 시작 단어는"));
		Assert.assertTrue(TTS.contains("할게. 이어지는 세 글자 단어로 입력해줄래?"));
		if((util.isElementPresent(By.id("home_text_input")))) {
			util.Android_BackKey();
		}
		Assert.assertTrue(util.Motion_JsonParsing(uID, dID, ServerName, Service, "끝말잇기 키보드로 시작").contains("Accepted_0001"));
		for(int i=0; i<10; i++) {
			Thread.sleep(1000);
			if((util.isElementPresent(By.id("home_text_input")))) {
				util.Android_BackKey();
			}
		}
		Thread.sleep(5000);
		for(int i=0; i<10; i++) {
			Thread.sleep(1000);
			if((util.isElementPresent(By.id("home_text_input")))) {
				util.Android_BackKey();
			}
		}
		
		
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 014-004-001 apollo_message_sendmessage_001 수신자 / 메시지 없음")
	public void TC_014_004_001(Method method) throws Exception {
		
		test.log(Status.INFO, "014-004-001 apollo_message_sendmessage_001 수신자 / 메시지 없음");
		System.out.println("014-004-001 apollo_message_sendmessage_001 수신자 / 메시지 없음");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-18854");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-18854");
		
		test.log(Status.INFO, "'문자' 발화 랜덤 명령어 전송");
		util.A_sendPost(util.ramdomCommand(Data.문자발화), uID, dID, ServerName);
		
		test.log(Status.INFO,"문자 발화 로그 조회");
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(tts_message.contains("누구에게 메시지를 보낼까?"));
		
		test.log(Status.INFO, "'아이유' 발화 랜덤 명령어 전송");
		util.A_sendPost("아이유", uID, dID, ServerName);
		
		test.log(Status.INFO,"문자 내용 TTS 로그 조회");
		String tts1_message = util.getText(By.id("message"));
		Assert.assertTrue(tts1_message.contains("아이유에게 뭐라고 보낼까?"));
		util.click(By.id("refresh"));
		Thread.sleep(2000);

		
	}
	
	@Test(description = "A. Hotfix Regression Test : 014-008-001 apollo_message_dialogue_020 연락처 리스트 중 수신자 선택 + 기/서수 + MSG_BODY값 없음")
	public void TC_014_008_001(Method method) throws Exception {
		
		test.log(Status.INFO, "014-008-001 apollo_message_dialogue_020 연락처 리스트 중 수신자 선택 + 기/서수 + MSG_BODY값 없음");
		System.out.println("014-008-001 apollo_message_dialogue_020 연락처 리스트 중 수신자 선택 + 기/서수 + MSG_BODY값 없음");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-18889");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-18889");
		
		test.log(Status.INFO, "'문자' 발화 랜덤 명령어 전송");
		util.A_sendPost("문자", uID, dID, ServerName);
		
		test.log(Status.INFO,"문자 발화 로그 조회");
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(tts_message.contains("누구에게 메시지를 보낼까?"));
		
		test.log(Status.INFO, "'김성수' 발화 명령어 전송");
		util.A_sendPost("김성수", uID, dID, ServerName);
		
		test.log(Status.INFO, "화면 템플릿 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("name")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("phoneNumber")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("profile_image")));
		
		test.log(Status.INFO,"문자 내용 TTS 로그 조회");
		String tts1_message = util.getText(By.id("message"));
		Assert.assertTrue(tts1_message.contains("몇번째에게 메세지를 보낼까?"));
		
		test.log(Status.INFO, "'문서' 서수 발화 랜덤 명령어 전송");
		util.A_sendPost(util.ramdomCommand(Data.서수문자발화), uID, dID, ServerName);
		
		test.log(Status.INFO,"서수 문자 내용 TTS 로그 조회");
		String tts2_message = util.getText(By.id("message"));
		Assert.assertTrue(tts2_message.contains("에게 뭐라고 보낼까?"));
		
		test.log(Status.INFO, "화면 템플릿 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text,'휴대폰 | 010-3245-0613')]")));
		
		util.click(By.id("refresh"));
		Thread.sleep(2000);

			
	}
	
	@Test(description = "A. Hotfix Regression Test : 015-004-001 apollo_telephony_global_001 Domain Default")
	public void TC_015_004_001(Method method) throws Exception {
		
		test.log(Status.INFO, "015-004-001 apollo_telephony_global_001 Domain Default");
		System.out.println("015-004-001 apollo_telephony_global_001 Domain Default");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-18922");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-18922");
		
		test.log(Status.INFO, "'전화' 발화 랜덤 명령어 전송");
		util.A_sendPost(util.ramdomCommand(Data.전화), uID, dID, ServerName);
		
		test.log(Status.INFO,"전화 발화 로그 조회");
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(tts_message.contains("누구에게 전화를 걸까?"));
		util.click(By.id("refresh"));
		Thread.sleep(2000);
		

	}
	
	@Test(description = "A. Hotfix Regression Test : 015-005-001 apollo_telephony_connetcall_001 수신자를 지정하지 않고 발신 요청 + 수신자 ENTITY 없는 발신 요청")
	public void TC_015_005_001(Method method) throws Exception {
		
		test.log(Status.INFO, "015-005-001 apollo_telephony_connetcall_001 수신자를 지정하지 않고 발신 요청 + 수신자 ENTITY 없는 발신 요청");
		System.out.println("015-005-001 apollo_telephony_connetcall_001 수신자를 지정하지 않고 발신 요청 + 수신자 ENTITY 없는 발신 요청");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-18931");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-18931");
		
		test.log(Status.INFO, "'전화' 발화 랜덤 명령어 전송");
		util.A_sendPost(util.ramdomCommand(Data.전화), uID, dID, ServerName);
		
		test.log(Status.INFO,"전화 발화 로그 조회");
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(tts_message.contains("누구에게 전화를 걸까?"));

		util.click(By.id("refresh"));
		Thread.sleep(2000);

	}
	
	@Test(description = "A. Hotfix Regression Test : 015-016-003 캐릭터 프로필 설정 영역 + 전화 프로필 설정 영역")
	public void TC_015_016_003(Method method) throws Exception {
		
		test.log(Status.INFO, "홈 화면 이동 확인");
		Thread.sleep(5000);
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		
		test.log(Status.INFO, "015-016-003 캐릭터 프로필 설정 영역 + 전화 프로필 설정 영역");
		System.out.println("015-016-003 캐릭터 프로필 설정 영역 + 전화 프로필 설정 영역");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-26137");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-26137");
		
		test.log(Status.INFO,"side menu button 버튼 클릭");
		util.click(By.id("left_menu_button"));
		
		test.log(Status.INFO,"캐릭터 프로필 설정 화면 진입");
		util.click(By.id("character_profile_setting"));
		
		test.log(Status.INFO,"캐릭터 이름 영역 확인");
		String TitleText =  util.getText(By.id("character_name_title_textview"));
		Assert.assertEquals(TitleText, "캐릭터 이름");
		
		test.log(Status.INFO,"캐릭터 이름 터치 후 '캐릭터 이름 설정' 화면 이동 확인");
		util.click(By.id("character_name_textview"));
		String TitleText1 =  util.getText(By.id("toolbar_title"));
		Assert.assertEquals(TitleText1, "캐릭터 이름");
		
		test.log(Status.INFO,"캐릭터 이름 9글자 입력 후 6글자 입력 적용 확인");
		util.type(By.id("character_name"), "에이닷에이닷에이닷"); 
		String character_name =  util.getText(By.id("character_name"));
		Assert.assertEquals(character_name, "에이닷에이닷");
		String name_size =  util.getText(By.id("name_size"));
		Assert.assertEquals(name_size, "6/6");
		
		test.log(Status.INFO,"저장 후 확인 복귀");
		util.click(By.id("btn_next"));
		
		test.log(Status.INFO,"캐릭터 배경 영역 확인");
		String character_bg_textview =  util.getText(By.id("character_bg_textview"));
		Assert.assertEquals(character_bg_textview, "캐릭터 배경");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("character_bg_item_recyclerview")));
		
		test.log(Status.INFO,"디폴트 캐릭터 배경외 항목 선택시 저장버튼 활성화 확인");
		util.click(By.xpath("//android.widget.TextView[contains(@text,'사무실')]"));
		util.getAttribute_Assertfunc(By.id("btn_save"), "enabled", "true");
		util.click(By.xpath("//android.widget.TextView[contains(@text,'빙하')]"));
		util.getAttribute_Assertfunc(By.id("btn_save"), "enabled", "false");
		
		
		test.log(Status.INFO,"캐릭터 모션 영역 확인");
		String character_motion_textview =  util.getText(By.id("character_motion_textview"));
		Assert.assertEquals(character_motion_textview, "캐릭터 모션");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("character_motion_item_recyclerview")));
		
		test.log(Status.INFO,"디폴트 캐릭터 모션외 항목 선택시 저장버튼 활성화 확인");
		util.click(By.xpath("//android.widget.TextView[contains(@text,'날개짓')]"));
		util.getAttribute_Assertfunc(By.id("btn_save"), "enabled", "true");
		util.click(By.xpath("//android.widget.TextView[contains(@text,'펭하')]"));
		util.getAttribute_Assertfunc(By.id("btn_save"), "enabled", "false");
		
		test.log(Status.INFO,"페이지 스크롤");
		util.scrollDown();
		
		test.log(Status.INFO,"T전화 프로필 설정 영역 확인");
		String username_textview =  util.getText(By.id("username_textview"));
		Assert.assertEquals(username_textview, "아폴로");
		String character_profile_title_textview =  util.getText(By.id("character_profile_title_textview"));
		Assert.assertEquals(character_profile_title_textview, "님의 T전화 프로필로 설정");
		util.click(By.id("character_profile_help_button"));
		
		test.log(Status.INFO,"T전화 프로필 안내 팝업 확인");
		String titleTextView =  util.getText(By.id("titleTextView"));
		Assert.assertEquals(titleTextView, "전화 프로필이란?");
		String contentTextView =  util.getText(By.id("contentTextView"));
		Assert.assertEquals(contentTextView, "내 A. 캐릭터를 T전화 프로필로 설정하는 기능입니다.\n"
				+ "통화 상대방이 T전화 화면에서 내 캐릭터를 볼 수 있어요");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("contentImage")));
		util.click(By.id("positiveButtonText"));
		
		test.log(Status.INFO,"T전화로 설정하러 가기 버튼 액션 동작 확인");
		util.click(By.id("phone_profile_button"));
		Thread.sleep(3000);
		//util.waitForIsElementPresent(By.id("capturing_title_textview")); //캐릭터 캡쳐중 ID
		String contentTextView1 =  util.getText(By.id("contentTextView"));
		Assert.assertEquals(contentTextView1, "T전화에서 최종 저장을 완료해주세요.\n"
				+ "T전화로 이동합니다.");
		util.click(By.id("positiveButtonText"));
		
		test.log(Status.INFO,"T전화 이동 페이지 확인");
		Assert.assertTrue(util.waitForActivity(".activities.setting.tservice.profile.ProfileSettingActivity"));
		util.Android_BackKey();
		util.click(By.xpath("//android.widget.TextView[contains(@resource-id, 'com.skt.prod.dialer:id/btnPositive')]"));
		util.Android_BackKey();
		util.Android_BackKey();
		util.Android_BackKey();
		
		
		test.log(Status.INFO,"에이닷 홈 이동 확인");
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		
		test.log(Status.INFO,"캐릭터 프로필 설정 화면 재 진입");
		util.click(By.id("left_menu_button"));
		util.click(By.id("character_profile_setting"));
		
		test.log(Status.INFO,"상단 캐릭터 설정 화면의 저장 버튼 클릭");
		util.click(By.id("save_image_button"));
		Thread.sleep(3000);
		//util.waitForIsElementPresent(By.id("capturing_title_textview")); //캐릭터 캡쳐중 ID
		
		test.log(Status.INFO,"상단 캐릭터 설정 저장 완료");
		String titleTextView1 =  util.getText(By.id("titleTextView"));
		Assert.assertEquals(titleTextView1, "저장 완료");
		String contentTextView2 =  util.getText(By.id("contentTextView"));
		Assert.assertEquals(contentTextView2, "업데이트된 내 캐릭터를\n"
				+ "T전화 프로필에도 반영할까요?");
		util.click(By.id("positiveButtonText"));
		
		test.log(Status.INFO,"최종 저장 안내 팝업");
		String contentTextView3 =  util.getText(By.id("contentTextView"));
		Assert.assertEquals(contentTextView3, "T전화에서 최종 저장을 완료해주세요.\n"
				+ "T전화로 이동합니다.");
		util.click(By.id("positiveButtonText"));
		
		test.log(Status.INFO,"T전화 이동 페이지 확인");
		Assert.assertTrue(util.waitForActivity(".activities.setting.tservice.profile.ProfileSettingActivity"));
		util.Android_BackKey();
		util.click(By.xpath("//android.widget.TextView[contains(@resource-id, 'com.skt.prod.dialer:id/btnPositive')]"));
		util.Android_BackKey();
		util.Android_BackKey();
		util.Android_BackKey();

		
	}


}
