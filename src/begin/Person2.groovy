package begin

/**
 * 默认public
 * 默认继承GroovyObject
 */
final class Person2 implements IAction {

    String name
    Integer age

    def increaseAge(Integer years){
        this.age += years
    }

    // 抛出MissingMethodException之前最后一层处理
    def invokeMethod(String name, Object args){
        println "method\'${name}\' & args\'${args}\'"
    }

    // methodMissing较invokeMethod更早
    def methodMissing(String name, Object args){
        println "the method ${name} is missing"
    }

    @Override
    void eat() {

    }

    @Override
    void drink() {

    }

    @Override
    void play() {

    }
}
