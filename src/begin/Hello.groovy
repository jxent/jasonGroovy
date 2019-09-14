package begin

println("hello world")


int x = 11;
println x.class
double y = 3.11
println y.class

println "------------------------------------"

def xx = 11
def yy = 3.14
def zz = "hello"
println xx.class
println yy.class
println zz.class

zz = 3.1313
println zz.class

println "------------------------------------"


def name = 'jason\'O(∩_∩)O\''
// 有格式
def name1 = '''\
One:Java World
Two:hi
Three:bye'''
println name
println name1

// "双引号字符串" 可扩展字符串 可以使用${表达式} $var
def name2 = "my name is $name ;age is ${xx + yy} "
println name2
println name2.class
// GStringImpl和String可以互转
def result = echo(name2)
println result.class
String echo(String message){
    return message
}


println "------------------------------------"

def str = "groovy"
// 字符串填充
println str.center(8, '_')
str = "groovy"
println str.padLeft(8, '_')

str = "groovy"
println str[0]
println str[2..3]
def str2 = "groovy"
println str == str2


def helloworld = 'helloworld'
def hello = 'hello'
println helloworld - hello
// 反转
println helloworld.reverse()
// 首字符大写
println helloworld.capitalize()
// 转为大写
println helloworld.toUpperCase()
helloworld = 'HELLOWORLD'
// 首字符小写
println helloworld.uncapitalize()
// 转为小写
println helloworld.toLowerCase()
// 转为list集合
println helloworld.toList()

// 转换为数字
def number = '10010'
println number.isNumber()
if(number.isNumber()){
    println number.toLong()
}
println "------------------------------------"





















