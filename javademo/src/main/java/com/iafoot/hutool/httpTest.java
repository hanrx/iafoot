package com.iafoot.hutool;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * 全量下载 OA员工图片信息
 *
 * @author iAfoot
 * @Create 20210330 13:54
 * @Version 1.0.0
 */
public class httpTest {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 10012259; i >10000001 ; i--) {
            oaLoad(i+"");
//            Thread.sleep(1000*5);
        }


    }


    public static void  oaLoad(String employId){
        //请求列表页
        String str2 = "http://192.168.240.31:8001/psc/HR91PRD_6/EMPLOYEE/HRMS/c/ST_ROOT_MENU.ST_EMPL_SRCH_D.GBL?Page=ST_EMPL_SRCH_D&Action=U&EMPLID="+employId+"&EMPL_RCD=0&TargetFrameName=None&PortalActualURL=http%3a%2f%2f192.168.240.31%3a8001%2fpsc%2fHR91PRD_6%2fEMPLOYEE%2fHRMS%2fc%2fST_ROOT_MENU.ST_EMPL_SRCH_D.GBL%3fPage%3dST_EMPL_SRCH_D%26Action%3dU%26EMPLID%3d10010570%26EMPL_RCD%3d0%26TargetFrameName%3dNone&PortalRegistryName=EMPLOYEE&PortalServletURI=http%3a%2f%2f192.168.240.31%3a8001%2fpsp%2fHR91PRD_6%2f&PortalURI=http%3a%2f%2f192.168.240.31%3a8001%2fpsc%2fHR91PRD_6%2f&PortalHostNode=HRMS&NoCrumbs=yes&PortalKeyStruct=yes";
        String listContent = HttpUtil.get(str2);//使用正则获取所有标题
        List<String> titles = ReUtil.findAll("<span  class='PSEDITBOX_DISPONLY' id='ST_NAMES_VW_NAME'>(.*?)</span>", listContent, 1);
        List<String> jpgs = ReUtil.findAll("<img src='/cs/HR91PRD/cache/EMPL_PHOTO_(.*?).JPG'", listContent, 1);
        List<String> sexs = ReUtil.findAll("<span  class='PSEDITBOX_DISPONLY' id='ST_SEX_VW_DESCR10'>(.*?)</span>", listContent, 1);
        List<String> ages = ReUtil.findAll("<span  class='PSEDITBOX_DISPONLY' id='DERIVED_HR_AGE_YEARS'>(.*?)</span>", listContent, 1);
        for (String title : titles) {
            if(!jpgs.isEmpty()){

                str2 = "http://192.168.240.31:8001/cs/HR91PRD/cache//EMPL_PHOTO_"+jpgs.get(0)+".JPG";
                try {
                    HttpUtil.downloadFile(str2,"E:/hanLS\\LS\\2021\\0330");
                    File file= new File("E:/hanLS\\LS\\2021\\0330\\"+"EMPL_PHOTO_"+ (Optional.ofNullable(jpgs).isPresent()?jpgs.get(0):"null")+".JPG");
                    String newFileName = "E:/hanLS\\LS\\2021\\0330\\"+title+"_"+sexs.get(0)+"_"+ages.get(0)+"_.jpg";//+tels.get(0);
                    FileUtil.rename(file,newFileName,true);
                    //打印标题
                    Console.log(title);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }













































}
