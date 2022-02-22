package com.aye10032.tctodolist.util;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Base64;

/**
 * @program: TCTodoList
 * @className: PNGUtil
 * @Description:
 * @version: v1.0
 * @author: Aye10032
 * @date: 2022/2/21 下午 11:22
 */
public class ProfileUtil {

    public static String getUUID(String player) {
        String uuid = "";

        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet get = new HttpGet("https://api.mojang.com/users/profiles/minecraft/" + player);
            HttpResponse response = client.execute(get);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                JsonElement result = JsonParser.parseString(EntityUtils.toString(response.getEntity()));
                uuid = result.getAsJsonObject().get("id").getAsString();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return uuid;
    }

    public static String getProfile(String uuid) {
        String base64 = "";

        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet get = new HttpGet("https://sessionserver.mojang.com/session/minecraft/profile/" + uuid);
            HttpResponse response = client.execute(get);

            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                JsonElement result = JsonParser.parseString(EntityUtils.toString(response.getEntity()));
                base64 = result.getAsJsonObject()
                        .get("properties").getAsJsonArray()
                        .get(0).getAsJsonObject()
                        .get("value").getAsString();
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return base64;
    }

    public static String base642Url(String base64) {
        if (base64 == null) {
            return null;
        }
        try {
            byte[] b = Base64.getDecoder().decode(base64);
            String json_str = new String(b);
            JsonObject jsonObject = JsonParser.parseString(json_str).getAsJsonObject();
            String url = jsonObject
                    .get("textures").getAsJsonObject()
                    .get("SKIN").getAsJsonObject()
                    .get("url").getAsString();
            return url;
        } catch (Exception e) {
            return null;
        }
    }

    public static String downloadFromUrl(String url, String file_name) {
        String filePath = "D:\\";
        String fileName = file_name + ".png";
        try {
            URL videoUrl = new URL(url);
            File file = new File(filePath, fileName);
            FileUtils.copyURLToFile(videoUrl, file);
        } catch (Exception e) {
            System.out.println(e);
        }
        return filePath + fileName;
    }

    public static void getAvatar(String url_str, String file_name) {
        String filePath = "D:\\";
        String fileName = file_name + ".png";
        URL url = null;
        try {
            url = new URL(url_str);
            BufferedImage image = ImageIO.read(url);

            BufferedImage head = new BufferedImage(8, 8, image.getType());

            for (int x = 8; x < 16; x++) {
                for (int y = 8; y < 16; y++) {
                    int pix = image.getRGB(x, y);
                    head.setRGB(x - 8, y - 8, pix);
                }
            }

            ImageIO.write(head, "png", new File(filePath, fileName));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
