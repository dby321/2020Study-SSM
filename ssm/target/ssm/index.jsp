<%--
  Created by IntelliJ IDEA.
  User: Dong Binyu
  Date: 2020/4/6
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"
%>
<html>
<head>
    <%--以/开始的相对路径， 是以服务器的根路径为标准,localhost:3306,需要加上项目名--%>
    <%
        pageContext.setAttribute ( "APP_PATH", request.getContextPath () );
    %>
    <title>员工列表页</title>
    <%--<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- 可选的 Bootstrap 主题文件（一般不用引入） -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>--%>
    <link rel="stylesheet" href="${APP_PATH}/static/bootstrap-4.4.1-dist/css/bootstrap.min.css">
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-3.4.1.min.js"></script>

    <script src="${APP_PATH}/static/bootstrap-4.4.1-dist/js/bootstrap.min.js"></script>
    <%--<script src="https://cdn.staticfile.org/jquery/1.10.2/jquery.min.js">
    </script>--%>

</head>
<body>
<!-- Modal -->
<div class="modal fade" id="empModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">员工添加</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="empName_add_input" class="col-sm-2 control-label">empName</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" name="empName" id="empName_add_input"
                                   placeholder="empName">
                            <div class="invalid-feedback"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email_add_input" class="col-sm-2 control-label">email</label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" name="email" id="email_add_input"
                                   placeholder="email">
                            <div class="valid-feedback"></div>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email_add_input" class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">

                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender1_add_input" value="M" checked="checked"> 男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender2_add_input" value="F"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email_add_input" class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-4">
                            <%--部门提交部门id即可--%>
                            <select class="form-control" name="dId" id="dept_add_select">

                            </select>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_save_button">保存</button>
            </div>
        </div>
    </div>
</div>
<!--员工修改 Modal -->
<div class="modal fade" id="empUpdateModel" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">员工修改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label for="empName_update_static" class="col-sm-2 col-form-label">empName</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control-plaintext" id="empName_update_static">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email_update_input" class="col-sm-2 col-form-label">Email</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="email_update_input">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">gender</label>
                        <div class="col-sm-10">

                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender1_update_input" value="M" checked="checked">
                                男
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="gender2_update_input" value="F"> 女
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="email_add_input" class="col-sm-2 control-label">deptName</label>
                        <div class="col-sm-4">
                            <%--部门提交部门id即可--%>
                            <select class="form-control" name="dId" id="dept_update_select">

                            </select>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="emp_update_button">修改</button>
            </div>
        </div>
    </div>
</div>
<%--搭建显示页面--%>
<div class="container">
    <%--标题--%>
    <div class="row">
        <div class="col-md-12">
            <h1>SSM-CRUD</h1>
        </div>
    </div>
    <%--按钮--%>
    <div class="row">

        <div class="col-md-4 offset-md-8">
            <button TYPE="button" class="btn btn-primary" id="emp_add_button">新增</button>
            <button class="btn btn-danger" id="emp_delete_all_btn">删除</button>
        </div>
    </div>
    <%--显示表格数据--%>
    <div class="row">
        <table class="table table-hover" id="emps_table">
            <thead>
            <tr>
                <th>
                    <input type="checkbox" id="check_all">
                </th>
                <th>#
                </th>
                <th>
                    empName
                </th>
                <th>
                    gender
                </th>
                <th>
                    email
                </th>
                <th>
                    deptName
                </th>
                <th>操作</th>
            </tr>
            </thead>

            <tbody>

            </tbody>
        </table>
    </div>
    <%--显示分页信息--%>
    <div class="row">
        <%--分页文字信息--%>
        <div class="col-md-6" id="page_info_area">

        </div>
        <%--分页条信息--%>
        <div class="col-md-6" id="page_nav_area">

        </div>
    </div>

