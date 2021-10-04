package SDK_001_AudioPlayer_Interface;

import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import SDK_000_xPath.xPath;
import TestNG_Set.SDK_TestCase;
import junit.framework.Assert;

public class AudioPlayer_Interface_01_공통 extends SDK_TestCase {
	
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
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-01")
	public void TC_01_01_01_AudioState_IDLE에서_PLAYING_전환확인(Method method) throws Exception {
		
		test.log(Status.INFO, "01_01_01_Audio State IDLE에서 PLAYING 전환 확인");
		System.out.println("01_01_01_Audio State IDLE에서 PLAYING 전환 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10388");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10388");

	    test.log(Status.INFO, "[노래 들러줘] 발화"); 
	    util.sendPost("노래 들러줘", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "AudioPlayer.Play directive_info 값 확인"); 
	    String directive = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive.contains("AudioPlayer.Play"));
	    
	    test.log(Status.INFO, "bar_player 값 확인"); 
	    boolean bar_player = util.isElementPresent(By.id("bar_player"));
	    Assert.assertTrue(bar_player);

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-02")
	public void TC_01_01_02_AudioState_PLAYING에서_PAUSED_전환확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-02 Audio State PLAYING에서 PAUSED 전환 확인");
		System.out.println("01-01-02 Audio State PLAYING에서 PAUSED 전환 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10389");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10389");
	    
