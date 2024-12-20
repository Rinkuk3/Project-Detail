package com.td.mbna.msec.midtier.tdwsservices;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

public class RcpFilter extends ConcurrentHashMap<String,String> {

	private static final long serialVersionUID = 688797429148589909L;
	private int filterIndex = 1;
	public final static RcpFilter ALL = new RcpFilter();
	public final static RcpFilter ALL_BUT_RELATIONSHIPS = new RcpFilter();
	public final static RcpFilter ALL_BUT_PREFERENCES = new RcpFilter();
	public final static RcpFilter PROFILE_AND_CONTACTS = new RcpFilter();
	public final static RcpFilter PROFILE = new RcpFilter();
	public final static RcpFilter CONTACTS = new RcpFilter();
	public final static RcpFilter PREFERENCES = new RcpFilter();
	public final static RcpFilter CONTACTS_AND_PREFERENCES = new RcpFilter(); 
	public final static RcpFilter RELATIONSHIPS = new RcpFilter();
	public final static RcpFilter RELATIONSHIPS_CARDHISTORY = new RcpFilter(); // to get card history
	static {
		ALL.addProfile().addContacts().addPreferences().addRelationships();
		ALL_BUT_RELATIONSHIPS.addProfile().addContacts().addPreferences();
		ALL_BUT_PREFERENCES.addProfile().addContacts().addRelationships();
		PROFILE_AND_CONTACTS.addProfile().addContacts();
		PROFILE.addProfile();
		CONTACTS.addContacts();
		PREFERENCES.addPreferences();
		CONTACTS_AND_PREFERENCES.addContacts().addPreferences();
		RELATIONSHIPS.addRelationships();
		RELATIONSHIPS_CARDHISTORY.addRelationships().addCardhistory();
	}
	
	private RcpFilter() {
		// prevent user from creating new filters
	}

	private RcpFilter addCardhistory() {
		put("dataTypeCd"+filterIndex++, "RELATIONSHIPS-CARDHISTORY");
		return this;
	}

	private RcpFilter addProfile() {
		put("dataTypeCd"+filterIndex++, "PROFILE");
		return this;
	}

	private RcpFilter addContacts() {
		put("dataTypeCd"+filterIndex++, "CONTACTS");
		return this;
	}

	private RcpFilter addPreferences() {
		put("dataTypeCd"+filterIndex++, "PREFERENCES");
		//put("dataTypeCd"+filterIndex++, "PREFERENCES-LOCATOR");
		return this;
	}

	private RcpFilter addRelationships() {
		put("dataTypeCd"+filterIndex++, "RELATIONSHIPS");
		return this;
	}
	
	public boolean containsFilter(RcpFilter filter) {
		Collection<String> inFilterTypeCds = new ArrayList<String>(filter.values()); 
		Collection<String> myFilterTypeCds = new ArrayList<String>(this.values());
		// local array lists used above because we don't know if the collection objects returned are thread-safe
		return myFilterTypeCds.containsAll(inFilterTypeCds);
	}
}