package batch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONArray;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class SelectStudentLowScore implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			URL url = new URL("http://localhost:9999/student/low-score-list");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
			if(conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				StringBuffer sb = new StringBuffer();
				String line = null;
				while((line = br.readLine()) != null)
					sb.append(line);
				
				JSONArray json = new JSONArray(sb.toString());
				
				for(int i=0;i<json.length();i++) {
					System.out.println(
							json.getJSONObject(i).getString("studentNo")
							+ " / " + json.getJSONObject(i).getString("studentName")
							+ " / " + json.getJSONObject(i).getString("majorName")
							+ " / " + json.getJSONObject(i).getDouble("score")
					);
				}
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}









