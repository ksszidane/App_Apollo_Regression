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

public class Apollo_05_공통 extends APOLLO_TestCase {
	
	@Test(description = "A. Hotfix Regression Test : 020-001-006 Voice_6")
	public void TC_020_001_006(Method method) throws Exception {
		
		test.log(Status.INFO, "020-001-006 Voice_6");
		System.out.println("020-001-006 Voice_6");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-19511");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-19511");
		
		test.log(Status.INFO, "홈 화면 이동 확인");
		Thread.sleep(5000);
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		
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
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("voice_chrome")));
		util.Android_BackKey();
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 020-002-001 Voice_8")
	public void TC_020_002_001(Method method) throws Exception {
		
		test.log(Status.INFO, "020-002-001 Voice_8");
		System.out.println("020-002-001 Voice_8");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-19513");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-19513");
		
		throw new SkipException("Skipping this exception");
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 020-002-017 Voice_24")
	public void TC_020_002_017(Method method) throws Exception {
		
		test.log(Status.INFO, "020-002-017 Voice_24");
		System.out.println("020-002-017 Voice_24");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-25645");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-25645");
		
		throw new SkipException("Skipping this exception");
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 021-001-001 Small talk_1 Default")
	public void TC_021_001_001(Method method) throws Exception {
		
		test.log(Status.INFO, "021-001-001 Small talk_1 Default");
		System.out.println("021-001-001 Small talk_1 Default");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-19452");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-19452");
		
		throw new SkipException("Skipping this exception");
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 022-001-002 Player_2 AOS_다른앱 위에 그리기 설정 +  floating Audio Player")
	public void TC_022_001_002(Method method) throws Exception {
		
		test.log(Status.INFO, "022-001-002 Player_2 AOS_다른앱 위에 그리기 설정 +  floating Audio Player");
		System.out.println("022-001-002 Player_2 AOS_다른앱 위에 그리기 설정 +  floating Audio Player");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-19452");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-19452");
		
		test.log(Status.INFO, "2 TestCase ");
		test.log(Status.INFO, "2 TestCase ");
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 023-002-003 UNSAFE_INSULT + 욕설/비하/비속어 + 반말")
	public void TC_023_002_003(Method method) throws Exception {
		
		test.log(Status.INFO, "023-002-003 UNSAFE_INSULT + 욕설/비하/비속어 + 반말");
		System.out.println("023-002-003 UNSAFE_INSULT + 욕설/비하/비속어 + 반말");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-20044");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-20044");
		
		test.log(Status.INFO, "'욕설' 발화 랜덤 명령어 전송");
		String 발화 = util.ramdomCommand(Data.욕설);
		util.A_sendPost(발화, uID, dID, ServerName);
		
		test.log(Status.INFO, "'TTS 및 모션 확인");
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(util.dataCheck_Contains(tts_message, Data.욕설TTS_set));
		Assert.assertTrue(util.dataCheck_Contains(util.Motion_JsonParsing(uID, dID, ServerName, Service, 발화), Data.욕설모션코드_set));
		
		test.log(Status.INFO, "1 TestCase ");
		test.log(Status.INFO, "1 TestCase ");
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 024-002-001 wiki_search_001 키워드 검색 + 검색 결과 있음(SQA)")
	public void TC_024_002_001(Method method) throws Exception {
		
		test.log(Status.INFO, "024-002-001 wiki_search_001 키워드 검색 + 검색 결과 있음(SQA)");
		System.out.println("0024-002-001 wiki_search_001 키워드 검색 + 검색 결과 있음(SQA)");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-20044");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-20044");
		
		test.log(Status.INFO, "홈 화면 이동 확인");
		Thread.sleep(5000);
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		
		test.log(Status.INFO, "'이순신이 누구야' 발화 랜덤 명령어 전송");
		util.A_sendPost("이순신이 누구야", uID, dID, ServerName);
		
		test.log(Status.INFO, "템플릿 구성 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("card_container")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text,'이순신')]")));
		
		test.log(Status.INFO, "'TTS 및 모션 확인 및 템플릿타입 확");
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(tts_message.contains("궁금한게 있으면 또 물어봐"));
		Assert.assertTrue(util.Motion_JsonParsing(uID, dID, ServerName, Service, "이순신이 누구야").contains("Talk_0001"));
		Assert.assertTrue(util.TemplateType_JsonParsing(uID, dID, ServerName, Service, "이순신이 누구야").contains("CardFullTextScrollable"));
		
		test.log(Status.INFO, "1 TestCase ");
		test.log(Status.INFO, "1 TestCase ");
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 028-003-002 apolloVideo_search_title_007 장르 + 콘텐츠명 확장 + 웨이브에서 포함")
	public void TC_028_003_002(Method method) throws Exception {
		
		test.log(Status.INFO, "028-003-002 apolloVideo_search_title_007 장르 + 콘텐츠명 확장 + 웨이브에서 포함");
		System.out.println("028-003-002 apolloVideo_search_title_007 장르 + 콘텐츠명 확장 + 웨이브에서 포함");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-23150");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-23150");
		
		test.log(Status.INFO, "홈 화면 이동 확인");
		Thread.sleep(5000);
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		
		test.log(Status.INFO, "'웨이브에서 영화 해리포터 찾아줘' 발화 랜덤 명령어 전송");
		util.A_sendPost("웨이브에서 영화 해리포터 찾아줘", uID, dID, ServerName);
		
		test.log(Status.INFO, "템플릿 구성 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("stack_container")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("contents")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text,'영화')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text,'YouTube')]")));
		
		test.log(Status.INFO, "'TTS 및 모션 확인 및 템플릿타입 확");
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(tts_message.contains("영화 해리포터로 찾아 봤어"));
		Assert.assertTrue(util.Motion_JsonParsing(uID, dID, ServerName, Service, "웨이브에서 영화 해리포터 찾아줘").contains("Btv_0001"));
		Assert.assertTrue(util.TemplateType_JsonParsing(uID, dID, ServerName, Service, "웨이브에서 영화 해리포터 찾아줘").contains("HorizontalListGroupImageText"));
		
		test.log(Status.INFO, "1 TestCase ");
		test.log(Status.INFO, "1 TestCase ");
	}
	
	@Test(description = "A. Hotfix Regression Test : 028-003-002 apolloVideo_search_title_007 장르 + 콘텐츠명 확장 + 웨이브에서 포함")
	public void TC_028_005_001(Method method) throws Exception {
		
		test.log(Status.INFO, "028-005-001 apolloVideo_recommend_001 추천 기능 + 영화/드라마 X + 키워드 X");
		System.out.println("028-005-001 apolloVideo_recommend_001 추천 기능 + 영화/드라마 X + 키워드 X");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-22534");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-22534");
		
		test.log(Status.INFO, "홈 화면 이동 확인");
		Thread.sleep(5000);
		util.waitForIsElementPresent(By.xpath(xPath.에이닷_홈));
		
		test.log(Status.INFO, "'볼만한 거 추천해줘' 발화 랜덤 명령어 전송");
		util.A_sendPost("볼만한 거 추천해줘", uID, dID, ServerName);
		
		test.log(Status.INFO, "템플릿 구성 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("stack_container")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("contents")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text,'A.tv')]")));
		util.getAttribute_Assertfunc(By.xpath("//android.widget.TextView[contains(@text,'A.tv')]"), "selected", "true");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text,'YouTube')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text,'영화')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text,'프로그램')]")));
		
		test.log(Status.INFO, "'TTS 및 모션 확인 및 템플릿타입 확");
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(tts_message.contains("좋아할만한 동영상 콘텐츠를 모아봤어."));
		Assert.assertTrue(util.Motion_JsonParsing(uID, dID, ServerName, Service, "볼만한 거 추천해줘").contains("Btv_0001"));
		Assert.assertTrue(util.TemplateType_JsonParsing(uID, dID, ServerName, Service, "볼만한 거 추천해줘").contains("HorizontalListGroupImageText"));
		
		test.log(Status.INFO, "2 TestCase ");
		test.log(Status.INFO, "2 TestCase ");
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 028-006-002 apolloVideo_search_recent_002 최근 본 VOD 있음 + 조회 기능 (술어 없는 \"내가 봤던\", \"최근 시청\" 등)")
	public void TC_028_006_002(Method method) throws Exception {
		
		test.log(Status.INFO, "028-006-002 apolloVideo_search_recent_002 최근 본 VOD 있음 + 조회 기능 (술어 없는 \"내가 봤던\", \"최근 시청\" 등)");
		System.out.println("028-006-002 apolloVideo_search_recent_002 최근 본 VOD 있음 + 조회 기능 (술어 없는 \"내가 봤던\", \"최근 시청\" 등)");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-22540");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-22540");
		
		test.log(Status.INFO, "0 TestCase ");
		test.log(Status.INFO, "0 TestCase ");
		
		throw new SkipException("테스트 계정 웨이브 서비스 연결 이슈로 테스트 스킵");
	
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 028-018-002 유투브 기본발화")
	public void TC_028_018_002(Method method) throws Exception {
		
		test.log(Status.INFO, "028-018-002 유투브 기본발화)");
		System.out.println("028-018-002 유투브 기본발화)");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-28549");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-28549");
		
		test.log(Status.INFO, "'유튜브에서 그해 우리는 찾아줘' 발화 랜덤 명령어 전송");
		util.A_sendPost("유튜브에서 그해 우리는 찾아줘", uID, dID, ServerName);
		
		test.log(Status.INFO, "템플릿 구성 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("stack_container")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("contents")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("caption")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text,'YouTube')]")));
		util.getAttribute_Assertfunc(By.xpath("//android.widget.TextView[contains(@text,'YouTube')]"), "selected", "true");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text,'프로그램')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TextView[contains(@text,'YouTube는 SKT 데이터 통화료 무료제공 대상에 포함되지 않습니다.')]")));
		
		test.log(Status.INFO, "유튜브 이동 확인 ");
		util.click(By.id("card"));
		Thread.sleep(1500);
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.Button[contains(@text,'YouTube 검색')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.view.View[contains(@content-desc, 'YouTube')]")));
		
		test.log(Status.INFO, "유튜브 종료 ");
		util.click(By.id("toolbar_button_close"));
		
		test.log(Status.INFO, "2 TestCase ");
		test.log(Status.INFO, "2 TestCase ");
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 030-003-002 screen_tworld_payment_002 요금 조회 메인")
	public void TC_030_003_002(Method method) throws Exception {
		
		test.log(Status.INFO, "030-003-002 screen_tworld_payment_002 요금 조회 메인");
		System.out.println("030-003-002 screen_tworld_payment_002 요금 조회 메인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-20397");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-20397");
		
		test.log(Status.INFO, "0 TestCase ");
		test.log(Status.INFO, "0 TestCase ");
		
		throw new SkipException("테스트 계정 및 STG서버 계정 문제로 T월드 테스트 스킵");
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 031-003-001 VIP Pick 진입 프로세스")
	public void TC_031_003_001(Method method) throws Exception {
		
		test.log(Status.INFO, "031-003-001 VIP Pick 진입 프로세스");
		System.out.println("031-003-001 VIP Pick 진입 프로세스");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-21429");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-21429");
		
		test.log(Status.INFO, "0 TestCase ");
		test.log(Status.INFO, "0 TestCase ");
		
		throw new SkipException("테스트 계정 및 STG서버 계정 문제로 T멤버쉽 테스트 스킵");
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 031-005-001 T Day 웹뷰 시나리오")
	public void TC_031_005_001(Method method) throws Exception {
		
		test.log(Status.INFO, "031-005-001 T Day 웹뷰 시나리오");
		System.out.println("031-005-001 T Day 웹뷰 시나리오");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-21428");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-21428");
		
		test.log(Status.INFO, "0 TestCase ");
		test.log(Status.INFO, "0 TestCase ");
		
		throw new SkipException("테스트 계정 및 STG서버 계정 문제로 T멤버쉽 테스트 스킵");
		
		
		
	}
	
	@Test(description = "A. Hotfix Regression Test : 032-002-001 공유하기 Flow_1")
	public void TC_032_002_001(Method method) throws Exception {
		
		test.log(Status.INFO, "032-002-001 공유하기 Flow_1");
		System.out.println("032-002-001 공유하기 Flow_1");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-21536");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-21536");
		
		test.log(Status.INFO,"더보기 버튼 클릭");
		util.click(By.id("more_button"));
		
		test.log(Status.INFO,"OS 공유 피커 노출 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.widget.TabHost[contains(@resource-id, 'profile_tabhost')]")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.xpath("//android.view.View[contains(@resource-id, 'sem_chooser_preview_icon')]")));
		String text1 = util.getText(By.xpath("//android.widget.TextView[contains(@resource-id, 'android:id/text1')]"));
		Assert.assertEquals(text1, "일상의 디지털 메이트, 에이닷");
		String text2 = util.getText(By.xpath("//android.widget.TextView[contains(@resource-id, 'android:id/text2')]"));
		Assert.assertTrue(text2.contains("A.(에이닷)"));
		
		
		util.Android_BackKey();
		
		test.log(Status.INFO, "1 TestCase ");
		test.log(Status.INFO, "1 TestCase ");

	}
	
	@Test(description = "A. Hotfix Regression Test : 033-003-001 sch_301 날짜 특정하지 않은 경우")
	public void TC_033_003_001(Method method) throws Exception {
		
		test.log(Status.INFO, "033-003-001 sch_301 날짜 특정하지 않은 경우");
		System.out.println("033-003-001 sch_301 날짜 특정하지 않은 경우");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-21779");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-21779");
		
		test.log(Status.INFO, "'무슨 요일이야?' 발화 랜덤 명령어 전송");
		util.A_sendPost("무슨 요일이야?", uID, dID, ServerName);
		
		test.log(Status.INFO, "'TTS 및 모션 확인");
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(util.dataCheck_Contains(tts_message, Data.요일TTS_set));
		
		test.log(Status.INFO, "1 TestCase ");
		test.log(Status.INFO, "1 TestCase ");

	}
	
	@Test(description = "A. Hotfix Regression Test : 034-002-001 time_domain_default time_now_main_001 time_now_main_002 time_now_main_003 도메인 명만 발화 + 시간 안내")
	public void TC_034_002_001(Method method) throws Exception {
		
		test.log(Status.INFO, "034-002-001 time_domain_default time_now_main_001 time_now_main_002 time_now_main_003 도메인 명만 발화 + 시간 안내");
		System.out.println("034-002-001 time_domain_default time_now_main_001 time_now_main_002 time_now_main_003 도메인 명만 발화 + 시간 안내");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-21761");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-21761");
		
		test.log(Status.INFO, "시간' 발화 랜덤 명령어 전송");
		util.A_sendPost("시간", uID, dID, ServerName);
		
		test.log(Status.INFO, "템플릿 구성 확인");
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("time")));
		Assert.assertTrue(util.isElementPresent_Assertfunc(By.id("image")));
		
		test.log(Status.INFO, "'TTS 및 모션 확인");
		String tts_message = util.getText(By.id("message"));
		Assert.assertTrue(tts_message.contains("시간을 알려줄게"));
		Assert.assertTrue(util.Motion_JsonParsing(uID, dID, ServerName, Service, "시간").contains("TimeResult_0001"));
		
		test.log(Status.INFO, "1 TestCase ");
		test.log(Status.INFO, "1 TestCase ");

	}

}
