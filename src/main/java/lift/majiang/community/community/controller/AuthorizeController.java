package lift.majiang.community.community.controller;

import lift.majiang.community.community.dto.AccesstokenDTO;
import lift.majiang.community.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state){
        AccesstokenDTO accesstokenDTO = new AccesstokenDTO();
        accesstokenDTO.setCode(code);
        accesstokenDTO.setState(state);
        accesstokenDTO.setRedirect_uri("http://localhost:8886/callback");
        accesstokenDTO.setClient_id("9ee1a1d3c29181a2d99b");
        accesstokenDTO.setClient_secret("cfb09a3bbe2c732bc521fd3d7fbffdd26eb0aa40");
        githubProvider.getAccessToken(accesstokenDTO);

        System.out.println(accesstokenDTO.getCode());
        System.out.println(accesstokenDTO.getState());
        return "index";
    }
}
