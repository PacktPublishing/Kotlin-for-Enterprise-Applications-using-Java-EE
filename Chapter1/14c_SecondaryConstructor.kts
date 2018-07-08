class AuditData {
var message = ""
var locale = ""
    constructor(msg: String) {
        message = msg
    }
    constructor(msg: String, localeInfo: String) {
        message = msg
        locale = localeInfo
    }
}
var audit = AuditData("some message")
println("Message ${audit.message}")

audit = AuditData("audit message", "en-US")
println("Message ${audit.message}")
println("Locale ${audit.locale}")
