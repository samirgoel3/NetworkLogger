package com.samir.nlogger.db;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class LogsTable {

    @Id(autoincrement = true)
    private Long id;
    private String tmestamp;
    private String tag ;
    private String message ;
    @Generated(hash = 1146406435)
    public LogsTable(Long id, String tmestamp, String tag, String message) {
        this.id = id;
        this.tmestamp = tmestamp;
        this.tag = tag;
        this.message = message;
    }
    @Generated(hash = 422806598)
    public LogsTable() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTmestamp() {
        return this.tmestamp;
    }
    public void setTmestamp(String tmestamp) {
        this.tmestamp = tmestamp;
    }
    public String getTag() {
        return this.tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }
    public String getMessage() {
        return this.message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

}
