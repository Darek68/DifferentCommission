


fun main() {
   // "VK Pay"  "Visa" "Мир" "MasterCard" "Maestro"
    println(makePay(cardType = "VK Pay",oldSum = 0,sumTransfer = 1000))
    println(makePay(cardType = "Visa",oldSum = 0,sumTransfer = 100))
    println(makePay(cardType = "Мир",oldSum = 0,sumTransfer = 10000))
    println(makePay(cardType = "MasterCard",oldSum = 0,sumTransfer = 10000))
    println(makePay(cardType = "Maestro",oldSum = 90000,sumTransfer = 10000))

}


fun makePay(cardType : String,oldSum : Int,sumTransfer : Int): String{

    val vStr = getOldSumTxt(cardType,oldSum)

    return "Коммисия по карте $cardType из суммы $sumTransfer $vStr будет  ${getCommission(inCardType = cardType,inSumTransfer = sumTransfer,inOldSum = oldSum)}"
}

fun getOldSumTxt(inType : String,inSum : Int) : String{

    return if (inType == "MasterCard" || inType == "Maestro") " (за мес - $inSum) " else ""

}

fun getCommission(inCardType : String,
                  inOldSum : Int,
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

