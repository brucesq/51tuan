/**
 * 
 */
package com.tuan.util;

import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Utility class providing methods to access the Locale of the current thread 
 * @author BruceSun
 *
 */
public class I18NUtil {
	 /**
     * Thread-local containing the content Locale for for the current thread.  This
     * can be used for content and property filtering.
     */
	private static ThreadLocal<Locale> threadContentLocale = new ThreadLocal<Locale>();
	/**
     * List of registered bundles
     */
	private static Set<String> resouceBundleBaseNames = new HashSet<String>();
	/**
     * Map of loaded bundles by Locale
     */    
	private static Map<Locale, Set<String>> loadedResourceBundles = new HashMap<Locale, Set<String>>();
	/**
     * Map of cached messaged by Locale
     */    
	private static Map<Locale, Map<String, String>> cachedMessages = new HashMap<Locale, Map<String, String>>();
	    
	/**
	 * Lock objects 
	 */  
	private static ReadWriteLock lock = new ReentrantReadWriteLock();
	private static Lock readLock = lock.readLock();
	private static Lock writeLock = lock.writeLock();

	/**
     * Thread-local containing the general Locale for the current thread
     */
    private static ThreadLocal<Locale> threadLocale = new ThreadLocal<Locale>();
    
    /**
     * Set the locale for the current thread.
     * 
     * @param locale   
     */
    public static void setLocale(Locale locale){
        threadLocale.set(locale);
    }

    /**
     * Get the general local for the current thread, will revert to the default locale if none 
     * specified for this thread.
     * 
     * @return 
     */
    public static Locale getLocale(){
        Locale locale = threadLocale.get(); 
        if (locale == null){
            locale = Locale.getDefault();
        }
        return locale;
    }
    
    /**
     * Get a Locale from a lang country string.
     * 
     * @param localeStr e.g. fr_FR
     * @return
     */
    public static Locale parseLocale(String localeStr){
        if(localeStr == null){
            return null; 
        }
        Locale locale = Locale.getDefault();
        StringTokenizer t = new StringTokenizer(localeStr, "_");
        int tokens = t.countTokens();
        if (tokens == 1){
           locale = new Locale(t.nextToken());
        }else if (tokens == 2){
           locale = new Locale(t.nextToken(), t.nextToken());
        }else if (tokens == 3){
           locale = new Locale(t.nextToken(), t.nextToken(), t.nextToken());
        }
        return locale;
    }
    /**
     * Set the content local for current thread
     * @param locale
     */
    public static void setContentLocale(Locale locale){
        threadContentLocale.set(locale);
    }
    public static Locale getContentLocale(){
        Locale locale = threadContentLocale.get(); 
        if (locale == null){
            // Revert to the normal locale
            locale = getLocale();
        }
        return locale;
    }
    /**
     * Register a resource bundle
     * @param bundleBaseName
     */
    public static void registerResourceBundle(String bundleBaseName){
        try{
            writeLock.lock();
            resouceBundleBaseNames.add(bundleBaseName);
        }
        finally{
            writeLock.unlock();
        }
    }
    /**
     * Get message from register bundle
     * @param messageKey
     * @return
     */
    public static String getMessage(String messageKey){
        return getMessage(messageKey, getLocale());
    }
    /**
     * Get a local message string
     * @param messageKey
     * @param locale
     * @return
     */
    public static String getMessage(String messageKey, Locale locale){
        String message = null;
        Map<String, String> props = getLocaleProperties(locale);
        if (props != null){
            message = props.get(messageKey);
        }                
        return message;
    }
    /**
     * Get a local message string, parameterized using standard MessageFormatter.
     * @param messageKey
     * @param params
     * @return
     */
    public static String getMessage(String messageKey, Object ... params){
        return getMessage(messageKey, getLocale(), params);
    }
    /**
     * Get a local message string, parameterized using standard MessageFormatter.
     * @param messageKey
     * @param locale
     * @param params
     * @return
     */
    public static String getMessage(String messageKey, Locale locale, Object ... params){
        String message = getMessage(messageKey, locale);
        if (message != null && params != null){
            message = MessageFormat.format(message, params);
        }
        return message;
    }
    
    /**
     * Get local properties
     * @param locale
     * @return
     */
    private static Map<String, String> getLocaleProperties(Locale locale){
        Set<String> loadedBundles = null;
        Map<String, String> props = null;
        int loadedBundleCount = 0;
        try{
            readLock.lock();
            loadedBundles = loadedResourceBundles.get(locale);
            props = cachedMessages.get(locale);
            loadedBundleCount = resouceBundleBaseNames.size();
        }
        finally{
            readLock.unlock();
        }
        
        if (loadedBundles == null){
            try{
                writeLock.lock();
                loadedBundles = new HashSet<String>();
                loadedResourceBundles.put(locale, loadedBundles);
            }
            finally {
                writeLock.unlock();
            }
        }
        
        if (props == null){
            try{
                writeLock.lock();
                props = new HashMap<String, String>();
                cachedMessages.put(locale, props);
            }
            finally{
                writeLock.unlock();
            }
        }
                
        if (loadedBundles.size() != loadedBundleCount){
            try{
                writeLock.lock();
                for (String resourceBundleBaseName : resouceBundleBaseNames){
                    if (loadedBundles.contains(resourceBundleBaseName) == false){
                        ResourceBundle resourcebundle = ResourceBundle.getBundle(resourceBundleBaseName, locale);
                        Enumeration<String> enumKeys = resourcebundle.getKeys();
                        while (enumKeys.hasMoreElements() == true){
                            String key = enumKeys.nextElement();
                            props.put(key, resourcebundle.getString(key));
                        }
                        loadedBundles.add(resourceBundleBaseName);
                    }
                }
            }
            finally{
                writeLock.unlock();
            }
        }
        
        return props;
    }
}
