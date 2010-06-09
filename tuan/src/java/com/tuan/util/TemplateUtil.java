/**
 * 
 */
package com.tuan.util;

import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Template utility methods.
 * @author BruceSun
 *
 */
public class TemplateUtil {
	
	private static final Logger LOG = LoggerFactory.getLogger(TemplateUtil.class);
	/**
	 * Template path
	 */
	private String loadPath ="template";
	/**
	 * Log class
	 */
	private String logClass="org.apache.velocity.runtime.log.Log4JLogChute";
	/**
	 * Input encoding
	 */
	private String inputEncoding="utf-8";
	/**
	 * Output encoding
	 */
	private String outputEncoding="utf-8";
	/**
	 * Template content cache
	 */
	private Boolean needCache=Boolean.TRUE;
	/**
	 * Check template file modify interval
	 */
	private int checkInterval=1800;
	
	/**
	 * Init velocity properties
	 */
	public void init(){
		try{
			Properties p = new Properties();
		    p.setProperty("file.resource.loader.path", this.getClass().getResource("/"+loadPath).getPath());
		    p.setProperty("runtime.log.logsystem.class",logClass);
		    p.setProperty("input.encoding",inputEncoding);
		    p.setProperty("output.encoding",outputEncoding);
		    p.setProperty("file.resource.loader.cache", needCache.toString());
		    p.setProperty( "file.resource.loader.modificationCheckInterval", ""+checkInterval );  
			Velocity.init(p);
		}catch(Exception e){
			LOG.error("Init Velocity Error:", e);
		}
	}
	/**
	 * Parse template.
	 * @param path
	 * @param map
	 * @return
	 */
	public String parseTemplate(String path,Map<String,Object> map){
		VelocityContext context = new VelocityContext();
		for(String key : map.keySet()){
			context.put(key, map.get(key));
		}
		try{
			Template template = Velocity.getTemplate("/"+path);
			StringWriter writer = new StringWriter();
			template.merge(context, writer);
			return writer.getBuffer().toString();
		}catch(Exception e){
			LOG.error("Get Velocity Template Error", e);
			return "";
		}
	}

	public String getLoadPath() {
		return loadPath;
	}


	public void setLoadPath(String loadPath) {
		this.loadPath = loadPath;
	}


	public String getLogClass() {
		return logClass;
	}


	public void setLogClass(String logClass) {
		this.logClass = logClass;
	}


	public String getInputEncoding() {
		return inputEncoding;
	}


	public void setInputEncoding(String inputEncoding) {
		this.inputEncoding = inputEncoding;
	}


	public String getOutputEncoding() {
		return outputEncoding;
	}


	public void setOutputEncoding(String outputEncoding) {
		this.outputEncoding = outputEncoding;
	}


	public boolean isNeedCache() {
		return needCache;
	}


	public void setNeedCache(boolean needCache) {
		this.needCache = needCache;
	}


	public int getCheckInterval() {
		return checkInterval;
	}


	public void setCheckInterval(int checkInterval) {
		this.checkInterval = checkInterval;
	}
	
	
}
