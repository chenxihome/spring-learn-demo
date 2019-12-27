package com.chenxi.example.idgenerate.util;



/**
 * Created by tukun on 2017/12/1.
 */
public class IdGenerateUtil {
    /*
     * 默认数据中心编号
     */
    private final static  int dataCenterId=1;

    public static  String getUniqueId(){
        Integer wordId=WorkIdUtil.getMachineId();
        IdWork idWorker = IdWork.getInstance(wordId,dataCenterId);
        String id= idWorker.nextId()+"";
        System.out.println("id TEST:"+id);
        return id;
    }

    public static  String getUniqueIdBySuffix(String bizTypeSuffix){
        String id= bizTypeSuffix+getUniqueId();
        System.out.println("id TEST:"+id);
        return id;
    }
}
