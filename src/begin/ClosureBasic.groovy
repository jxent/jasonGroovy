package begin

/**
 * 闭包概念：一段代码块，类似于方法
 *
 *
 */
// 无参定义
def closure = {
    println 'hello groovy'
}
// 不指定参数，默认有一个隐式参数it
def closureDef = {
    println "hello $it"
}

// 指定参数的写法
def closure1 = { String name ->
    println "hello $name"
}

def student = {String name, int age ->
    println "姓名：$name 年龄：$age"
}

// 调用方式
closure.call()
closure()
def hah = 'default parameter'
closureDef.call(hah)
closureDef(hah)

closure1.call("jason")
closure1("jason")

student.call("jason", 18)
student('jason', 18)


println '------------------------------------------'

/**
 * 闭包的返回值
 */

// 有返回值，使用return语句
def resultClosure = {
    return 'result code = 200'
}
def result = resultClosure()
println result

// 返回值为null
def resultNullClosure = {
    println "default result null"
}
def resultNull = resultNullClosure()
println resultNull