</div>
<script type="text/javascript">
    var currentPage;
    $(function () {

        to_page(1);

    });

    function build_emps_table(result) {
        $("#emps_table tbody").empty();
        var emps = result.extend.pageInfo.list;
        $.each(emps, function (index, item) {
            // alert(item.empName);
            var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>")
            var empId = $("<td></td>").append(item.empId);
            var empName = $("<td></td>").append(item.empName);
            var gender = $("<td></td>").append(item.gender == "M" ? "男" : "女");
            var email = $("<td></td>").append(item.email);
            var deptName = $("<td></td>").append(item.dept.deptName);
            var editBtn = $(" <button type=\"button\" class=\"btn btn-primary btn-sm edit_btn\">\n" +
                "                            <span class=\"glyphicon glyphicon-pencil\" aria-hidden=\"true\"></span>\n" +
                "                            编辑\n" +
                "                        </button>");
            //添加自定义属性，作为员工id
            editBtn.attr("edit-id", item.empId);
            var delBtn = $(" <button type=\"button\" class=\"btn btn-danger btn-sm delete_btn\">\n" +
                "                            <span class=\"glyphicon glyphicon-trash\" aria-hidden=\"true\"></span>\n" +
                "                            删除\n" +
                "                        </button>");
            delBtn.attr("del-id", item.empId);
            var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
            $("<tr></tr>").append(checkBoxTd).append(empId).append(empName).append(gender).append(email).append(deptName).append(btnTd).appendTo("#emps_table tbody");
        })
    }


    function to_page(pn) {
        $.ajax({
            url: "${APP_PATH}/emps",
            data: "pn=" + pn,
            type: "GET",
            success: function (result) {
                console.log(result);
                build_emps_table(result);
                build_page_info(result);
                build_page_nav(result);
            }
        });
    }

    function build_page_info(result) {
        $("#page_info_area").empty();
        $("#page_info_area").append("当前记录数：" + result.extend.pageInfo.pageNum +
            "页,总页码：" + result.extend.pageInfo.pages + ",总记录数：" + result.extend.pageInfo.total
        )
        ;
        currentPage = result.extend.pageInfo.pageNum;
    }

    function build_page_nav(result) {
        $("#page_nav_area").empty();
        var ul = $("<ul><ul>").addClass("pagination");

        var firstPageLi = $("<li></li>").addClass("page-item").append($("<a></a>")).addClass("page-link").append("首页").attr("href", "#");
        var prePageLi = $("<li></li>").addClass("page-item").append($("<a></a>")).addClass("page-link").append("&laquo;");
        firstPageLi.click(function () {
            to_page(1);
        });
        prePageLi.click(function () {
            to_page(result.extend.pageInfo.pageNum - 1);
        });
        var nextPageLi = $("<li></li>").addClass("page-item").append($("<a></a>")).addClass("page-link").append("&raquo;");
        var lastPageLi = $("<li></li>").addClass("page-item").append($("<a></a>")).addClass("page-link").append("末页").attr("href", "#");
        nextPageLi.click(function () {
            to_page(result.extend.pageInfo.pageNum + 1);
        });
        lastPageLi.click(function () {
            to_page(result.extend.pageInfo.pages);
        });
        ul.append(firstPageLi).append(prePageLi);
        $.each(result.extend.pageInfo.navigatepageNums, function (index, item) {

            var numLi = $("<li></li>").addClass("page-item").append($("<a></a>")).addClass("page-link").append(item);
            if (result.extend.pageInfo.pageNum == item) {
                numLi.addClass("active");
            }
            numLi.click(function () {
                to_page(item);
            })
            ul.append(numLi);
        });
        ul.append(nextPageLi).append(lastPageLi);
        var navEle = $("<nav></nav>").append(ul);
        navEle.appendTo("#page_nav_area");
    }

    $("#emp_add_button").click(function () {
        //表单完整重置
        reset_form("#empModel form");
        getDepts("#dept_add_select");
        //发送ajax请求，查出部门信息。显示在下拉列表中
        $("#empModel").modal({
            backdrop: "static"
        })
    });

    function reset_form(ele) {
        $(ele)[0].reset();
        $("#empModel  input").removeClass("is-valid is-invalid");
        /*$("#empName_add_input").removeClass("is-valid is-invalid");
        $("#email_add_input").removeClass("is-valid is-invalid");*/
        $(ele).find(".valid-feedback").text("");
        $(ele).find(".invalid-feedback").text("");
    }

    function getDepts(ele) {
        $(ele).empty();
        $.ajax({
            url: "${APP_PATH}/depts",
            type: "GET",
            success: function (result) {
                // console.log(result);
                $.each(result.extend.depts, function () {
                    var optionEle = $("<option></option>").append(this.deptName).attr("value", this.deptId);
                    optionEle.appendTo(ele);
                });

            }
        })
    }

    function validate_add_form() {
        var empName = $("#empName_add_input").val();
        var regName = /(^[a-zA-Z0-9_-]{6,16}$)|([\u4E00-\u9FA5]{2,5})/;
        // alert(regName.test(empName));
        if (!regName.test(empName)) {
            // alert("用户名校验失败");
            show_validate_msg("#empName_add_input", "error", "用户名校验失败");
            return false;
        } else {
            show_validate_msg("#empName_add_input", "success", "用户名校验成功");
        }
        var email = $("#email_add_input").val();
        var regname2 = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
        if (!regname2.test(email)) {
            show_validate_msg("#email_add_input", "error", "邮箱校验失败");
            return false;
        } else {
            show_validate_msg("#email_add_input", "success", "邮箱校验成功");
        }
        return true;


    }

    function show_validate_msg(el, status, msg) {
        //清除当前元素校验状态
        $(el).removeClass("is-valid is-invalid");
        $(el).next("div").text("");
        if ("success" == status) {
            $(el).addClass("is-valid");
            $(el).next("div").text(msg);
        } else if ("error" == status) {
            $(el).addClass("is-invalid");
            $(el).next("div").text(msg);
        }
    }

    //点击保存
    $("#emp_save_button").click(function () {
        //数据校验
        if (!validate_add_form()) {
            return false;
        }
        if ($(this).attr("ajax-va") == "error") {
            return false;
        }
        $.ajax({
            url: "${APP_PATH}/emps",
            type: "POST",
            data: $("#empModel form").serialize(),
            success: function (result) {
                // alert(result.msg);
                if (result.code == 100) {
                    $("#empModel").modal("hide");
                    to_page(9999);
                } else {
                    if (undefined != result.extend.errrorFields.email) {
                        show_validate_msg("#email_add_input", "error", result.extend.errorFields.email);
                    }
                    if (undefined != result.extend.errrorFields.empName) {
                        show_validate_msg("#empName_add_input", "error", result.extend.errorFields.empName);
                    }
                }

            }
        })
    });
    $("#empName_add_input").change(function () {
        var empName = this.value;
        $.ajax({
            url: "${APP_PATH}/checkUser",
            data: "empName=" + empName,
            type: "POST",
            success: function (result) {
                if (result.code == 100) {
                    show_validate_msg("#empName_add_input", "success", "用户名可用");
                    $("#emp_save_button").attr("ajax-va", "success");
                } else {
                    show_validate_msg("#empName_add_input", "error", result.extend.va_msg);
                    $("#emp_save_button").attr("ajax-va", "error");
                }
            }
        })
    });
    $(document).on("click", ".edit_btn", function () {
        // alert("edit");

        getDepts("#empUpdateModel select");
        getEmp($(this).attr("edit-id"));

        $("#emp_update_button").attr("edit-id", $(this).attr("edit-id"));
        $("#empUpdateModel").modal({
            backdrop: "static"
        });
    });

    function getEmp(id) {
        $.ajax({
            url: "${APP_PATH}/emp/" + id,
            type: "GET",
            success: function (result) {
                console.log(result);
                var empData = result.extend.emp;
                $("#empName_update_static").val([empData.empName]);
                $("#email_update_input").attr("value", empData.email);
                $("#empUpdateModel input[name=gender]").val([empData.gender]);
                console.log(empData.dId.toString());

                console.log($("#dept_update_select ").val("8"));

                $("#dept_update_select ").val("" + empData.dId).attr("selected", "selected");

            }

        })
    }

    //    点击更新，更新员工信息
    $("#emp_update_button").click(function () {
        //    邮箱验证是否合法
        var email = $("#email_update_input").val();
        var regname2 = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
        if (!regname2.test(email)) {
            show_validate_msg("#email_update_input", "error", "邮箱校验失败");
            return false;
        } else {
            show_validate_msg("#email_update_input", "success", "邮箱校验成功");
        }
        //put请求不能直接发，tomcat不封装请求体
        $.ajax({
            url: "${APP_PATH}/emp/" + $(this).attr("edit-id"),
            type: "PUT",
            data: $("#empUpdateModel form").serialize(),
            success: function (result) {
                alert(result.msg);
                $("#empUpdateModel").modal("hide");
                to_page(currentPage);
            }
        });
    });
    //单个删除
    $(document).on("click", ".delete_btn", function () {
        var empName = $(this).parents("tr").find("td:eq(2)").text();
        var empId = $(this).attr("del-id");
        if (confirm("确认删除【" + empName + "】吗？")) {
            // console.log(111);
            $.ajax({
                url: "${APP_PATH}/emp/" + empId,
                type: "DELETE",
                success: function (result) {
                    to_page(currentPage);
                }
            });
        }
    });
    $("#check_all").click(function () {
        //prop用来获取原生的属性，attr用来获取自定义的属性

        $(".check_item").prop("checked", $(this).prop("checked"));
    });
    $(document).on("click", ".check_item", function () {
        var flag = $(".check_item:checked").length == $(".check_item").length;
        $("#check_all").prop("checked", flag);
    });
    //点击全部删除，就是批量删除
    $("#emp_delete_all_btn").click(function () {
        var empNames = "";
        var del_idstr = "";
        $.each($(".check_item:checked"), function () {
            empNames += $(this).parents("tr").find("td:eq(2)").text() + ",";
            del_idstr += $(this).parents("tr").find("td:eq(1)").text() + "-";
            //去除逗号

        });
        empNames=empNames.substring(0, empNames.length - 1);
        del_idstr=del_idstr.substring(0, del_idstr.length - 1);
        if (confirm("确认删除【" + empNames + "】吗？")) {
            $.ajax({
                url: "${APP_PATH}/emp/" + del_idstr,
                type: "DELETE",
                success: function (result) {
                    alert(result.msg);
                    to_page(currentPage);
                }
            });
        }

    })
</script>
</body>
</html>

