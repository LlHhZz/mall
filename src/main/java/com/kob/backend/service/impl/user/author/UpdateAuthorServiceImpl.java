package com.kob.backend.service.impl.user.author;

import com.kob.backend.mapper.AuthorMapper;
import com.kob.backend.pojo.Author;
import com.kob.backend.pojo.User;
import com.kob.backend.service.impl.utils.UserDetailsImpl;
import com.kob.backend.service.user.author.UpdateAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UpdateAuthorServiceImpl implements UpdateAuthorService {
    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public Map<String, String> update(Map<String, String> data) {
        // 取得用户信息
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authentication.getPrincipal();
        User user = loginUser.getUser();

        // 根据id删除
        int author_id = Integer.parseInt(data.get("author_id"));

        String name = data.get("name");
        String province = data.get("province");
        String region = data.get("region");
        String address = data.get("address");
        String postal_code = data.get("postal_code");

        Map<String, String> map = new HashMap<>();

        // 为确保安全性，需要在后端判断
        if(name == null || name.length() == 0) {
            map.put("error_message", "姓名不能为空");
            return map;
        }
        if(name.length() > 255) {
            map.put("error_message", "姓名长度不能大于255");
            return map;
        }

        if(province == null || province.length() == 0) {
            map.put("error_message", "省份不能为空");
            return map;
        }
        if(province.length() > 255) {
            map.put("error_message", "省份长度不能大于255");
            return map;
        }

        if(region == null || region.length() == 0) {
            map.put("error_message", "地区不能为空");
            return map;
        }
        if(region.length() > 255) {
            map.put("error_message", "地区长度不能大于255");
            return map;
        }

        // 允许为空
        if(address == null || address.length() == 0) {
            address = "暂未填写";
        }
        if(address.length() > 255) {
            map.put("error_message", "地址长度不能大于255");
            return map;
        }

        if(postal_code == null || postal_code.length() == 0) {
            map.put("error_message", "邮政编码不能为空");
            return map;
        }
        if(postal_code.length() > 10) {
            map.put("error_message", "邮政编码不能大于10");
            return map;
        }

        Author author = authorMapper.selectById(author_id);
        if(author == null) {
            map.put("error_message", "作者不存在或已被删除");
            return map;
        }

        System.out.println(author.getCreationDate());

        Author new_author = new Author(author.getId(), author.getCreationDate(), name, province, region, address, postal_code);
        authorMapper.updateById(new_author);

        map.put("error_message", "success");

        return map;
    }
}
