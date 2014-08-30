package JobFeedTest.JibePost.MatchTest;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import JobFeedTest.JibePost.Basic.BaseScript;
import JobFeedTest.JibePost.XMLFeedController.Helper;


public class JobMatchTest extends BaseScript{
	
	@Test
	public void mssvMatchTest() {
		
		System.out.println("The total jobs of Microsoft Silicon Valley from Jibe are: " + mssv_jibe.size());
		int mssv_mismatch = Helper.compareJobFeeds(mssv_ms, mssv_jibe, "Microsoft Sillicon Valley");
		
		assertEquals(0, mssv_mismatch);
		
		System.out.println("-----------------------------------------------------");
	}
	
	@Test
	public void linkedInMatchTest() {
		
		System.out.println("The total jobs of LinkedIn from Jibe are: " + linkedIn_jibe.size());
		int linkedIn_mismatch = Helper.compareJobFeeds(msJobMap, linkedIn_jibe, "LinkedIn");
		
		System.out.println("The total jobs contain Skype/Lync from Microsoft are: " + skypeLync_ms.size());
        System.out.println("The total jobs contain Yammer from Microsoft are: " + yammer_ms.size());
        System.out.println("The other jobs from Microsoft are: " + others_ms.size());
         
        System.out.println();
         
        System.out.println("The total jobs contain Skype/Lync from Jibe are: " + skypeLync_jibe.size());
        System.out.println("The total jobs contain Yammer from Jibe are: " + yammer_jibe.size());
        System.out.println("The other jobs from Jibe are: " + others_jibe.size());
        
        Helper.compareJobFeeds(skypeLync_ms, skypeLync_jibe, "SKype&Lync");
	    Helper.compareJobFeeds(yammer_ms, yammer_jibe, "Yammer");
	    Helper.compareJobFeeds(others_ms, others_jibe, "Others");
	            
		assertEquals(0, linkedIn_mismatch);

		System.out.println("-----------------------------------------------------");
	}	
	
	@Test
	public void indeedMatchTest() {
		
		System.out.println("The total jobs of Indeed from Jibe are: " + indeed_jibe.size());
		int Indeed_mismatch = Helper.compareJobFeeds(msJobMap, indeed_jibe, "Indeed");
		
		assertEquals(0, Indeed_mismatch);
		
		System.out.println("-----------------------------------------------------");
	}
	
	@Test
	public void glassdoorMatchTest() {
		
		System.out.println("The total jobs of Glassdoor from Jibe are: " + glassdoor_jibe.size());
		int Glassdoor_mismatch = Helper.compareJobFeeds(msJobMap, glassdoor_jibe, "Glassdoor");
		
		assertEquals(0, Glassdoor_mismatch);
		
		System.out.println("-----------------------------------------------------");
	}
	
	@Test
	public void diversityworkingMatchTest() {
		
		System.out.println("The total jobs of Diversity Working from Jibe are: " + diversityworking_jibe.size());
		int diversityworking_mismatch = Helper.compareJobFeeds(msJobMap, diversityworking_jibe, "Diversity Working");
		
		assertEquals(0, diversityworking_mismatch);
		
		System.out.println("-----------------------------------------------------");
	}
	
	@Test
	public void burningglassMatchTest() {
		
		System.out.println("The total jobs of Burning Glass from Jibe are: " + burningglass_jibe.size());
		int burningglass_mismatch = Helper.compareJobFeeds(msJobMap, burningglass_jibe, "Burning Glass");
		
		assertEquals(0, burningglass_mismatch);
		
		System.out.println("-----------------------------------------------------");
	}
	
	@Test
	public void gajgalMatchTest() {
		
		System.out.println("The total jobs of Gajgal from Jibe are: " + gajgal_jibe.size());
		int gajgal_mismatch = Helper.compareJobFeeds(msJobMap, gajgal_jibe, "Gajgal");
		
		assertEquals(0, gajgal_mismatch);
		
		System.out.println("-----------------------------------------------------");
	}
	
	@Test
	public void punchkickMatchTest() {
		
		System.out.println("The total jobs of Punchkick from Jibe are: " + punchkick_jibe.size());
		int punchkick_mismatch = Helper.compareJobFeeds(msJobMap, punchkick_jibe, "punchkick");
		
		assertEquals(0, punchkick_mismatch);
		
		System.out.println("-----------------------------------------------------");
	}
	
	@Test
	public void simplyhiredMatchTest() {
		
		System.out.println("The total jobs of Simplyhired from Jibe are: " + simplyhired_jibe.size());
		int simplyhired_mismatch = Helper.compareJobFeeds(msJobMap, simplyhired_jibe, "simplyhired");
		
		assertEquals(0, simplyhired_mismatch);
		
		System.out.println("-----------------------------------------------------");
	}
	
