package com.td.mbna.msec.midtier.mbalert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.td.mbna.msec.midtier.mbalert.facade.MbnaAlertFacade;
import com.td.mbna.msec.midtier.service.EmailInfo;

@Service
public class MbnaAlertImpl implements MbnaAlert {

    @Autowired
    private MbnaAlertFacade mbnaOfpFacade;

	@Override
	public boolean addAlertEvent(EmailInfo emailInfo) {
		return mbnaOfpFacade.addAlertEvent(emailInfo);
	}
}
