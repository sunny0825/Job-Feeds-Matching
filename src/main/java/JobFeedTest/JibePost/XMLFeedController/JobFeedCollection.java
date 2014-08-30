package JobFeedTest.JibePost.XMLFeedController;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.json.simple.parser.ParseException;

import JobFeedTest.JibePost.model.Job;

public class JobFeedCollection {
	
	//Microsoft job feed
	public static void buildMSJobs(HashMap<String, Job> msJobMap,
			HashMap<String, Job> mssv_from_ms,
			HashMap<String, Job> acc_from_ms, 
			HashMap<String, Job> nerd_from_ms, 
			HashMap<String, Job> mappedinisrael_from_ms,
			HashMap<String, Job> sixfigurejob_from_ms,
			HashMap<String, Job> hbcu_from_ms,
			HashMap<String, Job> naukri_from_ms,
			HashMap<String, Job> careerbuilderfr_from_ms,
			HashMap<String, Job> erecrut_from_ms,
			HashMap<String, Job> lesJeudis_from_ms,
			HashMap<String, Job> phonemploi_from_ms,
			HashMap<String, Job> recrulex_from_ms,
			HashMap<String, Job> skypeLync_from_ms,
			HashMap<String, Job> yammer_from_ms, 
			HashMap<String, Job> others_from_ms) {
		//Filter locations for Microsoft Silicon Valley
		Set<String> mssvLocations = new HashSet<String>(Arrays.asList( new String[] {"Mountain View, CA","Sunnyvale, CA","Palo Alto, CA","San Francisco, CA"}));
		
		//Filter location for NERD
		String nerdLocation_1 = "Cambridge, MA, United States";
		String nerdLocation_2 = "Boston, MA, United States";
		
		//Filter title for ACC
		String accCategory = "Legal";
		String accTitle = "Paralegal";
		
		//Filter country for mappedinisrael
		String mappedinisraelCountry = "Israel";
		
		//Filter keyword for 6 figure jobs
		String sixFigureDepartment = "Retail Stores";
		String sixFigureCategory = "Business Services & Administration";
		
		//Filter department and country for hbcu
		String hbcuDepartment = "Cloud and Enterprise Engineering";
		
		//Filter country for naukri
		String naukriCountry = "India";
		
		//Filter country for careerbuilder France
		String careerbuildfrCountry = "France";
		
		String erecrutCategory_1 = "Sales";
		String erecrutCategory_2 = "Consulting";
		String lesJeudisCategory = "IT";
		String phonemploiCategory = "Customer Service";
		String recrulexCategory = "Legal";
		
		JobFeedRetriever.parseMSXmlFeed("https://microsoft_jobsfeed.com", 
									msJobMap, mssv_from_ms, acc_from_ms, nerd_from_ms,
									mappedinisrael_from_ms, sixfigurejob_from_ms, hbcu_from_ms, naukri_from_ms,
									careerbuilderfr_from_ms, erecrut_from_ms, lesJeudis_from_ms, phonemploi_from_ms, recrulex_from_ms,
									skypeLync_from_ms, yammer_from_ms, others_from_ms,
									AppConstant.MSJobTag, 
									AppConstant.MSIDTag, 
									AppConstant.MSTitleTag, 
									AppConstant.MSCityTag, 
									AppConstant.MSStateTag, 
									AppConstant.MSCountryTag, 
									AppConstant.MSCategoryTag, 
									AppConstant.MSDepartmentTag,
									AppConstant.MSPostdateTag,
									AppConstant.MSDescriptionTag,
									AppConstant.ProductSrvTag,
									mssvLocations,
									nerdLocation_1, nerdLocation_2, 
									mappedinisraelCountry,
									accCategory, accTitle,
									sixFigureDepartment, sixFigureCategory,
									hbcuDepartment,
									naukriCountry,
									careerbuildfrCountry, erecrutCategory_1, erecrutCategory_2, lesJeudisCategory, 
									phonemploiCategory, recrulexCategory);
	}
	
	//Miscrosoft Silicon Valley job feed from Jibe
	public static void buildMSSV_From_Jibe(HashMap<String, Job> jobMap) throws Exception {
		JobFeedRetriever.parseJSONFeed("https://microsoft-mssv.json", jobMap);
	}
	
	//Indeed job feed from Jibe
	public static void buildIndeed_From_Jibe(HashMap<String, Job> jobMap) {
		
		genericBuild_1("https://microsoft-indeed.xml", jobMap);
	}
	
	//LinkedIn job feed from Jibe
	public static void buildLinkedIn_From_Jibe(HashMap<String, Job> jobMap,  HashMap<String, Job> skypeLync_map,
												HashMap<String, Job> yammer_map, HashMap<String, Job> others_map) {
		JobFeedRetriever.parseJibeXmlFeed_3("https://microsoft-linkedin.xml", 
											jobMap, skypeLync_map, yammer_map, others_map,
											AppConstant.JibeJobTag, 
											AppConstant.IndeedIDTag, 
											AppConstant.JibeTitleTag, 
											AppConstant.JibeCityTag,
											AppConstant.JibeStateTag,
											AppConstant.JibeCountryTag,
											AppConstant.JibePostdateTag, 
											AppConstant.CompanyIDTag, 
											AppConstant.JibeUrlTag);
	}
	
