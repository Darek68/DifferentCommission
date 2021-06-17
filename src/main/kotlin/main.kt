


fun main() {
   // "VK Pay"  "Visa" "Мир" "MasterCard" "Maestro"

    println("Коммисия по карте VK Pay из суммы 1000 будет " + getCommission(inCardType = "VK Pay",inSumTransfer = 1000))

    println("Коммисия по карте Visa из суммы 100 будет " + getCommission(inCardType = "Visa",inSumTransfer = 100))

    println("Коммисия по карте Мир из суммы 10000 будет " + getCommission(inCardType = "Мир",inSumTransfer = 10000))

    println("Коммисия по карте MasterCard из суммы 10000 (за мес - 0) будет " + getCommission(inCardType = "MasterCard",inSumTransfer = 10000))

    println("Коммисия по карте Maestro из суммы 10000 (за мес - 90000) будет " + getCommission(inCardType = "Maestro",inSumTransfer = 10000,inOldSum = 90000))


}


fun getCommission(inCardType : String = "VK Pay",
                  inOldSum : Int = 0,
                  inSumTransfer : Int): Double {
    val minSumVisa = 35 * 10000 / 75
    val limitMaster = 75000

    val commission = when (inCardType){
                           "VK Pay" -> 0.0
                           "Visa","Мир" -> if (inSumTransfer <= minSumVisa) 35.00 else inSumTransfer / 10000 * 75.00
                            else -> {val retMaster = if ((inOldSum + inSumTransfer) > limitMaster){inSumTransfer / 1000 * 6 + 20} else 0.0
                                retMaster
                            }
                      }
    return commission.toDouble()
}
