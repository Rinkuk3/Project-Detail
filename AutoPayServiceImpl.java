package com.td.mbna.msec.midtier.autopay;

import com.td.mbna.msec.midtier.autopay.AutoPayService;
import com.td.mbna.msec.midtier.autopay.payload.addpad.AddPadRequest;
import com.td.mbna.msec.midtier.autopay.payload.addpad.AddPadResponse;
import com.td.mbna.msec.midtier.autopay.payload.checkpadenrolled.CheckPadEnrolledRequest;
import com.td.mbna.msec.midtier.autopay.payload.checkpadenrolled.CheckPadEnrolledResponse;
import com.td.mbna.msec.midtier.autopay.payload.retrievepad.RetrievePadRequest;
import com.td.mbna.msec.midtier.autopay.payload.retrievepad.RetrievePadResponse;
import com.td.mbna.msec.midtier.autopay.payload.validatebankaccount.ValidateBankAccountRequest;
import com.td.mbna.msec.midtier.autopay.payload.validatebankaccount.ValidateBankAccountResponse;
import com.td.mbna.msec.midtier.util.MbnaLogger;
import com.td.mbna.msec.midtier.util.perf.ProfileLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutoPayServiceImpl implements AutoPayService {

	private final static MbnaLogger logger = new MbnaLogger(AutoPayServiceImpl.class);

	@Autowired
	private CheckPadEnrolledOperation checkPadEnrolledOperation;

	@Autowired
	private RetrievePadOperation retrievePadOperation;

	@Autowired
	private AddPadOperation addPadOperation;
	
	@Autowired
	private ValidateBankAccountOperation validateBankAccountOperation;
	
	@ProfileLog
	public CheckPadEnrolledResponse checkPadEnrolled(CheckPadEnrolledRequest request, String... token) {
		return checkPadEnrolledOperation.invokeService(request, token);
	}

	@Override
	public RetrievePadResponse retrievePad(RetrievePadRequest request, String... token) {
		return retrievePadOperation.invokeService(request, token);
	}

	@Override
	public ValidateBankAccountResponse validateBankAccount(ValidateBankAccountRequest validateBankAccountRequest, String... token) {
		return validateBankAccountOperation.invokeService(validateBankAccountRequest, token);
	}

	@Override
	public AddPadResponse addPad(AddPadRequest addPadRequest, String... token) {
		return this.addPadOperation.invokeService(addPadRequest, token);
	}
}
