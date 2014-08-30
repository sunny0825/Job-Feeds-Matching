package JobFeedTest.JibePost.XMLFeedController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import JobFeedTest.JibePost.model.Job;

public class JobFeedRetriever {
	
	//XML parser for Microsoft job feed
	public static void parseMSXmlFeed(String xmlUrl, HashMap<String, Job> msJobMap, 
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
			HashMap<String, Job> others_from_ms,
			String jobTag, String jobIdTag, String titleTag, String cityTag, String stateTag, String countryTag, 
			String categoryTag, String departmentTag, String postdateTag, String descriptionTag, String productSrvTag,
			Set<String> mssvLocations,
			String nerdLocation_1, String nerdLocation_2, 
			String mappedinisraelCountry,
			String accCategory, String accTitle,
			String sixFigureDepartemtn, String sixFigureCategory,
			String hbcuDepartment,
			String naukriCountry,
			String careerbuildfrCountry, String erecrutCategory_1, String erecrutCategory_2, String lesJeudisCategory, 
			String phonemploiCategory, String recrulexCategory) {
		
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

			URL url = new URL(xmlUrl);
			
			InputStream stream = url.openStream();
			Document doc = docBuilder.parse(stream);
			Job newJob = null;
			String jobId, title, city, state, cityState, country, location, description, category, department, postdate, productService;

			doc.getDocumentElement().normalize();
			
			NodeList listOfJobs = doc.getElementsByTagName(jobTag);
			
			for (int i = 0; i < listOfJobs.getLength(); i++) {
				
				Node jobNode = listOfJobs.item(i);
				
				if (jobNode.getNodeType() == Node.ELEMENT_NODE) {
					
					Element jobElement = (Element) jobNode;
					newJob = new Job();
					
					jobId = retrieveValue(jobElement,jobIdTag);
					ArrayList<String> idList = new ArrayList<String>(Arrays.asList(jobId.split("-")));
					newJob.setJobId(idList.get(0).trim());
					
					title = retrieveValue(jobElement,titleTag);
					newJob.setTitle(title);
					
					city = retrieveValue(jobElement,cityTag);
					ArrayList<String> cityList = new ArrayList<String>(Arrays.asList(city.split(",")));
					if(cityList.size() == 2) {
						city = cityList.get(1).trim();
						state = cityList.get(0).trim();
					}else{
						state = "";
					}
					if(city.equals("Bellevue")) {
						state = "WA";
					}else if(city.equals("Washington DC")) {
						state = "DC";
					}
					cityState = city + ", " + state;
					
					country = retrieveValue(jobElement,countryTag);
					location = cityState + ", " + country;
					newJob.setLocation(location);
					
					category = retrieveValue(jobElement,categoryTag);
					newJob.setCategory(category);
					
					department = retrieveValue(jobElement,departmentTag);
					newJob.setDepartment(department);
					
					postdate = retrieveValue(jobElement,postdateTag);
					newJob.setPostdate(postdate);
					
					description = retrieveValue(jobElement,descriptionTag);
					newJob.setDescription(description);
					
					productService = retrieveValue(jobElement, productSrvTag);
					
					msJobMap.put(jobId + location, newJob);
					
					if(mssvLocations.contains(cityState)) {
						mssv_from_ms.put(jobId + location, newJob);
					}
					
					if(location.equalsIgnoreCase(nerdLocation_1) || location.equals(nerdLocation_2)) {
						nerd_from_ms.put(jobId + location, newJob);
					}
					
					if(category.contains(accCategory) && !title.contains(accTitle)) {
						acc_from_ms.put(jobId + location, newJob);
					}
					
					if(country.equalsIgnoreCase(mappedinisraelCountry)) {
						mappedinisrael_from_ms.put(jobId + location, newJob);
					}
					
					if(country.equalsIgnoreCase(naukriCountry)) {
						naukri_from_ms.put(jobId + location, newJob);
					}
					
					if(country.equalsIgnoreCase(careerbuildfrCountry)) {
						careerbuilderfr_from_ms.put(jobId + location, newJob);
						
						if(category.contains(erecrutCategory_1) || category.contains(erecrutCategory_2)) {
							erecrut_from_ms.put(jobId + location, newJob);
						}else if(category.contains(lesJeudisCategory)) {
							lesJeudis_from_ms.put(jobId + location, newJob);
						}else if(category.contains(phonemploiCategory)) {
							phonemploi_from_ms.put(jobId + location, newJob);
						}else if(category.contains(recrulexCategory)) {
							recrulex_from_ms.put(jobId + location, newJob);
						}
					}
					
					if(!department.equalsIgnoreCase(sixFigureDepartemtn) && !category.equalsIgnoreCase(sixFigureCategory)) {
						sixfigurejob_from_ms.put(jobId + location, newJob);
					}
					
					if(department.equalsIgnoreCase(hbcuDepartment)) {
						hbcu_from_ms.put(jobId + location, newJob);
					}
					
					if(productService.equals("Skype") || productService.equals("Lync")) {
    					skypeLync_from_ms.put(jobId + location, newJob);
    				}else if(productService.equals("Yammer")) {
    					yammer_from_ms.put(jobId + location, newJob);
    				}else{
    					others_from_ms.put(jobId + location, newJob);
    				}
				
					newJob = null;		
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}
	
	//XML parser for Jibe-Post job feeds version_1
	public static void parseJibeXmlFeed(String xmlUrl, HashMap<String, Job> jobMap, String jobTag, String jobIdTag,
										String titleTag, String cityTag, String stateTag, String countryTag, 
										String categoryTag, String postdateTag, String urlTag) {
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

			URL url = new URL(xmlUrl);
			InputStream stream = url.openStream();
			Document doc = docBuilder.parse(stream);
			Job newJob = null;
			String value, jobId, city, state, country, location;

			doc.getDocumentElement().normalize();
			NodeList listOfJobs = doc.getElementsByTagName(jobTag);

			for (int i = 0; i < listOfJobs.getLength(); i++) {

				Node jobNode = listOfJobs.item(i);

				if (jobNode.getNodeType() == Node.ELEMENT_NODE) {

					Element jobElement = (Element) jobNode;
					newJob = new Job();

					value = retrieveValue(jobElement, jobIdTag);
					ArrayList<String> idList = new ArrayList<String>(Arrays.asList(value.split("-")));
					jobId = idList.get(0).trim();
					newJob.setJobId(jobId);

					value = retrieveValue(jobElement, titleTag);
					newJob.setTitle(value);

					city = retrieveValue(jobElement,cityTag);
					ArrayList<String> cityList = new ArrayList<String>(Arrays.asList(city.split(",")));
					if(cityList.size() == 2) {
						city = cityList.get(1).trim();
					}
					
					state = retrieveValue(jobElement,stateTag);
					if(cityList.size() == 2 && state.equals("")) {
						state = cityList.get(0).trim();
					}

					country = retrieveValue(jobElement, countryTag);
					location = city + ", " + state + ", " + country;
					newJob.setLocation(location);
					
					value = retrieveValue(jobElement, postdateTag);
					newJob.setPostdate(value);
					
					value = retrieveValue(jobElement, urlTag);
					newJob.setUrl(value);

					jobMap.put(jobId + location, newJob);

					newJob = null;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}
	
	//XML parser for Jibe-Post job feeds version_2
	public static void parseJibeXmlFeed2(String xmlUrl, HashMap<String, Job> jobMap, String jobTag, String jobIdTag,
										String titleTag, String locationTag, String categoriesTag, String categoryTag,
										String customTag, String departmentTag, String postdateTag, String urlTag) {
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

			URL url = new URL(xmlUrl);
			InputStream stream = url.openStream();
			Document doc = docBuilder.parse(stream);
			Job newJob = null;
			String value, jobId, city, location;

			doc.getDocumentElement().normalize();
			NodeList listOfJobs = doc.getElementsByTagName(jobTag);

			for (int i = 0; i < listOfJobs.getLength(); i++) {

				Node jobNode = listOfJobs.item(i);

				if (jobNode.getNodeType() == Node.ELEMENT_NODE) {

					Element jobElement = (Element) jobNode;
					newJob = new Job();

					value = retrieveValue(jobElement, jobIdTag);
					ArrayList<String> idList = new ArrayList<String>(Arrays.asList(value.split("-")));
					jobId = idList.get(0).trim();
					newJob.setJobId(jobId);
					
					value = retrieveValue(jobElement, titleTag);
					newJob.setTitle(value);

					newJob = retrieveLocation(newJob, jobElement,locationTag);
						
					value = retrieveChildValue(jobElement, categoriesTag, categoryTag);
					newJob.setCategory(value);
						
					value = retrieveChildValue(jobElement, customTag, departmentTag);
					newJob.setDepartment(value);
						
					value = retrieveValue(jobElement, postdateTag);
					newJob.setPostdate(value);
					
					value = retrieveValue(jobElement, urlTag);
					newJob.setUrl(value);

					jobMap.put(jobId + newJob.getLocation(), newJob);
					
					newJob = null;
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}
	
	//XML parser for Jibe-Post job feeds version_3
	public static void parseJibeXmlFeed_3(String xmlUrl, HashMap<String, Job> jobMap, HashMap<String, Job> skypeLync_map,
											HashMap<String, Job> yammer_map, HashMap<String, Job> others_map,
											String jobTag, String jobIdTag, String titleTag, String cityTag, String stateTag,
											String countryTag, String postdateTag, String companyIDTag, String urlTag) {
		try {
			DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();

			URL url = new URL(xmlUrl);
			InputStream stream = url.openStream();
			Document doc = docBuilder.parse(stream);
			Job newJob = null;
			String value, jobId, title, city, state, country, location, postdate, companyId;

			doc.getDocumentElement().normalize();
			NodeList listOfJobs = doc.getElementsByTagName(jobTag);

			for (int i = 0; i < listOfJobs.getLength(); i++) {

				Node jobNode = listOfJobs.item(i);

				if (jobNode.getNodeType() == Node.ELEMENT_NODE) {

					Element jobElement = (Element) jobNode;
					newJob = new Job();

					jobId = retrieveValue(jobElement, jobIdTag);
					ArrayList<String> idList = new ArrayList<String>(Arrays.asList(jobId.split("-")));
					jobId = idList.get(0).trim();
					newJob.setJobId(jobId);

					title = retrieveValue(jobElement, titleTag);
					newJob.setTitle(title);

					city = retrieveValue(jobElement, cityTag);
					state = retrieveValue(jobElement, stateTag);
					country = retrieveValue(jobElement, countryTag);
					location = city + ", " + state + ", " + country;
					if(location.equals("Puerto Rico, San Juan, , Puerto Rico")) {
						location = "San Juan, Puerto Rico, Puerto Rico";
					}
					newJob.setLocation(location);

					postdate = retrieveValue(jobElement, postdateTag);
					newJob.setPostdate(postdate);

					value = retrieveValue(jobElement, urlTag);
					newJob.setUrl(value);
					
					companyId = retrieveValue(jobElement, companyIDTag);
					if(companyId.equals("7299")) {
						skypeLync_map.put(jobId + location, newJob);
					}else if(companyId.equals("260901")) {
						yammer_map.put(jobId + location, newJob);
					}else if(companyId.equals("1035")) {
						others_map.put(jobId + location, newJob);
					}

					jobMap.put(jobId + location, newJob);
					newJob = null;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static Element retrieveElement(Element jobElement, String tagName) {
		NodeList nodeList = jobElement.getElementsByTagName(tagName);
		return (Element) nodeList.item(0);
	}
	
	//help function
	public static String retrieveValue(Element jobElement, String tagName) {
		Element nodeElement = retrieveElement(jobElement, tagName);
		
		if(nodeElement == null) { return ""; }
		
		NodeList textnodeList = nodeElement.getChildNodes();
		
		if(textnodeList.item(0) == null) { return ""; }
		return textnodeList.item(0).getNodeValue().trim();
	}
	
	public static String retrieveChildValue(Element jobElement, String parentTagName, String childTagName) {
		Element nodeElement = retrieveElement(jobElement, parentTagName);
		return retrieveValue(nodeElement, childTagName);
	}
	
	//help function for retrieving location
	public static Job retrieveLocation(Job newJob, Element jobElement, String tagName) {
		Element nodeElement = retrieveElement(jobElement, tagName);
		
		String city = retrieveValue(nodeElement, "city");
		String state = retrieveValue(nodeElement, "state");
		String country = retrieveValue(nodeElement, "country");
		ArrayList<String> cityList = new ArrayList<String>(Arrays.asList(city.split(",")));
		if(cityList.size() == 2) {
			city = cityList.get(1).trim();
			state = cityList.get(0).trim();
		}
		newJob.setLocation(city + ", " + state + ", " + country);
		
		return newJob;
	}
	
	//JSON parser for Jibe-Post job feed
	public static void parseJSONFeed(String jsonUrl, HashMap<String, Job> jobMap) throws Exception {
		URL url = new URL(jsonUrl);
		InputStream inputStream = url.openStream();
		File jsonFile = new File("microsoft-sv.json");
		OutputStream outputStream = new FileOutputStream(jsonFile);

		int read = 0;
		byte[] bytes = new byte[1024];
	
		while ((read = inputStream.read(bytes)) != -1) {
			outputStream.write(bytes, 0, read);
		}
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(jsonFile));
		JSONObject jsonObj = (JSONObject)obj;
		JSONArray array = (JSONArray) jsonObj.get("jobs");

		Iterator<JSONObject> it = array.iterator();
		JSONObject eachObj;
		JSONObject locationObj = null;
		String id, title, date_posted, city, state, country, location, utmUrl;

		Job newJob;
		while (it.hasNext()) {
			eachObj = it.next();
			id = (String) eachObj.get("id");
			ArrayList<String> idList = new ArrayList<String>(Arrays.asList(id.split("-")));
			id = idList.get(0).trim();
			title = (String)eachObj.get("title");
			date_posted = (String)eachObj.get("date_posted");
			
			locationObj = (JSONObject) eachObj.get("location");
			city = (String) locationObj.get("city");
			state = (String)locationObj.get("state");
			country = (String)locationObj.get("country");
			location = city + ", " + state + ", " +country;
			utmUrl = (String)eachObj.get("url");
			
			newJob = new Job(id, title.trim(), location, date_posted, utmUrl);
			jobMap.put(id+location, newJob);
		}
	}
 }

