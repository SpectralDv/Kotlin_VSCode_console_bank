

package Account

import java.text.DecimalFormat


data class Account(val customerNumber:Int,var pinNumber:Int)
{
    var cardBalance:Double = 0.0
    private set
    var savingBalance:Double = 0.0
    private set


    fun CalcBalance(amount:Double,balance:Double):Double
    {
        return (balance + amount)
    }

    fun GetCheckingWithdraw(amount:Double)
    {
        cardBalance = CalcBalance(-amount,cardBalance)
    }
    fun GetCheckingDeosit(amount:Double)
    {
        cardBalance = CalcBalance(amount,cardBalance)
    }
    fun GetSavingWithdraw(amount:Double)
    {
        savingBalance = CalcBalance(-amount,savingBalance)
    }
    fun GetSavingDeposit(amount:Double)
    {
        savingBalance = CalcBalance(amount,savingBalance)
    }
}

class ViewAccount()
{
    private var moneyFormat = DecimalFormat("'$'###,##0.00")

    fun PrintBalance(balance:Double)
    {
        println("Текущий баланс счета ${moneyFormat.format(balance)}")
    }

    fun InputWithdraw(account:Account):Double
    {
        var amount = readLine()!!.toDouble()
        if((account.cardBalance - amount) >= 0)
        {
            return amount
        }   
        return 0.0
    }
    fun InputDeposit():Double
    {
        var amount = readLine()!!.toDouble()
        if(amount > 0)
        {
            return amount
        }   
        return 0.0
    }
}