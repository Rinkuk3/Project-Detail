package com.td.mbna.msec.midtier.mbnaap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.td.api.mbpad.response.retrievebranch.RetrieveBranchResponse;
import com.td.mbna.msec.midtier.autopay.payload.addpad.AddPadRequest;
import com.td.mbna.msec.midtier.autopay.payload.addpad.AddPadResponse;
import com.td.mbna.msec.midtier.autopay.payload.checkpadenrolled.CheckPadEnrolledResponse;
import com.td.mbna.msec.midtier.autopay.payload.retrievepad.RetrievePadResponse;
import com.td.mbna.msec.midtier.autopay.payload.updatepad.UpdatePadRequest;
import com.td.mbna.msec.midtier.autopay.payload.validatebankaccount.ValidateBankAccountRequest;
import com.td.mbna.msec.midtier.autopay.payload.validatebankaccount.ValidateBankAccountResponse;
import com.td.mbna.msec.midtier.mbnaap.MbnaAP;
import com.td.mbna.msec.midtier.mbnaap.facade.MbnaAPFacade;

@Service
public class MbnaAPImpl implements MbnaAP {

    @Autowired
    MbnaAPFacade mbnaAPFacade;
    
	@Override
	public CheckPadEnrolledResponse checkEnrolledForPad(String cardNum, String token) {
		return mbnaAPFacade.checkEnrolledForPad(cardNum, token);
	}

	@Override
	public RetrievePadResponse retrievePad(String arrangementId, String token) {
		return mbnaAPFacade.retrievePad(arrangementId, token);
	}

	@Override
	public boolean deletePad(String arrangementId, String token) {
		return false;
	}

	@Override
	public AddPadResponse addPad(AddPadRequest addPadRequest, String token) {
		return mbnaAPFacade.addPad(addPadRequest, token);
	}

	@Override
	public String updatePad(UpdatePadRequest updatePadRequest, String token) {
		return null;
	}

	@Override
	public ValidateBankAccountResponse validateBankAccount(ValidateBankAccountRequest request, String token) {
		return mbnaAPFacade.validateBankAccount(request, token);
	}

	@Override
	public RetrieveBranchResponse retrieveBranch(String bankNum, String branchNum, String token) {
		return mbnaAPFacade.retrieveBranch(bankNum, branchNum, token);
	}
	
}
