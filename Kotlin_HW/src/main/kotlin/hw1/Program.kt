import kotlin.system.exitProcess

private var phoneBook = "Phonebook:\n"

fun main(){
    println("Write command:\n" +
            "exit\n" +
            "help\n" +
            "add <Name> phone <Number>\n" +
            "add <Name> mail <Mail>")
    var command = readln()
    while (true){
        var arrString = command.split(" ")
        when{
            arrString[0] == "exit" -> exitProcess(0)
            arrString[0] == "help" -> help()
            arrString[0] == "add" -> {
                when{
                    arrString[2] == "phone" -> addPhone(arrString[1], arrString[3])
                    arrString[2] == "mail" -> addMail(arrString[1], arrString[3])
                }
            }
        }
        command = readln()
    }
}

fun addPhone(name: String, numberPhone: String) {
    if(numberPhone.matches(Regex("""[+]\d+|\d+"""))) {
        phoneBook += "${name} - phone: ${numberPhone}\n"
    } else {
        println("Incorrect phone number")
    }
}

fun addMail(name: String, mail: String) {
    if(mail.contains(Regex("""@"""))) {
        phoneBook += "${name} - mail: ${mail}\n"
    } else {
        println("Incorrect mail")
    }
}

fun help(){
    println(phoneBook)
}