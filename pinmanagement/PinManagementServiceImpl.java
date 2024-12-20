package com.td.mbna.msec.midtier.pinmanagement;

import com.td.mbna.msec.midtier.pinmanagement.payload.changepin.ChangePinRequest;
import com.td.mbna.msec.midtier.pinmanagement.payload.changepin.ChangePinResponse;
import com.td.mbna.msec.midtier.pinmanagement.payload.getpin.GetPinRequest;
import com.td.mbna.msec.midtier.pinmanagement.payload.unlockpin.UnblockPinRequest;
import com.td.mbna.msec.midtier.pinmanagement.payload.unlockpin.UnblockPinResponse;
import com.td.mbna.msec.midtier.util.perf.ProfileLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PinManagementServiceImpl implements PinManagementService {


    @Autowired
    private ChangePinOperationImpl changePinOperation;

    @Autowired
    private ViewPinOperationImpl viewPinOperation;

    @Autowired
    private UnblockPinOperationImpl unblockPinOperation;


    @ProfileLog
    @Override
    public com.td.mbna.msec.midtier.pinmanagement.payload.getpin.GetPinResponse getPin(GetPinRequest request, String... token) {
        return viewPinOperation.invokeService(request,token);
    }

    @ProfileLog
    @Override
    public ChangePinResponse changePin(ChangePinRequest request, String... token) {
        return changePinOperation.invokeService(request,token);
    }

    @ProfileLog
    @Override
    public UnblockPinResponse unlockPin(UnblockPinRequest request, String... token) {
        return unblockPinOperation.invokeService(request, token);
    }

}
