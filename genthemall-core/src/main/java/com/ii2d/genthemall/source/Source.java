package com.ii2d.genthemall.source;

import java.util.Collection;
import java.util.List;

/**
 * source interface
 * @author Doni
 * @since 2012-09-09
 */
public interface Source {

	/**
	 * source name
	 */
	String getName();
	
	/**
	 * set name of the source
	 */
	void setName(String name);
	
	/**
	 * get properties from this source
	 */
	List<SourceProperty> getSourceProperties();
	
	
	/**
	 * add a source property object
	 */
	public boolean addSourceProperty(SourceProperty p);
	
	/**
	 * add collection source properties
	 */
	public boolean addSourceProperty(Collection<SourceProperty> properties);
}
