<%--
  Created by IntelliJ IDEA.
  User: niudd
  Date: 2018/11/17
  Time: 14:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/webjars/github-com-zTree-zTree_v3/3.5.33/demo.css" type="text/css">
    <link rel="stylesheet" href="/webjars/github-com-zTree-zTree_v3/3.5.33/zTreeStyle/zTreeStyle.css" type="text/css">
    <link rel="stylesheet" href="/artDialog-master/css/ui-dialog.css">

    <script type="text/javascript" src="/webjars/jquery/3.3.1-1/jquery.min.js"></script>
    <script type="text/javascript" src="/artDialog-master/dist/dialog-plus-min.js"></script>
    <script type="text/javascript" src="/webjars/github-com-zTree-zTree_v3/3.5.33/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="/webjars/github-com-zTree-zTree_v3/3.5.33/jquery.ztree.all.js"></script>
    <SCRIPT LANGUAGE="JavaScript">
        var zTreeObj;
        // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
        var setting = {
            view: {
                addHoverDom: addHoverDom,
                removeHoverDom: removeHoverDom,
                selectedMulti: false
            },
            async: {
                enable: true,
                url: "listZtrees",
            },
            data: {
                simpleData: {
                    enable: true,
                    idKey: "id",
                    pIdKey: "pid",
                    rootPId: 0
                }
            },
            edit: {
                enable: true,
                showRemoveBtn: true,
                showRenameBtn: true
            },
            callback: {
                beforeRemove: zTreeBeforeRemove,
                beforeRename: zTreeBeforeRename
            }
        };

        function addHoverDom(treeId, treeNode) {
            var sObj = $("#" + treeNode.tId + "_span");
            if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
            var addStr = "<span background-image='/img/add.png' class='button add' id='addBtn_" + treeNode.tId
                + "' title='add node' onfocus='this.blur();'></span>";
            sObj.after(addStr);
            var btn = $("#addBtn_"+treeNode.tId);
            if (btn) btn.bind("click", function(){

                //自己增加节点
                //先通过ajax异步增加数据，将增加的数据获取到之后没放在{}
                //弹框
                var add_form = dialog({
                    title: '增加',
                    content: "节点名称：<input type='text' id='newNameInp'>",
                    okValue: '确 定',
                    ok: function () {

                        $.post("saveZtreeNode",{"name":$("#newNameInp").val(),"pid": treeNode.id},function(data){
                            var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                            zTree.addNodes(treeNode, {id: data.id, pid:data.pid, name:data.name});
                        })

                    },
                    cancelValue: '取消',
                    cancel: function () {
                        this.title('已经取消..',1);
                    }
                });
                add_form.show();

                return false;
            });
        };
        function removeHoverDom(treeId, treeNode) {
            $("#addBtn_"+treeNode.tId).unbind().remove();
        };
        function zTreeBeforeRename(treeId,treeNode,newName,isCancel){
            $.ajax({
                url:"updateZtreeById/"+treeNode.id+"/"+newName,
                type:"post",
                success:function(data){
                    return true;
                },
                error:function(){
                    return false;
                }
            })
        }
        function zTreeBeforeRemove(treeId,treeNode){

            $.ajax({
                url:"deleteZtreeById/"+treeNode.id,
                type:"post",
                success:function(data){
                    return true;
                },
                error:function(){
                    return false;
                }
            })
        }
        // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）

        $(document).ready(function(){
            //异步加载节点数据
            /*$.post("listZtree",function (data) {

                zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, data);
            })*/
            zTreeObj = $.fn.zTree.init($("#treeDemo"), setting);

        });
    </SCRIPT>
</head>
<body>
<div>
    <ul id="treeDemo" class="ztree"></ul>
</div>
</body>
</html>
