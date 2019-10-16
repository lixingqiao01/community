package lift.majiang.community.community.provider;

import com.alibaba.fastjson.JSON;
import lift.majiang.community.community.dto.AccesstokenDTO;
import lift.majiang.community.community.dto.GithubUser;
import org.springframework.stereotype.Component;
import okhttp3.*;
import java.io.IOException;

@Component
public class GithubProvider {
    public String getAccessToken(AccesstokenDTO accesstokenDTO) {
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();

//        RequestBody body = RequestBody.create(mediaType,JSON.toJSONString(accesstokenDTO));
        RequestBody body = new FormBody.Builder()
                .add(String.valueOf(mediaType),JSON.toJSONString(accesstokenDTO))
                .build();
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();

//        try (Response response = client.newCall(request).execute()) {
//            String string = response.body().string();
//            System.out.println(string);
//            return response.body().string();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return null;
    }

    public GithubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+ accessToken)
                .build();

        try {
            Response response = client.newCall(request).execute();
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {

        }
        return null;
    }
}
