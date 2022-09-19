

package ATM
import Account.*
import ViewManu.*

public class ATM
{
    val accounts:List<Account>
    var viewAccount:ViewAccount = ViewAccount()
    lateinit var account:Account
    var customerNumber:Int = -1
    var pinNumber:Int = -1

    constructor(accounts:List<Account>)
    {
        this.accounts = accounts
    }

    fun Start()
    {
        var flag = 1

        do{
            println("Добро пожаловать в проект АТМ!")
            try
            {
                print("Введите номер своей карты: ")
                customerNumber = readLine()!!.toInt()
                print("Введите пин своей карты: ")
                pinNumber = readLine()!!.toInt()
            }
            catch(e: Exception)
            {
                println("Exception $e")
                Start()
            }
            
            if(customerNumber == 0 && pinNumber == 0)
            {
                Stop()
            }

            accounts.forEach{
                if(it.customerNumber == customerNumber && it.pinNumber == pinNumber)
                {
                    println("Проверка прошла успешно")
                    this.account = it
                    MainMenu()
                }
                else
                {
                    
                }
            }
            println("Проверка не пройдена")
        }while(flag == 1)
    }
    fun MainMenu()
    {
        ViewMainManu()
        var selection = readLine()!!.toInt()
        when(selection)
        {
            1 -> MenuCheckAccount()
            2 -> MenuSaveAccount()
            3 -> println("Спасибо за использование АТМ")
            else -> {println("Ваш номер введен некорректно\n");MainMenu()}
        }
    }
    fun MenuCheckAccount()
    {
        ViewSubMenu("основного");
        var selection = readLine()!!.toInt()
        when(selection)
        {
            1 -> { 
                println("Баланс основного аккаунта: ${this.account.cardBalance}")
                MenuCheckAccount()
            }
            2 -> {
                this.viewAccount.PrintBalance(this.account.cardBalance)
                print("Введите сумму, которую вы хотите снять со счета: ")
                this.account.GetCheckingWithdraw(this.viewAccount.InputWithdraw(this.account));MenuCheckAccount()
            }
            3 -> {
                this.viewAccount.PrintBalance(this.account.cardBalance)
                print("Введите сумму, которую вы хотите положить на счет: ")
                val b = this.viewAccount.InputDeposit()
                println("amount: $b")
                this.account.GetCheckingDeosit(b);MenuCheckAccount()
            }
            4 -> println("Спасибо за использование АТМ")
            else -> {println("Ваш номер введен некорректно\n");MenuCheckAccount()}
        }
    }
    fun MenuSaveAccount()
    {
        ViewSubMenu("сберегательного");
        var selection = readLine()!!.toInt()
        when(selection)
        {
            1 -> { 
                println("Баланс сберегательного аккаунта: ${this.account.savingBalance}")
                MenuSaveAccount()
            }
            2 -> {
                this.viewAccount.PrintBalance(this.account.savingBalance)
                print("Введите сумму, которую вы хотите снять со счета: ")
                this.account.GetSavingWithdraw(this.viewAccount.InputWithdraw(this.account));MenuSaveAccount()
            }
            3 -> {
                this.viewAccount.PrintBalance(this.account.savingBalance)
                print("Введите сумму, которую вы хотите положить на счет: ")
                this.account.GetSavingDeposit(this.viewAccount.InputDeposit());MenuSaveAccount()
            }
            4 -> println("Спасибо за использование АТМ")
            else -> {println("Ваш номер не верный\n");MenuSaveAccount()}
        }
    }
    fun Stop()
    {
        println("Stopping system...")
        System.exit(0)
    }
}

