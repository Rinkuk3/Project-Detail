package com.td.mbna.msec.midtier.transfer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.td.mbna.msec.midtier.transfer.payload.addbalancetransfertocreditorpayee.AddBalanceTransferToCreditorPayeeRequest;
import com.td.mbna.msec.midtier.transfer.payload.addbalancetransfertocreditorpayee.AddBalanceTransferToCreditorPayeeResponse;
import com.td.mbna.msec.midtier.transfer.payload.adddeposittochequingpayee.AddDepositToChequingPayeeRequest;
import com.td.mbna.msec.midtier.transfer.payload.adddeposittochequingpayee.AddDepositToChequingPayeeResponse;
import com.td.mbna.msec.midtier.transfer.payload.balancetransfertocreditor.BalanceTransferToCreditorRequest;
import com.td.mbna.msec.midtier.transfer.payload.balancetransfertocreditor.BalanceTransferToCreditorResponse;
import com.td.mbna.msec.midtier.transfer.payload.deletebalancetransfertocreditorpayee.DeleteBalanceTransferToCreditorPayeeRequest;
import com.td.mbna.msec.midtier.transfer.payload.deletebalancetransfertocreditorpayee.DeleteBalanceTransferToCreditorPayeeResponse;
import com.td.mbna.msec.midtier.transfer.payload.deletedeposittochequingpayee.DeleteDepositToChequingPayeeRequest;
import com.td.mbna.msec.midtier.transfer.payload.deletedeposittochequingpayee.DeleteDepositToChequingPayeeResponse;
import com.td.mbna.msec.midtier.transfer.payload.deposittochequing.DepositToChequingRequest;
import com.td.mbna.msec.midtier.transfer.payload.deposittochequing.DepositToChequingResponse;
import com.td.mbna.msec.midtier.transfer.payload.getbalancetransfertocreditorpayees.GetBalanceTransferToCreditorPayeesRequest;
import com.td.mbna.msec.midtier.transfer.payload.getbalancetransfertocreditorpayees.GetBalanceTransferToCreditorPayeesResponse;
import com.td.mbna.msec.midtier.transfer.payload.getbalancetransfertocreditorsummary.GetBalanceTransferToCreditorSummaryRequest;
import com.td.mbna.msec.midtier.transfer.payload.getbalancetransfertocreditorsummary.GetBalanceTransferToCreditorSummaryResponse;
import com.td.mbna.msec.midtier.transfer.payload.getdeposittochequingpayees.GetDepositToChequingPayeesRequest;
import com.td.mbna.msec.midtier.transfer.payload.getdeposittochequingpayees.GetDepositToChequingPayeesResponse;
import com.td.mbna.msec.midtier.transfer.payload.getknowncardissuers.GetKnownCardIssuersRequest;
import com.td.mbna.msec.midtier.transfer.payload.getknowncardissuers.GetKnownCardIssuersResponse;
import com.td.mbna.msec.midtier.transfer.payload.updatebalancetransfertocreditorpayee.UpdateBalanceTransferToCreditorPayeeRequest;
import com.td.mbna.msec.midtier.transfer.payload.updatebalancetransfertocreditorpayee.UpdateBalanceTransferToCreditorPayeeResponse;
import com.td.mbna.msec.midtier.transfer.payload.updatedeposittochequingpayee.UpdateDepositToChequingPayeeRequest;
import com.td.mbna.msec.midtier.transfer.payload.updatedeposittochequingpayee.UpdateDepositToChequingPayeeResponse;
import com.td.mbna.msec.midtier.util.perf.ProfileLog;

@Component("transferServiceImpl")
public class TransferServiceImpl implements TransferService {

	@Autowired
	private AddBalanceTransferToCreditorPayeeOperation addBalanceTransferToCreditorPayeeOperation;

	@Autowired
	private AddDepositToChequingPayeeOperation addDepositToChequingPayeeOperation;

	@Autowired
	private DeleteBalanceTransferToCreditorPayeeOperation deleteBalanceTransferToCreditorPayeeOperation;

	@Autowired
	private DeleteDepositToChequingPayeeOperation deleteDepositToChequingPayeeOperation;

	@Autowired
	private DepositToChequingOperation depositToChequingOperation;

	@Autowired
	private UpdateDepositToChequingPayeeOperation updateDepositToChequingPayeeOperation;

	@Autowired
	private UpdateBalanceTransferToCreditorPayeeOperation updateBalanceTransferToCreditorPayeeOperation;

