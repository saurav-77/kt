//                             Scope functions

/**
 * let
 * let can be used for scoping and null-checks.
 * When called on an object, let executes the given block of code and returns the result of its last expression.
 * The object is accessible inside the block by the reference it (by default) or a custom name.
 * e.g:
 * val message: String? = "Hello"
 * message?.let {
 *     print(it.toUpperCase()) // Output: "HELLO"
 * }
 */


/**
 * run
 * Like let, run is another scoping function from the standard library.
 * Basically, it does the same: executes a code block and returns its result.
 * The difference is that inside run the object is accessed by this.
 * This is useful when you want to call the object’s methods rather than pass it as an argument.
 *
 * val message: String? = "Hello"
 * message?.run {
 *     print(this.toUpperCase()) // Output: "HELLO"
 * }
 *
 */

/**
 * with * it is a non-extension function that can access members of its argument concisely:
 * you can omit the instance name when referring to its members.
 *
 * val person = Person("Ali", 24)
 * val message = with(person) {
 *     "My name is $name, and I'm $age years old."
 * }
 */

/**
 * apply
 * apply executes a block of code on an object and returns the object itself.
 * Inside the block, the object is referenced by this. This function is handy for initializing objects.
 *
 * val person = Person("Ali", 24)
 * person.apply {
 *     name = "Ali"
 *     age = 24
 * }
 */

/**
 * also
 * also works like apply: it executes a given block and returns the object called.
 * Inside the block, the object is referenced by it, so it’s easier to pass it as an argument.
 * This function is handy for embedding additional actions, such as logging in call chains.
 *
 * val message: String? = "Hello"
 * message?.also {
 *     print(it.toUpperCase()) // Output: "HELLO"
 * }
 */