/** 定义基础的控制器 */
app.controller("baseController", function($scope){

    // 定义分页组件需要参数对象
    $scope.paginationConf = {
        currentPage : 1, // 当前页码
        perPageOptions : [10,15,20], // 页码下拉列表框
        totalItems : 0, // 总记录数
        itemsPerPage : 10, // 每页显示记录数
        onChange : function(){ // 当页码发生改变后需要调用的函数
            // 重新加载数据
            $scope.reload();
        }
    };

    // 定义重新加载数据方法
    $scope.reload = function(){
        // 分页查询(带查询条件)
        $scope.search($scope.paginationConf.currentPage,
            $scope.paginationConf.itemsPerPage);
    };

    // 定义数组封装用户选择的id
    $scope.ids = [];

    // 为checkbox绑定点击事件
    $scope.updateSelection = function($event,id,i){
        // $event: 事件对象
        // $event.target: dom元素
        // $event.target.checked : 判断checkbox是否选中
        if ($event.target.checked){
            // 往数组中添加元素
            $scope.ids.push(id);
        }else{
            // 得到该元素在数组中的索引号
            var idx = $scope.ids.indexOf(id);
            // 从数组中删除一个元素
            // 第一个参数：数组中元素的索引号
            // 第二个参数：删除的个数
            $scope.ids.splice(idx,1);
        }

        // 重新赋值，再次绑定checkbox
        $scope.checkedArr[i] = $event.target.checked;
        // 让全选是否选中,再次绑定checkbox
        $scope.ckAll = $scope.dataList.length == $scope.ids.length;
    };

// 定义checkbox是否选中的数组
    $scope.checkedArr = [];

    // 为全选绑定点击事件
    $scope.checkAll = function($event){
        // 清空用户选择的ids
        $scope.ids = [];
        // 循环当前页数据数组
        for (var i = 0; i < $scope.dataList.length; i++) {
            // 初始化数组
            $scope.checkedArr[i] = $event.target.checked;
            // 判断是否选中
            if ($event.target.checked) {
                // {id}
                $scope.ids.push($scope.dataList[i].id);
            }
        }
        // 重新赋值，再次绑定checkbox
        $scope.ckAll = $scope.dataList.length == $scope.ids.length;
    };

    /** 分页查询(查询条件) */
    $scope.search = function(page, rows){
        /**###########全选(下一页清空)#########*/
        $scope.ids = [];
        $scope.checkedArr = [];
        $scope.ckAll = false;
    };
    /** 提取数组中json某个属性，返回拼接的字符串(逗号分隔) */
    $scope.jsonArr2Str = function(jsonArrStr, key){

        // 把jsonArrStr转化成JSON数组对象
        var jsonArr = JSON.parse(jsonArrStr);
        // 定义新数组
        var resArr = [];
        // 迭代json数组
        for (var i = 0; i < jsonArr.length; i++){
            // 取数组中的一个元素
            var json = jsonArr[i];
            // 把json对象的值添加到新数组
            resArr.push(json[key]);
        }
        // 返回数组中的元素用逗号分隔的字符串
        return resArr.join(",");
    };
});