

import ATM.*
import Account.*


internal var data = mutableListOf<Account>()

fun main() 
{
    val c1 = Account(12345678,1234)
    val c2 = Account(87654321,4321)

    data.add(c1)
    data.add(c2)

    ATM(data).Start()
}

