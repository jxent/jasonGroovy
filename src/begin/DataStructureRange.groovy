package begin

/**
 * groovy中范围
 */

def range = 1..10
println range.toString()
println range[0]
println "range size : ${range.size()}"
println range.contains(8)
println "range from: ${range.from}"
println "range to : ${range.to}"

range.each {
    println it
}


for (i in range) {
    println i
}


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


println getGrade(students[1].score)
def getGrade(Number number){
    def result
    switch (number){
        case 0..<60:
            result = '不及格'
            break
        case 60..100:
            result = '及格'
            break
        default:
            result = '不在范围内'
            break;
    }
    return result
}