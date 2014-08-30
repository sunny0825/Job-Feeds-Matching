package JobFeedTest.JibePost.XMLFeedController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import JobFeedTest.JibePost.model.Job;

public class Helper {
	
	public static int compareJobFeeds(HashMap<String, Job> msJobFeed, HashMap<String, Job> jibeJobFeed, String xmlFeed) {
		
		int msSize = msJobFeed.size();
		int jibeSize = jibeJobFeed.size();
		int mismatch_cnt = 0;
		
		String key = null;
		Job job_From_Jibe, job_From_MS;
		Iterator<Entry<String, Job>> it = jibeJobFeed.entrySet().iterator();
		Map.Entry pairs;
	    while (it.hasNext()) {
	        pairs = (Map.Entry)it.next();
	        key = (String) pairs.getKey();
	        job_From_Jibe = (Job) pairs.getValue();
	        job_From_MS = msJobFeed.get(key);
	        
	        if(job_From_MS == null) {
	        	System.out.println("Cannot match the job from Microsoft: " + job_From_Jibe.getJobId() + " " + job_From_Jibe.getLocation());
	        	mismatch_cnt++;
	        }else if(!job_From_Jibe.equals(job_From_MS)){
	        	mismatch_cnt++;
	        }
	    }
		
		if(mismatch_cnt == 0 && msSize == jibeSize) {
			System.out.println(xmlFeed+ " matched with Microsoft!");
		}else{
			if(mismatch_cnt == 0) {
				mismatch_cnt = msSize - jibeSize;
			}
			System.out.println(mismatch_cnt +" mismatched jobs between "+ xmlFeed + " and Microsoft");
			System.out.println("-----------------------------------------------------");
		}
		
		return mismatch_cnt;
	}
}
