import org.mockito.{Mockito => M}

final case class UserID(value: String) extends AnyVal

trait UserService {
  def makeID(): UserID
}

object Main extends App {

  val fixedID = UserID("fixed")

  val userService = M.mock(classOf[UserService])

  // This results in a run-time test failure:
  M.when(userService.makeID).thenReturn(fixedID)

  println(
    userService.makeID()
  )

}
