package vicomte

import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.json4s.jackson.JsonMethods._

class Vicomte(phantom: PhantomJSDriver) {
  def execute[T](script: String) = phantom.executePhantomJS(script).asInstanceOf[T]
  private def executeMap[K, V] = execute[java.util.Map[K, V]] _
  private def executeJson(script: String) = parse(execute[String](script))

  def cookies = {
    val j = executeJson("return JSON.stringify(phantom.cookies);");
    j.children.map(Cookie.fromJson)
  }

  lazy val cookiesEnabled = {
    execute[Boolean]("return phantom.cookiesEnabled;")
  }

  lazy val libraryPath = execute[String]("return phantom.libraryPath;")

  lazy val version = {
    val map = executeMap[String, Long]("return phantom.version;")
    Version(
      map.get("patch"),
      map.get("major"),
      map.get("minor")
    )
  }

  def addCookie(cookie: Cookie) = execute[Boolean](s"return phantom.addCookie(${cookie.jsonify()});")

  def clearCookies(): Unit = execute[String]("phantom.clearCookies();")

  def deleteCookie(name: String) = execute[Boolean](s"return phantom.deleteCookie('$name');")

  def exit(returnValue: Int) = execute[Int](s"return phantom.exit($returnValue);")

  def injectJs(filename: String) = execute[Boolean](s"return phantom.injectJs($filename);")
}