package Apollo_Data;

public class xPath {
	
	public static String 에이닷_홈 = "//android.widget.FrameLayout[contains(@resource-id, 'voice_chrome_fragment')]";
	public static String 꾸미기로딩 = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ImageView";

	//Tmap 최근 목적지 Web Xpath
	public static String Tmap최근목적지Text_web = "//*[@id='root']/section/header/h1";
	public static String Tmap즐겨찾기아이콘_web = "//*[@id='root']/section/ul/li[1]/button";
	public static String Tmap최근목적지POI_text_web = "//*[@id='root']/section/ul/li[1]/button/div/p[1]";
	public static String Tmap_Webview_STG_URL = "apollo-p-stg.tmobiweb.com/recent-destinations?&extraYn=Y";

}