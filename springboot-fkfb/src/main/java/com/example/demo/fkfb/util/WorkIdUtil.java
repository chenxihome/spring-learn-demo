package com.example.demo.fkfb.util;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by tukun on 2019/12/26.
 */
@Component
public class WorkIdUtil {
    private  final static String MIANMACHEINEREDISKEY="GENERATEUNIQUEVMID";
    private  final static int INIT_VM_ID=0;
    private  final static int EXPIRE_TIME=24*60;


    public   static Integer  getMachineId() {
        String mainVMIdStr=RedisUtil.get(MIANMACHEINEREDISKEY);
        String localIp=IpUtil.getLocalIP();
        return StringUtils.isEmpty(mainVMIdStr)?getRealVmId(localIp,INIT_VM_ID+""):getRealVmId(localIp,mainVMIdStr);
    }

   private static Integer getRealVmId(String ip,String mainVMId) {
       String localVmId=RedisUtil.get(ip);
       if(StringUtils.isEmpty(localVmId)) {
           Integer newVmId=Integer.valueOf(mainVMId)+1;
           RedisUtil.setEx(MIANMACHEINEREDISKEY,newVmId.toString(),EXPIRE_TIME, TimeUnit.MINUTES);
           RedisUtil.setEx(ip,newVmId.toString(),EXPIRE_TIME, TimeUnit.MINUTES);
           return newVmId;
       }
       return Integer.valueOf(localVmId);
   }


}
