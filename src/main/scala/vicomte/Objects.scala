package vicomte

import org.json4s.DefaultFormats
import org.json4s.JsonAST.JValue
import org.json4s.jackson.JsonMethods._
import org.json4s.JsonDSL._

abstract class ToJson {
  def ast: JValue

  def jsonify() = compact(ast)
}

case class Version(patch: Long, major: Long, minor: Long)

case class Cookie(name: String, value: String, domain: String,
                  path: Option[String] = None, httpOnly: Boolean = false, secure: Boolean = false)
  extends ToJson {
  val ast = ("name" -> name) ~
    ("value" -> value) ~
    ("domain" -> domain) ~
    ("httponly" -> httpOnly) ~
    ("secure" -> secure) ~
    ("path" -> path)
}

object Cookie {
  private implicit val formats = DefaultFormats

  def fromJson(j: JValue) = {
    Cookie(
      (j \ "name").extract[String],
      (j \ "value").extract[String],
      (j \ "domain").extract[String],
      path = (j \ "path").extractOpt[String],
      httpOnly = (j \ "httponly").extract[Boolean],
      secure = (j \ "secure").extract[Boolean]
    )
  }
}