package com.efufu.mstest.controller;

import com.efufu.mstest.dao.IUser;
import com.efufu.mstest.service.SessionUtil;
import com.efufu.mstest.vo.User;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class MyController {

    @RequestMapping(value = "find", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String find() {
        SessionUtil sessionUtil = new SessionUtil();
        IUser iUser = sessionUtil.getIUser();
        List<User> users = iUser.find();
        sessionUtil.destroy();
        return new Gson().toJson(users);
    }

    @RequestMapping(value = "add", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String add(String name, String sex, String msg, String grade, MultipartFile file, HttpServletRequest req) throws IOException {
        String rpath = req.getServletContext().getRealPath("/files/" + name);
        File dir = new File(rpath);
        if (!dir.exists())
            dir.mkdirs();

        String oriname = file.getOriginalFilename();
        String suffix = oriname.substring(oriname.lastIndexOf("."));
        if (suffix.equalsIgnoreCase(".png") || suffix.equalsIgnoreCase(".jpg") || suffix.equalsIgnoreCase(".gif")) { // 判断文件的后缀

            SessionUtil sessionUtil = new SessionUtil();
            IUser iUser = sessionUtil.getIUser();
            if (iUser.findName(name) == null) {
                String uuid = UUID.randomUUID().toString();// 生成一个新的文件名，避免文件同名出现文件覆盖的现象
                String newName = uuid + suffix;
                FileUtils.copyInputStreamToFile(file.getInputStream(), new File(dir + "\\" + newName));
                User user = new User(name, sex, msg, grade, oriname, dir + "\\" + newName);
                iUser.add(user);
            } else
                return "用户重复";
            sessionUtil.destroy();
            return "添加成功";
        } else {
            return "文件类型不支持";
        }
    }

    @RequestMapping(value = "update", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String update(String name, String sex, String msg, String grade, MultipartFile file, HttpServletRequest req) throws IOException {
        String rpath = req.getServletContext().getRealPath("/files/" + name);
        File dir = new File(rpath);
        if (!dir.exists())
            dir.mkdirs();

        String oriname = file.getOriginalFilename();
        String suffix = oriname.substring(oriname.lastIndexOf("."));
        if (suffix.equalsIgnoreCase(".png") || suffix.equalsIgnoreCase(".jpg") || suffix.equalsIgnoreCase(".gif")) { // 判断文件的后缀

            SessionUtil sessionUtil = new SessionUtil();
            IUser iUser = sessionUtil.getIUser();
            String uuid = UUID.randomUUID().toString();// 生成一个新的文件名，避免文件同名出现文件覆盖的现象
            String newName = uuid + suffix;
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(dir + "\\" + newName));
            User user = iUser.findName(name);
            User new_user = new User(name, sex, msg, grade, user.getFilename() + "," + oriname, user.getFilepath() + "," + dir + "\\" + newName);
            iUser.update(new_user);
            sessionUtil.destroy();
            return "更新成功";
        } else {
            return "文件类型不支持";
        }

    }

}
