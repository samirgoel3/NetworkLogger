package com.samir.nlogger;

import android.os.AsyncTask;

import com.samir.nlogger.db.LogsTable;
import com.samir.nlogger.db.LogsTableDao;

import java.util.List;

public class DatabaseManager {

    public static void insertLog(final String tag ,final String message){
        new AsyncTask<Void,Void,Void>(){
            @Override
            protected Void doInBackground(Void... voids) {
                NLogger.mDaoSession.getLogsTableDao().insert(new LogsTable(null, ""+System.currentTimeMillis(),tag,  message));
                return null;
            }
        }.execute();
    }

    public static List<LogsTable> getAllLogs(){
        List<LogsTable> apiLogTables = NLogger.mDaoSession.getLogsTableDao().queryBuilder().orderDesc(LogsTableDao.Properties.Tmestamp).list();
        return apiLogTables ;
    }




}
