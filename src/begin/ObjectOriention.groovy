package begin

/**
 * groovy中的面向对象
 */
def person2 = new Person2(name: 'jason', age:29)
// Integer默认值null int默认值0
def person2_1 = new Person2(name: 'jason')
def person2_2 = new Person2(age:29)

println "${person2.name}    ${person2.getAge()}"
println "${person2_1.getName()}    ${person2_1.age}"
println "${person2_2.name}    ${person2_2.getAge()}"

// 没有定义的方法
person2.cry()

/**
 * 运行时动态注入，更好地解决了有些场景下只能通过继承某些类去扩展新方法的需求，并且final也可以扩展
 */
// 动态注入新的属性
Person2.metaClass.gender = 'male'
def Person2 person2_3 = new Person2()
println person2_3.gender
// 修改属性值
person2_3.gender = 'female'
println person2_3.gender

// 动态注入新的方法
Person2.metaClass.genderUpperCase = {
    -> gender.toUpperCase()
}
def Person2 person2_4 = new Person2()
println person2_4.genderUpperCase()

Person2.metaClass.static.getInstance = {
    String name, int age ->
        return new Person2(name:name, age:age)
}
Person2 person2_5 = Person2.getInstance('jason', 18)
println "动态添加静态方法输出： ${person2_5.name} &  ${person2_5.age}"


// 以上方式注入的属性和方法在其他模块中是不可用的，可用通过在注入之前添加以下设置
ExpandoMetaClass.enableGlobally()
// 注入操作

// 这样注入的属性和方法的就可以全局使用了