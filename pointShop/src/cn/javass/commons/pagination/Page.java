package cn.javass.commons.pagination;

import java.util.Collections;
import java.util.List;


/**
 * 表示分页中的一页。
 * 
 * @author Zhang Kaitao
 */
public class Page<E> {
    private boolean hasPre; //是否是首页
    private boolean hasNext; //是否是尾页
    private List<E> items; //当前页包含的记录列表
    private int index; //当前页页码(起始为1)
    
//为了简化SSH集成，我们将不是必须的注释掉，如果需要请打开
//    private IPageContext<E> context;
//    
//    public IPageContext<E> getContext() {
//        return this.context;
//    }
//
//    public void setContext(IPageContext<E> context) {
//        this.context = context;
//    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isHasPre() {
        return this.hasPre;
    }

    public void setHasPre(boolean hasPre) {
        this.hasPre = hasPre;
    }

    public boolean isHasNext() {
        return this.hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public List<E> getItems() {
        return this.items == null ? Collections.<E>emptyList() : this.items;
    }

    public void setItems(List<E> items) {
        this.items = items;
    }
    
}
