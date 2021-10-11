class BankAccount(deposited: Long, withdrawn: Long) {
    var deposited = deposited
    var withdrawn = withdrawn
    var balance = deposited - withdrawn
}