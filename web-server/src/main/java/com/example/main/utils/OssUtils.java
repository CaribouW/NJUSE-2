package com.example.main.utils;

/**
 * 利用阿里云oss上传文件
 *
 * @author :lfm
 */

import com.aliyun.oss.HttpMethod;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.GeneratePresignedUrlRequest;
import org.springframework.stereotype.Component;

import java.net.URL;

import java.util.Date;

@Component
public class OssUtils {
    private final long serialVersionUID = 5522372203700422672L;
    private String accessId = "LTAIE7vXcOceVoyj"; // 请填写您的AccessKeyId。
    private String accessKey = "1gvwmOTTgGLLNfAL5FbjCsUo4vYizS"; // 请填写您的AccessKeySecret。
    private String endpoint = "oss-cn-hangzhou.aliyuncs.com"; // 请填写您的 endpoint。
    private String bucket = "champion-images0"; // 请填写您的 bucketname 。
    private String host = "http://" + bucket + "." + endpoint; // host的格式为 bucketname.endpoint
    private String dir = "user-dir-prefix/"; // 用户上传文件时指定的前缀。
    private OSSClient client = new OSSClient(endpoint, accessId, accessKey);

    /**
     * 上传文件.
     * 返回一个oss id.
     *
     * @param objectName :用户给予文件名。之后将会存到数据库
     * @return : oss服务器返回文件id , 需要返回给用户.方便用户后续的下载工作
     */
    public String getUploadURL(String objectName) {
        // 生成签名URL。
        Date expiration = new Date(new Date().getTime() + 600000);//十分钟
        GeneratePresignedUrlRequest request = new GeneratePresignedUrlRequest(bucket, objectName, HttpMethod.PUT);
        // 设置过期时间。
        request.setExpiration(expiration);
        // 设置Content-Type。
        /*
         * 支持下边几种文件格式，有其他需求可自行加入
         */
        if (objectName.matches("[0-9a-zA-Z_/]*.jpg")) {
            request.setContentType("image/jpeg");
        } else if (objectName.matches("[0-9a-zA-Z_/]*.png")) {
            request.setContentType("image/png");
        } else if (objectName.matches("[0-9a-zA-Z_/]*.pdf")) {
            request.setContentType("application/pdf");
        } else return "辣鸡";
        // 生成签名URL（HTTP PUT请求）。
        URL signedUrl = client.generatePresignedUrl(request);

        // 关闭OSSClient。
        client.shutdown();
        return signedUrl.toString();
    }

    /**
     * 下载oss 的文件
     *
     * @param key:
     * @return :返回oss服务器的资源url
     */
    public String getDownloadURL(String key) {
        //有效期一小时
        Date expiration = new Date(new Date().getTime() + 3600l * 1000);
        URL url = client.generatePresignedUrl(bucket, key, expiration);
        client.shutdown();
        if (url != null) {
            return url.toString();
        } else return null;
    }

    public enum contentType {

    }
    /**
     * 鉴于现在用的方法不太靠谱，没准以后还要改方式，下边的代码先不删了，以备不时之需
     */
}
