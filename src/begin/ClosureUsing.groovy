package begin

/**
 * 数字和闭包
 */
int x = 10

// 使用闭包求阶乘
int fab(int number){

    int result = 1;
    // 从1开始，循环到number，然后依次调用闭包
    1.upto(number, {num -> result *= num})

    return result
}

def result = fab(5)
println result


int fab2(int number){
    int sum = 1

//    number.downto(1, {num -> sum *= num})
    number.downto(1){
        num -> sum *= num
    }

    return sum
}

def result2 = fab2(5)
println result2


int time(int number){
    int sum = 0;

    number.times {
        num -> sum += num
    }

    return sum
}

// 累加到100
def resultSum = time(101)
println resultSum


println '------------------------------------------'

/**
 * 字符串和闭包
 * */
def str = 'jason'
str.each {
    args -> print args + ' '
}
str = 'jason678'
println "\n" + str.find{
    String s -> s.isNumber()
}
println str.findAll{
    s -> s.isNumber()
}

str = "hell0"
println str.any{
    s -> s.isNumber()
}
println str.every{
    s -> s.isNumber()
}

def listStr =  str.collect{
    s -> s.toUpperCase()
}
println listStr.toListString()
