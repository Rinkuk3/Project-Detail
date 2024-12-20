package com.td.api.mbna.msec.midtier.mbnaparty.payload;

import com.td.mbna.msec.midtier.types.common.BaseResponse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VerifyCardPartyResponse extends BaseResponse {
    public ResponsePayload responsePayload;
}
