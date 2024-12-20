package com.td.mbna.msec.midtier.enrollment;
import com.td.mbna.msec.midtier.account.payload.deleteaccount.DeleteAccountResponse;
import com.td.mbna.msec.midtier.customerprofile.payload.retrieveenrollment.RetrieveEnrollmentResponse;
import com.td.mbna.msec.midtier.enrollment.facade.TdEnrollmentFacade;
import com.td.mbna.msec.midtier.util.perf.ProfileLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MbnaEnrollmentImpl implements MbnaEnrollment{
	
    @Autowired
    private TdEnrollmentFacade tdEnrollmentFacade;
	
    @Override
    @ProfileLog
    public RetrieveEnrollmentResponse retrieveEnrollment(String connectId, String token) {
        return tdEnrollmentFacade.retrieveEnrollments(connectId,token);
    }
	
    @Override
    @ProfileLog
    public DeleteAccountResponse unEnroll(String connectId, String accountId, String token) {
        return tdEnrollmentFacade.unEnroll(connectId,accountId,token);
    }
	
	@Override
	@ProfileLog
	public String cleanApiCache(String connectId) {
		return tdEnrollmentFacade.cleanApiCache(connectId);
	}
}