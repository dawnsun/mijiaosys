package com.mijiaokj.sys.web.response;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sunchenguang on 2017/5/31.
 */
public class PagingList<T> {
    private PagingVO paging = new PagingVO();
    private List<T> items = new ArrayList();

    public PagingList() {
    }

    public void add(T e) {
        this.items.add(e);
    }

    public T get(int index) {
        return this.items.get(index);
    }

    public List<T> getItems() {
        return this.items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public PagingVO getPaging() {
        return this.paging;
    }

    public void setPaging(PagingVO paging) {
        this.paging = paging;
    }
}