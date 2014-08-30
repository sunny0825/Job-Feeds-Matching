package JobFeedTest.JibePost.model;

public class Job {
	private String jobId;
	private String title;
	private String location;
	private String category;
	private String postdate;
	private String department;
	private String description;
	private String url;
	
	public Job() {}
	
	public Job(String jobId, String title, String location, String postdate, String url) {
		this.jobId = jobId;
		this.title = title;
		this.location = location;
		this.postdate = postdate;
		this.url = url;
	}
	
	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getJobId() {
		return jobId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}

	public void setPostdate(String postdate) {
		this.postdate = postdate;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String toString(){
		String display = "*******************************************"+
						 "\nJob ID: " + jobId +
						 "\nCategory: " + category +
						 "\nJob Title: " + title +
						 "\nJob Location: " + location +
						 "\nPost Date: " + postdate;
		return display;
	}
	
	public boolean equals(Job comparedJob) {	
		if(!this.title.equals(comparedJob.title)) {
			System.out.println("title doesn't match for: " + this.jobId);
			return false;
		}else if(!this.postdate.equals(comparedJob.postdate)) {
			System.out.println("postdate doesn't match for: " + this.jobId);
			return false;
		}
		
		return true;
	}
}
