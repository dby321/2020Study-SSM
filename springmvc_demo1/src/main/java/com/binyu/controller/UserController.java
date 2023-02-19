package com.binyu.controller;

import com.binyu.domain.User;
import com.binyu.exception.SysException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @BelongsProject: springmvc_demo1
 * @BelongsPackage: com.binyu.controller
 * @Author: Dong Binyu
 * @CreateTime: 2020-08-18 15:26
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/hello")
    public String sayHello() {
        System.out.println ( "Hello" );
        return "success";
    }

    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println ( "testString执行了..." );
        User user = new User ();
        user.setUsername ( "董滨雨" );
        user.setPassword ( "123" );
        user.setAge ( 23 );
        model.addAttribute ( "user", user );
        return "success";
    }

    /**
     * 默认返回/WEB-INF/pages/user/testVoid.jsp页面
     * 如果不想这样，
     */
    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println ( "testVoid执行了" );
        /* 手动写转发不会调用视图解析器 http://localhost:8080/springmvc_demo1_war/user/testVoid */
//        request.getRequestDispatcher ( "/WEB-INF/pages/success.jsp" ).forward ( request, response );

        /* 重定向 http://localhost:8080/springmvc_demo1_war/index.jsp*/
//        response.sendRedirect ( request.getContextPath ()+"/index.jsp" );
        //   /springmvc_demo1_war
//        System.out.println (request.getContextPath ());

        /* 解决中文乱码 */
        response.setCharacterEncoding ( "UTF-8" );
        response.setContentType ( "text/html;charset=UTF-8" );
        /* 直接响应 http://localhost:8080/springmvc_demo1_war/user/testVoid */
        response.getWriter ().print ( "你好" );
        return;
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println ( "testModelAndView执行了" );

        User user = new User ();
        user.setUsername ( "董滨雨" );
        user.setPassword ( "123" );
        user.setAge ( 23 );

        ModelAndView modelAndView = new ModelAndView ();
        modelAndView.addObject ( "user", user );
        modelAndView.setViewName ( "success" );
        return modelAndView;
    }

    @RequestMapping("/testForward")
    public String testForward() {
        System.out.println ( "testForward执行了..." );
        return "forward:/WEB-INF/pages/success.jsp";
    }

    @RequestMapping("/testRedirect")
    public String testRedirect() {
        System.out.println ( "testRedirect执行了..." );
        return "redirect:/index.jsp";
    }

    @RequestMapping("/testAjax")
    public @ResponseBody
    User testAjax(@RequestBody User user) {
        System.out.println ( "testAjax执行了..." );
        /* Json-->Java bean需要jackson的相关jar包 */
        System.out.println ( user );
        /* 响应 */
        user.setUsername ( "binyu" );
        return user;
    }

    @RequestMapping("/fileupload1")
    public String fileupload1(HttpServletRequest request) throws Exception {
        System.out.println ( "fileupload执行了..." );
        String path = request.getSession ().getServletContext ().getRealPath ( "/uploads/" );
        File file = new File ( path );
        if (!file.exists ()) {
            file.mkdirs ();
        }
        DiskFileItemFactory factory = new DiskFileItemFactory ();
        ServletFileUpload upload = new ServletFileUpload ( factory );
        List<FileItem> list = upload.parseRequest ( request );
        for (FileItem item : list) {
            if (item.isFormField ()) {
//              普通表单项
                System.out.println ("普通表单项");
            } else {
                System.out.println ("保存文件");
                String filename = item.getName ();
                String uuid = UUID.randomUUID ().toString ().replace ( "-", "" );
                filename = uuid + "_" + filename;
                System.out.println ("文件名"+filename);
                item.write ( new File ( path, filename ) );
                item.delete ();
            }
        }
        return "success";
    }

    @RequestMapping("/fileupload2")
    public String fileupload2(HttpServletRequest request, MultipartFile upload) throws IOException {
        System.out.println ( request.getSession () );
        System.out.println ( request.getSession ().getServletContext () );
        System.out.println ( request.getSession ().getServletContext ().getRealPath ( "/uploads" ) );
        System.out.println ( request.getContextPath () );
        System.out.println ( request.getServletPath () );
        System.out.println ( request.getServletContext ().getRealPath ( "/" ) );
        System.out.println ( "------------" );
        String path = request.getSession ().getServletContext ().getRealPath ( "/uploads/" );
//        String path2=System.getProperty ( "user.dir" )+"\\src\\main\\webapp\\upload";
        File file = new File ( path );
        if (!file.exists ()) {
            file.mkdirs ();
        }

        String filename = upload.getOriginalFilename ();
        System.out.println ( filename );
        System.out.println ( UUID.randomUUID ().toString () );
        String uuid = UUID.randomUUID ().toString ().replace ( "-", "" );
        filename = uuid + "_" + filename;
        upload.transferTo ( new File ( path, filename ) );
        return "success";
    }


//    @RequestMapping("/fileupload3")
//    public String fileupload3(MultipartFile upload) throws IOException {
//        System.out.println ("跨服务器上传...");
//
//        String path="http://localhost:9090/uploads/";
//
//        String filename=upload.getOriginalFilename ();
//        String uuid=UUID.randomUUID ().toString ().replace ( "-","" );
//        filename=uuid+"_"+filename;
//
//        Client client = Client.create ();
//        WebResource resource = client.resource ( path + filename );
//        resource.put (upload.getBytes ());
//        return "success";
//    }

    @RequestMapping("/testException")
    public String testException() {
        System.out.println ( "testException执行了..." );
        try {
            int a = 10 / 0;
        } catch (Exception e) {
            throw new SysException ( "除0错误" );
        }
        return "success";
    }

    @RequestMapping("/testInterceptor")
    public String testInterceptor()  {
        System.out.println ( "testInterceptor..." );

        return "success";
    }
}
