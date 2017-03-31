/*package official.web

// http://docs.scala-lang.org/ko/tutorials/tour/case-classes.html
abstract class Notification

case class Email(sourceEmail: String, title: String, body: String) extends Notification

case class SMS(sourceNumber: String, message: String) extends Notification
case class VooidRecording(contatctName: String, link: String) extends Notification


val emailFromJohn = Email("john.doe@email.com", "Greetings from John!", "Hi")

val title = emailFromJohn.title
println(title)

emailFromJohn.title = "Hi2"

val editedEmail = emailFromJohn.copy(title = "I am learning Scala!", body = "It's so cool!")


println(editedEmail)

val firstSms = SMS("12345", "Hi")
val secondSms = SMS("12345", "Hi")

if(firstSMS == secondSms) {
  println("They are equal!")
}

// pattern matching
def showNotification(notification: Notification): Sting = {
  notifiction match {
    case Email(email, title, _) =>
      "You got an email from " + email + " with title: " + title
    case SMS(numer, message) =>
      "You got an SMS from " + number +"! message: " + message
    case VoiceRecording(name, link) =>
      "You received a Voice Recording from " + name + "! Click the link to hear it: " + link
  }
}

val someSms = SMS("1234", "Are you there?")

println(showNotification(someSms))*/