	//Glassdoor job feed from Jibe 
	public static void buildGlassdoor_From_Jibe(HashMap<String, Job> jobMap) {
		
		JobFeedRetriever.parseJibeXmlFeed("https://microsoft-glassdoor.xml", jobMap,
									AppConstant.JibeJobTag,
									AppConstant.GlassdoorIDTag,
									AppConstant.JibeTitleTag,
									AppConstant.JibeCityTag,
									AppConstant.JibeStateTag,
									AppConstant.JibeCountryTag,
									AppConstant.JibeCategoryTag,
									AppConstant.GlassdoorPostdateTag,
									AppConstant.JibeUrlTag);
	}
	
	//Diversity Working job feed from Jibe
	public static void buildDiversityWorking_From_Jibe(HashMap<String, Job> jobMap) {
		genericBuild_2("https://microsoft-diversityworking.xml", jobMap);
	}
	
	//Burning Glass job feed from Jibe
	public static void buildBurningGlass_From_Jibe(HashMap<String, Job> jobMap) {	
		genericBuild_2("https://microsoft-burningglass.xml", jobMap);
	}
	
	//Gajgal job feed from Jibe
	public static void buildGajgal_From_Jibe(HashMap<String, Job> jobMap) {
		genericBuild_2("https://microsoft-gajgal.xml", jobMap);
	}
	
	//Punchkick job feed from Jibe
	public static void buildPunchkick_From_Jibe(HashMap<String, Job> jobMap) {
		genericBuild_2("https://microsoft-punchkick.xml", jobMap);
	}
	
	//Simplyhired job feed from Jibe
	public static void buildSimplyhired_From_Jibe(HashMap<String, Job> jobMap) {
		genericBuild_2("https://microsoft-simplyhired.xml", jobMap);
	} 
	
	//Direct Employer 
	public static void buildDirectEmployer_From_Jibe(HashMap<String, Job> jobMap) {
		genericBuild_2("https://microsoft-directemployers.xml", jobMap);
	}
	
	//ACC job feed from Jibe 
	public static void buildACC_From_Jibe(HashMap<String, Job> jobMap) {	
		genericBuild_1("https://microsoft-acc.xml", jobMap);
	}
	
	//NERD job feed from Jibe 
	public static void buildNERD_From_Jibe(HashMap<String, Job> jobMap) {			
		genericBuild_1("https://microsoft-nerd.xml", jobMap);
	}
	
	//mappedinisrael job feed from Jibe
	public static void buildMappedinisrael_From_Jibe(HashMap<String, Job> jobMap) {
			
		genericBuild_2("https://microsoft-mappedinisrael.xml", jobMap);
	}
	
	//6 figure job feed from Jibe
	public static void buildSixFigureJobs_From_Jibe(HashMap<String, Job> jobMap) {	
		genericBuild_2("https://microsoft-6figure.xml", jobMap);
	}
	
	//hbcu job feed from Jibe
	public static void buildHBCU_From_Jibe(HashMap<String, Job> jobMap) {
		genericBuild_2("https://microsoft-hbcu.xml", jobMap);
	}
	
	//naukri job feed from Jibe
	public static void buildNaukri_From_Jibe(HashMap<String, Job> jobMap) {
		genericBuild_2("https://microsoft-naukri.xml", jobMap);
	}
	
	//careerbuilderfr job feed from Jibe
	public static void buildCareerbuilderfr_From_Jibe(HashMap<String, Job> jobMap) {
		genericBuild_2("https://microsoft-careerbuilderfr.xml", jobMap);
	}
	
	//erecrut job feed from Jibe
	public static void buildErecrut_From_Jibe(HashMap<String, Job> jobMap) {
		genericBuild_2("https://microsoft-erecrut.xml", jobMap);
	}
	
	//lesjeudis job feed from Jibe
	public static void buildLesjeudis_From_Jibe(HashMap<String, Job> jobMap) {
		genericBuild_2("https://microsoft-lesjeudis.xml", jobMap);
	}
	
	//phonemploi job feed from Jibe
	public static void buildPhonemploi_From_Jibe(HashMap<String, Job> jobMap) {
		genericBuild_2("https://microsoft-phonemploi.xml", jobMap);
	}	
	
	//recrulex job feed from Jibe
	public static void buildRecrulex_From_Jibe(HashMap<String, Job> jobMap) {
		genericBuild_2("https://microsoft-recrulex.xml", jobMap);
	}
	
	public static void genericBuild_1(String xmlUrl, HashMap<String, Job> jobMap) {
		
		JobFeedRetriever.parseJibeXmlFeed(xmlUrl, jobMap,
				AppConstant.JibeJobTag, 
				AppConstant.JibeIDTag, 
				AppConstant.JibeTitleTag, 
				AppConstant.JibeCityTag, 
				AppConstant.JibeStateTag, 
				AppConstant.JibeCountryTag, 
				AppConstant.JibeCategoryTag, 
				AppConstant.JibePostdateTag,
				AppConstant.JibeUrlTag);
	}
	
	public static void genericBuild_2(String xmlUrl, HashMap<String, Job> jobMap) {
		
		JobFeedRetriever.parseJibeXmlFeed2(xmlUrl, jobMap,
				AppConstant.JibeJobTag, 
				AppConstant.IDTag, 
				AppConstant.JibeTitleTag, 
				AppConstant.LocationTag,
				AppConstant.CatetoriesTag,
				AppConstant.JibeCategoryTag,
				AppConstant.CustomTag,
				AppConstant.JibeDepartmentTag,
				AppConstant.PostdateTag,
				AppConstant.JibeUrlTag);
	}
}
