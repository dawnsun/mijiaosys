package com.mijiaokj.sys.web.response;

import java.io.Serializable;

/**
 * Created by sunchenguang on 2017/5/31.
 */
public abstract class BaseModelView implements Serializable {
    private String csrfId;

    public BaseModelView() {
    }

    public String getCsrfId() {
        return this.csrfId;
    }

    public void setCsrfId(String csrfId) {
        this.csrfId = csrfId;
    }
}

