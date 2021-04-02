package com.usoft.sdk.b2b.client.v2.uas;

import com.usoft.b2b.trade.external.uas.api.protobuf.GetBuyerOrderProductReq;
import com.usoft.b2b.trade.external.uas.api.protobuf.GetBuyerOrderProductResp;
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
     * 开发
     */
    private UasOrderGetSdk uasOrderGetSdk = new UasOrderGetSdk("http://127.0.0.1:27320", "10050624", "c49f7be6a861461ab951e55030055a5c");

    /**
     * 测试地址
     */
//    private UasOrderGetSdk uasOrderGetSdk = new UasOrderGetSdk("https://b2btraderest.uuzcc.cn", "10050904", "c97d043cb9894c1e8c4dac330cf3cde9");

    /**
     * 正式地址
     */
//    private UasOrderGetSdk uasOrderGetSdk = new UasOrderGetSdk("https://b2btraderest.usoftchina.com", "10044430", "b31b1ceb5cd34ea6978aa81adbcca3d8");


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

    @Test
    public void getBuyerOrderProduct() throws Exception {
        GetBuyerOrderProductReq.Builder req = GetBuyerOrderProductReq.newBuilder();
        req.setBizCode("BC201028386482394508");
        req.setOrdinal(2);
        GetBuyerOrderProductResp resp = uasOrderGetSdk.getBuyerOrderProduct(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }
}
