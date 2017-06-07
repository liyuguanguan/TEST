package client;


import java.util.HashMap;

/**
 * Created by Rainy on 2017/5/26.
 */
public class test {

    public static void main(String[] args) {
        HashMap  ha = new HashMap<String,String>();
        ha.put("","");
        String a ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<ENT511Message guid=\"11888fb0-fa11-4e27-8872-44405c8837d6\" version=\"1.0\" xmlns:ENT=\"http://www.chinaport.gov.cn/ENT\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" +
                "<Logistics>\n" +
                "<LogisticsHead>\n" +
                "<guid>d88e927a-4d20-4ad5-9326-fd27e8e0a0d2</guid>\n" +
                "<appType>1</appType>\n" +
                "<appTime>20161201111100</appTime>\n" +
                "<appStatus>2</appStatus>\n" +
                "<logisticsCode>3702980058</logisticsCode>\n" +
                "<logisticsName>青岛翔通国际运输代理有限公司</logisticsName>\n" +
                "<logisticsNo>W201612011111</logisticsNo>\n" +
                "<billNo>BILLNO12011111</billNo>\n" +
                "<freight>0</freight>\n" +
                "<insuredFee>0</insuredFee>\n" +
                "<currency>142</currency>\n" +
                "<weight>2</weight>\n" +
                "<packNo>1</packNo>\n" +
                "<goodsInfo>美国福摩天然无谷鸭肉甜薯全犬期狗粮鸭肉</goodsInfo>\n" +
                "<consignee>张三</consignee>\n" +
                "<consigneeAddress>北京市北京市丰台区北京市北京市丰台区马家堡街道马家堡西路32号2c703</consigneeAddress>\n" +
                "<consigneeTelephone>13800001234</consigneeTelephone>\n" +
                "<ebcCode>1234567890</ebcCode>\n" +
                "<note>1</note>\n" +
                "</LogisticsHead>\n" +
                "</Logistics>\n" +
                "<BaseTransfer>\n" +
                "<copCode>3702980058</copCode>\n" +
                "<copName>青岛翔通国际运输代理有限公司</copName>\n" +
                "<dxpMode>DXP</dxpMode>\n" +
                "<dxpId>DXPENT0000012815</dxpId>\n" +
                "<note>1</note>\n" +
                "</BaseTransfer>\t\n" +
                "</ENT511Message>";

    }
}
