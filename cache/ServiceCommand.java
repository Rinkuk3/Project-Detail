package com.td.mbna.msec.midtier.cache;

import java.io.Serializable;

//import com.ibm.websphere.command.CacheableCommandImpl;

/**
 * Service Command
 *
 */
public abstract class ServiceCommand  implements Serializable, BaseServiceCommand {

	private static final long serialVersionUID = 8245376264063166007L;
	
	/**
	 * is ready to call execute
	 */
	//@Override
	public boolean isReadyToCallExecute() {
		return true;
	}

	public abstract void performExecute();
}
