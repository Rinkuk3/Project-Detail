package com.td.mbna.msec.midtier.mbcapd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.td.mbna.msec.midtier.customerprofile.payload.retrievecapd.RetrieveCapdRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.retrievecapd.RetrieveCapdResponse;
import com.td.mbna.msec.midtier.customerprofile.payload.retrievevaletdata.RetrieveValetDataRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.retrievevaletdata.RetrieveValetDataResponse;
import com.td.mbna.msec.midtier.customerprofile.payload.savevaletdata.SaveValetDataRequest;
import com.td.mbna.msec.midtier.customerprofile.payload.savevaletdata.SaveValetDataResponse;
import com.td.mbna.msec.midtier.mbcapd.facade.MbnaCapdFacade;
import com.td.mbna.msec.midtier.mbcapd.MbnaCapd;

@Service
public class MbnaCapdImpl implements MbnaCapd {

    @Autowired
    private MbnaCapdFacade mbnaCapdFacade;

    @Override
    public RetrieveCapdResponse retrieveCapd(RetrieveCapdRequest retrieveCapdRequest,String... token){
    	return mbnaCapdFacade.retrieveCapd(retrieveCapdRequest, token);
    }

    @Override
	public SaveValetDataResponse saveValetData(SaveValetDataRequest request, String... token){
    	return mbnaCapdFacade.saveValetData(request, token);
    }
    
    @Override
	public RetrieveValetDataResponse retrieveValetData(RetrieveValetDataRequest request, String... token){
    	return mbnaCapdFacade.retrieveValetData(request, token);
    }

}
