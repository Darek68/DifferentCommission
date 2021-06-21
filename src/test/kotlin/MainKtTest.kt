import org.junit.Test

import org.junit.Assert.*

class MainKtTest {
// Тестирование makePay

    @Test
    fun makePayVKPay() { // "VK Pay",oldSum = 0,sumTransfer = 1000
        //arrange
        val inCardType = "VK Pay"
        val inOldSum   = 0
        val inSumTrnsf = 1000
        //act
        val result = makePay(inCardType,inOldSum,inSumTrnsf)
        //assert
        assertEquals("Коммисия по карте VK Pay из суммы 1000  будет  0.0",result)
    }
    @Test
    fun makePayVisa() { // "Visa",oldSum = 0,sumTransfer = 100
        //arrange
        val inCardType = "Visa"
        val inOldSum   = 0
        val inSumTrnsf = 100
        //act
        val result = makePay(inCardType,inOldSum,inSumTrnsf)
        //assert
        assertEquals("Коммисия по карте Visa из суммы 100  будет  35.0",result)
    }
    @Test
    fun makePayMir() { // "Мир",oldSum = 0,sumTransfer = 10000
        //arrange
        val inCardType = "Мир"
        val inOldSum   = 0
        val inSumTrnsf = 10000
        //act
        val result = makePay(inCardType,inOldSum,inSumTrnsf)
        //assert
        assertEquals("Коммисия по карте Мир из суммы 10000  будет  75.0",result)
    }
    @Test
    fun makePayMaster() { // "MasterCard",oldSum = 0,sumTransfer = 10000
        //arrange
        val inCardType = "MasterCard"
        val inOldSum   = 0
        val inSumTrnsf = 10000
        //act
        val result = makePay(inCardType,inOldSum,inSumTrnsf)
        //assert
        assertEquals("Коммисия по карте MasterCard из суммы 10000  (за мес - 0)  будет  0.0",result)
    }
    @Test
    fun makePayMaestro() { // "Maestro",oldSum = 90000,sumTransfer = 10000
        //arrange
        val inCardType = "Maestro"
        val inOldSum   = 90000
        val inSumTrnsf = 10000
        //act
        val result = makePay(inCardType,inOldSum,inSumTrnsf)
        //assert
        assertEquals("Коммисия по карте Maestro из суммы 10000  (за мес - 90000)  будет  80.0",result)
    }
// тестирование getCommission
    @Test
    fun getComVKPay() { // VK Pay из суммы 1000  будет  0.0
        //arrange
        val inCardType = "VK Pay"
        val inOldSum   = 0
        val inSumTrnsf = 1000
        //act
        val result : Double = getCommission(inCardType,inOldSum,inSumTrnsf)
        //assert
        assertEquals(0.0,result,0.001)
    }
    @Test
    fun getComVisa() { // Visa из суммы 100  будет  35.0
        //arrange
        val inCardType = "Visa"
        val inOldSum   = 0
        val inSumTrnsf = 100
        //act
        val result : Double = getCommission(inCardType,inOldSum,inSumTrnsf)
        //assert
        assertEquals(35.0,result,0.001)
    }
    @Test
    fun getComMir() { // Мир из суммы 10000  будет  75.0
        //arrange
        val inCardType = "Мир"
        val inOldSum   = 0
        val inSumTrnsf = 10000
        //act
        val result : Double = getCommission(inCardType,inOldSum,inSumTrnsf)
        //assert
        assertEquals(75.0,result,0.001)
    }
    @Test
    fun getComMaster() { // MasterCard из суммы 10000  (за мес - 0)  будет  0.0
        //arrange
        val inCardType = "MasterCard"
        val inOldSum   = 0
        val inSumTrnsf = 10000
        //act
        val result : Double = getCommission(inCardType,inOldSum,inSumTrnsf)
        //assert
        assertEquals(0.0,result,0.001)
    }
    @Test
    fun getComMaestro() { // Maestro из суммы 10000  (за мес - 90000)  будет  80.0
        //arrange
        val inCardType = "MasterCard"
        val inOldSum   = 90000
        val inSumTrnsf = 10000
        //act
        val result : Double = getCommission(inCardType,inOldSum,inSumTrnsf)
        //assert
        assertEquals(80.0,result,0.001)
    }
   // Тестирование getOldSumTxt
    @Test
    fun getOldSumTxtMaster90000() { // "MasterCard" "Maestro" 90000 (за мес - 0) (за мес - 90000)
        //arrange
        val inCardType = "MasterCard"
        val inSumTrnsf = 90000
        //act
        val result = getOldSumTxt(inCardType,inSumTrnsf)
        //assert
        assertEquals(" (за мес - 90000) ",result)
    }
    @Test
    fun getOldSumTxtMaestro90000() { // "MasterCard" "Maestro" 90000 (за мес - 0) (за мес - 90000)
        //arrange
        val inCardType = "Maestro"
        val inSumTrnsf = 90000
        //act
        val result = getOldSumTxt(inCardType,inSumTrnsf)
        //assert
        assertEquals(" (за мес - 90000) ",result)
    }
    @Test
    fun getOldSumTxtVisa90000() { // "MasterCard" "Maestro" 90000 (за мес - 0) (за мес - 90000)
        //arrange
        val inCardType = "Visa"
        val inSumTrnsf = 90000
        //act
        val result = getOldSumTxt(inCardType,inSumTrnsf)
        //assert
        assertEquals("",result)
    }
}