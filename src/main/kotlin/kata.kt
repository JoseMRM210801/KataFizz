import java.math.BigDecimal


fun cantidadConLetra(s: String?): String? {
    val result = StringBuilder()
    val totalBigDecimal = BigDecimal(s).setScale(2, BigDecimal.ROUND_DOWN)
    val parteEntera = totalBigDecimal.toBigInteger().toLong()
    val Unidades = (parteEntera % 1000).toInt()
    val Miles = (parteEntera / 1000 % 1000).toInt()
    if (parteEntera == 0L) {
        result.append("Cero ")
        return result.toString()
    }
    if (Miles > 0) result.append(convertidor(Miles).toString() + "Mil ")
    if (Unidades > 0) result.append(convertidor(Unidades).toString())
    return result.toString()
}
private fun convertidor(n: Int): StringBuilder {
    val result = StringBuilder()
    val centenas = n / 100
    val decenas = n % 100 / 10
    val unidades = n % 10
    when (centenas) {
        0 -> {}
        1 -> if (decenas == 0 && unidades == 0) {
            result.append("Cien ")
            return result
        } else result.append("Ciento ")
        2 -> result.append("Doscientos ")
        3 -> result.append("Trescientos ")
        4 -> result.append("Cuatrocientos ")
        5 -> result.append("Quinientos ")
        6 -> result.append("Seiscientos ")
        7 -> result.append("Setecientos ")
        8 -> result.append("Ochocientos ")
        9 -> result.append("Novecientos ")
    }
    when (decenas) {
        0 -> {}
        1 -> if (unidades == 0) {
            result.append("Diez ")
            return result
        } else if (unidades == 1) {
            result.append("Once ")
            return result
        } else if (unidades == 2) {
            result.append("Doce ")
            return result
        } else if (unidades == 3) {
            result.append("Trece ")
            return result
        } else if (unidades == 4) {
            result.append("Catorce ")
            return result
        } else if (unidades == 5) {
            result.append("Quince ")
            return result
        } else result.append("Dieci")
        2 -> if (unidades == 0) {
            result.append("Veinte ")
            return result
        } else result.append("Veinti")
        3 -> result.append("Treinta ")
        4 -> result.append("Cuarenta ")
        5 -> result.append("Cincuenta ")
        6 -> result.append("Sesenta ")
        7 -> result.append("Setenta ")
        8 -> result.append("Ochenta ")
        9 -> result.append("Noventa ")
    }
    if (decenas > 2 && unidades > 0) result.append("y ")
    when (unidades) {
        0 -> {}
        1 -> result.append("Un ")
        2 -> result.append("Dos ")
        3 -> result.append("Tres ")
        4 -> result.append("Cuatro ")
        5 -> result.append("Cinco ")
        6 -> result.append("Seis ")
        7 -> result.append("Siete ")
        8 -> result.append("Ocho ")
        9 -> result.append("Nueve ")
    }
    return result
}


fun main(args: Array<String>) {

    println("Escribe un numero entero: ")
    val number= readLine()
    var numero= number?.toIntOrNull()
    if (numero != null) {
        when{
            numero== 0 -> print("cero")
            numero %3 == 0 && numero % 5 == 0->print("Fizzbuzz")
            numero %3 == 0 -> print("Fizz")
            numero %5 == 0 -> print("Buzz")
            else ->  println(cantidadConLetra(number))
        }
    }

}
