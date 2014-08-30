package JobFeedTest.JibePost.Basic;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.*;

import JobFeedTest.JibePost.XMLFeedController.JobFeedCollection;
import JobFeedTest.JibePost.model.Job;

public class BaseScript {
	
	public static HashMap<String, Job> msJobMap;
	public static HashMap<String, Job> acc_ms;
	public static HashMap<String, Job> nerd_ms;
	public static HashMap<String, Job> mssv_ms;
	public static HashMap<String, Job> mappedinisrael_ms;
	public static HashMap<String, Job> sixfigurejob_ms;
	public static HashMap<String, Job> hbcu_ms;
	public static HashMap<String, Job> naukri_ms;
	public static HashMap<String, Job> careerbuilderfr_ms;
	public static HashMap<String, Job> erecrut_ms;
	public static HashMap<String, Job> lesJeudis_ms;
	public static HashMap<String, Job> phonemploi_ms;
	public static HashMap<String, Job> recrulex_ms;
	public static HashMap<String, Job> skypeLync_ms;
	public static HashMap<String, Job> yammer_ms;
	public static HashMap<String, Job> others_ms;
	
	public static HashMap<String, Job> indeed_jibe;	
	public static HashMap<String, Job> linkedIn_jibe;
	public static HashMap<String, Job> skypeLync_jibe;
	public static HashMap<String, Job> yammer_jibe;
	public static HashMap<String, Job> others_jibe;
	public static HashMap<String, Job> glassdoor_jibe;	
	public static HashMap<String, Job> diversityworking_jibe;	
	public static HashMap<String, Job> burningglass_jibe;	
	public static HashMap<String, Job> gajgal_jibe;	
	public static HashMap<String, Job> punchkick_jibe;	
	public static HashMap<String, Job> simplyhired_jibe;	
	public static HashMap<String, Job> directemployer_jibe;	
	public static HashMap<String, Job> acc_jibe;	
	public static HashMap<String, Job> nerd_jibe;	
	public static HashMap<String, Job> mssv_jibe;	
	public static HashMap<String, Job> mappedinisrael_jibe;	
	public static HashMap<String, Job> sixfigurejob_jibe;	
	public static HashMap<String, Job> hbcu_jibe;	
	public static HashMap<String, Job> naukri_jibe;	
	public static HashMap<String, Job> phonemploi_jibe;	
	public static HashMap<String, Job> erecrut_jibe;	
	public static HashMap<String, Job> lesJeudis_jibe;	
	public static HashMap<String, Job> recrulex_jibe;	
	public static HashMap<String, Job> careerbuilderfr_jibe;
	
