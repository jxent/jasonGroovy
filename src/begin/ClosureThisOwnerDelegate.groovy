package begin

/**
 * 闭包的三个关键变量
 * this owner delegate
 */

def scriptClosure = {
    // this 闭包定义处的类
    println "  script this " + this
    // owner 闭包定义处的类或对象
    println "  script owner " + owner
    // 任意对象，默认和owner一致
    println "  script delegate " + delegate
}

scriptClosure.call()

class Person{
    def /*static*/ classClosure = {
        //
        println " class  this " + this
        //
        println " class  owner " + owner
        //
        println " class delegate " + delegate
    }

    def /*static*/ hi(){
        def methodClosure = {
            //
            println " method  this " + this
            //
            println " method owner " + owner
            //
            println " method  delegate " + delegate
        }
        classClosure.call()
        methodClosure.call()
    }
}

//Person.hi()
new Person().hi()


println '-------------------------------------'

/**
 * 在闭包中定义闭包
 *
 * 嵌套闭包中的owner和delegate会执行内部的闭包，this会指向外部闭包
 * delegate可以修改，修改后就会和owner不一致
 *
 * */

def nestedClosure= {
    def innerClosure = {
        //
        println " nested-inner  this " + this
        //
        println " nested-inner owner " + owner
        //
        println " nested-inner  delegate " + delegate
    }
    // 可以手动修改delegate的值，但是无法修改owner的值
    Person p = new Person()
    innerClosure.owner = p
    innerClosure.delegate = p
    innerClosure.call()
}
nestedClosure.call()

println '-------------------------------------'

/**
 * 闭包的委托策略
 *
 * */

class Student{
    String name
    String alias

    def pretty = { "my name is $name and alias is $alias"}

    String toString(){
        pretty.call()
    }
}

class Teacher {
    String name
    String alias1
}

def stu = new Student(name: 'Jason')
def teacher0 = new Teacher(name: 'Alisa', alias1: 'alias0')
def teacher1 = new Teacher(name: 'Jenny', alias1: 'alias1')
println 'stu.toString() : ' + stu.toString()
// 修改delegate
stu.pretty.delegate = teacher0
stu.pretty.resolveStrategy = Closure.DELEGATE_FIRST
println '委托策略改为DELEGATE_FIRST stu.toString() : ' + stu.toString()
try{
    stu.pretty.delegate = teacher1
    // 委托策略为only，如果找不到则抛出异常
    stu.pretty.resolveStrategy = Closure.DELEGATE_ONLY
    println '委托策略改为DELEGATE_ONLY stu.toString() : ' + stu.toString()
}catch(MissingPropertyException e){
    // e.printStackTrace()
    println e.getMessage()
}finally {

}