	@Test
	public void directemplyoerMatchTest() {
		
		System.out.println("The total jobs of DirectEmploer from Jibe are: " + directemployer_jibe.size());
		int directemploer_mismatch = Helper.compareJobFeeds(msJobMap, directemployer_jibe, "directemploer");
		
		assertEquals(0, directemploer_mismatch);
		
		System.out.println("-----------------------------------------------------");
	}
	
	@Test
	public void accMatchTest() {
		
		System.out.println("The total jobs of ACC from Jibe are: " + acc_jibe.size());
		int ACC_mismatch = Helper.compareJobFeeds(acc_ms, acc_jibe, "ACC");
		
		assertEquals(0, ACC_mismatch);
		
		System.out.println("-----------------------------------------------------");
	}
	
	@Test
	public void nerdMatchTest() {
		
		System.out.println("The total jobs of NERD from Jibe are: " + nerd_jibe.size());
		int NERD_mismatch = Helper.compareJobFeeds(nerd_ms, nerd_jibe, "NERD");
		
		assertEquals(0, NERD_mismatch);
		
		System.out.println("-----------------------------------------------------");
	}
	
	@Test
	public void mappedinisraelMatchTest() {
		
		System.out.println("The total jobs of Mappedinisrael from Jibe are: " + mappedinisrael_jibe.size());
		int mappedinisrael_mismatch = Helper.compareJobFeeds(mappedinisrael_ms, mappedinisrael_jibe, "Mappedinisrael");
		
		assertEquals(0, mappedinisrael_mismatch);
		
		System.out.println("-----------------------------------------------------");
	}
	
	@Test
	public void sixFigureJobMatchTest() {
		
		System.out.println("The total jobs of 6 figure from Jibe are: " + sixfigurejob_jibe.size());
		int sixfigure_mismatch = Helper.compareJobFeeds(sixfigurejob_ms, sixfigurejob_jibe, "6 figure job");
		
		assertEquals(0, sixfigure_mismatch);
		
		System.out.println("-----------------------------------------------------");
	}
	
	@Test
	public void hbcuMatchTest() {
		
		System.out.println("The total jobs of hbcu from Jibe are: " + hbcu_jibe.size());
		int hbcu_mismatch = Helper.compareJobFeeds(hbcu_ms, hbcu_jibe, "HBCU");
		
		assertEquals(0, hbcu_mismatch);
		
		System.out.println("-----------------------------------------------------");
	}
	
	@Test
	public void naukriMatchTest() {
		
		System.out.println("The total jobs of naukri from Jibe are: " + naukri_jibe.size());
		int naukri_mismatch = Helper.compareJobFeeds(naukri_ms, naukri_jibe, "Naukri");
		
		assertEquals(0, naukri_mismatch);
		
		System.out.println("-----------------------------------------------------");
	}
	
	@Test
	public void careerbuilderfrMatchTest() {
		
		System.out.println("The total jobs of careerbuilderfr from Jibe are: " + careerbuilderfr_jibe.size());
		int careerbuilderfr_mismatch = Helper.compareJobFeeds(careerbuilderfr_ms, careerbuilderfr_jibe, "Careerbuilder France");
		
		assertEquals(0, careerbuilderfr_mismatch);
		
		System.out.println("-----------------------------------------------------");
	}
	
	@Test
	public void erecrutJobsMatchTest() {
		
		System.out.println("The total jobs of erecrut from Jibe are: " + erecrut_jibe.size());
		int erecrut_mismatch = Helper.compareJobFeeds(erecrut_ms, erecrut_jibe, "Erecrut");
		
		assertEquals(0, erecrut_mismatch);
		
		System.out.println("-----------------------------------------------------");
	}
	
	@Test
	public void lesjeudisMatchTest() {
		
		System.out.println("The total jobs of lesjeudis from Jibe are: " + lesJeudis_jibe.size());
		int lesjeudis_mismatch = Helper.compareJobFeeds(lesJeudis_ms, lesJeudis_jibe, "Lesjeudis");
		
		assertEquals(0, lesjeudis_mismatch);
		
		System.out.println("-----------------------------------------------------");
	}
	
	@Test
	public void phonemploiMatchTest() {
		
		System.out.println("The total jobs of phonemploi from Jibe are: " + phonemploi_jibe.size());
		int phonemploi_mismatch = Helper.compareJobFeeds(phonemploi_ms,phonemploi_jibe, "Pshonemploi");
		
		assertEquals(0, phonemploi_mismatch);
		
		System.out.println("-----------------------------------------------------");
	}
	
	@Test
	public void recrulexMatchTest() {
		
		System.out.println("The total jobs of recrulex from Jibe are: " + recrulex_jibe.size());
		int recrulex_mismatch = Helper.compareJobFeeds(recrulex_ms,recrulex_jibe, "Recrulex");
		
		assertEquals(0, recrulex_mismatch);
		
		System.out.println("-----------------------------------------------------");
	}
}
