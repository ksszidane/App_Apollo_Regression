package Apollo_Data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Data {
	
	public static String 뉴스발화 [] = {"뉴스 들러줘", "뉴스 틀어줘", "뉴스 이야기해줘", "뉴스 재생", "뉴스 기사 들려줘", "데일리 브리핑틀어줘", "데일리 브리핑 해줘", 
			"헤드라인 뉴스 틀어줘", "주요 뉴스 틀어줘", "헤드라인 브리핑 해줘", "주요 뉴스 브리핑 해줘", "헤드라인 뉴스 틀어줘", "이슈 알려줘"};
	
	public static String 티맵발화 [] = {"최근목적지 보여줘", "최근방문 보여줘", "최근방문지 보여줘", "최근방문기록 보여줘", "티맵 최근목적지 보여줘", "티맵 최근방문 보여줘", "티맵 최근방문지 보여줘", 
			"티맵 최근기록 보여줘"};
	
	public static String 띠운세발화 [] = {"오늘 소띠 운세 알려줘", "내일 호랑이 띠 운세 알려줘"};
	
	public static String 날씨발화 [] = {"날씨 알려줘","부산 날씨 어떄?","당산동 일기예보 알려줘", "대전 날씨는?", "날씨 정보", "에버랜드 날씨 상태", "날씨 예보", "날씨 정보"};
	
	public static String 문자발화 [] = {"메시지 내용 작성","메시지 발송해줘","메시지 작성", "메시지발신", "메시지발신해", "문자 날려", "문자 날려줘", "문자 메시지 보내기",
			"문자 메시지 보내줘", "문자 발송", "문자 발신", "문자 보내", "문자 보내줘", "문자 쓰기", "문자 전송해줘"};
	
	public static String 서수문자발화 [] = {"1번","두번째에게 보내","첫번째한테 메세지 보내", "첫번째 김성수에게 보내"};
	
	public static String 전화 [] = {"전화","통화연결","전화 걸기", "전화 연결"};
	
	public static String 음악시작 [] = {"음악", "FLO"};
	public List<String> 음악시작_list = Arrays.asList(음악시작);  
	public static Set<String> 음악시작_set = new HashSet<String>(Arrays.asList(음악시작));
	
	public static String 뉴스시작 [] = {"뉴스", "주요 뉴스"};
	public List<String> 뉴스시작_list = Arrays.asList(뉴스시작);  
	public static Set<String> 뉴스시작_set = new HashSet<String>(Arrays.asList(뉴스시작));
	
	public static String 날씨모션코드 [] = {"M_Talk_0001","L_Weather_Sunny","L_Weather_rain", "L_Weather_Cloud", "L_Weather_Low", "L_Weather_Gale", "L_Weather_Finedust"};
	public List<String> 날씨모션코드_list = Arrays.asList(날씨모션코드);  
	public static Set<String> 날씨모션코드_set = new HashSet<String>(Arrays.asList(날씨모션코드));
	
	public static String 티맵TTS [] = {"다음 중 목적지를 선택해 줘","다음 중 목적지를 선택해 주세요"};
	public List<String> 티맵TTS_list = Arrays.asList(티맵TTS);  
	public static Set<String> 티맵TTS_set = new HashSet<String>(Arrays.asList(티맵TTS));


}
