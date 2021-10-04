package SDK_001_AudioPlayer_Interface;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import SDK_000_xPath.xPath;
import TestNG_Set.SDK_TestCase;
import junit.framework.Assert;

public class AudioPlayer_Interface_02_AudioPlayer_Template1 extends SDK_TestCase {
	
	String authToken;
	
	public void authToken얻기() throws Exception {
		
		test.log(Status.INFO, "Main 화면 CommandText에 [노래 들려줘] 입력하기 ");
		util.type(By.xpath(xPath.텍스트커맨드입력), "벅스에서 노래 들려줘");
		
		test.log(Status.INFO, "입력한 CommandText 실행");
		util.click(By.xpath(xPath.메인화면_커맨드입력_Enter));
		
		test.log(Status.INFO, "acceesToken 얻기"); 
	    String actn = util.authToken_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    
	    test.log(Status.INFO, "authToken : " + actn); 
	    System.out.println(actn);
	    authToken = actn;
	    
	    test.log(Status.INFO, "음악중단 [그만] 발화"); 
	    util.sendPost("그만", uID, SampleApp_did, ServerName, Place, authToken);
		
	}
	
	@Test
	public void TC_00_00_00_SampleApp_Start(Method method) throws Exception {
		
		test.log(Status.INFO, "다른앱 위에 그리기 권한 스킵");
	    util.Android_BackKey();
		
		test.log(Status.INFO, "AppActivity으로 화면 확인");
	    util.switchContext("NATIVE_APP");
	    
	    test.log(Status.INFO, "앱 실행 후 authToken 얻기 함수 실행");
	    authToken얻기();

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-49")
	public void TC_01_01_49_AudioPlayerTemplate1의_titleiconUrl_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-49 AudioPlayer.Template1의 title.iconUrl 확인");
		System.out.println("01-01-49 AudioPlayer.Template1의 title.iconUrl 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10660");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10660");
		
		test.log(Status.INFO, "[모든 음악 정지] 발화"); 
	    util.sendPost("모든 음악 정지", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(3000);
		
		test.log(Status.INFO, "[자우림의 나비 들려줘] 발화"); 
	    util.sendPost("자우림의 나비 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(5000);
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "directive값에 \"iconUrl\":https://cdn.sktnugu.com/aladdin/image/play/melon/melon_logo_60_line.png 확인"); 
	    String directive1 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive1.contains("\"iconUrl\":\"https://cdn.sktnugu.com/aladdin/image/play/melon/melon_logo_60_line.png"));
	    
	    test.log(Status.INFO, "player 상단 도메인 이미지 노출 확인"); 
	    boolean iv_logo = util.isElementPresent(By.id("iv_logo"));
	    Assert.assertTrue(iv_logo);


	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-50")
	public void TC_01_01_50_AudioPlayerTemplate1의_titletext_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-50 AudioPlayer.Template1의 title.iconUrl 확인");
		System.out.println("01-01-50 AudioPlayer.Template1의 title.iconUrl 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10661");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10661");
		
	    test.log(Status.INFO, "directive값에 \"text\":Melon"); 
	    String directive2 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive2.contains("\"text\":\"Melon"));
	    
	    test.log(Status.INFO, "player 상단 도메인 타이틀 노출 확인"); 
	    boolean tv_title = util.isElementPresent(By.id("tv_title"));
	    Assert.assertTrue(tv_title);

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-51")
	public void TC_01_01_51_AudioPlayerTemplate1의_contenttitle_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-51 AudioPlayer.Template1의 content.title 확인");
		System.out.println("01-01-51 AudioPlayer.Template1의 content.title 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10662");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10662");
		
