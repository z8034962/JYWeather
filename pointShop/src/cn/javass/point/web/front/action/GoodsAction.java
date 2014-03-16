package cn.javass.point.web.front.action;

import cn.javass.commons.web.action.BaseAction;
import cn.javass.point.exception.NotCodeException;
import cn.javass.point.model.GoodsCodeModel;
import cn.javass.point.service.IGoodsCodeService;
import cn.javass.point.service.IGoodsService;

public class GoodsAction extends BaseAction {
    
    private static final String BUY_RESULT = "buyResult";
    
    public String list() {
        getValueStack().set(PAGE, goodsService.listAllPublished(getPn()));
        return LIST;
    }
    
    public String buy() {
        String username = "test";
        GoodsCodeModel goodsCode = null;
        try {
            goodsCode = goodsCodeService.buy(username, goodsId);
        } catch (NotCodeException e) {
            this.addActionError("没有足够的兑换码了");
            return BUY_RESULT;
        } catch (Exception e) {
            e.printStackTrace();
            this.addActionError("未知错误");
            return BUY_RESULT;
        }
        this.addActionMessage("购买成功，您的兑换码为 :"+ goodsCode.getCode());
        getValueStack().set(MODEL, goodsCode);
        return BUY_RESULT;
    }
    
    //-----------------------
    //字段驱动数据填充
    //-----------------------    
    private int goodsId;
    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }
    
    //-----------------------
    //依赖注入
    //-----------------------
    IGoodsService goodsService;
    IGoodsCodeService goodsCodeService;
    public void setGoodsService(IGoodsService goodsService) {
        this.goodsService = goodsService;
    }
    public void setGoodsCodeService(IGoodsCodeService goodsCodeService) {
        this.goodsCodeService = goodsCodeService;
    }
    
}
