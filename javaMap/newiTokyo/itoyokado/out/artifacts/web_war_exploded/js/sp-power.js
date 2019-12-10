// layui.config({
//     version: '1554901098009' //为了更新 js 缓存，可忽略
// }
use = layui.use(['laydate', 'laypage', 'layer', 'table', 'element', 'form'], function () {
    var laydate = layui.laydate //日期
        , laypage = layui.laypage //分页
        , layer = layui.layer //弹层
        , table = layui.table //表格
        , element = layui.element //元素操作
        , form = layui.form,
        $=layui.$;
    //向世界问个好
    layer.msg('加载中', {
        icon: 16
        , shade: 0.01
    });
    //监听Tab切换
    element.on('tab(demo)', function (data) {
        layer.tips('切换了 ' + data.index + '：' + this.innerHTML, this, {
            tips: 1
        });
    });
    //执行一个 table 实例
    table.render({
        elem: '#demo'
        , height: 520
        , url: '/SysUserServlet?method=findSysUser' //数据接口
        , title: '用户表'
        , page: true //开启分页
        , toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        , totalRow: true //开启合计行
        , cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            , {field: 'id', title: '编号', sort: true, align: 'center'}
            , {field: 'job_number', title: '工号', align: 'center'}
            , {field: 's_name', title: '姓名', sort: true, align: 'center'}
            , {field: 's_tel', title: '手机', align: 'center'}
            , {field: 'last_login_date', title: '上次登陆时间', align: 'center'}
            , {field: 'last_logout_date', title: '上次退出时间', sort: true, align: 'center'}
            , {
                field: 'company_id', title: '所属分店', align: 'center',
                templet: function (item) {
                    var s = item.company_id;
                    if (s == 0) {
                        return "眉山店";
                    } else if (s == 1) {
                        return "高新店";
                    } else if (s == 2) {
                        return "锦江店";
                    } else {
                        return "武侯店";
                    }
                }
            }
            , {
                field: 'type', title: '角色', sort: true, align: 'center',
                templet: function (item) {
                    var s = item.type;
                    if (s == 0) {
                        return "管理员";
                    } else if (s == 1) {
                        return "客服";
                    } else if (s == 2) {
                        return "配送员";
                    }
                    return null;
                }
            }
            , {fixed: 'right', width: 80, align: 'center', toolbar: '#barDemo'}
        ]]
        , response: {
            statusCode: 200 //重新规定成功的状态码为 200，table 组件默认为 0
        }
        , parseData: function (res) { //将原始数据解析成 table 组件所规定的数据
            return {
                "code": res.status, //解析接口状态
                "msg": res.message, //解析提示文本
                "count": res.total, //解析数据长度
                "data": res.rows.item //解析数据列表
            };
        }
        , id: 'reload'   //唯一ID
    });

    //表格重载
    active = {
        reload: function () {
            var field = $("#field");

            //执行重载
            table.reload('reload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                , where: {
                    field: field.val()
                }
            });
        }
    };

    $('.demoTable .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    //添加用户点击事件
    $(".butt1").on("click", function () {
        layer.open({
            type: 2,
            area: ['500px', '600px'],
            title: '添加用户',
            offset: 't',
            shade: 0.6, //遮罩透明度
            maxmin: true, //允许全屏最小化
            anim: 1,//0-6的动画形式，-1不开启
            content: 'add-spuser.html' //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        });
    });
    //监听头工具栏事件
    /* table.on('toolbar(test)', function(obj){
         var checkStatus = table.checkStatus(obj.config.id)
             ,data = checkStatus.data; //获取选中的数据
         switch(obj.event){
             case 'add':
                 layer.msg('添加');
                 break;
             case 'delete':
                 if(data.length === 0){
                     layer.msg('请选择一行');
                 } else {
                     layer.msg('删除');
                 }
                 break;
         };
     });*/
    //监听行工具事件
    table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            , layEvent = obj.event; //获得 lay-event 对应的值
        if (layEvent === 'edit') {
            setForm(data.type);
            layer.open({
                type: 1,
                area: ['420px', '330px'],
                title: '用户管理',
                content: $("#roleSet")//指定
            });
            //动态向表传递赋值可以参看文章进行修改界面的更新前数据的显示，当然也是异步请求的要数据的修改数据的获取
            setFormValue(obj, data);
        }
    });

    //数据渲染
    function setForm(type) {
        //必须的使用这些 不然无法选中指定下拉框
        // layui.use(['form','jquery'],function () {
        //     var form = layui.form,
        //         $ = layui.jquery;
        if (type == 0) {
            $("#roleSet #select01").find("option[value='0']").attr("selected", true);
            $("#roleSet #select01").find("option[value='1']").attr("selected", false);
            $("#roleSet #select01").find("option[value='2']").attr("selected", false);
        } else if (type == 1) {
            $("#roleSet #select01").find("option[value='1']").attr("selected", true);
            $("#roleSet #select01").find("option[value='0']").attr("selected", false);
            $("#roleSet #select01").find("option[value='2']").attr("selected", false);
        } else if (type == 2) {
            $("#roleSet #select01").find("option[value='2']").attr("selected", true);
            $("#roleSet #select01").find("option[value='0']").attr("selected", false);
            $("#roleSet #select01").find("option[value='1']").attr("selected", false);
        }
        form.render();
        // });

    }

    // 查询事件
    // 监听弹出框表单提交，massage是修改界面的表单数据'submit(demo11),是修改按钮的绑定
    function setFormValue(obj, data) {
        form.on('submit(powerform)', function (massage) {
            var newpassword = massage.field.newpassword;
            var newData = {"id": data.id, "type": massage.field.type, "s_password": newpassword};
            console.log(newData);
            $.ajax({
                url: '/SysUserServlet?method=updateSysUser',
                type: 'POST',
                data: newData,
                dataType: "json",
                success: function (result) {
                    // var returnCode = msg.returnCode;//取得返回数据（Sting类型的字符串）的信息进行取值判断
                    console.log(result);
                    if (result == 'true') {
                        layer.closeAll('loading');
                        layer.load(2);
                        layer.msg("修改成功", {icon: 6});
                        setTimeout(function () {
                            obj.update({
                                eqptType: massage.field.neweqptType,
                                eqptIdCode: massage.field.neweqptIdCode,
                                eqptName: massage.field.neweqptName
                            });//修改成功修改表格数据不进行跳转
                            layer.closeAll();//关闭所有的弹出层
                        }, 1000);
                        //加载层-风格
                    } else {
                        console.log('真失败')
                        layer.msg("修改失败", {icon: 5});
                    }
                },
                error:function (result) {
                    console.log('失败')
                }
            })
        })
    }
});
