package com.tuan.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Generic utility methods
 * @author BruceSun
 *
 */
@SuppressWarnings("unchecked")
public class GenericsUtils {
	private static final Logger LOG = LoggerFactory.getLogger(BeanUtils.class);

	private GenericsUtils() {
	}

	/**
	 * Get superclass  generic type 
	 *
	 * @param clazz The class to introspect
	 * @return the first generic declaration, or <code>Object.class</code> if cannot be determined
	 */
	public static Class getSuperClassGenricType(Class clazz) {
		return getSuperClassGenricType(clazz, 0);
	}

	/**
	 * Get superclass generic type . for example, public BookManager extends GenricManager<Book>
	 *
	 * @param clazz clazz The class to introspect
	 * @param index the Index of the generic declaration,start from 0.
	 * @return the index generic declaration, or <code>Object.class</code> if cannot be determined
	 */
	
	public static Class getSuperClassGenricType(Class clazz, int index) {

		Type genType = clazz.getGenericSuperclass();

		if (!(genType instanceof ParameterizedType)) {
			if(LOG.isWarnEnabled()){
				LOG.warn(clazz.getSimpleName() + "'s superclass not ParameterizedType");
			}
			
			return Object.class;
		}

		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();

		if (index >= params.length || index < 0) {
			if(LOG.isWarnEnabled()){
				LOG.warn("Index: " + index + ", Size of " + clazz.getSimpleName() + "'s Parameterized Type: "
						+ params.length);
				
			}
			return Object.class;
		}
		if (!(params[index] instanceof Class)) {
			if(LOG.isWarnEnabled()){
				LOG.warn(clazz.getSimpleName() + " not set the actual class on superclass generic parameter");
				
			}
			return Object.class;
		}
		return (Class) params[index];
	}
}
