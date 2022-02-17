import com.alibaba.fastjson.JSONObject;

import java.io.File;

public class AnimationPhoto {
    public static class APIObject {
        public String code;
        public String message;
        public long time;
        public String version;
        public data data;

        public static class data {
            public String num;
            public String function;
            public String[] url;
        }
    }

    public static void main(String[] args) {
        String Body = HttpClient.doGet("https://api.nyan.xyz/httpapi/sexphoto/");

        APIObject Data = JSONObject.parseObject(Body, APIObject.class);

        String URL = Data.data.url[0];
        System.out.println(URL);

        //创建文件夹
        File Path = new File("./images");
        Path.mkdirs();

        PictureDownload.downloadPicture(URL);

        File tmpFile = new File(URL);
        String fileName = tmpFile.getName();
        System.out.println("图片已保存在images/" + fileName);
    }
}
