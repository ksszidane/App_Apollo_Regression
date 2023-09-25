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
	
	public static String 알람발화 [] = {"알람 맞춰줘","알람 설정해줘","알람 등록해줘", "모니콜 해줘", "2020년 2월 3일에 알람해"};
	
	public static String 할일 [] = {"할일 화면으로 가줘","할일 화면 보여줘","투두 메뉴 ", "할일목록 가줘", "할일리스트 가줘", "할일목록으로", "할일화면으로", "할일화면으로 이동"};
	
	public static String 전화 [] = {"전화","통화연결","전화 걸기", "전화 연결"};
	
	public static String FLO [] = {"플로 음악 틀어줘","FLO에서 음원 찾아줘","FLO 음원 들려줘"};
	
	public static String ASMR [] = {"ASMR 플레이", "자연의 소리 플레이", "힐링 사운드 플레이", "ASMR 셔플"};
	
	public static String 욕설 [] = {"아오 저 개색히 말하는 뽄새 봐", "아 저 개시발같은 엄청 나대네", "응 뻐큐나 드세여", "저거 완전 도라이 아냐~"};
	
	public static String 음악시작 [] = {"음악", "FLO"};
	public List<String> 음악시작_list = Arrays.asList(음악시작);  
	public static Set<String> 음악시작_set = new HashSet<String>(Arrays.asList(음악시작));
	
	public static String FLO_TTS [] = {"FLO에서 최근 감상한 음악 들려줄게", "널 위해 준비한 음악이야. 같이 들어보자~"};
	public List<String> FLO_TTS_list = Arrays.asList(FLO_TTS);  
	public static Set<String> FLO_TTS_set = new HashSet<String>(Arrays.asList(FLO_TTS));
	
	public static String 뉴스시작 [] = {"뉴스", "주요 뉴스"};
	public List<String> 뉴스시작_list = Arrays.asList(뉴스시작);  
	public static Set<String> 뉴스시작_set = new HashSet<String>(Arrays.asList(뉴스시작));
	
	public static String 날씨모션코드 [] = {"M_Talk_0001","L_Weather_Sunny","L_Weather_rain", "L_Weather_Cloud", "L_Weather_Low", "L_Weather_Gale", "L_Weather_Finedust"};
	public List<String> 날씨모션코드_list = Arrays.asList(날씨모션코드);  
	public static Set<String> 날씨모션코드_set = new HashSet<String>(Arrays.asList(날씨모션코드));
	
	public static String 서비스설정모션코드 [] = {"Talk_0001","Phone_0001","Talk_0002", "Talk_0003", "Talk_0004", "L_Briefing_0001"};
	public List<String> 서비스설정모션코드_list = Arrays.asList(서비스설정모션코드);  
	public static Set<String> 서비스설정모션코드_set = new HashSet<String>(Arrays.asList(서비스설정모션코드));
	
	public static String 욕설모션코드 [] = {"L_Talk_0002","Resolute_0001"};
	public List<String> 욕설모션코드_list = Arrays.asList(욕설모션코드);  
	public static Set<String> 욕설모션코드_set = new HashSet<String>(Arrays.asList(욕설모션코드));
	
	public static String 티맵TTS [] = {"다음 중 목적지를 선택해 줘","다음 중 목적지를 선택해 주세요"};
	public List<String> 티맵TTS_list = Arrays.asList(티맵TTS);  
	public static Set<String> 티맵TTS_set = new HashSet<String>(Arrays.asList(티맵TTS));
	
	public static String 구매버튼 [] = {"구매", "구매 1", "구매 2", "구매 3", "구매 4", "구매 5", "구매 6", "구매 7"};
	public List<String> 구매버튼_list = Arrays.asList(구매버튼);  
	public static Set<String> 구매버튼_set = new HashSet<String>(Arrays.asList(구매버튼));
	
	public static String 욕설TTS [] = {"많이 화났구나", "일단 심호흡하고", "기분이 많이 안 좋구나", "마음을 차분하게 다스려보자", "우리 마음을 가라앉혀보자", "조금만 이따 다시 대화해 볼까", "잠시만 마음을 가다듬어보는 거 어때", "마음"};
	public List<String> 욕설TTS_list = Arrays.asList(욕설TTS);  
	public static Set<String> 욕설TTS_set = new HashSet<String>(Arrays.asList(욕설TTS));
	
	public static String 요일TTS [] = {"오늘은 월요일이야", "오늘은 화요일이야", "오늘은 수요일이야", "오늘은 목요일이야", "오늘은 금요일이야", "오늘은 토요일이야", "오늘은 일요일이야"};
	public List<String> 요일TTS_list = Arrays.asList(요일TTS);  
	public static Set<String> 요일TTS_set = new HashSet<String>(Arrays.asList(요일TTS));
	
	

}
