layui.config({
    version: '1554901098009' //为了更新 js 缓存，可忽略
});
layui.use(['laydate', 'laypage', 'layer', 'table', 'element', 'form'], function () {
    var laydate = layui.laydate //日期
        , laypage = layui.laypage //分页
        , layer = layui.layer //弹层
        , table = layui.table //表格
        , element = layui.element //元素操作
        , form = layui.form;
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
        elem: '#test'
        , height: 520
        , url: '/CategoryServlet?method=findCategory' //数据接口
        , title: '用户表'
        , page: true //开启分页
        , toolbar: 'default' //开启工具栏，此处显示默认图标，可以自定义模板，详见文档
        , totalRow: true //开启合计行
        , cols: [[ //表头
            {type: 'checkbox', fixed: 'left'}
            , {
                field: 'parent_name', title: '父级分类', sort: true, align: 'center'
                , templet: function (item) {
                    var s = item.fstatu;
                    if (s == 0) {
                        return "---------";
                    } else {
                        return item.parent_name;
                    }
                }
            }
            , {
                field: 'name', title: '子级分类', align: 'center'
                , templet: function (item) {
                    var p = item.fstatu;
                    if (p == 0 ){
                        return "------------";
                    } else {
                        var s = item.zstatu;
                        if (s == 0) {
                            return "------------";
                        } else {
                            return item.name;
                        }
                    }
                }
            }
            // ,{field:'s', title: '促销中', sort: true, align: 'center'}
            , {fixed: 'right', title: '操作', width: 200, align: 'center', toolbar: '#barDemo'}
        ]], response: {
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

    //表格重载 做查询
    active = {
        reload: function () {
            var field = $("#field");

            //执行重载
            table.reload('reload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                , where: {
                    name: field.val()
                }
            });
        }
    };

    $('#sreach').on('click', function () {
        console.log("点击了查询");
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    $(".butt1").on("click", function () {
        layer.open({
            type: 2,
            area: ['435px', '290px'],
            title: '分类管理',
            offset: 'auto',
            shade: 0.6, //遮罩透明度
            maxmin: true, //允许全屏最小化
            anim: 3,//0-6的动画形式，-1不开启
            content: 'add-class.html' //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
        });
    });

    $(".butt2").on("click", function () {
        layer.open({
            type: 2,
            area: ['500px', '290px'],
            title: '分类管理',
            offset: 'auto',
            shade: 0.6, //遮罩透明度
            maxmin: true, //允许全屏最小化
            anim: 3,//0-6的动画形式，-1不开启
            content: 'add-pclass.html' //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
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
    //监听行工具事件 隐藏 or显示
    table.on('tool(test)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            , layEvent = obj.event; //获得 lay-event 对应的值
        if (layEvent === 'edit') {
            layer.open({
                type: 1,
                area: ['420px', '300px'],
                title: '分类隐藏',
                offset: 'auto',
                shade: 0.6, //遮罩透明度
                maxmin: true, //允许全屏最小化
                anim: 4,//0-6的动画形式，-1不开启
                content: $("#setX") //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
            });
            setForm(obj, data);
        }else if (layEvent === 'show') {
            layer.open({
                type: 1,
                area: ['420px', '300px'],
                title: '分类显示',
                offset: 'auto',
                shade: 0.6, //遮罩透明度
                maxmin: true, //允许全屏最小化
                anim: 4,//0-6的动画形式，-1不开启
                content: $("#setY") //这里content是一个URL，如果你不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
            });
            setShow(obj, data);
        } else if (layEvent === 'del') {
            layer.confirm('真的删除行么', function (index) {
                obj.del(); //删除对应行（tr）的DOM结构
                layer.close(index);
                //向服务端发送删除指令
            });
        }
    });

    //监听弹出表单框提交 隐藏分类
    function setForm(obj, data) {
        form.on('submit(hide)', function (massage) {
            var msg = massage.field.cate;
            var newData;
            if (msg == '父') {
                newData = {"id": data.parent_id, "statu": 0};
            } else {
                newData = {"id": data.id, "statu": 0};
            }
            $.ajax({
                url: '/CategoryServlet?method=hideCate',
                type: 'POST',
                data: newData,
                dataType: "json",
                success: function (result) {
                    // var returnCode = msg.returnCode;//取得返回数据（Sting类型的字符串）的信息进行取值判断
                    console.log(result);
                    // if (result.status=="true") {
                    if (result) {
                        layer.msg("修改成功", {icon: 6});
                        layer.closeAll('loading');
                        layer.load(2);
                        setTimeout(function () {
                            obj.update({
                                eqptType: massage.field.neweqptType,
                                eqptIdCode: massage.field.neweqptIdCode,
                                eqptName: massage.field.neweqptName
                            });//修改成功修改表格数据不进行跳转
                            layer.closeAll();//关闭所有的弹出层
                            x_admin_father_reload();
                        }, 1000);
                        //加载层-风格
                    } else {
                        console.log('真失败');
                        layer.msg("修改失败", {icon: 5});
                        x_admin_father_reload();
                    }
                },
                error: function (result) {
                    console.log(result);
                    console.log('失败')
                    x_admin_father_reload();
                }
            })
        })
    }

    //监听弹出表单框提交 显示分类
    function setShow(obj, data) {
        form.on('submit(showCate)', function (massage) {
            var msg = massage.field.cate;
            var newData;
            if (msg == '父') {
                newData = {"id": data.parent_id, "statu": 1};
            } else {
                newData = {"id": data.id, "statu": 1};
            }
            $.ajax({
                url: '/CategoryServlet?method=hideCate',
                type: 'POST',
                data: newData,
                dataType: "json",
                success: function (result) {
                    // var returnCode = msg.returnCode;//取得返回数据（Sting类型的字符串）的信息进行取值判断
                    console.log(result);
                    // if (result.status=="true") {
                    if (result) {
                        layer.msg("修改成功", {icon: 6});
                        layer.closeAll('loading');
                        layer.load(2);
                        setTimeout(function () {
                            obj.update({
                                eqptType: massage.field.neweqptType,
                                eqptIdCode: massage.field.neweqptIdCode,
                                eqptName: massage.field.neweqptName
                            });//修改成功修改表格数据不进行跳转
                            layer.closeAll();//关闭所有的弹出层
                            x_admin_father_reload();
                        }, 1000);

                        //加载层-风格
                    } else {
                        console.log('真失败');
                        layer.msg("修改失败", {icon: 5});
                        x_admin_father_reload();
                    }
                },
                error: function (result) {
                    console.log(result);
                    console.log('失败')
                    x_admin_father_reload();
                }
            })
        })
    }
});