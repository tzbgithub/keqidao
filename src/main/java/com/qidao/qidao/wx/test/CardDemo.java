package com.qidao.qidao.wx.test;

import weixin.popular.api.CardAPI;
import weixin.popular.api.TokenAPI;
import weixin.popular.bean.card.*;
import weixin.popular.bean.card.create.CreateResult;

//统计数量变化
public class CardDemo {

    String app_id = "wx8757750483ef5899";
    String app_secret = "ac2075e29477b9877b987ec145dbcb07";
    String accessToken = TokenAPI.token(app_id, app_secret).getAccess_token();

    //创建卡券(非商家无法创建卡券)
    public void createCard() {

        Cash c = new Cash();
        c.setLeastCost(100);
        c.setReduceCost(10);
        BaseInfo bi = new BaseInfo();
        bi.setLogoUrl("https://p.qqan.com/up/2021-3/16164095551737424.jpg");
        bi.setBrandName("科企岛");
        bi.setColor("Color010");
        BaseInfoDateInfo di = new BaseInfoDateInfo();
        di.setBeginTimestamp(1617643377);
        di.setEndTimestamp(1617988977);

        bi.setDateInfo(di);
        BaseInfoSku sku = new BaseInfoSku();
        sku.setQuantity(500000);
        bi.setSku(sku);

        c.setBaseInfo(bi);
        CashCard cc = new CashCard();
        cc.setCash(c);
        CreateResult cr = CardAPI.create(accessToken,cc);
        return;

    }


    public static void main(String[] args) {
        CardDemo cardDemo = new CardDemo();
        cardDemo.createCard();
    }
}
