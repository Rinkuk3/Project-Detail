package com.td.mbna.msec.midtier.pinmanagement;

import com.td.mbna.msec.midtier.pinmanagement.payload.changepin.ChangePinRequest;
import com.td.mbna.msec.midtier.pinmanagement.payload.changepin.ChangePinResponse;
import com.td.mbna.msec.midtier.pinmanagement.payload.getpin.GetPinRequest;
import com.td.mbna.msec.midtier.pinmanagement.payload.getpin.GetPinResponse;
import com.td.mbna.msec.midtier.pinmanagement.payload.unlockpin.UnblockPinRequest;
import com.td.mbna.msec.midtier.pinmanagement.payload.unlockpin.UnblockPinResponse;

public interface PinManagementService {
	public GetPinResponse getPin(GetPinRequest request, String... token);
	public ChangePinResponse changePin(ChangePinRequest request, String... token);
	public UnblockPinResponse unlockPin(UnblockPinRequest request, String... token);
}