	    test.log(Status.INFO, "directive값에 \"title\":나비"); 
	    String directive2 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive2.contains("\"title\":\"나비"));
	    
	    test.log(Status.INFO, "player 음원 타이틀 노출 확인"); 
	    boolean tv_header = util.isElementPresent(By.id("tv_header"));
	    Assert.assertTrue(tv_header);

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-52")
	public void TC_01_01_52_AudioPlayerTemplate1의_contensubtitle1_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-52 AudioPlayer.Template1의 content.subtitle1 확인");
		System.out.println("01-01-52 AudioPlayer.Template1의 content.subtitle1 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10664");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10664");
		
	    test.log(Status.INFO, "directive값에 \"subtitle1\":자우림"); 
	    String directive2 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive2.contains("\"subtitle1\":\"자우림"));
	    
	    test.log(Status.INFO, "player 음원 가수명 노출 확인"); 
	    boolean tv_body = util.isElementPresent(By.id("tv_body"));
	    Assert.assertTrue(tv_body);

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-53")
	public void TC_01_01_53_AudioPlayerTemplate1의_contensubtitle2_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-53 AudioPlayer.Template1의 content.subtitle2 확인");
		System.out.println("01-01-53 AudioPlayer.Template1의 content.subtitle2 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10665");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10665");
		
	    test.log(Status.INFO, "directive값에 \"subtitle2\":정규작업"); 
	    String directive2 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive2.contains("\"subtitle2\":\"B정규작업"));
	    
	    test.log(Status.INFO, "player 음원 앨범명 노출 확인"); 
	    boolean tv_footer = util.isElementPresent(By.id("tv_footer"));
	    Assert.assertTrue(tv_footer);

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-54")
	public void TC_01_01_54_AudioPlayerTemplate1의_contentimageUrl_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-54 AudioPlayer.Template1의 content.imageUrl 확인");
		System.out.println("01-01-54 AudioPlayer.Template1의 content.imageUrl 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10666");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10666");
		
	    test.log(Status.INFO, "directive값에 \"imageUrl\":https://cdnimg.melon.co.kr/cm/album/images/000/04/661/4661_500.jpg/melon/optimize/90"); 
	    String directive2 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive2.contains("\"imageUrl\":\"https://cdnimg.melon.co.kr/cm/album/images/000/04/661/4661_500.jpg/melon/optimize/90"));
	    
	    test.log(Status.INFO, "player 음원 앨범 이미지 노출 확인"); 
	    boolean iv_image = util.isElementPresent(By.id("iv_image"));
	    Assert.assertTrue(iv_image);

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-55")
	public void TC_01_01_55_AudioPlayerTemplate1의_contentdurationSec_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-55 AudioPlayer.Template1의 content.durationSec 확인");
		System.out.println("01-01-55 AudioPlayer.Template1의 content.durationSec 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10667");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10667");
		
	    test.log(Status.INFO, "directive값에 \"durationSec\":264"); 
	    String directive2 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive2.contains("\"durationSec\":\"264"));
	    
	    test.log(Status.INFO, "player 음원 프로그레스바 노출 확인"); 
	    boolean sb_progress = util.isElementPresent(By.id("sb_progress"));
	    Assert.assertTrue(sb_progress);
	    
	    test.log(Status.INFO, "player 음원 재생시간 노출 확인"); 
	    boolean tv_fulltime = util.isElementPresent(By.id("tv_fulltime"));
	    Assert.assertTrue(tv_fulltime);
	    
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-57")
	public void TC_01_01_57_AudioPlayerTemplate1의_contentbadgeImageUrl_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-55 AudioPlayer.Template1의 content.badgeImageUrl 확인");
		System.out.println("01-01-55 AudioPlayer.Template1의 content.badgeImageUrl 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10670");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10670");
		
		test.log(Status.INFO, "[지코의 유레카 들려줘] 발화"); 
	    util.sendPost("지코의 유레카 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(5000);
		
	    test.log(Status.INFO, "directive값에 \"badgeImageUrl\":https://cdn.sktnugu.com/aladdin/image/play/music/NU300/nu300_badge_19.png"); 
	    String directive2 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive2.contains("\"badgeImageUrl\":\"https://cdn.sktnugu.com/aladdin/image/play/music/NU300/nu300_badge_19.png"));
	    
	    test.log(Status.INFO, "player 음원 19금 뱃지 노출 확인"); 
	    boolean iv_badgeImage = util.isElementPresent(By.id("iv_badgeImage"));
	    Assert.assertTrue(iv_badgeImage);
	    
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-59")
	public void TC_01_01_59_AudioPlayerTemplate1의_contentlyricstitle_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-55 AudioPlayer.Template1의 content.lyrics.title 확인");
		System.out.println("01-01-59 AudioPlayer.Template1의 content.lyrics.title 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10672");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10672");
		
		test.log(Status.INFO, "[모든 음악 정지] 발화"); 
	    util.sendPost("모든 음악 정지", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(3000);
		
		test.log(Status.INFO, "[자우림의 나비 들려줘] 발화"); 
	    util.sendPost("자우림의 나비 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(5000);
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "가사 클릭"); 
	    util.click(By.id("rv_lyrics"));
	    
	    test.log(Status.INFO, "가사뷰 제목 타이틀 확인"); 
	    String viewTitle = util.getText(By.id("tv_lyrics_header"));
	    Assert.assertTrue(viewTitle.contains("나비 · 자우림"));
	    
	    test.log(Status.INFO, "directive값에 \"lyrics\":{\"title\":\"나비 · 자우림"); 
	    String directive2 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive2.contains("\"lyrics\":{\"title\":\"나비 · 자우림"));

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-60")
	public void TC_01_01_60_01_AudioPlayerTemplate1의_contentlyricslyricsType_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-60 AudioPlayer.Template1의 content.lyrics.lyricsType 확인");
		System.out.println("01-01-60 AudioPlayer.Template1의 content.lyrics.lyricsType 확인");
		
		test.log(Status.INFO, "가사 동기화 음악 재생"); 
		
	    test.log(Status.INFO, "directive값에 \"lyricsType\":\"SYNC"); 
	    String directive2 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive2.contains("\"lyricsType\":\"SYNC"));

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-60")
	public void TC_01_01_60_02_AudioPlayerTemplate1의_contentlyricslyricsType_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-60 AudioPlayer.Template1의 content.lyrics.lyricsType 확인");
		System.out.println("01-01-60 AudioPlayer.Template1의 content.lyrics.lyricsType 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10673");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10673");
		
		test.log(Status.INFO, "[모든 음악 정지] 발화"); 
	    util.sendPost("모든 음악 정지", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(3000);
		
	    test.log(Status.INFO, "가사 미동기화 음악 재생"); 
		test.log(Status.INFO, "[아기 상어 노래 들려줘 ] 발화"); 
	    util.sendPost("아기 상어 노래 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(5000);
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "가사 전체보기 클릭"); 
	    util.click(By.id("tv_show_lyrics"));
 
	    test.log(Status.INFO, "directive값에 \"lyricsType\":\"NON_SYNC"); 
	    String directive2 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive2.contains("\"lyricsType\":\"NON_SYNC"));

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-60")
	public void TC_01_01_60_03_AudioPlayerTemplate1의_contentlyricslyricsType_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-60 AudioPlayer.Template1의 content.lyrics.lyricsType 확인");
		System.out.println("01-01-60 AudioPlayer.Template1의 content.lyrics.lyricsType 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10673");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10673");
		
		test.log(Status.INFO, "[모든 음악 정지] 발화"); 
	    util.sendPost("모든 음악 정지", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(3000);
		
	    test.log(Status.INFO, "가사 없는 음악 재생"); 
		test.log(Status.INFO, "[클래식 음악 들려줘 ] 발화"); 
	    util.sendPost("클래식 음악 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(5000);
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "[가사 보여줘] 발화"); 
	    util.sendPost("가사 보여줘", uID, SampleApp_did, ServerName, Place, authToken);
 
	    test.log(Status.INFO, "directive값에 \"lyricsType\":\"NONE"); 
	    String directive2 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive2.contains("\"lyricsType\":\"NONE"));

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-61")
	public void TC_01_01_61_01_AudioPlayerTemplate1의_contentlyricslyricsInfoList_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-61 AudioPlayer.Template1의 content.lyrics.lyricsInfoList  확인");
		System.out.println("01-01-61 AudioPlayer.Template1의 content.lyrics.lyricsInfoList  확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10676");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10676");
		
		test.log(Status.INFO, "[모든 음악 정지] 발화"); 
	    util.sendPost("모든 음악 정지", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(3000);
		
	    test.log(Status.INFO, "가사 미동기화 음악 재생"); 
		test.log(Status.INFO, "[아기 상어 노래 들려줘 ] 발화"); 
	    util.sendPost("아기 상어 노래 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(5000);
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "가사 전체보기 클릭"); 
	    util.click(By.id("tv_show_lyrics"));
 
	    test.log(Status.INFO, "directive값에 lyricsInfoList 확인"); 
	    String directive2 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive2.contains("\"lyricsInfoList\":"));

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-61")
	public void TC_01_01_61_02_AudioPlayerTemplate1의_contentlyricslyricsInfoList_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-61 AudioPlayer.Template1의 content.lyrics.lyricsInfoList  확인");
		System.out.println("01-01-61 AudioPlayer.Template1의 content.lyrics.lyricsInfoList  확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10676");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10676");
		
		test.log(Status.INFO, "[모든 음악 정지] 발화"); 
	    util.sendPost("모든 음악 정지", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(3000);
		
	    test.log(Status.INFO, "가사 동기화 음악 재생"); 
		test.log(Status.INFO, "[자우림의 나비 들려줘 ] 발화"); 
	    util.sendPost("자우림의 나비 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(5000);
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "가사 클릭"); 
	    util.click(By.id("cv_small_lyrics"));
 
	    test.log(Status.INFO, "directive값에 lyricsInfoList 확인"); 
	    String directive2 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive2.contains("\"lyricsInfoList\":"));

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-62")
	public void TC_01_01_62_01_AudioPlayerTemplate1의_contentlyricslyricsInfoListtime_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-62 AudioPlayer.Template1의 content.lyrics.lyricsInfoList.time   확인");
		System.out.println("01-01-62 AudioPlayer.Template1의 content.lyrics.lyricsInfoList.time   확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10677");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10677");
		
		test.log(Status.INFO, "[모든 음악 정지] 발화"); 
	    util.sendPost("모든 음악 정지", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(3000);
		
	    test.log(Status.INFO, "가사 미동기화 음악 재생"); 
		test.log(Status.INFO, "[아기 상어 노래 들려줘 ] 발화"); 
	    util.sendPost("아기 상어 노래 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(5000);
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "가사 전체보기 클릭"); 
	    util.click(By.id("tv_show_lyrics"));
 
	    test.log(Status.INFO, "directive값에 lyricsInfoList.time 확인"); 
	    String directive2 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive2.contains("{\"text\":\"아기 상어\"}"));

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-62")
	public void TC_01_01_62_02_AudioPlayerTemplate1의_contentlyricslyricsInfoListtime_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-62 AudioPlayer.Template1의 content.lyrics.lyricsInfoList.time   확인");
		System.out.println("01-01-62 AudioPlayer.Template1의 content.lyrics.lyricsInfoList.time   확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10677");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10677");
		
		test.log(Status.INFO, "[모든 음악 정지] 발화"); 
	    util.sendPost("모든 음악 정지", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(3000);
		
	    test.log(Status.INFO, "가사 동기화 음악 재생"); 
		test.log(Status.INFO, "[자우림의 나비 들려줘 ] 발화"); 
	    util.sendPost("자우림의 나비 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(5000);
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "가사 클릭"); 
	    util.click(By.id("cv_small_lyrics"));
 
	    test.log(Status.INFO, "directive값에 lyricsInfoList.time 확인"); 
	    String directive2 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive2.contains("\"time\":1,\"text\":\"나비 - 자우림"));

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-63")
	public void TC_01_01_63_AudioPlayerTemplate1의_contentlyricslyricsInfoListtext_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-63 AudioPlayer.Template1의 content.lyrics.lyricsInfoList.text   확인");
		System.out.println("01-01-63 AudioPlayer.Template1의 content.lyrics.lyricsInfoList.text   확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10679");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10679");
 
	    test.log(Status.INFO, "directive값에 lyricsInfoList.text 확인"); 
	    String directive2 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive2.contains("\"time\":1,\"text\":\"나비 - 자우림"));

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-64")
	public void TC_01_01_64_AudioPlayerTemplate1의_contentlyricslyricsInfoListshowButton_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-64 AudioPlayer.Template1의 content.lyrics.lyricsInfoList.showButton   확인");
		System.out.println("01-01-64 AudioPlayer.Template1의 content.lyrics.lyricsInfoList.showButton   확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10680");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10680");
 
		test.log(Status.INFO, "[모든 음악 정지] 발화"); 
	    util.sendPost("모든 음악 정지", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(3000);
		
	    test.log(Status.INFO, "가사 동기화 음악 재생"); 
		test.log(Status.INFO, "[자우림의 나비 들려줘 ] 발화"); 
	    util.sendPost("자우림의 나비 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(5000);
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "가사 전체보기 버튼 미노출 확인"); 
	    boolean tv_show_lyrics1 = util.isElementPresent(By.id("tv_show_lyrics"));
	    Assert.assertFalse(tv_show_lyrics1);
	    
	    test.log(Status.INFO, "가사 미동기화 음악 재생"); 
		test.log(Status.INFO, "[아기 상어 노래 들려줘 ] 발화"); 
	    util.sendPost("아기 상어 노래 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(5000);
	    
	    test.log(Status.INFO, "가사 전체보기 버튼 노출 확인"); 
	    boolean tv_show_lyrics2 = util.isElementPresent(By.id("tv_show_lyrics"));
	    Assert.assertTrue(tv_show_lyrics2);
	    
	    test.log(Status.INFO, "가사 없는 음악 재생"); 
		test.log(Status.INFO, "[클래식 음악 들려줘 ] 발화"); 
	    util.sendPost("클래식 음악 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(5000);
	    
	    test.log(Status.INFO, "가사 전체보기 버튼 미노출 확인"); 
	    boolean tv_show_lyrics3 = util.isElementPresent(By.id("tv_show_lyrics"));
	    Assert.assertFalse(tv_show_lyrics3);

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-65")
	public void TC_01_01_65_좋아요미지원Play_AudioPlayerTemplate1의_settingsfavorite_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-65 좋아요 미지원 Play AudioPlayer.Template1의 settings.favorite 확인");
		System.out.println("01-01-65 좋아요 미지원 Play AudioPlayer.Template1의 settings.favorite 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10681");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10681");
 
		test.log(Status.INFO, "[ASMR] 발화"); 
	    util.sendPost("ASMR", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "좋아요 버튼 미노출 확인"); 
	    boolean iv_favorite = util.isElementPresent(By.id("iv_favorite"));
	    Assert.assertFalse(iv_favorite);
	    
	    test.log(Status.INFO, "directive값에 \"settings\":{\"favorite 미노출 확인"); 
	    String directive2 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertFalse(directive2.contains("\"settings\":{\"favorite"));
	    
	    test.log(Status.INFO, "[누구 DJ 들려줘] 발화"); 
	    util.sendPost("누구 DJ 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "좋아요 버튼 미노출 확인"); 
	    boolean iv_favorite2 = util.isElementPresent(By.id("iv_favorite"));
	    Assert.assertFalse(iv_favorite2);
	    
	    test.log(Status.INFO, "directive값에 \"settings\":{\"favorite 미노출 확인"); 
	    String directive1 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertFalse(directive1.contains("\"settings\":{\"favorite"));
		

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-66")
	public void TC_01_01_66_좋아요지원Play_AudioPlayerTemplate1의_settingsfavorite_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-65 좋아요 미지원 Play AudioPlayer.Template1의 settings.favorite 확인");
		System.out.println("01-01-65 좋아요 미지원 Play AudioPlayer.Template1의 settings.favorite 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10682");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10682");
 
		test.log(Status.INFO, "[멜론에서 노래 들려줘] 발화"); 
	    util.sendPost("멜론에서 노래 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "좋아요 버튼 노출 확인"); 
	    boolean iv_favorite = util.isElementPresent(By.id("iv_favorite"));
	    Assert.assertTrue(iv_favorite);
	    
	    test.log(Status.INFO, "directive값에 \"settings\":{\"favorite 노출 확인"); 
	    String directive2 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive2.contains("\"settings\":{\"favorite"));
	    
	    test.log(Status.INFO, "[오디오북 들려줘] 발화"); 
	    util.sendPost("오디오북 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "좋아요 버튼 노출 확인"); 
	    boolean iv_favorite2 = util.isElementPresent(By.id("iv_favorite"));
	    Assert.assertTrue(iv_favorite2);
	    
	    test.log(Status.INFO, "directive값에 \"settings\":{\"favorite 노출 확인"); 
	    String directive1 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive1.contains("\"settings\":{\"favorite"));

	    test.log(Status.INFO, "[팟캐스트 들려줘] 발화"); 
	    util.sendPost("팟캐스트 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "좋아요 버튼 노출 확인"); 
	    boolean iv_favorite3 = util.isElementPresent(By.id("iv_favorite"));
	    Assert.assertTrue(iv_favorite3);
	    
	    test.log(Status.INFO, "directive값에 \"settings\":{\"favorite 노출 확인"); 
	    String directive3 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive3.contains("\"settings\":{\"favorite"));
	    
	    test.log(Status.INFO, "[라디오 들려줘] 발화"); 
	    util.sendPost("라디오 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "좋아요 버튼 노출 확인"); 
	    boolean iv_favorite4 = util.isElementPresent(By.id("iv_favorite"));
	    Assert.assertTrue(iv_favorite4);
	    
	    test.log(Status.INFO, "directive값에 \"settings\":{\"favorite 노출 확인"); 
	    String directive4 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive4.contains("\"settings\":{\"favorite"));
		

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-67")
	public void TC_01_01_67_Play_AudioPlayerTemplate1의_settingsfavorite_변동값확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-67 Play AudioPlayer.Template1의 settings.favorite 변동 값 확인");
		System.out.println("01-01-67 Play AudioPlayer.Template1의 settings.favorite 변동 값 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10684");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10684");
		
		test.log(Status.INFO, "[자우림 미안해 널 미워해 들려줘] 발화"); 
	    util.sendPost("자우림 미안해 널 미워해 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "directive값에 \"favorite\":false 확인"); 
	    String directive = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive.contains("\"favorite\":false"));
	    
	    test.log(Status.INFO, "[노래 그만 ] 발화"); 
	    util.sendPost("노래 그만", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "[멜론에서 좋아요한 노래 들려줘] 발화"); 
	    util.sendPost("노래 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "directive값에 \"favorite\":true 확인"); 
	    String directive1 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive1.contains("\"favorite\":true"));

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-68")
	public void TC_01_01_68_Play_AudioPlayerTemplate1의_settingsrepeat_변동값확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-68 Play AudioPlayer.Template1의 settings.repeat 변동 값 확인");
		System.out.println("01-01-68 Play AudioPlayer.Template1의 settings.repeat 변동 값 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10685");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10685");
		
		test.log(Status.INFO, "[노래 들려줘] 발화"); 
	    util.sendPost("노래 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "[iv_repeat] 클릭"); 
	    util.click(By.id("iv_repeat"));
	    
	    test.log(Status.INFO, "directive값에 \"repeat\\\":\"ONE\" 확인"); 
	    String directive = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive.contains("\"repeat\":\"ONE\""));
	    
	    test.log(Status.INFO, "[iv_repeat] 클릭"); 
	    util.click(By.id("iv_repeat"));
	    
	    test.log(Status.INFO, "directive값에 \"repeat\":\"NONE\" 확인"); 
	    String directive2 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive2.contains("\"repeat\":\"NONE\""));
	    
	    test.log(Status.INFO, "[iv_repeat] 클릭"); 
	    util.click(By.id("iv_repeat"));
	    
	    test.log(Status.INFO, "directive값에 \"repeat\":\"ALL\" 확인"); 
	    String directive3 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive3.contains("\"repeat\":\"ALL\""));
	    

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-68")
	public void TC_01_01_69_Play_AudioPlayerTemplate1의_settingsshuffle_변동값확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-69 Play AudioPlayer.Template1의 settings.shuffle 변동 값 확인");
		System.out.println("01-01-69 Play AudioPlayer.Template1의 settings.shuffle 변동 값 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10686");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10686");
		
		test.log(Status.INFO, "[노래 들려줘] 발화"); 
	    util.sendPost("노래 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(3000);
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "directive값에 \"shuffle\":false 확인"); 
	    String directive1 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive1.contains("\"shuffle\":false"));
	    
	    test.log(Status.INFO, "[셔플 해줘] 발화"); 
	    util.sendPost("셔플 해줘", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "directive값에 \"shuffle\":true 확인"); 
	    String directive2 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive2.contains("\"shuffle\":true"));
	    
	    test.log(Status.INFO, "[셔플 해제] 발화"); 
	    util.sendPost("셔플 해제", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "directive값에 \"shuffle\":false 확인"); 
	    String directive3 = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive3.contains("\"shuffle\":false"));
	    

	}
	
	
	

}
