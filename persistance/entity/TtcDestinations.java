package com.td.mbna.msec.midtier.persistance.entity;

import java.io.Serializable;

import lombok.Data;

/**
 * This class corresponds to individual rows in the TTCDESTINATIONS table in the local database.
 *   
 */
@Data
public class TtcDestinations  implements Serializable {

	private static final long serialVersionUID = 2847602721721504823L;
	private Integer ttcDestinationId;
	private String customerId;
	private String nickname;
	private String bankId;
	private String transitNum;
	private String accountNumber;

}
