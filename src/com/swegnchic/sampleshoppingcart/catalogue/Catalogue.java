package com.swegnchic.sampleshoppingcart.catalogue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;

import com.swegnchic.sampleshoppingcart.danceclass.DanceClass;

/**
 * Manages list of dance classes
 * 
 * @author swegnchic
 *
 */
public class Catalogue {
	private static Catalogue catalogue;	
	private CatalogueDAO catalogueDAO;	
	private HashMap<Long, DanceClass> danceClasses;
	private List<DanceClass> danceClassList;
	
	public Catalogue(Context context) {		
		catalogueDAO = new CatalogueDAO(context);		
		danceClasses = new HashMap<Long, DanceClass>();
	}
	
	public static Catalogue getInstance(Context context) {
		if(catalogue == null) {
			catalogue = new Catalogue(context);
		}		
		return catalogue;
	}
	
	public int getCatalogueSize() {
		return danceClasses.size();
	}
	
	public long saveDanceClass(DanceClass danceClass) {	
		long id = catalogueDAO.insertClass(danceClass);
		danceClasses.put(id, danceClass);		
		return id;
	}
	
	public DanceClass getDanceClassById(long id) {		
		return danceClasses.get(id);
	}
	
	public List<DanceClass> getDanceClasses() {
		danceClassList = catalogueDAO.getDanceClasses();
		return danceClassList;
	}
	
	
	public List<String> getDanceClassNames() {
		List<String> names = new ArrayList<String>();
		for(DanceClass danceClass : danceClassList){
			names.add(danceClass.getName());
		}		
		return names;
	}
}
