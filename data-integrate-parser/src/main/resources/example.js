/**
 * 判断字符串是否为空字符串
 * @param str
 * @returns {boolean}
 */
function isNotEmptyString(str){
    if(str==null || str.length==0){
        return false;
    }
    return true;
}

function test(obj) {
    return eval(obj);
}
/**
 * 判断key、value是否有值
 *
 */
function isKeyExists(path, object) {
    var global = (function () {
        return this;
    }());
    var pathList = path.split('.');
    var obj = null;
    var globalObj = global[pathList.shift()];
    obj = object || globalObj;
    if (!obj) {
        return false;
    }
    for (var i = 0; key = pathList[i]; i++) {
        if (!obj[key]) {
            return false;
        }
        obj = obj[key];
    }
    return true;
}

/**
 * 只判断key是否存在,key存在就返回true
 *
 */
function isOnlyKeyExists(path, object) {
    var global = (function () {
        return this;
    }());
    var pathList = path.split(".");
    var obj = null;
    var globalObj = global[pathList.shift()];
    obj = object || globalObj;
    if (!obj) {
        return false;
    }
    for (var i = 0; key = pathList[i]; i++) {
        if (obj[key] == null) {
            return false;
        }
        obj = obj[key];
    }
    return true;
}


/**
 * MAP定义
 *
 */
function Map() {
    var struct = function (key, value) {
        this.key = key;
        this.value = value;
    };

    var put = function (key, value) {
        for (var i = 0; i < this.arr.length; i++) {
            if (this.arr[i].key === key) {
                this.arr[i].value = value;
                return;
            }
        }
        this.arr[this.arr.length] = new struct(key, value);
    };

    var get = function (key) {
        for (var i = 0; i < this.arr.length; i++) {
            if (this.arr[i].key === key) {
                return this.arr[i].value;
            }
        }
        return null;
    };

    var remove = function (key) {
        var v;
        for (var i = 0; i < this.arr.length; i++) {
            v = this.arr.pop();
            if (v.key === key) {
                continue;
            }
            this.arr.unshift(v);
        }
    };

    var size = function () {
        return this.arr.length;
    };

    var isEmpty = function () {
        return this.arr.length <= 0;
    };
    this.arr = new Array();
    this.get = get;
    this.put = put;
    this.remove = remove;
    this.size = size;
    this.isEmpty = isEmpty;
}


var obj = eval('(' + paramJson + ')');

var EquipmentCallLog = obj.purchaseDatas.EquipmentCallLog;

//20180403
var i_eqcl_cell3_num = 'tempVar',i_eqcl_collection_occ = 'tempVar',i_eqcl_fraudcell_num = 'tempVar';