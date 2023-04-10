package Apollo_001_공통;

import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Apollo_000_xPath.xPath;
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
		
		test.log(Status.INFO, "'111 플러스 222' 명령어 전송 후 로그아웃 버튼 클릭");
		util.A_sendPost("111 플러스 222", uID, dID, ServerName);
		test.log(Status.INFO, "'111 플러스 222'템플릿 노출 확인");
		util.waitForIsElementPresent(By.id("banner_container"));
		템플릿텍스트1 = util.getText(By.id("text1"));
		Assert.assertEquals(템플릿텍스트1, "111 + 222");
		템플릿텍스트2 = util.getText(By.id("text2"));
		Assert.assertEquals(템플릿텍스트2, "= 333");
		
		test.log(Status.INFO, "'로그 2는 얼마야 ' 명령어 전송 후 로그아웃 버튼 클릭");
		util.A_sendPost("1로그 2는 얼마야", uID, dID, ServerName);
		test.log(Status.INFO, "'로그 2는 얼마야 '템플릿 노출 확인");
		util.waitForIsElementPresent(By.id("banner_container"));
		템플릿텍스트1 = util.getText(By.id("text1"));
		Assert.assertEquals(템플릿텍스트1, "log2");
		템플릿텍스트2 = util.getText(By.id("text2"));
		Assert.assertEquals(템플릿텍스트2, "= 0.3010299957");

		//test.log(Status.INFO, "'루트 2 더하기 루트 2는 뭐야' 명령어 전송 후 로그아웃 버튼 클릭");
		//util.A_sendPost("루트 2 더하기 루트 2는 뭐야", uID, dID, ServerName);
		//test.log(Status.INFO, "'루트 2 더하기 루트 2는 뭐야 '템플릿 노출 확인");
		//util.waitForIsElementPresent(By.id("banner_container"));
		//템플릿텍스트1 = util.getText(By.id("text1"));
		//Assert.assertEquals(템플릿텍스트1, "√2 + √2");
		//템플릿텍스트2 = util.getText(By.id("text2"));
		//Assert.assertEquals(템플릿텍스트2, "= 2.8284271247");
		
		test.log(Status.INFO, "'탄젠트 45 마이너스 5 ' 명령어 전송 후 로그아웃 버튼 클릭");
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
		
		test.log(Status.INFO, "'3π 값 알려줘  ' 명령어 전송 후 로그아웃 버튼 클릭");
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
		
	}
	
	

}
