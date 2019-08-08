package me.hades.controller;

import me.hades.entiy.FileInfo;
import me.hades.repository.FileInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.List;

@Controller

public class FileController {
    @Autowired
    FileInfoRepository fileInfoRepository;



    /**
     * 查询所有的文件并且页面显示
     * @param model
     * @return
     */
    @RequestMapping("/temp")
    public String showmoban(Model model)
    {
        List<FileInfo> fileInfos =   fileInfoRepository.findAll();
        model.addAttribute("fileinfor",fileInfos);

        return "fileupload";
    }

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest request,FileInfo fi, Model model) {

//      Enumeration<String> enumeration = request.getAttributeNames();
//      while (enumeration.hasMoreElements())
//      {
//          System.out.println(enumeration.nextElement());
//          System.out.println(request.getAttribute(enumeration.toString()));
//
//      }
        System.out.println(request.getAttribute("filename"));
        System.out.println(fi);
        //logger.info("开始上传文件");
        HttpSession httpSession = request.getSession();
        //Integer userId = (Integer) httpSession.getAttribute("USER_ID");


        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("up_file");
        //System.out.println(files.get(0).getName());

        MultipartFile file = null;
        BufferedOutputStream stream = null;

        File filePath = new File("C://Files" );

        if (!filePath.exists()) {
            filePath.mkdirs();
        }


        for (int i = 0; i < files.size(); ++i) {

            file = files.get(i);
            String filepath = filePath.getPath() + File.separator + file.getOriginalFilename();
            File file1 = new File(filepath);
            FileInfo fileInfo = new FileInfo();
            //fileInfo.setUif((UserInfo) httpSession.getAttribute("userinfo"));
            fileInfo.setUploadtime(new Date());
            fileInfo.setPath(filepath);
//            fileInfo.setFilename();
//            fileInfo.setDiscipline();

            if (!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(file1));
                    stream.write(bytes);
                    stream.close();

                } catch (Exception e) {
                    model.addAttribute("error", "服务器错误，请重试");
                    return "fileupload";                }
            } else {
                model.addAttribute("error", "文件不能为空，请重新添加");
                return "fileupload";            }

        }
        //logger.info("上传文件成功");
        model.addAttribute("message", "附件添加成功，是否继续添加");
        //return "redirect:/user/forwardUploadFile";
        List<FileInfo> fileInfos =   fileInfoRepository.findAll();
        model.addAttribute("fileinfor",fileInfos);


        return "fileupload";
    }
    }