	@Autowired
	private BalanceTransferToCreditorOperation balanceTransferToCreditorOperation;

	@Autowired
	private GetBalanceTransferToCreditorPayeesOperation getBalanceTransferToCreditorPayeesOperation;

	@Autowired
	private GetBalanceTransferToCreditorSummaryOperation getBalanceTransferToCreditorSummaryOperation;

	@Autowired
	private GetDepositToChequingPayeesOperation getDepositToChequingPayeesOperation;

	@Autowired
	private GetKnownCardIssuersOperation getKnownCardIssuersOperation;


	@ProfileLog
	public BalanceTransferToCreditorResponse balanceTransferToCreditor(BalanceTransferToCreditorRequest balanceTransferToCreditorRequest, String... token) {
		return this.balanceTransferToCreditorOperation.invokeService(balanceTransferToCreditorRequest, token);
	}

	@ProfileLog
	public GetBalanceTransferToCreditorPayeesResponse getBalanceTransferToCreditorPayees(GetBalanceTransferToCreditorPayeesRequest getBalanceTransferToCreditorPayeesRequest) {
		return this.getBalanceTransferToCreditorPayeesOperation.invokeService(getBalanceTransferToCreditorPayeesRequest);
	}

	@ProfileLog
	public GetBalanceTransferToCreditorSummaryResponse getBalanceTransferToCreditorSummary(GetBalanceTransferToCreditorSummaryRequest getBalanceTransferToCreditorSummaryRequest) {
		return this.getBalanceTransferToCreditorSummaryOperation.invokeService(getBalanceTransferToCreditorSummaryRequest);
	}

	@ProfileLog
	public AddBalanceTransferToCreditorPayeeResponse addBalanceTransferToCreditorPayee(AddBalanceTransferToCreditorPayeeRequest addBalanceTransferToCreditorPayeeRequest) {
		return this.addBalanceTransferToCreditorPayeeOperation.invokeService(addBalanceTransferToCreditorPayeeRequest);
	}

	@ProfileLog
	public DeleteBalanceTransferToCreditorPayeeResponse deleteBalanceTransferToCreditorPayee(DeleteBalanceTransferToCreditorPayeeRequest deleteBalanceTransferToCreditorPayeeRequest) {
		return this.deleteBalanceTransferToCreditorPayeeOperation.invokeService(deleteBalanceTransferToCreditorPayeeRequest);
	}

	@ProfileLog
	public UpdateBalanceTransferToCreditorPayeeResponse updateBalanceTransferToCreditorPayee(UpdateBalanceTransferToCreditorPayeeRequest updateBalanceTransferToCreditorPayeeRequest) {
		return this.updateBalanceTransferToCreditorPayeeOperation.invokeService(updateBalanceTransferToCreditorPayeeRequest);
	}

	@ProfileLog
	public DepositToChequingResponse depositToChequing(DepositToChequingRequest depositToChequingRequest, String... token) {
		return this.depositToChequingOperation.invokeService(depositToChequingRequest, token);
	}

	@ProfileLog
	public GetDepositToChequingPayeesResponse getDepositToChequingPayees(GetDepositToChequingPayeesRequest getDepositToChequingPayeesRequest) {
		return this.getDepositToChequingPayeesOperation.invokeService(getDepositToChequingPayeesRequest);
	}

	@ProfileLog
	public AddDepositToChequingPayeeResponse addDepositToChequingPayee(AddDepositToChequingPayeeRequest addDepositToChequingPayeeRequest) {
		return this.addDepositToChequingPayeeOperation.invokeService(addDepositToChequingPayeeRequest);
	}

	@ProfileLog
	public DeleteDepositToChequingPayeeResponse deleteDepositToChequingPayee(DeleteDepositToChequingPayeeRequest deleteDepositToChequingPayeeRequest) {
		return this.deleteDepositToChequingPayeeOperation.invokeService(deleteDepositToChequingPayeeRequest);
	}

	@ProfileLog
	public UpdateDepositToChequingPayeeResponse updateDepositToChequingPayee(UpdateDepositToChequingPayeeRequest updateDepositToChequingPayeeRequest, String... token) {
		return this.updateDepositToChequingPayeeOperation.invokeService(updateDepositToChequingPayeeRequest, token);
	}

	@ProfileLog
	public GetKnownCardIssuersResponse getKnownCardIssuers(GetKnownCardIssuersRequest getKnownCardIssuersRequest) {
		return this.getKnownCardIssuersOperation.invokeService(getKnownCardIssuersRequest);
	}

}