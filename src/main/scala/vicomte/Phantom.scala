package vicomte

import scala.scalajs.js
import scala.scalajs.js.annotation._

@JSName("phantom")
@js.native
trait Phantom extends js.Object {
  /**
   * Get or set Cookies for any domain (though, for setting, use of phantom.addCookie is preferred). These Cookies
   * are stored in the CookieJar and will be supplied when opening pertinent WebPages. This array will be
   * pre-populated by any existing Cookie data stored in the cookie file specified in the PhantomJS
   * startup config/command-line options, if any.
   * Introduced: PhantomJS 1.7
   */
  var cookies: js.Dictionary[js.Object] = js.native


  /**
   * Controls whether the CookieJar is enabled or not. Defaults to true.
   * Introduced: PhantomJS 1.7
   */
  var cookiesEnabled: Boolean = js.native

  /**
   * This property stores the path which is used by injectJs function to resolve the script name.
   * Initially it is set to the location of the script invoked by PhantomJS.
   */
  var libraryPath: String = js.native


  /**
   * Read-only. The version of the executing PhantomJS instance.
   * Example value: { 'major': 1, 'minor': 7, 'patch': 0 }.
   */
  var version: js.Dictionary[Int] = js.native

  /**
   * Add a Cookie to the CookieJar.
   * Returns true if successfully added, otherwise false.
   * Introduced: PhantomJS 1.7
   * @param cookie
   * @return
   */
  def addCookie(cookie: js.Dictionary[js.Object]): Boolean = js.native

  /**
   * Delete all Cookies in the CookieJar.
   * Introduced: PhantomJS 1.7
   */
  def clearCookies(): Unit = js.native

  /**
   * Delete any Cookies in the CookieJar with a 'name' property matching cookieName.
   * Returns true if successfully deleted, otherwise false.
   * Introduced: PhantomJS 1.7
   * @param name
   * @return
   */
  def deleteCookie(name: String) = js.native

  /**
   * Exits the program with the specified return value. If no return value is specified, it is set to 0.
   * @param returnValue
   * @return
   */
  def exit(returnValue: String) = js.native

  /**
   * Injects external script code from the specified file into the Phantom outer space.
   * If the file cannot be found in the current directory, libraryPath is used for additional look up.
   * This function returns true if injection is successful, otherwise it returns false.
   * @param filename
   * @return
   */
  def injectJs(filename: String) = js.native

  /**
   * This callback is invoked when there is a JavaScript execution error not caught by a page.onError handler.
   * This is the closest it gets to having a global error handler in PhantomJS, and so it is a best practice
   * to set this onError handle up in order to catch any unexpected problems.
   * The arguments passed to the callback are the error message and the stack trace [as an Array].
   * Introduced: PhantomJS 1.5
   * @param cb (msg, trace) => ()
   * @return
   */
  def onError(cb: (String, Seq[js.Object]) => Unit) = js.native
}

