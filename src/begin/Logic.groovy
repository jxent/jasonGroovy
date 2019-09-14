package begin

def x = 1.23
def y = 'hello'
def z = 13
def result
// 增强的switch case
switch (z){
    case 'foo':
        result = 'found'
        break
    case 'bar':
        result = 'bar'
        break
    case [1.23,5,6,'hello', 'world']:
        result = 'list'
        break
    case 12..30:
        result = 'range'
        break
    case Integer:
        result = 'integer'
        break
    case BigDecimal:
        result = 'bigDecimal'
        break
    default:
        result = 'default'
        break
}
println result

println '--------------------------------------'

/**
 * 增强的for循环
 */
def sum = 0
for (i in 10..20) {
    sum += i
}
println sum
sum = 0

// list
for (i in [1,5,10,20,100]) {
    sum += i
}
println sum
sum = 0

// map
for (i in ['ming':12, 'ling':15, 'meimei':16, 'wenwen':17]){
    sum += i.value
}
println sum
