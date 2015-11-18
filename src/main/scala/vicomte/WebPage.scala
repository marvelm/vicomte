package vicomte

import scala.scalajs.js
import scala.scalajs.js.annotation.JSName

@JSName("webpage")
@js.native
trait WebPage extends js.Object {
  var canGoBack: Boolean = js.native
  var canGoForward: Boolean = js.native

  /**
   * This property defines the rectangular area of the web page to be rasterized when page.render is invoked.
   * If no clipping rectangle is set, page.render will process the entire web page.
   *
   * page.clipRect = {
   * top: 14,
   * left: 3,
   * width: 400,
   * height: 300
   * };
   */
  var clipRect: js.Dictionary[Int] = js.native

  /**
   * This property stores the content of the web page (main frame), enclosed in an HTML/XML element.
   * Setting the property will effectively reload the web page with the new content.
   *
   * See also page.plainText to get the content without any HTML tags.
   */
  var content: String = js.native

  /**
   * Get or set Cookies visible to the current URL (though, for setting, use of page.addCookie is preferred).
   * This array will be pre-populated by any existing Cookie data visible to this UR that is stored
   * in the CookieJar, if any.
   *
   * Cookies is an array of objects: javascript {
   * domain: 'example.com',
   * expires: 'Sat Oct 11 2014 21:44:33 GMT+0200 (CEST)',
   * expiry: 1476128618,
   * httponly: false,
   * name: 'cookieName',
   * path: '/',
   * secure: false,
   * value: cookieValue
   * }
   */
  var cookies: js.Object = js.native

  /**
   * This property specifies additional HTTP request headers that will be sent to the server
   * for every request issued (for pages and resources). The default value is an empty object {}.
   * Headers names and values get encoded in US-ASCII before being sent.
   * Please note that the 'User-Agent' should be set using the page.settings,
   * setting the 'User-Agent' property in this property will overwrite the value set via page.settings.
   * Introduced: PhantomJS 1.5
   */
  var customHeaders: js.Dictionary[String] = js.native

  var event: js.Object = js.native

  /**
   * This property stores the content of the web page's currently active frame
   * (which may or may not be the main frame), enclosed in an HTML/XML element.
   * Setting the property will effectively reload the web page with the new content.
   * Introduced: PhantomJS 1.7
   */
  var frameContent: String = js.native

  /**
   * Read-only. This property stores the content of the web page's currently active frame
   * (which may or may not be the main frame) as plain text — no element tags!
   * Introduced: PhantomJS 1.7
   */
  val framePlainText: String = js.native

  /**
   * Read-only. This property gets the current URL of the web page's
   * currently active frame (which may or may not be the main frame).
   * Introduced: PhantomJS 1.7
   */
  var frameUrl: String = js.native

  /**
   * Returns array with frames names.
   */
  var frameNames: Seq[String] = js.native

  /**
   * This property stores the path which is used by page.injectJs function to resolve the script name.
   * Initially it is set to the location of the script invoked by PhantomJS.
   */
  var libraryPath: String = js.native

  /**
   * This property defines whether navigation away from the page is permitted or not.
   * If it is set to true, then the page is locked to the current URL. Defaults to false.
   */
  var navigationLocked: Boolean = js.native
}
