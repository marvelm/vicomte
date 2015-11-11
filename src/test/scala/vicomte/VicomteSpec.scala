package vicomte

import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.scalatest._

class VicomteSpec extends FlatSpec with Matchers {
  val phantom = new PhantomJSDriver
  val vic = new Vicomte(phantom)

  "Vicomte" should "yield the correct version" in {
    vic.version shouldEqual Version(0, 2, 0)
  }

  it should "have enabled cookies" in {
    vic.cookiesEnabled shouldEqual true
  }

  it should "add cookie" in {
    vic.addCookie(Cookie("cname", "cvalue", "cdomain")) shouldEqual true
  }

  it should "have one cookie" in {
    vic.cookies.length shouldEqual 1
  }
}