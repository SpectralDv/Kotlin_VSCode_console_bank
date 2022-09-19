
package ViewManu


fun ViewMainManu()
{
    println("Выберите учетную запись")
    println("Type 1 - Основной аккаунт")
    println("Type 2 - Сберегательный аккаунт")
    println("Type 3 - Выход")
    println("Выберите пожалуйста...")
}

fun ViewSubMenu(text:String)
{
    println("Меню $text аккаунта")
    println("Type 1 - Баланс")
    println("Type 2 - Снять средства")
    println("Type 3 - Внести средства")
    println("Type 4 - Выход")
}
