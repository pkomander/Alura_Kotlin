fun main() {
    println("Bem vindo ao Bytebank")
    val contaAlex = Conta(titular = "Alex", numero =  1000)
    contaAlex.deposita(-200.0)

    val contaFran = Conta(titular = "Fran", numero = 1001)
    contaFran.deposita(300.0)

    println(contaAlex.titular)
    println(contaAlex.numero)
    println(contaAlex.saldo)

    println()

    println(contaFran.titular)
    println(contaFran.numero)
    println(contaFran.saldo)

    println("depositando na conta do Alex")
    contaAlex.deposita(50.0)
    println(contaAlex.saldo)
    println("depositando na conta do Fran")
    contaFran.deposita(70.0)
    println(contaFran.saldo)
    println()
    println("sacando na conta do Alex")
    contaAlex.saca(250.0)
    println(contaAlex.saldo)

    println("sacando na conta da Fran")
    contaFran.saca(100.0)
    println(contaFran.saldo)

    println()

    println("saque em excesso na conta do Alex")
    contaAlex.saca(100.0)
    println(contaAlex.saldo)

    println("saque em excesso na conta da Fran")
    contaFran.saca(500.0)
    println(contaFran.saldo)

    println()

    println("Transferencia da conta da Fran para o Alex")

    if (contaFran.transfere(valor = 100.0, destino = contaAlex)) {
        println("Transferencia sucedida")
    } else {
        println("Falha na transferencia")
    }

    println(contaAlex.saldo)
    println(contaFran.saldo)
}

            //constructor primario na classe, podendo inicializar os atributos diretamente
class Conta(
    var titular: String,
    val numero: Int
) {
    var saldo = 0.0
        private set


    //metodo
    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    fun saca(valor: Double) {
        if (saldo >= valor) {
            this.saldo -= valor
        }
    }

    fun transfere(valor: Double, destino: Conta): Boolean {
        if (saldo >= valor) {
            saldo -= valor
            destino.deposita(valor)
            return true
        }
        return false
    }

    //no kotlin não e usual utilizar os geters e seters
//    fun getSaldo(): Double {
//        return saldo
//    }
//
//    fun setSaldo(valor: Double) {
//        if (valor > 0) {
//            saldo = valor
//        }
//    }
}

fun testaCopiasEReferencias() {
    val numeroX = 10
    var numeroY = numeroX
    numeroY++

    println("numeroX $numeroX")
    println("numeroY $numeroY")

    val contaJoao = Conta("João", 1002)
    var contaMaria = Conta("Maria", 1003)

    println("titular conta joao: ${contaJoao.titular}")
    println("titular conta maria: ${contaMaria.titular}")
}

fun testaLacos() {

    var i = 0
    while (i < 5) {
        val titular: String = "Alex $i"
        val numeroConta: Int = 1000 + i
        var saldo: Double = i + 10.0

        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")
        println()
        i++
    }

//    for (i in 1..5) para rodar o codigo dentro do range de 1 á 5
//    downTo para contagem regreciva
//    step roda o codigo com intervalo de numeros
    for (i in 5 downTo 1) {

        if (i == 4) {
            break
        }
        val titular: String = "Alex $i"
        val numeroConta: Int = 1000 + i
        var saldo: Double = i + 10.0

        println("titular $titular")
        println("número da conta $numeroConta")
        println("saldo da conta $saldo")

        println()
    }
}

fun testaCondicoes(saldo: Double) {

    if (saldo > 0.0) {
        println("conta é positiva")
    } else if (saldo == 0.0) {
        println("conta e neutra")
    } else {
        println("conta e negativa")
    }

    when {
        saldo > 0.0 -> {
            println("conta é positiva")
        }
        saldo == 0.0 -> {
            println("conta e neutra")
        }
        else -> {
            println("conta e negativa")
        }
    }
}