	    test.log(Status.INFO, "[일시정지] 발화"); 
	    util.sendPost("일시정지", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "AudioPlayer.Pause directive_info 값 확인"); 
	    String directive = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive.contains("AudioPlayer.Pause"));
	    
	    test.log(Status.INFO, "bar_player 일시정지(재생)버튼 확인"); 
	    boolean btn_bar_play = util.isElementPresent(By.id("btn_bar_play"));
	    Assert.assertTrue(btn_bar_play);

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-03")
	public void TC_01_01_03_AudioState_PAUSED에서_PLAYING_전환확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-03 Audio State PAUSED에서 PLAYING 전환 확인");
		System.out.println("01-01-03 Audio State PAUSED에서 PLAYING 전환 확인");
	    
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10390");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10390");
		
	    test.log(Status.INFO, "[이어서 들려줘] 발화"); 
	    util.sendPost("이어서 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "AudioPlayer.Play directive_info 값 확인"); 
	    String directive = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive.contains("AudioPlayer.Play"));
	    
	    test.log(Status.INFO, "audio_activity PLAYING 상태 확인"); 
	    String audio_activity = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    Assert.assertTrue(audio_activity.contains("PLAYING"));

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-04")
	public void TC_01_01_04_AudioState_PLAYING에서_STOP_전환확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-04 Audio State PLAYING에서 STOP전환 확인");
		System.out.println("01-01-04 Audio State PLAYING에서 STOP전환 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10391");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10391");
		
		test.log(Status.INFO, "[그만] 발화"); 
	    util.sendPost("그만", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "AudioPlayer.Stop directive_info 값 확인"); 
	    String directive = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive.contains("AudioPlayer.Stop"));
	    
	    test.log(Status.INFO, "audio_activity STOPPED 상태 확인"); 
	    String audio_activity = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    Assert.assertTrue(audio_activity.contains("STOPPED"));

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-05")
	public void TC_01_01_05_AudioState_PAUSED에서_STOP_전환확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-05 Audio State PAUSED에서 STOP 전환 확인");
		System.out.println("01-01-05 Audio State PAUSED에서 STOP 전환 확인");
	    
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10392");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10392");
		
	    test.log(Status.INFO, "[노래 들러줘] 발화"); 
	    util.sendPost("노래 들러줘", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "[일시정지] 발화"); 
	    util.sendPost("일시정지", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "audio_activity PAUSED 상태 확인"); 
	    String audio_activity1 = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    Assert.assertTrue(audio_activity1.contains("PAUSED"));
	    
	    test.log(Status.INFO, "[그만] 발화"); 
	    util.sendPost("그만", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "AudioPlayer.Stop directive_info 값 확인"); 
	    String directive = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive.contains("AudioPlayer.Stop"));
	    
	    test.log(Status.INFO, "audio_activity STOPPED 상태 확인"); 
	    String audio_activity2 = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    Assert.assertTrue(audio_activity2.contains("STOPPED"));

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-06")
	public void TC_01_01_06_AudioState_PLAYING에서_FINISHED_전환확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-06 Audio State PLAYING 에서 FINISHED 전환 확인");
		System.out.println("01-01-06 Audio State PLAYING 에서 FINISHED 전환 확인");
	    
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10393");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10393");
		
	    test.log(Status.INFO, "[sk텔레콤 관련 뉴스 들려줘] 발화"); 
	    util.sendPost("sk텔레콤 관련 뉴스 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    String TTS = "";
	    int i = 0;
	    test.log(Status.INFO, "다음 뉴스가 재생될때까지 대기 체크");
	    while(!TTS.contains("다음 뉴스")) {
	    	int count = i+1; 
	    	if (i<10) {
	    		test.log(Status.INFO, count+"번째 대기 체크 중 ("+count+"/10)");
		    	System.out.println(count+"번째 대기 체크 중("+count+"/10)");
			    TTS = util.TTS_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    	} else if (i>10) {
	    		break;
	    	}
		    i++;
	    }
	    
	    test.log(Status.INFO, "AudioPlayer.PlaybackFinished event_info 값 확인"); 
	    String event = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event.contains("AudioPlayer.PlaybackFinished"));
	    
	    test.log(Status.INFO, "[그만] 발화"); 
	    util.sendPost("그만", uID, SampleApp_did, ServerName, Place, authToken);


	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-07")
	public void TC_01_01_07_AudioState_PLAYING에서_다른_capabilityinterface로인해_Pause된_경우확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-07 Audio State PLAYING 상태에서 다른 capability interface로 인해 Pause된 경우 확인");
		System.out.println("01-01-07 Audio State PLAYING 상태에서 다른 capability interface로 인해 Pause된 경우 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10394");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10394");
	    
	    test.log(Status.INFO, "[노래 들려줘] 발화"); 
	    util.sendPost("노래 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "AudioPlayer.Play directive_info 값 확인"); 
	    String directive = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive.contains("AudioPlayer.Play"));
	    
	    test.log(Status.INFO, "[몇시야] 발화"); 
	    util.sendPost("몇시야", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "AudioPlayer.PlaybackFinished event_info 값 없음 확인"); 
	    String event = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertFalse(event.contains("AudioPlayer.PlaybackPause"));
	    
	    test.log(Status.INFO, "audio_activity PLAYING 상태 확인"); 
	    String audio_activity = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    Assert.assertTrue(audio_activity.contains("PLAYING"));
	    

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-08")
	public void TC_01_01_08_AudioState_PLAYING에서_UpdateMetadata_repeat_one_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-08 Audio State PLAYING 상태에서 UpdateMetadata-repeat one 확인");
		System.out.println("01-01-08 Audio State PLAYING 상태에서 UpdateMetadata-repeat one 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10395");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10395");
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    
	    test.log(Status.INFO, "[iv_repeat] 클릭"); 
	    util.click(By.id("iv_repeat"));
	    
	    test.log(Status.INFO, "AudioPlayer.UpdateMetadata directive_info 값 확인"); 
	    String directive_info = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive_info.contains("AudioPlayer.UpdateMetadata"));
	    
	    test.log(Status.INFO, "directive값에 \"repeat\\\":\"ONE\" 확인"); 
	    String directive = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive.contains("\"repeat\":\"ONE\""));

	   
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-09")
	public void TC_01_01_09_AudioState_PLAYING에서_UpdateMetadata_repeat_None_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-09 Audio State PLAYING 상태에서 UpdateMetadata-repeat None 확인");
		System.out.println("01-01-09 Audio State PLAYING 상태에서 UpdateMetadata-repeat None 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10397");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10397");

	    test.log(Status.INFO, "[iv_repeat] 클릭"); 
	    util.click(By.id("iv_repeat"));
	    
	    test.log(Status.INFO, "AudioPlayer.UpdateMetadata directive_info 값 확인"); 
	    String directive_info = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive_info.contains("AudioPlayer.UpdateMetadata"));
	    
	    test.log(Status.INFO, "directive값에 \"repeat\":\"NONE\" 확인"); 
	    String directive = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive.contains("\"repeat\":\"NONE\""));
 
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-10")
	public void TC_01_01_10_AudioState_PLAYING에서_UpdateMetadata_repeat_ALL_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-10 Audio State PLAYING 상태에서 UpdateMetadata-repeat ALL 확인");
		System.out.println("01-01-10 Audio State PLAYING 상태에서 UpdateMetadata-repeat ALL 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10396");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10396");

	    test.log(Status.INFO, "[iv_repeat] 클릭"); 
	    util.click(By.id("iv_repeat"));
	    
	    test.log(Status.INFO, "AudioPlayer.UpdateMetadata directive_info 값 확인"); 
	    String directive_info = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive_info.contains("AudioPlayer.UpdateMetadata"));
	    
	    test.log(Status.INFO, "directive값에 \"repeat\":\"ALL\" 확인"); 
	    String directive = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive.contains("\"repeat\":\"ALL\""));
 
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-11")
	public void TC_01_01_11_AudioState_PLAYING에서_UpdateMetadata_shuffle_ture_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-11 Audio State PLAYING 상태에서 UpdateMetadata-shuffle ture 확인");
		System.out.println("01-01-11 Audio State PLAYING 상태에서 UpdateMetadata-shuffle ture 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10398");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10398");

		test.log(Status.INFO, "[셔플 해줘] 발화"); 
	    util.sendPost("셔플 해줘", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "AudioPlayer.UpdateMetadata directive_info 값 확인"); 
	    String directive_info = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive_info.contains("AudioPlayer.UpdateMetadata"));
	    
	    test.log(Status.INFO, "directive값에 \"shuffle\":true 확인"); 
	    String directive = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive.contains("\"shuffle\":true"));
 
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-12")
	public void TC_01_01_12_AudioState_PLAYING에서_UpdateMetadata_shuffle_false_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-12 Audio State PLAYING 상태에서 UpdateMetadata-shuffle false 확인");
		System.out.println("01-01-12 Audio State PLAYING 상태에서 UpdateMetadata-shuffle false 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10399");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10399");

		test.log(Status.INFO, "[셔플 해제] 발화"); 
	    util.sendPost("셔플 해제", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "AudioPlayer.UpdateMetadata directive_info 값 확인"); 
	    String directive_info = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive_info.contains("AudioPlayer.UpdateMetadata"));
	    
	    test.log(Status.INFO, "directive값에 \"shuffle\":false 확인"); 
	    String directive = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive.contains("\"shuffle\":false"));
 
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-13")
	public void TC_01_01_13_AudioState_PLAYING에서_UpdateMetadata_favorite_true_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-13 Audio State PLAYING 상태에서 UpdateMetadata-favorite true 확인");
		System.out.println("01-01-13 Audio State PLAYING 상태에서 UpdateMetadata-favorite true 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10400");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10400");

		test.log(Status.INFO, "[좋아요 해줘] 발화"); 
	    util.sendPost("좋아요 해줘", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "AudioPlayer.UpdateMetadata directive_info 값 확인"); 
	    String directive_info = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive_info.contains("AudioPlayer.UpdateMetadata"));
	    
	    test.log(Status.INFO, "directive값에 \"favorite\":true 확인"); 
	    String directive = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive.contains("\"favorite\":true"));
 
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-14")
	public void TC_01_01_14_AudioState_PLAYING에서_UpdateMetadata_favorite_false_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-14 Audio State PLAYING 상태에서 UpdateMetadata-favorite false 확인");
		System.out.println("01-01-14 Audio State PLAYING 상태에서 UpdateMetadata-favorite false 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10401");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10401");

		test.log(Status.INFO, "[좋아요 해제] 발화"); 
	    util.sendPost("좋아요 해제", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "AudioPlayer.UpdateMetadata directive_info 값 확인"); 
	    String directive_info = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive_info.contains("AudioPlayer.UpdateMetadata"));
	    
	    test.log(Status.INFO, "directive값에 \"favorite\":false 확인"); 
	    String directive = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive.contains("\"favorite\":false"));
 
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-15")
	public void TC_01_01_15_AudioState_PAUSE에서_UpdateMetadata_repeat_one_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-15 Audio State PAUSE 상태에서 UpdateMetadata-repeat one 확인");
		System.out.println("01-01-15 Audio State PAUSE 상태에서 UpdateMetadata-repeat one 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10402");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10402");
		
		test.log(Status.INFO, "[일시정지] 발화"); 
	    util.sendPost("일시정지", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "[iv_repeat] 클릭"); 
	    util.click(By.id("iv_repeat"));
	    
	    test.log(Status.INFO, "AudioPlayer.UpdateMetadata directive_info 값 확인"); 
	    String directive_info = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive_info.contains("AudioPlayer.UpdateMetadata"));
	    
	    test.log(Status.INFO, "directive값에 \\\"repeat\\\":\\\"ONE\\\" 확인"); 
	    String directive = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive.contains("\"repeat\":\"ONE\""));
	    
	    test.log(Status.INFO, "audio_activity PAUSE 상태 확인"); 
	    String audio_activity = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    Assert.assertTrue(audio_activity.contains("PAUSE"));

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-16")
	public void TC_01_01_16_AudioState_PAUSE에서_UpdateMetadata_repeat_None_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-16 Audio State PAUSE 상태에서 UpdateMetadata-repeat None 확인");
		System.out.println("01-01-16 Audio State PAUSE 상태에서 UpdateMetadata-repeat None 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10404");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10404");

	    test.log(Status.INFO, "[iv_repeat] 클릭"); 
	    util.click(By.id("iv_repeat"));
	    
	    test.log(Status.INFO, "AudioPlayer.UpdateMetadata directive_info 값 확인"); 
	    String directive_info = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive_info.contains("AudioPlayer.UpdateMetadata"));
	    
	    test.log(Status.INFO, "directive값에 \"repeat\":\"NONE\" 확인"); 
	    String directive = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive.contains("\"repeat\":\"NONE\""));
	    
	    test.log(Status.INFO, "audio_activity PAUSE 상태 확인"); 
	    String audio_activity = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    Assert.assertTrue(audio_activity.contains("PAUSE"));
 
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-17")
	public void TC_01_01_17_AudioState_PAUSE에서_UpdateMetadata_repeat_ALL_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-17 Audio State PAUSE 상태에서 UpdateMetadata-repeat ALL 확인");
		System.out.println("01-01-17 Audio State PAUSE 상태에서 UpdateMetadata-repeat ALL 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10403");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10403");

	    test.log(Status.INFO, "[iv_repeat] 클릭"); 
	    util.click(By.id("iv_repeat"));
	    
	    test.log(Status.INFO, "AudioPlayer.UpdateMetadata directive_info 값 확인"); 
	    String directive_info = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive_info.contains("AudioPlayer.UpdateMetadata"));
	    
	    test.log(Status.INFO, "directive값에 \"repeat\":\"ALL\" 확인"); 
	    String directive = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive.contains("\"repeat\":\"ALL\""));
	    
	    test.log(Status.INFO, "audio_activity PAUSE 상태 확인"); 
	    String audio_activity = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    Assert.assertTrue(audio_activity.contains("PAUSE"));
 
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-18")
	public void TC_01_01_18_AudioState_PAUSE에서_UpdateMetadata_shuffle_ture_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-18 Audio State PAUSE 상태에서 UpdateMetadata-shuffle ture 확인");
		System.out.println("01-01-18 Audio State PAUSE 상태에서 UpdateMetadata-shuffle ture 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10405");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10405");

		test.log(Status.INFO, "[셔플 해줘] 발화"); 
	    util.sendPost("셔플 해줘", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "AudioPlayer.UpdateMetadata directive_info 값 확인"); 
	    String directive_info = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive_info.contains("AudioPlayer.UpdateMetadata"));
	    
	    test.log(Status.INFO, "directive값에 \"shuffle\":true 확인"); 
	    String directive = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive.contains("\"shuffle\":true"));
	    
	    test.log(Status.INFO, "audio_activity PAUSE 상태 확인"); 
	    String audio_activity = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    Assert.assertTrue(audio_activity.contains("PAUSE"));
 
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-19")
	public void TC_01_01_19_AudioState_PAUSE에서_UpdateMetadata_shuffle_false_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-19 Audio State PAUSE 상태에서 UpdateMetadata-shuffle false 확인");
		System.out.println("01-01-19 Audio State PAUSE 상태에서 UpdateMetadata-shuffle false 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10406");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10406");

		test.log(Status.INFO, "[셔플 해제] 발화"); 
	    util.sendPost("셔플 해제", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "AudioPlayer.UpdateMetadata directive_info 값 확인"); 
	    String directive_info = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive_info.contains("AudioPlayer.UpdateMetadata"));
	    
	    test.log(Status.INFO, "directive값에 \"shuffle\":false 확인"); 
	    String directive = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive.contains("\"shuffle\":false"));
	    
	    test.log(Status.INFO, "audio_activity PAUSE 상태 확인"); 
	    String audio_activity = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    Assert.assertTrue(audio_activity.contains("PAUSE"));
 
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-20")
	public void TC_01_01_20_AudioState_PAUSE에서_UpdateMetadata_favorite_true_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-20 Audio State PAUSE 상태에서 UpdateMetadata-favorite true 확인");
		System.out.println("01-01-20 Audio State PAUSE 상태에서 UpdateMetadata-favorite true 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10407");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10407");

		test.log(Status.INFO, "[좋아요 해줘] 발화"); 
	    util.sendPost("좋아요 해줘", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "AudioPlayer.UpdateMetadata directive_info 값 확인"); 
	    String directive_info = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive_info.contains("AudioPlayer.UpdateMetadata"));
	    
	    test.log(Status.INFO, "directive값에 \"favorite\":true 확인"); 
	    String directive = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive.contains("\"favorite\":true"));
	    
	    test.log(Status.INFO, "audio_activity PAUSE 상태 확인"); 
	    String audio_activity = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    Assert.assertTrue(audio_activity.contains("PAUSE"));
 
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-21")
	public void TC_01_01_21_AudioState_PAUSE에서_UpdateMetadata_favorite_false_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-21 Audio State PAUSE 상태에서 UpdateMetadata-favorite false 확인");
		System.out.println("01-01-21 Audio State PAUSE 상태에서 UpdateMetadata-favorite false 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10408");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10408");

		test.log(Status.INFO, "[좋아요 해제] 발화"); 
	    util.sendPost("좋아요 해제", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "AudioPlayer.UpdateMetadata directive_info 값 확인"); 
	    String directive_info = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive_info.contains("AudioPlayer.UpdateMetadata"));
	    
	    test.log(Status.INFO, "directive값에 \"favorite\":false 확인"); 
	    String directive = util.directive_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive.contains("\"favorite\":false"));
	    
	    test.log(Status.INFO, "audio_activity PAUSE 상태 확인"); 
	    String audio_activity = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    Assert.assertTrue(audio_activity.contains("PAUSE"));
 
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-22")
	public void TC_01_01_22_AudioState_PLAYING에서_ShowLyrics_ShowLyricsSucceeded_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-22 Audio State PLAYING 상태에서 ShowLyrics/ShowLyricsSucceeded 확인");
		System.out.println("01-01-22 Audio State PLAYING 상태에서 ShowLyrics/ShowLyricsSucceeded 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10409");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10409");

		test.log(Status.INFO, "[일시정지 해제] 발화"); 
	    util.sendPost("일시정지 해제", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "[가사 보여줘] 발화"); 
	    util.sendPost("가사 보여줘", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "AudioPlayer.ShowLyrics directive_info 값 확인"); 
	    String directive_info = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive_info.contains("AudioPlayer.ShowLyrics"));
	    
	    test.log(Status.INFO, "AudioPlayer.ShowLyricsSucceeded event_info 값 확인"); 
	    String event_info = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info.contains("AudioPlayer.ShowLyricsSucceeded"));
	    
	    test.log(Status.INFO, "audio_activity PAUSE 상태 확인"); 
	    String audio_activity = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    Assert.assertTrue(audio_activity.contains("PLAYING"));

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-23")
	public void TC_01_01_23_AudioState_PLAYING에서_HideLyrics_HideLyricsSucceeded_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-23 Audio State PLAYING 상태에서 HideLyrics/HideLyricsSucceeded 확인");
		System.out.println("01-01-23 Audio State PLAYING 상태에서 HideLyrics/HideLyricsSucceeded 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10411");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10411");
	    
	    test.log(Status.INFO, "[가사 닫아] 발화"); 
	    util.sendPost("가사 닫아", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "AudioPlayer.HideLyrics directive_info 값 확인"); 
	    String directive_info = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive_info.contains("AudioPlayer.HideLyrics"));
	    
	    test.log(Status.INFO, "AudioPlayer.HideLyricsSucceeded event_info 값 확인"); 
	    String event_info = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info.contains("AudioPlayer.HideLyricsSucceeded"));
	    
	    test.log(Status.INFO, "audio_activity PAUSE 상태 확인"); 
	    String audio_activity = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    Assert.assertTrue(audio_activity.contains("PLAYING"));
 
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-24")
	public void TC_01_01_24_AudioState_PAUSE에서_ShowLyrics_ShowLyricsSucceeded_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-24 Audio State PAUSE 상태에서 ShowLyrics/ShowLyricsSucceeded 확인");
		System.out.println("01-01-24 Audio State PAUSE 상태에서 ShowLyrics/ShowLyricsSucceeded 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10410");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10410");

		test.log(Status.INFO, "[일시정지] 발화"); 
	    util.sendPost("일시정지", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "[가사 보여줘] 발화"); 
	    util.sendPost("가사 보여줘", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "AudioPlayer.ShowLyrics directive_info 값 확인"); 
	    String directive_info = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive_info.contains("AudioPlayer.ShowLyrics"));
	    
	    test.log(Status.INFO, "AudioPlayer.ShowLyricsSucceeded event_info 값 확인"); 
	    String event_info = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info.contains("AudioPlayer.ShowLyricsSucceeded"));
	    
	    test.log(Status.INFO, "audio_activity PAUSE 상태 확인"); 
	    String audio_activity = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    Assert.assertTrue(audio_activity.contains("PAUSE"));

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-25")
	public void TC_01_01_25_AudioState_PAUSE에서_HideLyrics_HideLyricsSucceeded_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-25 Audio State PAUSE 상태에서 HideLyrics/HideLyricsSucceeded 확인");
		System.out.println("01-01-25 Audio State PAUSE 상태에서 HideLyrics/HideLyricsSucceeded 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10412");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10412");
	    
	    test.log(Status.INFO, "[가사 닫아] 발화"); 
	    util.sendPost("가사 닫아", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "AudioPlayer.HideLyrics directive_info 값 확인"); 
	    String directive_info = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive_info.contains("AudioPlayer.HideLyrics"));
	    
	    test.log(Status.INFO, "AudioPlayer.HideLyricsSucceeded event_info 값 확인"); 
	    String event_info = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info.contains("AudioPlayer.HideLyricsSucceeded"));
	    
	    test.log(Status.INFO, "audio_activity PAUSE 상태 확인"); 
	    String audio_activity = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    Assert.assertTrue(audio_activity.contains("PAUSE"));
 
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-28")
	public void TC_01_01_28_01_RequestPlayCommand의_track정보_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-28 RequestPlayCommand의 track정보 확인");
		System.out.println("01-01-28 RequestPlayCommand의 track정보 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10415");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10415");
	    
	    test.log(Status.INFO, "[부스트파크송 들려줘] 발화"); 
	    util.sendPost("부스트파크송 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "[이전] 발화"); 
	    util.sendPost("이전", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "한곡만 재생시 미지원 TTS 확인");
	    String tts1 = util.TTS_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(tts1.contains("한 곡만 재생할 때는 지원하지 않는 기능이에요."));
	    
	    test.log(Status.INFO, "[다음] 발화"); 
	    util.sendPost("다음", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "한곡만 재생시 미지원 TTS 확인");
	    String tts2 = util.TTS_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(tts2.contains("한 곡만 재생할 때는 지원하지 않는 기능이에요."));
	    
	    test.log(Status.INFO, "[셔플해줘] 발화"); 
	    util.sendPost("셔플해줘", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "한곡만 재생시 미지원 TTS 확인");
	    String tts3 = util.TTS_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(tts3.contains("한 곡만 재생할 때는 지원하지 않는 기능이에요."));
 
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-28")
	public void TC_01_01_28_02_RequestPlayCommand의_track정보_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-28 RequestPlayCommand의 track정보 확인");
		System.out.println("01-01-28 RequestPlayCommand의 track정보 확인");
		
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10415");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10415");
	    
	    test.log(Status.INFO, "[아이유 노래 들려줘] 발화"); 
	    util.sendPost("아이유 노래 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "[이전] 발화"); 
	    util.sendPost("이전", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "intent 값 previous 확인");
	    String intent1 = util.intent_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(intent1.contains("previous"));
	    
	    test.log(Status.INFO, "[다음] 발화"); 
	    util.sendPost("다음", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "intent 값 next 확인");
	    String intent2 = util.intent_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(intent2.contains("next"));
	    
	    test.log(Status.INFO, "[셔플해줘] 발화"); 
	    util.sendPost("셔플해줘", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "intent 값 random 확인");
	    String intent3 = util.intent_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(intent3.contains("random"));
 
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-28")
	public void TC_01_01_29_RequestPlayCommand의_track정보_확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-29 Idle 상태의 AudioPlayer 실행 event의 PlaybackStarted 확인");
		System.out.println("01-01-29 Idle 상태의 AudioPlayer 실행 event의 PlaybackStarted 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10418");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10418");
		    
	    test.log(Status.INFO, "[그만] 발화로 Idle 상태 변경"); 
	    util.sendPost("그만", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(2000);
		    
	    test.log(Status.INFO, "[노래 들려줘] 발화"); 
	    util.sendPost("노래 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "AudioPlayer.PlaybackStarted event_info값 확인"); 
	    String event_info = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info.contains("AudioPlayer.PlaybackStarted"));
	    
	    test.log(Status.INFO, "audio_activity PAUSE 상태 확인"); 
	    String audio_activity = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    Assert.assertTrue(audio_activity.contains("PLAYING"));
	 
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-30")
	public void TC_01_01_30_Playing상태의_AudioPlayer_PauseButton_동작(Method method) throws Exception {

		test.log(Status.INFO, "01-01-30 Playing 상태의 AudioPlayer Pause Button 동작");
		System.out.println("01-01-30 Playing 상태의 AudioPlayer Pause Button 동작");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10419");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10419");
		    
		test.log(Status.INFO, "[btn_bar_play] 클릭"); 
	    util.click(By.id("btn_bar_play"));
	    
	    test.log(Status.INFO, "AudioPlayer.PlaybackPaused event_info 값 확인"); 
	    String event_info1 = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info1.contains("AudioPlayer.PlaybackPaused"));
	    
	    test.log(Status.INFO, "audio_activity PAUSE 상태 확인"); 
	    String audio_activity = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    Assert.assertTrue(audio_activity.contains("PAUSE"));
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    
	    test.log(Status.INFO, "[btn_play] 클릭"); 
	    util.click(By.id("btn_play"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "[btn_play] 클릭"); 
	    util.click(By.id("btn_play"));
	    
	    test.log(Status.INFO, "AudioPlayer.PlaybackPaused event_info 값 확인"); 
	    String event_info3 = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info3.contains("AudioPlayer.PlaybackPaused"));
	    
	    test.log(Status.INFO, "audio_activity PAUSE 상태 확인"); 
	    String audio_activity2 = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    Assert.assertTrue(audio_activity2.contains("PAUSE"));
	 
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-31")
	public void TC_01_01_31_Pause상태의_AudioPlayer_PauseButton_동작(Method method) throws Exception {

		test.log(Status.INFO, "01-01-31 Pause 상태의 AudioPlayer Pause Button 동작");
		System.out.println("01-01-31 Pause 상태의 AudioPlayer Pause Button 동작");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10420");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10420");
		
		test.log(Status.INFO, "[btn_play] 클릭"); 
	    util.click(By.id("btn_play"));
	    
	    test.log(Status.INFO, "AudioPlayer.PlaybackResumed event_info 값 확인"); 
	    String event_info3 = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info3.contains("AudioPlayer.PlaybackResumed"));
	    
	    test.log(Status.INFO, "audio_activity PLAYING 상태 확인"); 
	    String audio_activity2 = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    Assert.assertTrue(audio_activity2.contains("PLAYING"));
		    
		test.log(Status.INFO, "[btn_collapsed] 클릭"); 
	    util.click(By.id("btn_collapsed"));
	    
	    test.log(Status.INFO, "[btn_bar_play] 클릭"); 
	    util.click(By.id("btn_bar_play"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "[btn_bar_play] 클릭"); 
	    util.click(By.id("btn_bar_play"));
	    
	    test.log(Status.INFO, "AudioPlayer.PlaybackResumed event_info 값 확인"); 
	    String event_info2 = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info2.contains("AudioPlayer.PlaybackResumed"));
	    
	    test.log(Status.INFO, "audio_activity PLAYING 상태 확인"); 
	    String audio_activity = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    Assert.assertTrue(audio_activity.contains("PLAYING"));

	 
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-32")
	public void TC_01_01_32_Playing종료지점_Finish_Stop_처리확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-32 Playing 종료지점 Finish/Stop 처리 확인");
		System.out.println("01-01-32 Playing 종료지점 Finish/Stop 처리 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10421");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10421");
		
		test.log(Status.INFO, "[부스트파크송 들려줘] 발화"); 
	    util.sendPost("부스트파크송 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "[반복 해제] 발화"); 
	    util.sendPost("반복 해제", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    String audio_activity = "";
	    int i = 0;
	    test.log(Status.INFO, "현재 미디어가 종료될떄까지 대기");
	    while(!audio_activity.contains("FINISHED")) {
	    	int count = i+1; 
	    	if (i<10) {
	    		test.log(Status.INFO, count+"번째 대기 체크 중 ("+count+"/10)");
		    	System.out.println(count+"번째 대기 체크 중("+count+"/10)");
		    	audio_activity = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    	} else if (i>10) {
	    		break;
	    	}
		    i++;
	    }
	    
	    test.log(Status.INFO, "AudioPlayer.PlaybackResumed event_info 값 확인"); 
	    String event_info = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info.contains("AudioPlayer.PlaybackFinished"));
	    
	    test.log(Status.INFO, "AudioPlayer.Stop directive_info 값 확인"); 
	    String directive = util.directive_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(directive.contains("AudioPlayer.Stop"));

	 
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-33")
	public void TC_01_01_33_01_Playing상태_Stop_StopCommandIssued_event_처리확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-32 Playing 상태 Stop/StopCommandIssued Event 확인");
		System.out.println("01-01-32 Playing 상태 Stop/StopCommandIssued Event 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10422");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10422");
		
		test.log(Status.INFO, "[노래 들려줘] 발화"); 
	    util.sendPost("노래 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(7000);
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "[btn_close] 클릭"); 
	    util.click(By.id("btn_close"));
	    
	    test.log(Status.INFO, "AudioPlayer.PlaybackStopped event_info 값 확인"); 
	    String event_info = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info.contains("AudioPlayer.PlaybackStopped"));

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-33")
	public void TC_01_01_33_02_Playing상태_Stop_StopCommandIssued_event_처리확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-33 Playing 상태 Stop/StopCommandIssued Event 확인");
		System.out.println("01-01-33 Playing 상태 Stop/StopCommandIssued Event 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10422");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10422");
		
		test.log(Status.INFO, "[노래 들려줘] 발화"); 
	    util.sendPost("노래 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(7000);
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "[그만] 발화"); 
	    util.sendPost("그만", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "AudioPlayer.PlaybackStopped event_info 값 확인"); 
	    String event_info = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info.contains("AudioPlayer.PlaybackStopped"));

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-35")
	public void TC_01_01_35_1분미리듣기_ProgressReportDelayElapsed_event확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-35 1분미리듣기 ProgressReportDelayElapsed event 확인");
		System.out.println("01-01-35 1분미리듣기 ProgressReportDelayElapsed event 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10428");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10428");
		
		test.log(Status.INFO, "[오디오북 선녀와 나무꾼들려줘] 발화"); 
	    util.sendPost("오디오북 선녀와 나무꾼들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(7000);
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    
	    String audio_activity = "";
	    int i = 0;
	    test.log(Status.INFO, "현재 미리듣기 미디어가 종료될떄까지 대기");
	    while(!audio_activity.contains("STOPPED")) {
	    	int count = i+1; 
	    	if (i<10) {
	    		test.log(Status.INFO, count+"번째 대기 체크 중 ("+count+"/10)");
		    	System.out.println(count+"번째 대기 체크 중("+count+"/10)");
		    	audio_activity = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    	} else if (i>10) {
	    		break;
	    	}
		    i++;
	    }
	    
	    test.log(Status.INFO, "AudioPlayer.ProgressReportDelayElapsed event_info 값 확인"); 
	    String event_info = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info.contains("AudioPlayer.ProgressReportDelayElapsed"));

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-36")
	public void TC_01_01_36_Playing상태_ProgressReportIntervalElapsed_event전송확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-36 Playing 상태 ProgressReportIntervalElapsed event 전송 확인");
		System.out.println("01-01-36 Playing 상태 ProgressReportIntervalElapsed event 전송 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10435");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10435");
		
		test.log(Status.INFO, "[SBS 라디오 들려줘 ] 발화"); 
	    util.sendPost("SBS 라디오 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    
	    test.log(Status.INFO, "라디오 스트리밍 5분 대기"); 
	    Thread.sleep(310000);
	    
	    test.log(Status.INFO, "AudioPlayer.ProgressReportIntervalElapsed event_info 값 확인"); 
	    String event_info = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info.contains("AudioPlayer.ProgressReportIntervalElapsed"));
	    
	    test.log(Status.INFO, "[그만] 발화"); 
	    util.sendPost("그만", uID, SampleApp_did, ServerName, Place, authToken);

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-37")
	public void TC_01_01_37_Playing상태_PlaybackResumed_event_전송확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-37 Playing 상태 PlaybackResumed event 전송 확인");
		System.out.println("01-01-37 Playing 상태 PlaybackResumed event 전송 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10450");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10450");
		
		test.log(Status.INFO, "[노래 들려줘] 발화"); 
	    util.sendPost("노래 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(5000);
	    
	    test.log(Status.INFO, "[btn_bar_play] 클릭"); 
	    util.click(By.id("btn_bar_play"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "[btn_bar_play] 클릭"); 
	    util.click(By.id("btn_bar_play"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "AudioPlayer.PlaybackResumed event_info 값 확인"); 
	    String event_info = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info.contains("AudioPlayer.PlaybackResumed"));
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "[btn_play] 클릭"); 
	    util.click(By.id("btn_play"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "[btn_play] 클릭"); 
	    util.click(By.id("btn_play"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "AudioPlayer.PlaybackResumed event_info 값 확인"); 
	    String event_info1 = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info1.contains("AudioPlayer.PlaybackResumed"));

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-38")
	public void TC_01_01_38_Playing상태_NextCommandIssued_event_전송확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-38 Playing 상태 NextCommandIssued event 확인");
		System.out.println("01-01-38 Playing 상태 NextCommandIssued event 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10453");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10453");
	    
	    test.log(Status.INFO, "[btn_next] 클릭"); 
	    util.click(By.id("btn_next"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "AudioPlayer.NextCommandIssued event_info 값 확인"); 
	    String event_info1 = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info1.contains("AudioPlayer.NextCommandIssued"));
	    
	    test.log(Status.INFO, "[btn_collapsed] 클릭"); 
	    util.click(By.id("btn_collapsed"));
	    
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-39")
	public void TC_01_01_39_Pause상태_NextCommandIssued_event_전송확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-38 Pause 상태 NextCommandIssued event 확인");
		System.out.println("01-01-38 Pause 상태 NextCommandIssued event 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10456");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10456");
		
		test.log(Status.INFO, "[노래 들려줘] 발화"); 
	    util.sendPost("노래 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(5000);
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "[btn_bar_play] 클릭"); 
	    util.click(By.id("btn_play"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "[btn_next] 클릭"); 
	    util.click(By.id("btn_next"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "AudioPlayer.NextCommandIssued event_info 값 확인"); 
	    String event_info1 = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info1.contains("AudioPlayer.NextCommandIssued"));
	    
	    test.log(Status.INFO, "audio_activity PLAYING 상태 확인"); 
	    String audio_activity2 = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    Assert.assertTrue(audio_activity2.contains("PLAYING"));
	    
	    test.log(Status.INFO, "[btn_collapsed] 클릭"); 
	    util.click(By.id("btn_collapsed"));
	    
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-40")
	public void TC_01_01_40_Playing상태_PreviousCommandIssued_event_전송확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-40 Playing 상태 PreviousCommandIssued event 확인");
		System.out.println("01-01-40 Playing 상태 PreviousCommandIssued event 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10460");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10460");
		
		test.log(Status.INFO, "[노래 들려줘] 발화"); 
	    util.sendPost("노래 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(5000);
		
		test.log(Status.INFO, "[btn_bar_prev] 클릭"); 
	    util.click(By.id("btn_bar_prev"));
	    
	    test.log(Status.INFO, "AudioPlayer.PreviousCommandIssued event_info 값 확인"); 
	    String event_info = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info.contains("AudioPlayer.PreviousCommandIssued"));
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "[btn_prev] 클릭"); 
	    util.click(By.id("btn_next"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "AudioPlayer.PreviousCommandIssued event_info 값 확인"); 
	    String event_info1 = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info1.contains("AudioPlayer.PreviousCommandIssued"));
	    
	    test.log(Status.INFO, "[btn_collapsed] 클릭"); 
	    util.click(By.id("btn_collapsed"));
	    
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-41")
	public void TC_01_01_41_Pause상태_PreviousCommandIssued_event_전송확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-41 Pause 상태 PreviousCommandIssued event 확인");
		System.out.println("01-01-41 Pause 상태 PreviousCommandIssued event 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10462");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10462");
		
		test.log(Status.INFO, "[노래 들려줘] 발화"); 
	    util.sendPost("노래 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(5000);
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("bar_player"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "[btn_bar_play] 클릭"); 
	    util.click(By.id("btn_play"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "[btn_prev] 클릭"); 
	    util.click(By.id("btn_prev"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "AudioPlayer.PreviousCommandIssued event_info 값 확인"); 
	    String event_info1 = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info1.contains("AudioPlayer.PreviousCommandIssued"));
	    
	    test.log(Status.INFO, "audio_activity PLAYING 상태 확인"); 
	    String audio_activity2 = util.audio_activity_JsonParsing(uID, SampleApp_did, ServerName, Place, 5);
	    Assert.assertTrue(audio_activity2.contains("PLAYING"));
	    
	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-42")
	public void TC_01_01_42_01_좋아요_즐겨찾기버튼클릭_FavoriteCommandIssued_event확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-42 좋아요/즐겨찾기 버튼 클릭 FavoriteCommandIssued event 확인");
		System.out.println("01-01-42 좋아요/즐겨찾기 버튼 클릭 FavoriteCommandIssued event 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10613");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10613");
		
		test.log(Status.INFO, "[자우림의 나비 들려줘] 발화"); 
	    util.sendPost("자우림의 나비 들려줘", uID, SampleApp_did, ServerName, Place, authToken);
	    Thread.sleep(5000);
		
	    test.log(Status.INFO, "[iv_favorite] 클릭"); 
	    util.click(By.id("iv_favorite"));
	    
	    test.log(Status.INFO, "좋아요 담기 TTS 확인");
	    String tts1 = util.TTS_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(tts1.contains("당신의 멜론 좋아요 리스트에 담았습니다."));
	    
	    test.log(Status.INFO, "AudioPlayer.FavoriteCommandIssued event_info 값 확인"); 
	    String event_info1 = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info1.contains("AudioPlayer.FavoriteCommandIssued"));

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-42")
	public void TC_01_01_42_02_좋아요_즐겨찾기버튼클릭_FavoriteCommandIssued_event확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-42 좋아요/즐겨찾기 버튼 클릭 FavoriteCommandIssued event 확인");
		System.out.println("01-01-42 좋아요/즐겨찾기 버튼 클릭 FavoriteCommandIssued event 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10613");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10613");
		
	    test.log(Status.INFO, "[iv_favorite] 클릭"); 
	    util.click(By.id("iv_favorite"));
	    
	    test.log(Status.INFO, "좋아요 해제 TTS 확인");
	    String tts1 = util.TTS_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(tts1.contains("당신의 멜론 좋아요 리스트에서 삭제했습니다."));
	    
	    test.log(Status.INFO, "AudioPlayer.FavoriteCommandIssued event_info 값 확인"); 
	    String event_info1 = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info1.contains("AudioPlayer.FavoriteCommandIssued"));

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-43")
	public void TC_01_01_43_01_Playing상태_반복아이콘클릭시_RepeatCommandIssued_event확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-43 반복 아이콘 클릭시 RepeatCommandIssued event 확인");
		System.out.println("01-01-43 반복 아이콘 클릭시 RepeatCommandIssued event 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10614");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10614");
		
	    test.log(Status.INFO, "[iv_repeat] 클릭"); 
	    util.click(By.id("iv_repeat"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "한곡 반복 TTS 확인");
	    String tts1 = util.TTS_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(tts1.contains("자우림 나비 반복할게요."));
	    
	    test.log(Status.INFO, "AudioPlayer.RepeatCommandIssued event_info 값 확인"); 
	    String event_info1 = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info1.contains("AudioPlayer.RepeatCommandIssued"));
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("iv_repeat"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "반복 해제 TTS 확인");
	    String tts2 = util.TTS_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(tts2.contains("반복을 해제했어요."));
	    
	    test.log(Status.INFO, "AudioPlayer.RepeatCommandIssued event_info 값 확인"); 
	    String event_info2 = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info2.contains("AudioPlayer.RepeatCommandIssued"));
	    
	    test.log(Status.INFO, "[iv_repeat] 클릭"); 
	    util.click(By.id("iv_repeat"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "전체 반복 TTS 확인");
	    String tts3 = util.TTS_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(tts3.contains("전체 반복할게요."));
	    
	    test.log(Status.INFO, "AudioPlayer.RepeatCommandIssued event_info 값 확인"); 
	    String event_info3 = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info3.contains("AudioPlayer.RepeatCommandIssued"));

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-43")
	public void TC_01_01_43_02_Pause상태_반복아이콘클릭시_RepeatCommandIssued_event확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-43 반복 아이콘 클릭시 RepeatCommandIssued event 확인");
		System.out.println("01-01-43 반복 아이콘 클릭시 RepeatCommandIssued event 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10614");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10614");
		
		test.log(Status.INFO, "[btn_play] 클릭"); 
	    util.click(By.id("btn_play"));
	    Thread.sleep(2000);
		
	    test.log(Status.INFO, "[iv_repeat] 클릭"); 
	    util.click(By.id("iv_repeat"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "한곡 반복 TTS 확인");
	    String tts1 = util.TTS_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(tts1.contains("자우림 나비 반복할게요."));
	    
	    test.log(Status.INFO, "AudioPlayer.RepeatCommandIssued event_info 값 확인"); 
	    String event_info1 = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info1.contains("AudioPlayer.RepeatCommandIssued"));
	    
	    test.log(Status.INFO, "[bar_player] 클릭"); 
	    util.click(By.id("iv_repeat"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "반복 해제 TTS 확인");
	    String tts2 = util.TTS_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(tts2.contains("반복을 해제했어요."));
	    
	    test.log(Status.INFO, "AudioPlayer.RepeatCommandIssued event_info 값 확인"); 
	    String event_info2 = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info2.contains("AudioPlayer.RepeatCommandIssued"));
	    
	    test.log(Status.INFO, "[iv_repeat] 클릭"); 
	    util.click(By.id("iv_repeat"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "전체 반복 TTS 확인");
	    String tts3 = util.TTS_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(tts3.contains("전체 반복할게요."));
	    
	    test.log(Status.INFO, "AudioPlayer.RepeatCommandIssued event_info 값 확인"); 
	    String event_info3 = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info3.contains("AudioPlayer.RepeatCommandIssued"));

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-44")
	public void TC_01_01_44_01_셔플아이콘클릭시_ShuffleCommandIssued_event확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-44 셔플 아이콘 클릭시 ShuffleCommandIssued event 확인");
		System.out.println("01-01-44 셔플 아이콘 클릭시 ShuffleCommandIssued event 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10615");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10615");
		
	    test.log(Status.INFO, "[iv_shuffle] 클릭"); 
	    util.click(By.id("iv_shuffle"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "셔플 TTS 확인");
	    String tts1 = util.TTS_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(tts1.contains("셔플할게요."));
	    
	    test.log(Status.INFO, "AudioPlayer.ShuffleCommandIssued event_info 값 확인"); 
	    String event_info1 = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info1.contains("AudioPlayer.ShuffleCommandIssued"));
	    

	}
	
	@Test(description = "SDK 리그레이션 TC : AudioPlayer_Interface_01-01-44")
	public void TC_01_01_44_02셔플아이콘클릭시_ShuffleCommandIssued_event확인(Method method) throws Exception {

		test.log(Status.INFO, "01-01-44 셔플 아이콘 클릭시 ShuffleCommandIssued event 확인");
		System.out.println("01-01-44 셔플 아이콘 클릭시 ShuffleCommandIssued event 확인");
			
		test.log(Status.INFO, "https://tde.sktelecom.com/pms/browse/AITE-10615");
		System.out.println("https://tde.sktelecom.com/pms/browse/AITE-10615");
		
	    test.log(Status.INFO, "[iv_shuffle] 클릭"); 
	    util.click(By.id("iv_shuffle"));
	    Thread.sleep(2000);
	    
	    test.log(Status.INFO, "셔플 TTS 확인");
	    String tts1 = util.TTS_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(tts1.contains("셔플을 해제할게요."));
	    
	    test.log(Status.INFO, "AudioPlayer.ShuffleCommandIssued event_info 값 확인"); 
	    String event_info1 = util.event_info_JsonParsing(uID, SampleApp_did, ServerName, Place);
	    Assert.assertTrue(event_info1.contains("AudioPlayer.ShuffleCommandIssued"));
	    

	}


}
