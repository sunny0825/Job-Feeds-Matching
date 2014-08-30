package JobFeedTest.JibePost.XMLFeedController;

public class AppConstant {
	
	// Microsoft xml feed tags: "Clientjobid", "Title", "City", "State", "Country", "Category", "Postdate"
	public static final String MSJobTag = "Job";
	public static final String MSIDTag = "Clientjobid";
	public static final String MSTitleTag = "Title";
	public static final String MSCityTag = "City";
	public static final String MSStateTag = "State";
	public static final String MSCountryTag = "Country";
	public static final String MSCategoryTag = "Category";
	public static final String MSPostdateTag = "Postdate";
	public static final String MSDepartmentTag = "Department";
	public static final String MSDescriptionTag = "Description";
	
	//Jibe xml feed tags: "job", "referencenumber", "title", "city", "state", "country", "Category", "date"
	public static final String JibeJobTag = "job";
	public static final String JibeIDTag = "referencenumber";
	public static final String JibeTitleTag = "title";
	public static final String JibeCityTag = "city";
	public static final String JibeStateTag = "state";
	public static final String JibeCountryTag = "country";
	public static final String JibeCategoryTag = "category";
	public static final String JibeDepartmentTag = "department";
	public static final String JibePostdateTag = "date";
	public static final String JibeUrlTag = "url";
	
	//Jibe xml feed tags which are different than generic ones
	
	//Glassdoor Tag
	public static final String GlassdoorIDTag = "guid";
	public static final String GlassdoorPostdateTag = "post_date";
	
	//Indeed Tag
	public static final String IndeedIDTag = "JobID";
	public static final String CompanyIDTag = "CompanyID";
	public static final String ProductSrvTag = "Productservice";
	
	public static final String IDTag = "id";
	public static final String PostdateTag = "date_posted";
	public static final String LocationTag = "location";
	public static final String CatetoriesTag = "categories";
	public static final String CustomTag = "custom";
	
	
}
