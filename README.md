Example of the problem of using value classes with Mockito

Mocking a service that returns this value class...

```
final case class UseID(value: String) extends AnyVal
```

...results in a run-time error:

```
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
[error]     - with doReturn|Throw() family of methods. More in javadocs for Mockito.spy() method. (spec.scala:21)
[error] UserSpec$$anonfun$1$$anonfun$apply$1.apply(spec.scala:21)
[error] UserSpec$$anonfun$1$$anonfun$apply$1.apply(spec.scala:16)
```

To see this, `sbt test`.

If you remove `extends AnyVal`, there is no error


