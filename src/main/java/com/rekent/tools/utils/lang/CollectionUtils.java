package com.rekent.tools.utils.lang;

import java.util.Collection;

/**
 * 
 * Utils to operate Collection
 * 
 * @author richard.zhang
 *
 */
public class CollectionUtils {

	/**
	 * if collection is empty or null
	 * 
	 * @param collection
	 * @return
	 */
	public static boolean isEmpty(Collection<?> collection) {
		if (collection == null) {
			return true;
		}
		return collection.isEmpty();
	}

	/**
	 * if collection is not empty and not null
	 * 
	 * @param collection
	 * @return
	 */
	public static boolean isNotEmpty(Collection<?> collection) {
		return !isEmpty(collection);
	}
}
