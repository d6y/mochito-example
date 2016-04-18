import org.specs2.mock.Mockito
import org.specs2.mutable.Specification
import org.specs2.specification.Scope
import org.mockito.{Mockito => M}

final case class UserID(value: String) extends AnyVal

trait UserService {
  def makeID(): UserID
}

class UserSpec extends Specification with Mockito {

  "User ID Service" should {

    "create a valid ID" in {
      val userService = mock[UserService]
      val fixedID = UserID("fixed")
      
      // This results in a run-time test failure:
      userService.makeID() returns fixedID
      /*
        [error] ! create a valid ID
        [error]
        [error]  UserID cannot be returned by makeID()
        [error]  makeID() should return String
        [error]  ***
        [error]  If you're unsure why you're getting above error read on.
        [error]  Due to the nature of the syntax above problem might occur because:
        [error]  1. This exception *might* occur in wrongly written multi-threaded tests.
        [error]     Please refer to Mockito FAQ on limitations of concurrency testing.
        [error]  2. A spy is stubbed using when(spy.foo()).then() syntax. It is safer to stub spies -
        [error]     - with doReturn|Throw() family of methods. More in javadocs for Mockito.spy() method. (spec.scala:15)
        [error] UserSpec$$anonfun$1$$anonfun$apply$1.apply(spec.scala:15)
        [error] UserSpec$$anonfun$1$$anonfun$apply$1.apply(spec.scala:10)
      */
     
      // This is a work-around of sorts:
      //   M.doReturn(fixedID.value).when(userService).makeID

      userService.makeID() must_==(fixedID)
    }

  }

}
