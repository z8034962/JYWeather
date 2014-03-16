package cn.javass.commons.pagination.provider;

import cn.javass.commons.pagination.AbstractNavigationProvider;
import cn.javass.commons.pagination.Page;

/**
 * 构建如“上一页 下一页”形式分页
 * @author Zhang Kaitao
 *
 */
public class NavigationProviderV1 extends AbstractNavigationProvider {
    
    @Override
    public String build(Page<?> page, String url) {
        StringBuilder sb = new StringBuilder();
        if (page.isHasPre()) {
            String preUrl = append(url, "pn", page.getIndex() - 1);
            sb.append("<a href=\"" + preUrl + "\">上一页</a>&nbsp;");
        }
        if (page.isHasNext()) {
            String nextUrl  = append(url, "pn", page.getIndex() + 1);
            sb.append("<a href=\"" + nextUrl + "\">下一页</a>");
        }
        return sb.toString();
    }

}
