package com.swegnchic.sampleshoppingcart.catalogue;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;

import com.swegnchic.sampleshoppingcart.constants.Constants;
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
	
	private List<DanceClass> danceClasses;
	
	private Catalogue(Context context) {		
		catalogueDAO = new CatalogueDAO(context);
		
		danceClasses = getDanceClasses();
	}
	
	public static Catalogue getCatalogue(Context context) {
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
		danceClasses.add(danceClass);
		
		return id;
	}
	
	public DanceClass getDanceClassById(long id) {
		if(danceClasses.size() <=0) {
			danceClasses = getDanceClasses();
		}
		
		DanceClass danceClass = new DanceClass();
		for(int i=0; i<danceClasses.size(); i++){
			if(danceClasses.get(i).getId() == id) {
				danceClass = danceClasses.get(i);
			}
		}
		
		return danceClass;
	}
	
	public List<DanceClass> getDanceClasses() {
		if(danceClasses == null) {
			danceClasses = new ArrayList<DanceClass>();
		} else {
			Cursor c = catalogueDAO.getDanceClassesCursor();
			manageCursor(c);
		}
		
		return danceClasses;
	}
	
	private void manageCursor(Cursor c) {
		if(c.moveToFirst()) {
			do {
				String className = c.getString(c.getColumnIndex(Constants.CLASS_NAME));
				String description = c.getString(c.getColumnIndex(Constants.DESCRIPTION_NAME));
				long id = c.getLong(c.getColumnIndex(Constants.KEY_ID));
				
				DanceClass tempClass = new DanceClass();
				tempClass.setName(className);
				tempClass.setDescription(description);
				tempClass.setId(id);
				
				danceClasses.add(tempClass);
				
			} while(c.moveToNext());
		}
	}
	
	public List<String> getDanceClassNames() {
		if(danceClasses.size() <=0) {
			danceClasses = getDanceClasses();
		}
		
		List<String> names = new ArrayList<String>();
		for(DanceClass danceClass : danceClasses){
			names.add(danceClass.getName());
		}
		
		return names;
	}
}
