package begin

/**
 * groovy中基本的数据结构
 */

// 列表
//def listA = new ArrayList().plus()
def listB = ['g', 'r', 'o', 'o', 'v', 'y']
def listC = [1, 2, 3, 4, 5]

println listC.class
println listC.size()

// 定义数组
def arrayA = [1, 3, 5, 7, 9] as int[]
println arrayA.class
int[] arrayB = [2, 4, 6, 8, 10]
println arrayB.class

// 列表排序 java方式
Collections.sort(listB)
println "java方式排序   " + listB
Comparator cA = {
    a, b ->
        a == b ? 0 :
                Math.abs(a) < Math.abs(b) ? -1 : 1
}
listD = [1, 6, 2, 45, 27, 23, 49, -10, 200, 44]
Collections.sort(listD, cA)
println "java方式按绝对值大小排序   " + listD
// groovy方式
listB.sort()
println "groovy方式排序： " + listB
listD.sort({
    a, b ->
        a == b ? 0 :
                Math.abs(a) < Math.abs(b) ? -1 : 1
})
println "groovy方式使用闭包排序： " + listD

def arrList = ['a', 'ba', 'hello', 'j', 'wolf']
arrList.sort({
    // 几种写法均可
//    it-> it.size()
//    it-> it.length()
//    it -> return it.size()
//    it -> return it.length()
//    it.size()
//    it.length()
//    return it.size()
    return it.length()
})
println arrList

def findList = [1, 34, 53, 38, 32, 1091, -8989, -3]
int firstResult = findList.find({
    return it % 2 == 0
})
println firstResult

def allResult = findList.findAll({
    return it % 2 == 0
})
println allResult.toListString()
// 是否有一个元素是奇数
println findList.any({ return it % 2 != 0 })
// 是否所有的元素都是奇数
println findList.every({ return it % 2 != 0 })

// 最大最小值
println findList.max()
println findList.min()
// 绝对值的最大最小值
println findList.max({ return Math.abs(it) })
println findList.min({ return Math.abs(it) })

// 统计奇数个数
int count = findList.count({ return it % 2 != 0 })
println count

/**
 * map映射
 */
println '---------------------------------------------'

// java方式
def mapJava = new HashMap()
mapJava.put('ha', 1)
mapJava.put('ga', 2)
println mapJava.size()
// groovy 方式 定义时key的单引号可以省略
def colors = ['red': 'ff0000', green: '00ff00', blue: '0000ff']
// 获取元素
println colors.get('red')
println colors['green']
println colors.blue
// 添加元素
colors.yellow = 'ffff00'
println colors.toMapString()

colors.leftShift(dark_grey:'333333')
// 添加不同类型的元素
colors.complex = [light_grey:'999999']
println colors.toMapString()
println colors.getClass()


def students = [
        1:[name:"jason", age:20, score:100],
        2:[name:"ming", age:9, score:90],
        3:[name:"hong", age:18, score:80],
        4:[name:"ling", age:17, score:55],
        5:[name:"dong", age:18, score:30],
        6:[name:"tian", age:14, score:85],
        7:[name:"xia", age:13, score:73],
        8:[name:"hello", age:13, score:93],
        9:[name:"love", age:18, score:99]
]

println "each 方式1"
students.each {
    stu -> println "key : ${stu.key} & value : ${stu.value}"
}
println "each 方式2"
students.each {
    key, value -> println "key : ${key} & value : ${value}"
}

students.eachWithIndex { /*Map.Entry<Integer, LinkedHashMap<String, Serializable>>*/def entry, int i ->
    println "index : $i  with key : ${entry.key} & value : ${entry.value}"
}

println 'map的查找'
def entry = students.find{
    stu -> return stu.value.score > 80
}
def entries = students.findAll {
    stu -> return stu.value.score > 80
}
println "分数大于80分的第一个stu ： ${entry.toString()}"
println "分数大于80分的所有stu：${entries.toMapString()}"

// 查找出所有分数达到60分年龄大于17的学生的名字
def names = students.findAll {
    def stu ->
        return stu.value.score >= 60
}.findAll {
    return it.value.age > 17
}.collect{
    return it.value.name
}

println names.toListString()

// 分组
def group = students.groupBy {
    def stu ->
        return stu.value.score >= 60 ? "及格": "不及格"
}

println group.toMapString()

// 按照分数排序
def mapSort = students.sort{
    def stu1, def stu2 ->
        Number sco1 = stu1.value.score
        Number sco2 = stu2.value.score
        return sco1 == sco2 ? 0 : sco1 > sco2 ? 1 : -1
}

println '按照分数排序：'
println mapSort.toMapString()
println mapSort.toMapString()





