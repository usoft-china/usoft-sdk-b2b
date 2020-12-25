package com.usoft.sdk.b2b.client.v2.uas;

import com.usoft.b2b.trade.external.uas.api.protobuf.PagingBuyerOrderProductReplyReq;
import com.usoft.b2b.trade.external.uas.api.protobuf.PagingBuyerOrderProductReplyResp;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

/**
 * @author uas
 * @date 2020/10/27 10:59
 */
public class UasOrderGetSdkTest {
    /**
     * 测试地址
     */
//    private UasOrderGetSdk uasOrderGetSdk = new UasOrderGetSdk("https://b2btraderest.uuzcc.cn", "10050904", "c97d043cb9894c1e8c4dac330cf3cde9");

    /**
     * 正式地址
     */
    private UasOrderGetSdk uasOrderGetSdk = new UasOrderGetSdk("https://b2btraderest.usoftchina.com", "10044430", "b31b1ceb5cd34ea6978aa81adbcca3d8");


    @Test
    public void pagingBuyerOrderProductReply() throws Exception {
        PagingBuyerOrderProductReplyReq.Builder req = PagingBuyerOrderProductReplyReq.newBuilder();
        req.setPageNumber(1);
        req.setPageSize(10);
//        req.setOrderProductCode("OP200821800439569394");
        req.setSortType(20);
        PagingBuyerOrderProductReplyResp resp = uasOrderGetSdk.pagingBuyerOrderProductReply(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }
}
