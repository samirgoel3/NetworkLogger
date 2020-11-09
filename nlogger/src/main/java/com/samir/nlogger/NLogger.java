package com.samir.nlogger;

import android.app.Application;
import android.content.Context;

import com.samir.nlogger.db.DaoMaster;
import com.samir.nlogger.db.DaoSession;
import com.samir.nlogger.db.LogsTable;

import java.util.List;


public class NLogger {

    static Builder mBuilder;
    static DaoSession mDaoSession;
    private final static String DB_SESSION_NAME = "logs.db";


    public static Builder startInit(Application application){
        return new Builder(application) ;
    }


    private static void endInit(NLogger.Builder builder){
        mBuilder = builder ;
        createDaoSession(builder.application);
    }

    private static DaoSession createDaoSession(Context context) {
        if (mDaoSession == null) {
            mDaoSession = new DaoMaster(new DaoMaster.DevOpenHelper(context, DB_SESSION_NAME).getWritableDb()).newSession();
            return mDaoSession;
        } else {
            return mDaoSession;
        }
    }



    public static class Builder{
        protected boolean IS_ENABLE = false ;
        protected String ENDPOINT = "";
        protected Application application ;
        protected int DB_ROWS_SIZE = 500 ;
        protected String TIME_FORMAT = "E hh:mm: a";

        private Builder(){}

        private Builder(Application application){
            this.application = application ;
        }

        public Builder setEnable(boolean val){
            this.IS_ENABLE = val ;
            return this;
        }

        public Builder setEndpoints(String endpoints){
            this.ENDPOINT = endpoints ;
            return this;
        }

        public Builder setTimeFormat(String endpoints){
            // hh:mm: a --> 11:23 AM
            // dd-MM-yyyy --> 12-09-2019
            // Format cheat sheet reference https://www.journaldev.com/17899/java-simpledateformat-java-date-format
            this.ENDPOINT = endpoints ;
            return this;
        }

        public Builder setMaxDBRows(int noOfRows){
            DB_ROWS_SIZE = noOfRows ;
            return this;
        }

        public void init(){
            NLogger.endInit(this);
        }

    }


    // Usable in projects method
    public static boolean isNLogeEnable(){ return mBuilder.IS_ENABLE; }
    public static void enable(boolean val){
        mBuilder.IS_ENABLE = val ;
    }

    public static void setEndPoint(String endpoint){ mBuilder.ENDPOINT = endpoint; }
    public static String getEndpoint(){ return mBuilder.ENDPOINT; }

    public static void setDBNoOfRows(int noOfRows){ mBuilder.DB_ROWS_SIZE = noOfRows ; }
    public static int getNoOfRowConfigured(){ return mBuilder.DB_ROWS_SIZE;}

    public static List<LogsTable> getAllLogs(){
        return DatabaseManager.getAllLogs();
    }


}


