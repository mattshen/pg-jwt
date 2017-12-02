package io.github.mattshen.pgjwt;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.gson.Gson;

import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Base64;


public class Main {

    public static final String CHARSET = "UTF-8";
    public static final Gson GSON = new Gson();

    public static void main(String[] args) throws UnsupportedEncodingException {
        Header h = new Header("HS256", "JWT");
        Payload p = new Payload("hello", "Donald", false);

        String jwt = sign(h, p, "top_secret");
        System.out.println("jwt = " + jwt);
    }


    public static String sign(Header h, Payload p, String key) throws UnsupportedEncodingException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(CHARSET), "HmacSHA256");
        HashFunction hmacSha256 = Hashing.hmacSha256(secretKeySpec);
        String hStr = GSON.toJson(h);
        String pStr = GSON.toJson(p);
        String content =
                Base64.getUrlEncoder().encodeToString(hStr.getBytes(CHARSET)) +
                        "." +
                        Base64.getUrlEncoder().encodeToString(pStr.getBytes(CHARSET));
        HashCode signature = hmacSha256.hashString(content, Charset.forName(CHARSET));
        String jwt = content + "."+signature;
        return jwt;
    }


}