	@BeforeClass
    public static void setUp() throws Exception {
		
		//Microsoft job feed
		msJobMap = new HashMap<String, Job>();
		acc_ms = new HashMap<String, Job>();
		nerd_ms = new HashMap<String, Job>();
		mssv_ms = new HashMap<String, Job>();
		mappedinisrael_ms = new HashMap<String, Job>();
		sixfigurejob_ms = new HashMap<String, Job>();
		hbcu_ms = new HashMap<String, Job>();
		naukri_ms = new HashMap<String, Job>();
		careerbuilderfr_ms = new HashMap<String, Job>();
		erecrut_ms = new HashMap<String, Job>();
		lesJeudis_ms = new HashMap<String, Job>();
		phonemploi_ms = new HashMap<String, Job>();
		recrulex_ms = new HashMap<String, Job>();
		skypeLync_ms = new HashMap<String, Job>();
		yammer_ms = new HashMap<String, Job>();
		others_ms = new HashMap<String, Job>();
		
		JobFeedCollection.buildMSJobs(msJobMap, mssv_ms, acc_ms, nerd_ms, 
				mappedinisrael_ms, sixfigurejob_ms, hbcu_ms, naukri_ms, 
				careerbuilderfr_ms, erecrut_ms, lesJeudis_ms, phonemploi_ms, recrulex_ms,
				skypeLync_ms, yammer_ms, others_ms);
		
		System.out.println("The total jobs from Microsoft are: " + msJobMap.size());
		System.out.println("Acc jobs from Microsoft are: " + acc_ms.size());
		System.out.println("NERD jobs from Microsoft are: " + nerd_ms.size());
		System.out.println("Microsoft Sillicon Valley jobs from Microsoft are: " + mssv_ms.size());
		System.out.println("Mappedinisrael jobs from Microsoft are: " + mappedinisrael_ms.size()); 
		System.out.println("6 figure jobs from Microsoft are: " + sixfigurejob_ms.size()); 
		System.out.println("hbcu jobs from Microsoft are: " + hbcu_ms.size());
		System.out.println("naukri jobs from Microsoft are: " + naukri_ms.size());
		System.out.println("careerbuilder france jobs from Microsoft are: " + careerbuilderfr_ms.size());
		System.out.println("erecrut jobs from Microsoft are: " + erecrut_ms.size());
		System.out.println("les Jeudis jobs from Microsoft are: " + lesJeudis_ms.size());
		System.out.println("phonemploi jobs from Microsoft are: " + phonemploi_ms.size());
		System.out.println("recrulex jobs from Microsoft are: " + recrulex_ms.size());
		
		String utm;
		
		//Microsoft Sillicon Valley job feed from Jibe
		mssv_jibe = new HashMap<String, Job>();
		JobFeedCollection.buildMSSV_From_Jibe(mssv_jibe);
		utm = "utm_source=MicrosoftSiliconValley";
		checkUtm(mssv_jibe, utm);
		
		//Indeed job feed from Jibe
		indeed_jibe = new HashMap<String, Job>();
		JobFeedCollection.buildIndeed_From_Jibe(indeed_jibe);
		utm = "utm_source=Indeed";
		checkUtm(indeed_jibe, utm);
		
		//LinkedIn job feed from Jibe
		linkedIn_jibe = new HashMap<String, Job>();
		skypeLync_jibe = new HashMap<String, Job>();
		yammer_jibe = new HashMap<String, Job>();
		others_jibe = new HashMap<String, Job>();
		JobFeedCollection.buildLinkedIn_From_Jibe(linkedIn_jibe, skypeLync_jibe, yammer_jibe, others_jibe);
		utm = "utm_source=LinkedIn";
		checkUtm(linkedIn_jibe, utm);
		
		//Glassdoor job feed from Jibe
		glassdoor_jibe = new HashMap<String, Job>();
		JobFeedCollection.buildGlassdoor_From_Jibe(glassdoor_jibe);
		utm = "utm_source=GlassDoor";
		checkUtm(glassdoor_jibe, utm);
		
		//Diversity Working job feed from Jibe
		diversityworking_jibe = new HashMap<String, Job>();
		JobFeedCollection.buildDiversityWorking_From_Jibe(diversityworking_jibe);
		utm = "utm_source=DiversityWorking";
		checkUtm(diversityworking_jibe, utm);
		
		//Burning Glass job feed from Jibe
		burningglass_jibe = new HashMap<String, Job>();
		JobFeedCollection.buildBurningGlass_From_Jibe(burningglass_jibe);
		utm = "utm_source=BurningGlass";
		checkUtm(burningglass_jibe, utm);
		
		//Gajgal job feed from Jibe
		gajgal_jibe = new HashMap<String, Job>();
		JobFeedCollection.buildGajgal_From_Jibe(gajgal_jibe);
		utm = "utm_source=Gajgal";
		checkUtm(gajgal_jibe, utm);
		
		//Punchkick job feed from Jibe
		punchkick_jibe = new HashMap<String, Job>();
		JobFeedCollection.buildPunchkick_From_Jibe(punchkick_jibe);
		utm = "utm_source=Punchkick";
		checkUtm(punchkick_jibe, utm);
		
		//Simplyhired job feed from Jibe
		simplyhired_jibe = new HashMap<String, Job>();
		JobFeedCollection.buildSimplyhired_From_Jibe(simplyhired_jibe);
		utm = "utm_source=SimplyHired";
		checkUtm(simplyhired_jibe, utm);
		
		//Direct Employer job feed from Jibe
		directemployer_jibe = new HashMap<String, Job>();
		JobFeedCollection.buildDirectEmployer_From_Jibe(directemployer_jibe);
		utm = "utm_source=SimplyHired";
		checkUtm(simplyhired_jibe, utm);
		
		//ACC job feed from Jibe
		acc_jibe = new HashMap<String, Job>();
		JobFeedCollection.buildACC_From_Jibe(acc_jibe);
		utm = "utm_source=ACC";
		checkUtm(acc_jibe, utm);
				
		//NERD job feed from Jibe
		nerd_jibe = new HashMap<String, Job>();
		JobFeedCollection.buildNERD_From_Jibe(nerd_jibe);
		utm = "utm_source=custom";
		checkUtm(nerd_jibe, utm);
		
		//mappedinisrael job feed from Jibe
		mappedinisrael_jibe = new HashMap<String, Job>();
		JobFeedCollection.buildMappedinisrael_From_Jibe(mappedinisrael_jibe);
		utm = "utm_source=MappedInIsrael";
		checkUtm(mappedinisrael_jibe, utm);
		
		//6 figure job feed from Jibe
		sixfigurejob_jibe = new HashMap<String, Job>();
		JobFeedCollection.buildSixFigureJobs_From_Jibe(sixfigurejob_jibe);
		utm = "utm_source=6FigureJobs";
		checkUtm(sixfigurejob_jibe, utm);
		
		//hbcu job feed from Jibe
		hbcu_jibe = new HashMap<String, Job>();
		JobFeedCollection.buildHBCU_From_Jibe(hbcu_jibe);
		utm = "utm_source=HBCU";
		checkUtm(hbcu_jibe, utm);
		
		//naukri job feed from Jibe
		naukri_jibe = new HashMap<String, Job>();
		JobFeedCollection.buildNaukri_From_Jibe(naukri_jibe);
		utm = "utm_source=Naukri";
		checkUtm(naukri_jibe, utm);
			
		//careerbuilderfr job feed from Jibe
		careerbuilderfr_jibe = new HashMap<String, Job>();
		JobFeedCollection.buildCareerbuilderfr_From_Jibe(careerbuilderfr_jibe);
		utm = "utm_source=CareerBuilderFrance";
		checkUtm(careerbuilderfr_jibe, utm);
		
		//erecrut job feed from Jibe
		erecrut_jibe = new HashMap<String, Job>();
		JobFeedCollection.buildErecrut_From_Jibe(erecrut_jibe);
		utm = "utm_source=Erecrut";
		checkUtm(erecrut_jibe, utm);
		
		//lesjeudis job feed from Jibe
		lesJeudis_jibe = new HashMap<String, Job>();
		JobFeedCollection.buildLesjeudis_From_Jibe(lesJeudis_jibe);
		utm = "utm_source=Lesjeudis";
		checkUtm(lesJeudis_jibe, utm);
		
		//phonemploi job feed from Jibe
		phonemploi_jibe = new HashMap<String, Job>();
		JobFeedCollection.buildPhonemploi_From_Jibe(phonemploi_jibe);
		utm = "utm_source=Phonemploi";
		checkUtm(phonemploi_jibe, utm);
		
		recrulex_jibe = new HashMap<String, Job>();
		JobFeedCollection.buildRecrulex_From_Jibe(recrulex_jibe);

		System.out.println("Test is starting ************************************\n");
			
	}
	
	public static void checkUtm(HashMap<String, Job> jobMap, String utm) {
		Iterator<Entry<String, Job>> it = jobMap.entrySet().iterator();
		Map.Entry pairs;
		Job job;
		boolean check = false;
	    while (it.hasNext()) {
	        pairs = (Map.Entry)it.next();
	        job = (Job) pairs.getValue();
	        if(!job.getUrl().contains(utm)) {
	        	System.out.println(job.getJobId() + " doesn't contain " + utm);
	        	check = true;
	        }
	    }
	    if(check){
	    	System.out.println("-----------------------------------------------------");
	    }
	}
	
	@AfterClass
	public static void runAfterClass() {
		System.out.println("\nTest is over     ************************************\n");
	}
}
